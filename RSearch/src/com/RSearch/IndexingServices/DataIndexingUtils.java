package com.RSearch.IndexingServices;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

public class DataIndexingUtils {
	
	protected static Set<String> docFieldsSet = new HashSet<String>();
	
	protected void indexData (List<Map> inputList) throws Exception
	{
	
		System.out.println("Inside DataIndexingUtils ::: indexData :::");
		StandardAnalyzer analyzer = new StandardAnalyzer();
		FSDirectory index = FSDirectory.open(Paths.get("C:\\Personal\\Eclipse_Workspace\\RSearch\\IndexLocation"));
	  
	  IndexWriterConfig config = new IndexWriterConfig(analyzer);
	  
	 if(inputList != null && inputList.size() >0)
	 {
		 IndexWriter w = new IndexWriter(index, config);
		 addDoc(w, inputList);
		 w.close();
	 }
	  /* for (String temp : docFieldsSet)
	   {
       		System.out.println("docFieldsSet Contents:::"+temp);
       }*/
	}
	
	private static void addDoc(IndexWriter w, List<Map> inputList) throws IOException 
	{
		
		if(inputList != null && inputList.size() >0)
		{
			for(int i=0; i<inputList.size(); i++)
			{
				Map<?, ?> mTemp = (HashMap<?, ?>)inputList.get(i);
				
				Document doc = new Document();
				
				Iterator<?> entries = mTemp.entrySet().iterator();
				
				while (entries.hasNext()) 
				{
				    Map.Entry entry = (Map.Entry) entries.next();
				    
//				    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				    
				    docFieldsSet.add((String)entry.getKey());
				    
					doc.add(new TextField((String)entry.getKey(), (String)entry.getValue(), Field.Store.YES));
				}
				w.addDocument(doc);
				
				
				/*
				strType = (String)((HashMap)(inputList.get(i))).get("type");
				strName = (String)((HashMap)(inputList.get(i))).get("type");
				strRevision = (String)((HashMap)(inputList.get(i))).get("type");
			//	strid = (String)inputMap.get("id");
				strDescription = (String)((HashMap)(inputList.get(i))).get("attribute[PLMEntity.V_description].value");
			
				doc = new Document();
				doc.add(new TextField("type", strType, Field.Store.YES));
				doc.add(new TextField("name", strName, Field.Store.YES));
				doc.add(new TextField("revision", strRevision, Field.Store.YES));
				doc.add(new StringField("id", strid, Field.Store.YES));
				doc.add(new TextField("description", strDescription, Field.Store.YES));
				w.addDocument(doc);*/

			}
		}
	}
	
	
	
	
}
