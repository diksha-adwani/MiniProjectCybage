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
<h3></h3>
<h1>Remove book</h1>
	
	<main>
	<form action='RemoveBook'>
		<table align='center' bgcolor=''>
			<tr>
				<td>Select Book Category :</td>
				<td><select name='category' style="height:30px;width:120px"><option>Novel</option>
						<option>Fictions</option>
						<option>Historical</option>
						<option>Technical</option>
						<option>Science Fiction</option>
				</select></td>
				<!-- <td bgcolor='red'>*</td> -->
			</tr>

			<tr>
				<td><input type='submit' value='Remove Book' align="middle" style="height:30px;width:100px"></td>
			</tr>
		</table>
	</form>
	
	<br/><br/><br/>

	<form action='RemoveBook' method='post'>
		<table align='center' bgcolor=''>

			<tr>
				<td>Enter Book Title :</td>
				<td><input type='text' name='title' required></td>
			</tr>
			<tr>
				<td><input type='submit' value='Remove Book' align="bottom" style="height:30px;width:100px"></td>
			</tr>
			
		</table>
	</form>
	</main>

</body>
</html>
