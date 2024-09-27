<%@page import="com.springproject.main.beans.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Customer customer = (Customer) request.getAttribute("Csutomer");

out.println(customer.getId() + "--" + customer.getName()+ "--" + customer.getCity() + "--" + customer.getAge());
%>
</body>
</html>