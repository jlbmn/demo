<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
<c:if test="${not empty list }">
			<h3>list of employes</h3>
			<div class="list-group">
				
				<c:forEach items="${list}" var="emp">
					<c:choose>
						<c:when test="${emp.title == 'title1'}">
							<a class="list-group-item">
								<span class="list-group-item-info"> ${emp.firstName }- ${emp.lastName }</span>
								<p>		- ${emp.title }</p>
									
							</a>
						</c:when>
						
						<c:when test="${emp.title == 'title3'}">
						<c:set var="emp3" value="${emp}"/>
							<a class="list-group-item">
								<span class="list-group-item-dark"> ${emp.firstName }- ${emp.lastName }</span>
								<p>		- ${emp.title }</p>
									
							</a>
						</c:when>
						
						<c:otherwise>
							<a class="list-group-item">
								<span class="list-group-item"> ${emp.firstName }- ${emp.lastName }</span>
								<p>		- ${emp.title }</p>
									
							</a>
						</c:otherwise>
					</c:choose>	

				</c:forEach>
				
				<h3><c:out value="${emp3}"/></h3>
			</div>
		</c:if>
</div>
	
</body>
</html>