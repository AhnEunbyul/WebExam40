<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String gender = request.getParameter("gender");
	String favArr[] = request.getParameterValues("fav");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_03_pro.jsp</title>
</head>
<body>
	성별 : <%= gender %><br>
	
	취미 : 
	
</body>
</html>