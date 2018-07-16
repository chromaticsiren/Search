<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.*" %>
<%@ page import="com.RSearch.SearchServices.*" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.fasterxml.jackson.databind.SerializationFeature" %>

<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
th {
    text-align: left;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">


<%
	String sQuery = request.getParameter("searchquery");

	List<Map> searchResults = new SearchUtils().retrieveResults(sQuery);
	
	ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    String json = mapper.writeValueAsString(searchResults);
    
    String encodedResults=java.net.URLEncoder.encode(json,"UTF-8");
    
    String strFwdUrl = "SearchResults.jsp?Results="+encodedResults;
    
    response.sendRedirect(strFwdUrl);
%>
</html>
