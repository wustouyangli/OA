package com.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.wltea.analyzer.lucene.IKQueryParser;
import org.wltea.analyzer.lucene.IKSimilarity;

public class Searcher {
	
   IndexSearcher indexSearcher;
   public IndexSearcher getIndexSearcher() {
	  return indexSearcher;
   }

   public void setIndexSearcher(IndexSearcher indexSearcher) {
	  this.indexSearcher = indexSearcher;
   }

public Searcher(RAMDirectory indexDirectory) throws IOException{
      //Directory indexDirectory = FSDirectory.open(new File(indexDirectoryPath));
	  IndexReader reader = IndexReader.open(indexDirectory);
	  indexSearcher = new IndexSearcher(reader);   
	  indexSearcher.setSimilarity(new IKSimilarity());
      
   }
   
   public TopDocs search( String searchQuery) throws IOException, ParseException{
	  Query query = IKQueryParser.parse("contents",searchQuery);
      return indexSearcher.search(query, Integer.MAX_VALUE);
   }

   public Document getDocument(ScoreDoc scoreDoc) throws CorruptIndexException, IOException{
      return indexSearcher.doc(scoreDoc.doc);	
   }

   public void close() throws IOException{
      indexSearcher.close();
   }
}
