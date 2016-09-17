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

	<br />

	<h1 align='center'>Welcome Admin </h1>
		<h3 align='center'>Please fill the details to add book </h3>
	

<main>
	<form action='AddBook' method='post'>
		<table align='center' bgcolor='white'>

			<tr>
				<td>Select Book Category :</td>
				<td><select name='category'>
						<option>Novel</option>
						<option>Fictions</option>
						<option>Historical</option>
						<option>Technical</option>
						<option>Science Fiction</option>
				</select></td>
				<td ><font color='red'>*</font></td>
			</tr>

			<tr>
				<td>Enter Book ISBN No :</td>
				<td><input type='text' name='isbn' required></td>
				<td ><font color='red'>*</font></td>
			</tr>
			<tr>
				<td>Enter Book Name :</td>
				<td><input type='text' name='name' required></td>
				<td ><font color='red'>*</font></td>
			</tr>
			<tr>
				<td>Enter Book Author :</td>
				<td><input type='text' name='author' required></td>
				<td ><font color='red'>*</font></td>
			</tr>
			<tr>
				<td>Enter Book Publication :</td>
				<td><input type='text' name='publication' required></td>
				<td ><font color='red'>*</font></td>
			</tr>
			<tr>
				<td>Enter Book Description :</td>
				<td><input type='text' cols='40' rows='5' name='description'
					style='width: 200px; height: 50px;'></td>
			</tr>

			<tr>
				<td><input type='submit' value='Add Book' align="middle" style="height:30px;width:80px"></td>
			</tr>

		</table>
	</form>
	
	</main>
</body>
</html>

<!-- done -->