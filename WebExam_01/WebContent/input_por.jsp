<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String age = request.getParameter("age");
	// 숫자는 이동이 안된다! 무조건 문자!(String)
	out.print("age:" + age + "<br>");
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어서와</title>
</head>
<body>
	나이는 <%= age %>
</body>
</html>