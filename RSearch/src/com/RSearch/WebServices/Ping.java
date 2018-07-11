package com.RSearch.WebServices;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Ping
{
	@GET
	@Path("/test")
	public Response test()
	{
		Date date = new Date();
		String output = "Ping! Hello There!";
		return Response.status(200).entity(output+"<br><br>"+date.toString()).build();
	}
}