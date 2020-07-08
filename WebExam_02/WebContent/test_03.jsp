<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String age = request.getParameter("age");
	// 다른 곳에 있는 것을 가져 올 때 request.getParameter 라는 메소드를 이용한다.
	// 따로 객체를 생성하지 않아도 직접 사용이 가능하다. - jsp 내장 객체<tomcat 설치 되어 있을 때만 가능>
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과는 : <%= age %>
</body>
</html>