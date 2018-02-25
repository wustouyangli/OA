package com.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class Indexer {

   private IndexWriter writer;
   public IndexWriter getWriter() {
	   return writer;
   }

   public void setWriter(IndexWriter writer) {
	   this.writer = writer;
   }

public Indexer(RAMDirectory indexDirectory) throws IOException{
      //FSDirectory indexDirectory = FSDirectory.open(new File(indexDirectoryPath));
      Analyzer analyzer = new IKAnalyzer();
      IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_35, analyzer);    
      writer = new IndexWriter(indexDirectory, iwc); 
   }

   public void close() throws CorruptIndexException, IOException{
      writer.close();
   }

   private Document getDocument(File file) throws IOException{
      Document document = new Document();

      //index file contents
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
      StringBuffer buf = new StringBuffer();
      while(br.ready()){
    	  buf.append(br.readLine() + "\r\n");
      }
      //System.out.println(String.valueOf(buf));
      Field contentField = new Field(LuceneConstants.CONTENTS, 
         String.valueOf(buf), 
         Field.Store.YES, Field.Index.ANALYZED);
      
      Field fileNameField = new Field(LuceneConstants.FILE_NAME,
         file.getName(),
         Field.Store.YES,Field.Index.NOT_ANALYZED);
     
      Field filePathField = new Field(LuceneConstants.FILE_PATH,
         file.getCanonicalPath(),
         Field.Store.YES,Field.Index.NOT_ANALYZED);

      document.add(contentField);
      document.add(fileNameField);
      document.add(filePathField);

      return document;
   }   

   public int createIndex(String dataDirPath, FileFilter filter) throws IOException{
      //get all files in the data directory
      File[] files = new File(dataDirPath).listFiles();

      for (File file : files) {
         if(!file.isDirectory()
            && !file.isHidden()
            && file.exists()
            && file.canRead()
            && filter.accept(file)) {
        	 Document document = getDocument(file);
             writer.addDocument(document);
         }
      }
      return writer.numDocs();
   }
}