<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container" style="background: #cdd; height: 100%;">
	<h2>fmt:formatDate Example</h2>
	<c:set var="dateNow" value="<%= new Date() %>"/>
	<p>
		Time(fmt:formatDate type="time")
		<br>Time: 
		<strong>
			<fmt:formatDate value="${dateNow }" type="time"/>
		</strong>
		<br>Date:
		<strong>
			<fmt:formatDate value="${dateNow }" type="date"/>
		</strong>
		<br>Choose pattern:
		<strong>
			<fmt:formatDate value="${dateNow }" pattern="dd-MM-yyy HH:mm:ss"/>
		</strong>
	</p>
</div>
</body>
</html>