<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="Footer.jsp" %>
<h3></h3>
<h3>Welcome Admin</h3>
<main>
	<form action="AddBook.jsp"><font size="3">click to add new book</font> 
		<font style="margin-left : 7em;"><input type = "submit" value="AddBook" style="height:20px;width:100px" align="middle">
	</form>
	<br><br>
	
	<form action="RemoveBook.jsp"><font size="3">click to remove book from database</font>
		<font style="margin-left : 2em;">  <input  class="button" type = "submit" value="RemoveBook" style="height:20px;width:100px" align="middle">
	</form>
	<br><br>
	
	<form action="ViewBook.jsp"><font size="3">click to view books</font>
	<font style="margin-left : 8em;">	<input type = "submit" value="View Book" style="height:20px;width:100px" align="middle">
	</form>
	<br><br>
	
	<form action="AddUser.jsp"><font size="3">click to add new user</font>
	<font style="margin-left : 7.2em;">	<input type = "submit" value="Add User" style="height:20px;width:100px" align="middle">
	</form>
	
	</main>
	Active Users Count:${activeUsersCount}
	<!-- <a href="ViewBook.jsp">View Book</a> -->
	
</body>
</html>

<!-- done -->