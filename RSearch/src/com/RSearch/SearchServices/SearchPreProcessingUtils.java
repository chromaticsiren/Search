package com.RSearch.SearchServices;


public class SearchPreProcessingUtils {
	
	public void searchPreProcessor(String input) throws Exception
	{
		System.out.println("SearchPreProcessor::: input ::"+input);
		
		new SearchUtils().retrieveResults(input);
	}
}
