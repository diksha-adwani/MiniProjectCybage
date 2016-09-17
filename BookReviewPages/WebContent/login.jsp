<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css"/>
</head>
<body>
<%@ include file="Footer.jsp" %>
<h3> Enter your username and password</h3>
<main>
<form method="post" action="Login">
 
  
Username   : <input align="center" type="text" name="username" required></input><br><br>
Password   : <input align="center" type="password" name="pass" required></input><br><br>
 <font style="margin-left : 7em;"><input align="center" type="submit" value="login"  style="height:30px;width:80px"></input><br><br>
  


   </form>
 </main> 
    





<!-- 
	<form method="post" action="Login">
		<table border=1>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form> -->
</body>
</html>