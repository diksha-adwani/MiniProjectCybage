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

    <h3>Welcome to CybageNet</h3>

<main>
<form action="login.jsp">
 
  <button  id="tab1" onclick="index.jsp" value="login"></button>
  <label for="tab1">login</label>
</form>
<form  action="1.html">
	
  <button  id="tab2" onclick="1.html"></button>
  <label for="tab2">about us</label>
   </form>
	<form action="1.html">
 <button  id="tab3" onclick="2.html"></button>
  <label for="tab3">contact us</label>
   </form>
	<form  action="1.html">
 <button  id="tab4" onclick="3.html"></button>
  <label for="tab4">Why books</label>
  </form>

</body>
</html>
<!-- done -->