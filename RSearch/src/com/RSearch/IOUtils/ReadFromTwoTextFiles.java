package com.RSearch.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFromTwoTextFiles {

	public static void main(String[] args) throws Exception {
		
		
    	List<Map> mlInput = new ArrayList<Map>();
    	List<Map<?, ?>> mlInput1 = new ArrayList<Map<?, ?>>();
    	
        try 
        {

            File f = new File("C:\\Users\\502244529\\Documents\\ReleasedObjInfo-findObjs -Test.txt");

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

            File f1 = new File("C:\\Users\\502244529\\Documents\\ReleasedObjInfo-CAList-Test.txt");

            BufferedReader b1 = new BufferedReader(new FileReader(f1));

            String readLine1 = "";

            System.out.println("Reading file using Buffered Reader");

            int i1 =0;
           
            String[] slTemp1_1 = null;
            String[] slTemp2_1 = null;
            
            while ((readLine1 = b1.readLine()) != null) 
            {
            	Map mTemp1 = new HashMap();   
            	slTemp1_1 = readLine.split(",");
            	
            	for(int j=0; j<slTemp1_1.length;j++)
            	{
            		
            		slTemp2_1 = ((((String)slTemp1_1[j]).trim()).split("="));
            		mTemp1.put((String)slTemp2_1[0], (String)slTemp2_1[1]);
            		
            	}
            	mlInput1.add(mTemp1);
            }
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
	}

}
