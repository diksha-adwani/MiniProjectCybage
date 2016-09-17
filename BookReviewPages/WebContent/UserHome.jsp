<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css"/></head>
<body link="black">
<%@ include file="UserHeader.jsp" %>
<%@ include file="Footer.jsp" %>
<h3></h3>
<h3>Welcome ${sessionScope.employee.firstName}</h3><br/>
	<%
Connection con ;
ServletContext ctx;
ctx = getServletContext();

con = (Connection) ctx.getAttribute("mycon");
if(con==null)
	System.out.println("No connection");
else
	System.out.println(" connection established ");

PreparedStatement ps = con.prepareStatement("select distinct category from books");
ResultSet rs = ps.executeQuery();

%>

	<center>
		<h2>Search Book</h2>
		<main>
		<form action="UserViewBookList"  method="post">
		<font style="margin-left : 3em;">category</font>	<select name="category">
				<option value="all">All</option>
				<%  while(rs.next()){ %>
				<option value="<%= rs.getString(1)%>"><%= rs.getString(1)%></option>
				<% } %>				
				
			</select> <input type="text" name="book_name" placeholder="Book name" /> 
			<input type="submit"
				value="Search" />
		</form>
		</main>
	</center>

</body>
</html>