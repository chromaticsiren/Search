<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.*" %>
<%@ page import="com.RSearch.SearchServices.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hello</title>
</head>
<body>
<h2>Hi There!</h2>
<br>
<h3>Date=<%= new Date() %>
</h3>


 <FORM NAME="form1"  action="jsps/SearchPreProcess.jsp" METHOD="POST"> 
       <input type="text" name= "searchquery" id="searchquery" placeholder="Enter Search Query"/>

<%
	String sQuery = request.getParameter("searchquery");
	System.out.println("sQuery>>PreProcess"+sQuery);
	new SearchUtils().retrieveResults(sQuery);
%>
</FORM>

</body>
</html>
