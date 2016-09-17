<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
</head>
<body>

<%@ include file="UserHeader.jsp" %>
<%@ include file="Footer.jsp" %>
	<form action='index.jsp'>
		<input type='submit' value='Home'></input>
	</form>
	<form action='index.jsp'>
		<input type='submit' value='Logout'></input>
	</form>

	<br />

	<h3 align='center'>Please Submit Your Valuable Review</h3>

<main>
	<form action='UserAddReview' method='post'>
		<table align='center' bgcolor=''>

			<tr>
				<td>Employee ID :</td>
				<td><input type='text' name='empid'
					value='${sessionScope.employee.empId}' readonly></td>
			</tr>
	
			<tr>
				<td>ISBN No<font style="margin-left : 1.8em;"> :</td>
				<td><input type='text' name='isbn' value='${param.isbn}'></td>
			</tr>
			<tr>
				<td>Type Review :</td>
				<td><textarea name='review' cols="38" rows="4" required></textarea></td>
			</tr>
			<tr>
				<td><input type='submit' value='Submit' align="middle"></td>
			</tr>

		</table>
	</form>
	</main>
</body>
</html>