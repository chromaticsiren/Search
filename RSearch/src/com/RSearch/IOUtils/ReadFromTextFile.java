package com.RSearch.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ReadFromTextFile {

	public static void main(String[] args) 
	{
    	List<Map> mlInput = new ArrayList<Map>();
    	List<Map<?, ?>> mlInput1 = new ArrayList<Map<?, ?>>();

        try 
        {
            File f = new File("C:\\Users\\502244529\\Desktop\\new 4.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";
            System.out.println("Reading file using Buffered Reader");

            int i =0;
           
	        String[] slTemp = null;
	        String[] slTemp1 = null;
            while ((readLine = b.readLine()) != null) 
            {
            	Map mTemp = new HashMap();   

	        	slTemp = readLine.split(",");
            	for(int j=0; j<slTemp.length;j++)
            	{
            		slTemp1 = ((((String)slTemp[j]).trim()).split("="));
            		
            		mTemp.put((String)slTemp1[0], (String)slTemp1[1]);
            		
            	}
            	mlInput.add(mTemp);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            
            String json = mapper.writeValueAsString(mlInput);
            
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}