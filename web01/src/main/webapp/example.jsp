<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>Here is the example</title>
</head>
<body>

<%! public int sum(int a, int b){
	return a+b;
	
}
%>

<%

	Random random = new Random();
	int randomInt = random.nextInt(3);
	if(randomInt == 0){
		%>
		
		<h1> Random value = <%=randomInt %></h1>
		
		<% 
	} else if(randomInt == 1){
		%>
		
		<h1> Random value = <%=randomInt %></h1>
		
		<% 
		
	} else {
		%>
		
		<h1> Random value = <%=randomInt %></h1>
		
		<% 
	}

%>



<h1>1+2 = <%= sum(1,2) %></h1>

<a href="<%= request.getRequestURI()%>">click</a>
</body>
</html>