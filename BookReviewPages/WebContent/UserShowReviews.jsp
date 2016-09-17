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
<h3>Book Reviews</h3>
<main>
	<table align='center' bgcolor='' border='1'>
		<tr>
			<th><font size='3'>Employee ID</font></th>
			<th><font size='3'>Review</font></th>
		</tr>
		<c:forEach var="bookReview" items="${requestScope.reviewList}">
		<tr>
			<td>${bookReview.empId}</td>
			<td>${bookReview.review}</td>
		</tr>
		</c:forEach>
	</table>
	</main>
</body>
</html>