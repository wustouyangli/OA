package com.lucene;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.RAMDirectory;

import com.lucene.Indexer;
import com.lucene.LuceneConstants;
import com.lucene.Searcher;
import com.lucene.TextFileFilter;

public class LuceneSearch {

	   private static String dataDir = "C:/E/Lucene/Data";
	   
	   private static Indexer indexer;
	   private static Searcher searcher;
	   private RAMDirectory indexDirectory;
	   
	   public LuceneSearch(){}
	   public ArrayList<Integer> getResult(String key){
		    try {	
		    	indexDirectory = new RAMDirectory();
		        CreateIndex();
		        return Search(key);
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
			return null;
	   }
	   
	   public void DeleteAll(){
		   System.out.println(DeleteDir(new File(dataDir)));	   
		   File f2 = new File(dataDir);
		   if (!f2.exists()){
		       if (f2.mkdirs()){
			       System.out.println("create success");
			   }else{
				   System.out.println("create fail");
			   }
		   }else{
			   System.out.println("already exists");
		   }
	    	
	   }
	   
	   public void CreateDataFile(String filename, String value) {
		  File file = new File(dataDir, filename);
		  if (!file.exists()) {  
		        try {  
		            file.createNewFile();  
		        } catch (IOException e) {   
		            e.printStackTrace();  
		        } 
		  }
		  try {
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
		    bw.write(value);
		    bw.close();
		  } catch (IOException e) {
		         e.printStackTrace();
		  }
	   }
	   
	   private static boolean DeleteDir(File dir) {
		    if(!dir.exists()){
		    	return true;
		    }
	        if (dir.isDirectory()) {
	            String[] children = dir.list();
	            for (int i=0; i<children.length; i++) {
	                boolean success = DeleteDir(new File(dir, children[i]));
	                if (!success) {
	                    return false;
	                }
	            }
	        }
	        return dir.delete();
	    }

	   private void CreateIndex() throws IOException{
		   indexer = new Indexer(indexDirectory);
	       indexer.createIndex(dataDir, new TextFileFilter()); 
	       indexer.close();
	   }

	   private ArrayList<Integer> Search(String searchQuery) throws IOException, ParseException{
		   searcher = new Searcher(indexDirectory);
	       TopDocs hits = searcher.search(searchQuery);
	       ArrayList<Integer> idList = new ArrayList<Integer>();
	       for(ScoreDoc scoreDoc : hits.scoreDocs) {
	           Document doc = searcher.getDocument(scoreDoc);
	           String fname = doc.get(LuceneConstants.FILE_NAME);
	           fname = fname.replace(".txt", "");
	           int id = Integer.parseInt(fname);
	           idList.add(id);
	      }
	       
	      searcher.close();
	      return idList;
	   }
}
