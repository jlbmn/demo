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
<div class="container" style="background: #cdd; height: 100%;">



		<h1>forTokens</h1>
		<c:if test="${not empty list }">
			<h3>list of names</h3>
			<div class="list-group">

				<c:forTokens items="bastien,anita,damien,elouan" delims=","	var="name">
					<span class="list-group-item"><c:out value="${name }" /></span>
				</c:forTokens>
			</div>
		</c:if>
	</div>

	
</body>
</html>