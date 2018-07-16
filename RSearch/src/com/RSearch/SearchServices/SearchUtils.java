package com.RSearch.SearchServices;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import  com.RSearch.IndexingServices.*;

public class SearchUtils extends DataIndexingUtils 
{
	
	public List<Map> retrieveResults(String strInput) throws Exception
	{
		List<Map> returnList = new ArrayList();
		
		String querystr = strInput;
		//System.out.println("SearchUtils ::: retrieveResults >>>"+querystr);
		
		try 
		{
			StandardAnalyzer analyzer = new StandardAnalyzer();
			FSDirectory index = FSDirectory.open(Paths.get("C:\\Personal\\Eclipse_Workspace\\RSearch\\IndexLocation"));
			
			
			BooleanClause.Occur[] flags = new BooleanClause.Occur[DataIndexingUtils.docFieldsSet.size()];
			
			String[] docFields =   DataIndexingUtils.docFieldsSet.toArray(new String[DataIndexingUtils.docFieldsSet.size()]);
			
			 for (int i=0; i<docFields.length; i++ )
			 {
//				 System.out.println("Search Utils ::: docFields from Set :::>>["+i+"]" + docFields[i]);
				 flags[i] = BooleanClause.Occur.SHOULD;
		     }

			 Query mltFldQuery = MultiFieldQueryParser.parse(querystr, docFields, flags, analyzer);
			
			int hitsPerPage = 10;
			IndexReader reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopDocs docs = searcher.search(mltFldQuery, hitsPerPage);
			ScoreDoc[] hits = docs.scoreDocs;

			//System.out.println("Found " + hits.length + " hits.");
			
			if(hits.length>0)
			{
				Map<String, String> mTemp = null;
				
				for(int i=0;i<hits.length;++i) 
				{
					mTemp = new HashMap<String, String>();
				    int docId = hits[i].doc;
				    System.out.println("Doc Id : "+docId);
				    Document d = searcher.doc(docId);
				    System.out.println((i + 1) + ". " + d.get("type") + "\t" + d.get("name") + "\t" + d.get("revision"));
				    
				    mTemp.put("type", d.get("type"));
				    mTemp.put("name", d.get("name"));
				    mTemp.put("revision", d.get("revision"));
				    returnList.add(mTemp);
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnList;
	}
}
