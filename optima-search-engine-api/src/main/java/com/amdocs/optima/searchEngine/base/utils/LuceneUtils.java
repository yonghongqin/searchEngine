package com.amdocs.optima.searchEngine.base.utils;


import com.amdocs.optima.searchEngine.framework.IConstants;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author QINY
 */
public class LuceneUtils {
    private static final String HIGHLIGHT_LEFT = "<span class=\"hl\"><strong><font color=\"#9932CC\">";
    private static final String HIGHLIGHT_RIGHT = "</font></strong></span>";

    // highlight stuff
    private static final SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(HIGHLIGHT_LEFT, HIGHLIGHT_RIGHT);
    private final Logger log = Logger.getLogger(LuceneUtils.class);

    public static IndexWriter createWriter(String indexDir) throws IOException {
        
        return createWriter(indexDir,OpenMode.CREATE);
    }
    
    public static IndexWriter createWriter(String indexDir,OpenMode openMode) throws IOException {
        FSDirectory dir = FSDirectory.open(Paths.get(indexDir));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        config.setOpenMode(openMode);
        IndexWriter writer = new IndexWriter(dir, config);
        return writer;
    }

    public static IndexSearcher createSearcher(String indexDir) throws IOException {
        FSDirectory dir = FSDirectory.open(Paths.get(indexDir));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        return searcher;
    }

    public static List<Document> searchByCaseId(String caseId, String indexPath, Boolean isSubCase)
            throws IOException, ParseException {

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
//    
//    public static String getHighlightedField(String queryString, Analyzer analyzer, Query query,Highlighter highlighter) 
//            throws IOException, InvalidTokenOffsetsException {
//              TokenStream tokenStream = analyzer.tokenStream(queryString,new StringReader(doc.get(desc)));
//              String bestFragments = highlighter.getBestFragments(tokenStream, doc.get(desc), 3, "...");
//              return bestFragments;
//}

}
