<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css"/></head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="Footer.jsp" %>

<%--Database Connection using Listener in Scriptlet tag --%>
<%
	Connection con ;
	ServletContext ctx;
	ctx = getServletContext();
	
	con = (Connection) ctx.getAttribute("mycon");//Fetching connection from listener class 
	if(con==null)
		System.out.println("No connection");
	else
		System.out.println(" connection established ");
	
	PreparedStatement ps = con.prepareStatement("select distinct category from books");//Query for fetching distinct category from books table 
	ResultSet rs = ps.executeQuery();//Storing result in resultset
%>
<%--Displaying category as drop down list and text box for book name input to search book based on category or book name or both  --%>
<h1>Search book</h1>
<main>
	<center>
		
		<form action="ViewBook">
		<font size="3">Category</font>


			<select name="category">
				<option value="all">All</option>
				<%  while(rs.next()){ %>
				<option value="<%= rs.getString(1)%>"><%= rs.getString(1)%></option>
				<% } %>
			</select> <input type="text" name="book_name" placeholder="Book name"/> <input type="submit"
				value="Search" />
		</form>
	</center>
</main>
</body>
</html>