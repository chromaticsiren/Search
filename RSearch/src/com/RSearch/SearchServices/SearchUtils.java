package com.RSearch.SearchServices;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
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
		List returnList = new ArrayList();
		
		String querystr = strInput;
		System.out.println("SearchUtils ::: retrieveResults >>>"+querystr);
		
		try 
		{
			StandardAnalyzer analyzer = new StandardAnalyzer();
			FSDirectory index = FSDirectory.open(Paths.get("C:\\Personal\\Eclipse_Workspace\\RSearch\\IndexLocation"));
			
			//Searches the input string against the "type" field in the index
			//Full type name has to be given as input -- not case sensitive.(Example: VPMReference or vpmreference)
			Query q = new QueryParser("name", analyzer).parse(querystr);
			
			
			int hitsPerPage = 10;
			IndexReader reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopDocs docs = searcher.search(q, hitsPerPage);
			ScoreDoc[] hits = docs.scoreDocs;

			System.out.println("Found " + hits.length + " hits.");
			
			for(int i=0;i<hits.length;++i) 
			{
			    int docId = hits[i].doc;
			    System.out.println("Doc Id : "+docId);
			    Document d = searcher.doc(docId);
			    System.out.println((i + 1) + ". " + d.get("type") + "\t" + d.get("name") + "\t" + d.get("revision"));
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
