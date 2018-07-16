<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.*" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.fasterxml.jackson.databind.SerializationFeature" %>


<%
String strResults = request.getParameter("Results");

ObjectMapper mapper = new ObjectMapper();
mapper.enable(SerializationFeature.INDENT_OUTPUT);

List<Map> lInput= mapper.readValue(strResults, List.class);


%>

<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
</head>
<h1>Indexed Search Results</h1>
<br>
<h3>Date = <%= new Date() %></h3>
<table>
<tr>
  <th>Type</th>
  <th>Name</th>
  <th>Revision</th>
</tr>

<%
for(int i=0; i<lInput.size();i++)
{
	String type = (String)(((HashMap)lInput.get(i)).get("type"));
	String name = (String)(((HashMap)lInput.get(i)).get("name"));
	String revision = (String)(((HashMap)lInput.get(i)).get("revision"));
%>


<tr>
  <td><%=type%></td>
  <td><%=name%></td>
  <td><%=revision%></td>
</tr>

<%
}
%>
</table>
</html>


