<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String bun = request.getParameter("bun");
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_02_pro.jsp</title>
</head>
<body>
	번호 : <%= bun %><br>
	이름 : <%= name %>
</body>
</html>