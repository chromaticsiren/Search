package com.RSearch.WebServices;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.json.JSONObject;

import com.RSearch.IndexingServices.PreProcessingUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Path("/index")
public class DataIndexService {
	
	@GET
	@Path("/test")
	public void test() throws Exception
	{
		System.out.println("DataIndexService received the request");
	}
	
	@GET
	@Path("/data")
	public void DataIndexPreProcessor(@QueryParam("data") String input) throws Exception
	{
		PreProcessingUtils processUtils = new PreProcessingUtils();
		
		ObjectMapper mapper = new ObjectMapper();
	      mapper.enable(SerializationFeature.INDENT_OUTPUT);

		 List<Map> lInput= mapper.readValue(input, List.class);
		
		processUtils.DataPreProcessor(lInput);
	}
}
