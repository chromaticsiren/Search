package com.RSearch.IndexingServices;

import java.util.List;
import java.util.Map;

public class PreProcessingUtils {
	
	public void DataPreProcessor(List<Map> inputList) throws Exception
	{
		System.out.println("DataPreProcessor ::: ");
		
		if(inputList != null && inputList.size() >0)
		{
			DataIndexingUtils dIUtils = new DataIndexingUtils();
			dIUtils.indexData(inputList);
		}
	}

}
