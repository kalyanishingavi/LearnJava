<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Home here</h1>


<%
String msgVal = (String) request.getAttribute("msg_model");
out.println(msgVal);
%>
<hr>

<%
String msgVal1 = (String) request.getAttribute("msg_request");
out.println(msgVal1);
%>
<hr>

<%
String msgVal2 = (String) request.getAttribute("msg_mav");
out.println(msgVal2);
%>
<hr>

<br><br>
<H4>Products</H4>
<a href ="${pageContext.request.contextPath }/products?name=laptops">Laptops</a><br>
<a href ="${pageContext.request.contextPath }/products?name=desktops">Desktops</a><br>
<a href ="${pageContext.request.contextPath }/products?name=mobiles">Mobiles</a>

<br><br>
<sf:form action = "${pageContext.request.contextPath }/add-customer" method="post" modelAttribute="employee">
	Name : <sf:input type ="text" path ="name" />&nbsp; <sf:errors path ="name" /><br><br>
	City : <sf:input type ="text" path ="city" />&nbsp; <sf:errors path ="city" /><br><br>
	<input type="submit" value ="Create customer record"/>
</sf:form>


</body>
</html>