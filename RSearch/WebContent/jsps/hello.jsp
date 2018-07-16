<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>RSearch</title>
</head>
<body>
<h2>Hi There!</h2>
<br>
<h3>Date = <%= new Date() %>
</h3>


 <FORM NAME="indexform"  action="jsps/IndexPreProcess.jsp" METHOD="POST"> 
       <input type="submit" value="Index Data" />
     
</FORM>

 <br>
 <br>
 
 <FORM NAME="searchform"  action="jsps/SearchPreProcess.jsp" METHOD="POST">
       <input type="text" name= "searchquery" id="searchquery" placeholder="Enter Search Query"/>
       <input type="submit" value="Search" />
</FORM>

</body>
</html>
