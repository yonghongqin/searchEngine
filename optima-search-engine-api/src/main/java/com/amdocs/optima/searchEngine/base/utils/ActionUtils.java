package com.amdocs.optima.searchEngine.base.utils;

import com.amdocs.optima.searchEngine.dto.SearchForm;
import com.amdocs.optima.searchEngine.dto.SearchResultObject;
import com.amdocs.optima.searchEngine.framework.IConstants;
import com.amdocs.optima.searchEngine.framework.IConstants.SearchOptions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanQuery.Builder;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.KeywordTokenizer;
import org.apache.lucene.analysis.core.UpperCaseFilter;
import org.jsoup.Jsoup;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.ui.ModelMap;

/**
 *
 * @author QINY
 */
public class ActionUtils {

    public static String escapeForwardSlash(String myQuery) {
       if(myQuery!=null&&myQuery.contains("/"))
           myQuery=myQuery.replaceAll("/", "\\\\/");
       
       return myQuery;
    }

    public static String handleMultipleWords(String myQuery) {
        String newString=myQuery;
        if(!isSearchStringPhrase(myQuery)){
            String[] words=myQuery.split(" ");
            if(words.length>2){
               newString= "(\""+myQuery+"\")^100"+" OR "+myQuery;
            }

        }
        
        return newString;
    }

    public static List<String> searchBasedOnIndexDir(SearchForm form, String indexPath, String subIndexDir) throws IOException {
        List<String> dirToSearch = new ArrayList<>();
        String[] firstTypeOfFilter = form.getFilterFirstType();
        String[] secondTypeOfFilter = form.getFilterSecondType();
        LogUtil.info("search index from base path:" + indexPath, ActionUtils.class.getName());
        final String basePath = indexPath;
        if (StringUtils.isNotBlank(subIndexDir)) {
            indexPath += subIndexDir;
            dirToSearch.add(subIndexDir);
        } else {
            if (!ArrayUtils.isEmpty(secondTypeOfFilter)) {
                if (!ArrayUtils.isEmpty(firstTypeOfFilter)) {
                    Stream.of(firstTypeOfFilter).forEach(team -> {
                        Stream.of(secondTypeOfFilter).forEach(module -> {
                            dirToSearch.add(basePath + File.separator + team + File.separator + module);
                        });
                    });
                } else {
                    Files.list(Paths.get(indexPath))
                            .filter(Files::isDirectory)
                            .forEach(team -> {
                                Stream.of(secondTypeOfFilter).forEach(module -> {
                                    dirToSearch.add(team + File.separator + module);
                                });
                            });
                }
            } else if (!ArrayUtils.isEmpty(firstTypeOfFilter)) {
                Stream.of(firstTypeOfFilter).forEach(team -> {
                    dirToSearch.add(basePath + File.separator + team);
                });
            }
        }
        return dirToSearch;

    }


    public static Builder processQueryFilter(Map<String, String[]> filterMap) {
        Builder finalQueryBuilder = new BooleanQuery.Builder();

        if (filterMap != null && !filterMap.isEmpty()) {
            filterMap.forEach((k, v) -> {
                Builder builder = new BooleanQuery.Builder();
                Arrays.asList(v).forEach(s -> {
                    TermQuery termQuery = new TermQuery(new Term(k, QueryParser.escape(s)));
                    builder.add(termQuery, BooleanClause.Occur.SHOULD);
                });

                if (builder.build() != null && !builder.build().clauses().isEmpty()) {
                    finalQueryBuilder.add(builder.build(), BooleanClause.Occur.MUST);
                }
            });

        }
        return finalQueryBuilder;
    }

    public static String html2Text(String str){
        if(str!=null) return Jsoup.parse(str).text();
        return str;
    }
    
    
    public static List<Document> searchByCaseId(String caseId, String indexPath, Boolean isSubCase)
            throws Exception {

        IndexReader reader = IndexManager.getIndexReader(indexPath);

        IndexSearcher searcher = new IndexSearcher(reader);
        Query query = null;

        if (isSubCase != null && isSubCase) {
            Term term = new Term(IConstants.SEARCH_ID, caseId);
            query = new PrefixQuery(term);
        } else {
            Analyzer analyzer = new KeywordAnalyzer();
            QueryParser parser = new QueryParser(IConstants.SEARCH_ID, analyzer);
            query = parser.parse(caseId);
        }

        query = query.rewrite(reader); // required to expand search terms

        // Do the search and score each result
        TopDocs hits = searcher.search(query, IConstants.MAX_RESULTS);
        List<Document> docs = new ArrayList<>();

        for (ScoreDoc sd : hits.scoreDocs) {
            Document doc = searcher.doc(sd.doc);
            docs.add(doc);
        }

        return docs;

    }

    public static boolean isSearchStringPhrase(String searchString) {
        boolean isPhrase = searchString.trim().matches(".*\".*?\".*");
        return isPhrase;
    }

    public static boolean checkIfCaseSubcaseId(String searchString) {
        Pattern p = Pattern.compile("^(\\d{3}\\d+)-(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])(\\d\\d)(-\\d+)?$");
        Matcher m = p.matcher(searchString);
        return m.matches();

    }

    public static String removeQuoteFromId(String searchString) {
        Pattern p = Pattern.compile("^id:\"(.*)\"$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(searchString);
        String idVal = null;
        while (m.find()) {
            idVal = m.group(1);
        }
        return idVal != null ? "id:" + idVal : searchString;
    }

    public static String formatDate(Date submitDate) {
        String submittedOn;
        LocalDate localDate = submitDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        submittedOn = localDate.format(formatter);
        return submittedOn;
    }

    public static class UpperCasingKeywordAnalyzer extends Analyzer {

        @Override
        protected TokenStreamComponents createComponents(String fieldName) {
            KeywordTokenizer keywordTokenizer = new KeywordTokenizer();
            return new TokenStreamComponents(keywordTokenizer, new UpperCaseFilter(keywordTokenizer));
        }
    }

    public static boolean filterValueEq(String fieldName, String fieldValue, Object obj) {
        boolean isEqual;
        String value = getValue(fieldName, obj);
        isEqual = value != null && value.equalsIgnoreCase(fieldValue);
        return isEqual;
    }
    
    public static boolean filterValueIn(String fieldName, String[] fieldValue, Object obj) {
        if(fieldValue==null||fieldValue.length<=0) return true;
        boolean isEqual;
        String value = getValue(fieldName, obj);
        isEqual = value != null && Arrays.asList(fieldValue).contains(value);
        return isEqual;
    }

    public static String getValue(String fieldName, Object obj) {
        String value = null;
        try {
            value = BeanUtils.getProperty(obj, fieldName);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }
//    public static boolean filterValueEq(String fieldName,String fieldValue,Object obj){
//        boolean isEqual=false;
//        try {
//            
//            Field field=ReflectionUtils.findField(SearchResultObject.class, fieldName);
//            ReflectionUtils.makeAccessible(field);
//            if(field.get(obj)!=null){
//                isEqual=field.get(obj).toString().equalsIgnoreCase(fieldValue);
//            }
//        } catch (IllegalArgumentException | IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ActionUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return isEqual;
//    }

    public static List<String> filterItems(List<SearchResultObject> searchResults, String fitlerName) {

        List<String> filtersList = searchResults.stream()
                .map(d -> getValue(fitlerName, d))
                .filter(s->null!=s)
                .sorted((s1, s2) -> s1.compareTo(s2))
                .distinct()
                .collect(Collectors.toList());

        return filtersList;
    }

    public static void filterItems(List<SearchResultObject> searchResults, int searchOption, ModelMap model) {

        if (SearchOptions.searchAPSS.getValue() == searchOption) {
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_ACCOUNT_LIST, filterItems(searchResults, "acct"));
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_YEAR_LIST, filterItems(searchResults, "year"));
            model.addAttribute(IConstants.MODLE_ATTRIBUTE_PRODUCTION_LINE_LIST, filterItems(searchResults, "productLine"));
        } else if (SearchOptions.searchClearQuest.getValue() == searchOption) {
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_SERVICE_NAME_LIST, filterItems(searchResults, "serviceName"));
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_CBS_MODULE_LIST, filterItems(searchResults, "cbsModule"));
        } else if (SearchOptions.searchDOC.getValue() == searchOption) {
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_DOC_TYPE_LIST, filterItems(searchResults, "ext"));
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_DIR_FIRST_LIST, filterItems(searchResults, "dirFirst"));
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_DIR_SECOND_LIST, filterItems(searchResults, "dirSecond"));
        } else if (SearchOptions.searchDDTS.getValue() == searchOption) {
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_ACCOUNT_LIST, filterItems(searchResults, "project"));
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_YEAR_LIST, filterItems(searchResults, "version"));
            model.addAttribute(IConstants.MODLE_ATTRIBUTE_PRODUCTION_LINE_LIST, filterItems(searchResults, "module"));
        } else if (SearchOptions.searchTRAC.getValue() == searchOption) {
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_ACCOUNT_LIST, filterItems(searchResults, "custId"));
        }if (SearchOptions.searchTFS.getValue() == searchOption) {
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_ACCOUNT_LIST, filterItems(searchResults, "acct")); 
            model.addAttribute(IConstants.MODEL_ATTRIBUTE_TFS_ITEM_TYPE_LIST, filterItems(searchResults, "workItemType")); 
        }

    }

    public static void SearchResultPagination(HttpServletRequest request, List<SearchResultObject> searchResults, ModelMap model, Integer currentPage) {

        PagedListHolder<SearchResultObject> pagedListHolder = new PagedListHolder<>(searchResults);
        request.getSession().setAttribute("pagedListHolder", pagedListHolder);
        pagedListHolder.setPageSize(IConstants.PAGE_SIZE);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if (currentPage == null || currentPage < 1 || currentPage > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            model.addAttribute("searchResults", pagedListHolder);
        } else {
            pagedListHolder.setPage(currentPage - 1);
            model.addAttribute("searchResults", pagedListHolder);
        }

        int numTotalHits = searchResults.size();
        int start = (currentPage - 1) * IConstants.PAGE_SIZE + 1;
        int end = (currentPage * IConstants.PAGE_SIZE);
        end = Math.min(numTotalHits, end);
        model.addAttribute("startRecords", start);
        model.addAttribute("endRecords", end);
        model.addAttribute("numTotalHits", numTotalHits);

    }
    
//    public static String  convertListToJson(List<?> list){
//        ObjectMapper objectMapper = new ObjectMapper();
//        //Set pretty printing of json
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        String arrayToJson=null;
//        try {
//            arrayToJson = objectMapper.writeValueAsString(list);
//        } catch (JsonProcessingException ex) {
//            java.util.logging.Logger.getLogger(ActionUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return arrayToJson;
//        
//    }
    
    

}
