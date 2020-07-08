<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nn = (String)request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	나이 : ${age}<br>	<!-- request라는 내장객체를 불러올 때 $를 쓴다. (서블릿과 연관되기도!) -->
	이름 : ${name}<br>
	이름 : <%= nn %><br>
</body>
</html>