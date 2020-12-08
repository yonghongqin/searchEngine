package com.amdocs.optima.searchEngine.base.utils;

import com.amdocs.optima.searchEngine.base.config.IConfiguration;
import com.amdocs.optima.searchEngine.dto.SearchForm;
import com.amdocs.optima.searchEngine.dto.SearchResultObject;
import com.amdocs.optima.searchEngine.framework.IConstants;
import com.amdocs.optima.searchEngine.framework.IConstants.DocumentTypeExtension;
import com.amdocs.optima.searchEngine.framework.IConstants.SearchOptions;
import com.amdocs.optima.searchEngine.model.docs.TFS;
import com.amdocs.optima.searchEngine.model.webmanager.SearchEngineErrorLog;
//import com.amdocs.optima.searchEngine.service.IWebManagerService;
//import com.amdocs.optima.searchEngine.tfs.TfsUtils;
//import com.microsoft.tfs.core.TFSTeamProjectCollection;
//import com.microsoft.tfs.core.clients.workitem.WorkItemClient;
//import com.microsoft.tfs.core.clients.workitem.project.Project;
//import com.microsoft.tfs.core.httpclient.Credentials;
//import com.microsoft.tfs.core.httpclient.UsernamePasswordCredentials;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;

import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;

import org.apache.lucene.search.BooleanQuery.Builder;
import org.apache.lucene.search.IndexSearcher;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;

import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;

import org.apache.lucene.search.highlight.QueryScorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author QINY
 */
@Component
public class ActionHelper {

    @Autowired
    Environment conf;
    
//    @Autowired
//    @Qualifier("webmanagerService")
//    IWebManagerService webmanagerService;
    
//    @Autowired
//    private RestTemplate restTemplate;
    

    public List<SearchResultObject> searchDocumentHelper(SearchForm form, String searchString, String indexBase, ModelMap model, Analyzer analyzer)
            throws Exception {

        List<SearchResultObject> searchResults = new ArrayList<>();

        LocalDateTime startTime = LocalDateTime.now();
        String[] docTypeOfFilter = form.getFilterDocType();
        Map<String, String[]> filterMap = new HashMap<>();

        String[] originalType = null;
        if (docTypeOfFilter != null && docTypeOfFilter.length > 0) {
            originalType = Arrays.asList(docTypeOfFilter).stream().map(s
                    -> Stream.of(IConstants.DocumentTypeExtension.values())
                            .filter(e -> e.getValue().equalsIgnoreCase(s))
                            .map(e -> e.getMapSource()).findFirst().get())
                    .toArray(String[]::new);
        }
        //.collect(Collectors.toCollection(String[]::new));

        if (originalType != null && originalType.length > 0) {
            filterMap.put(IConstants.DOC_TYPE, originalType);
        }

        String subIndexDirFirst = form.getSubIndexDirFirst();
        String subIndexDirSecond = form.getSubIndexDirSecond();
        String subIndexDir = subIndexDirFirst;
        if (StringUtils.isNotBlank(subIndexDirSecond)) {
            subIndexDir = subIndexDirFirst + File.separator + subIndexDirSecond;
        }
        String indexPath = conf.getProperty(indexBase);

        List<String> dirToSearch = ActionUtils.searchBasedOnIndexDir(form, indexPath, subIndexDir);

        LogUtil.info("search index from dir:" + dirToSearch.stream().collect(Collectors.joining("\n")), ActionUtils.class.getName());

        if (!dirToSearch.isEmpty()) {
            for (String subDir : dirToSearch) {
                searchResults.addAll(searchDocument(form, searchString, subDir, filterMap, model, analyzer));
            }

        } else {
            searchResults = searchDocument(form, searchString, indexPath, filterMap, model, analyzer);
        }

        ActionUtils.filterItems(searchResults, SearchOptions.searchDOC.getValue(), model);

        return searchResults;
    }

    private List<SearchResultObject> searchDocument(SearchForm form, String searchString, String indexPath, Map<String, String[]> filterMap, ModelMap model, Analyzer analyzer)
            throws Exception {
        String[] fields = {IConstants.INDEX_FILE_NAME, IConstants.INDEX_FILE_CONTENT};
        List<SearchResultObject> searchResults = new ArrayList<>();

        IndexReader reader = IndexManager.getIndexReader(indexPath);

        IndexSearcher searcher = new IndexSearcher(reader);
//            PerFieldAnalyzerWrapper analyzer = new PerFieldAnalyzerWrapper(new StandardAnalyzer());
//            analyzer.addAnalyzer(IConstants.SEARCH_ID, new KeywordAnalyzer());
        //MultiFieldQueryParser parser=new MultiFieldQueryParser(fields,new StandardAnalyzer());
        //query=parser.parse(searchString);
        //Query query = MultiFieldQueryParser.parse(fields, new StandardAnalyzer());

        QueryParser parser = new MultiFieldQueryParser(fields, analyzer);
        Query query = parser.parse(searchString);
        query = query.rewrite(reader); // required to expand search terms

        boolean hasTermQuery = false;
        Builder finalQueryBuilder = ActionUtils.processQueryFilter(filterMap);
        List<BooleanClause> clauses = finalQueryBuilder.build().clauses();
        if (clauses != null && !clauses.isEmpty()) {
            hasTermQuery = true;
        }

        TopDocs topDocs = null;

        if (hasTermQuery) {

            topDocs = searcher.search(finalQueryBuilder.build(), IConstants.MAX_RESULTS);
        } else {
            topDocs = searcher.search(query, IConstants.MAX_RESULTS);
        }

//            searcher.search(query, collector);
        ScoreDoc[] hits = topDocs.scoreDocs;

        int numTotalHits = hits.length;
        LogUtil.info("Found " + numTotalHits + " for given search criteria", ActionUtils.class.getName());

        Highlighter highlighter = new Highlighter(IConstants.htmlFormatter, new QueryScorer(query));

        //redirect will always be the same since the id=? part will be different from different search
        String url = conf.getProperty(IConfiguration.PRODUCT_MANUAL_URL_REDIRECT);
        MessageFormat urlformat = new MessageFormat(url);

        for (ScoreDoc sd : hits) {

            Document doc = searcher.doc(sd.doc);
            //do NOT add duplicate case id
//				if(searchResults.stream().map(r->r.get(IConstants.INDEX_FILE_ID)).anyMatch(s->s.equals(doc.get(IConstants.INDEX_FILE_ID))))
//					continue;

            SearchResultObject resultObject = new SearchResultObject();
            TokenStream tokenStream = analyzer.tokenStream(searchString, new StringReader(doc.get(IConstants.INDEX_FILE_CONTENT)));
            String bestFragments = highlighter.getBestFragments(tokenStream, doc.get(IConstants.INDEX_FILE_CONTENT), 3, "...");

            String fileLocation = URLEncoder.encode(doc.get(IConstants.INDEX_FILE_LOCATION), "UTF-8");
            String fileName = doc.get(IConstants.INDEX_FILE_NAME);
            String docType = Stream.of(IConstants.DocumentTypeExtension.values())
                    .filter(e -> e.getMapSource().contains(Utils.getFileExtension(fileName)))
                    .map(e -> e.getValue()).findFirst().get();
            resultObject.setType("doc");
            resultObject.setExt(docType);
            if (!DocumentTypeExtension.VIDEO.getValue().equals(docType)) {
                resultObject.setUrl(urlformat.format(new Object[]{fileLocation}));
                if (DocumentTypeExtension.ELEARNING.getValue().equals(docType)) {
                    //do not encode for the link
                    resultObject.setUrl(doc.get(IConstants.INDEX_FILE_LOCATION));
                }

            }
            resultObject.setTitle(fileName.substring(0, fileName.lastIndexOf('.')));
            resultObject.setSize(doc.get(IConstants.INDEX_FILE_SIZE));
            //resultBean.set(IConstants.INDEX_FILE_NAME, doc.get(IConstants.INDEX_FILE_NAME));
            resultObject.setBestFragment(bestFragments);
            //resultBean.set(IConstants.SEARCH_SCORE, String.format("%.3f", new Float(sd.score)));
            resultObject.setScore(sd.score);
            resultObject.setDirFirst(doc.get(IConstants.INDEX_FILE_HIERARCHY_FRIST));
            if (doc.get(IConstants.INDEX_FILE_HIERARCHY_SECOND) != null) {
                resultObject.setDirSecond(doc.get(IConstants.INDEX_FILE_HIERARCHY_SECOND));
            }
            searchResults.add(resultObject);
        }

        List<String> docTypeList = searchResults.stream()
                .map(d -> d.getExt())
                .sorted((s1, s2) -> s1.compareTo(s2))
                .distinct()
                .collect(Collectors.toList());

        model.addAttribute("docTypeList", docTypeList);

        return searchResults;
    }

    final static String TFS_JNI_DIR = "com.microsoft.tfs.jni.native.base-directory";
    
    //todo: TFS 

//    public WorkItemClient getWorkItemClient() {
//        WorkItemClient workItemClient = null;
//        try {
//            if (System.getProperty(TFS_JNI_DIR) == null) {
//                System.setProperty(TFS_JNI_DIR, conf.getProperty(IConfiguration.TFS_NATIVE_DIR));
////                Properties properties=System.getProperties();
////                properties.setProperty(TFS_JNI_DIR, conf.getProperty(IConfiguration.TFS_NATIVE_DIR));
//                log.info("tfs native dir from config="+conf.getProperty(IConfiguration.TFS_NATIVE_DIR));
//                log.info("tfs native dir from system="+System.getProperty(TFS_JNI_DIR));
//                
//            }
//
//            byte[] base64decodedBytes = Base64.getDecoder().decode(conf.getProperty(IConfiguration.TFS_URL_PASSWORD));
//            Credentials credentials;
//
//            credentials = new UsernamePasswordCredentials(conf.getProperty(IConfiguration.TFS_URL_USERNAME), new String(base64decodedBytes, "utf-8"));
//
//            URI uri = new URI(conf.getProperty(IConfiguration.TFS_URL_REDIRECT));
//            TFSTeamProjectCollection tpc = new TFSTeamProjectCollection(uri, credentials);
//            Project project = tpc.getWorkItemClient().getProjects().get("NBU");
//            workItemClient = project.getWorkItemClient();
//        } catch (UnsupportedEncodingException | URISyntaxException ex) {
//            log.error("Running into Exception:"+ex);
//            java.util.logging.Logger.getLogger(TfsUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return workItemClient;
//    }
//

}
