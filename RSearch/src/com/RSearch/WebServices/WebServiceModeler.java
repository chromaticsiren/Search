package com.RSearch.WebServices;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class WebServiceModeler extends Application  
{
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> s = new HashSet<Class<?>>();
		
		s.add(Ping.class);
		s.add(DataIndexService.class);
		
		return s;
	}
}
