<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css"/></head>
<body>
<%@ include file="UserHeader.jsp" %>
<%@ include file="Footer.jsp" %>
	<h3>Book Details</h3>
<main>
	<TABLE BORDER="2" CELLPADDING="3" CELLSPACING="1"
		style="text-align: center;" align='center'>

		<tr>
			<td>ISBN:</td>
			<td>${requestScope.bookPojo.isbn}</td>

		</tr>
		<tr>
			<td>Book Name:</td>
			<td>${requestScope.bookPojo.bookName}</td>
		</tr>
		<tr>
			<td>Category:</td>
			<td>${requestScope.bookPojo.category}</td>
		</tr>
		<tr>
			<td>Author:</td>
			<td>${requestScope.bookPojo.author}</td>
		</tr>
		<tr>
			<td>Publication:</td>
			<td>${requestScope.bookPojo.publication}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${requestScope.bookPojo.description}</td>
		</tr>
		<%-- ${requestScope.bookPojo.isbn} --%>
		<tr>
			<td><form method="get" action="UserAddReview.jsp">
					<input type='hidden' name='isbn' value='${requestScope.bookPojo.isbn}'>
					<input type='submit' value='Add Review' align="middle">
				</form>
			</td>

			<td>
				<form method="post" action="UserShowReview">
					<input type='hidden' name='isbn' value='${requestScope.bookPojo.isbn}'>
					<input type='submit' value='Show All Reviews' align="middle">
				</form>
			</td>
		</tr>
	</table>
	</main>





</body>
</html>