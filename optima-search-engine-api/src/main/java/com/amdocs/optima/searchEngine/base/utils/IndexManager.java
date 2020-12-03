package com.amdocs.optima.searchEngine.base.utils;

import com.amdocs.optima.searchEngine.framework.IConstants;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.store.FSDirectory;

public class IndexManager {

	private static Logger log = Logger.getLogger(IndexManager.class);
	private static IndexManager instance = null;
	private Map indexReaderMap;
	
	private IndexManager() {
		indexReaderMap = new HashMap();
	}
	
	private static IndexManager getInstance()	{
		if (instance == null) {
			instance = new IndexManager();
		}
		return instance;
	}
	
	public static IndexReader getIndexReader (String indexDir) throws IOException {
		Map readerMap = getInstance().indexReaderMap;
		
		IndexReader reader = (IndexReader)readerMap.get(indexDir);
		if (reader == null) {
                       FSDirectory dir=FSDirectory.open(Paths.get(indexDir));
			reader = DirectoryReader.open(dir);
			readerMap.put(indexDir, reader);
		}
		return reader;
	}
        
    public static IndexSearcher createSearcher(String indexPath) throws IOException {
        IndexReader reader = IndexManager.getIndexReader(indexPath);
        IndexSearcher searcher = new IndexSearcher(reader);
        return searcher;
    }
	
	public static IndexReader reopenIndexReader (String indexDir) throws IOException {
		Map readerMap = getInstance().indexReaderMap;
		
		IndexReader reader = (IndexReader)readerMap.get(indexDir);
//		if (reader != null) {
//			IndexReader newReader = null;
//			newReader = reader.reopen();
//			// Check if a new reader was opened;
//			if (newReader != reader) {
//				log.info("Reopen operated returned new IndexReader for directory ["+indexDir+"]");
//				// close old reader and update the cache with the new instance
//				reader.close();
//				reader = newReader;
//				readerMap.put(indexDir, newReader);
//			}
//		}
		return reader;
	}

    public static Highlighter CreateHighlighter(Query query) {
        Highlighter highlighter = new Highlighter(IConstants.htmlFormatter, new QueryScorer(query));
        return highlighter;
    }
	
}
