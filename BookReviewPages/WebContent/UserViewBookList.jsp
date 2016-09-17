<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cybagenet.pojos.Book"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css"/></head>
<body>
<%@ include file="UserHeader.jsp" %>
<%@ include file="Footer.jsp" %>
<h3></h3>
<main>
	<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1"
		style="text-align: center;">

		<c:choose>
			<c:when test="${!empty requestScope.bookList}">

				<TR>
					<TH>ISBN No</TH>
					<TH>Name</TH>
					<TH>Category</TH>
					<TH>Author</TH>
					<TH>Publication</TH>
					<TH>Description</TH>
					<TH>Action</TH>
				</TR>
				<c:forEach items="${requestScope.bookList}" var="bookList">
					<TR>
						<TD>${bookList.isbn}</TD>
						<TD>${bookList.bookName}</TD>
						<TD>${bookList.category}</TD>
						<TD>${bookList.author}</TD>
						<TD>${bookList.publication}</TD>
						<TD>${bookList.description}</TD>
						<TD>
							<form action='UserViewBookDetails' method='post'>
								<input type='hidden' name='isbn' value='${bookList.isbn}'>
								<input type='submit' value='View Details'>
							</form>
						</TD>
					</TR>
				</c:forEach>
			</c:when>

			<c:otherwise>
				<h3>No Records Found . . .</h3>
				<h4>
					<a href="UserViewBook.jsp">Back</a>
				</h4>
			</c:otherwise>
		</c:choose>
	</TABLE>
	</main>
</body>
</html>