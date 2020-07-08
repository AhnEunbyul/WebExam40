<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	// 한글 안 깨지게 하는 것
	
	String bun = request.getParameter("hakbun");
	String name = request.getParameter("name");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input_pro</title>
</head>
<body>
	학번 :<%= bun %><br>
	이름 :<%= name %><br>
	연락처 :<%= phone1 %>-<%= phone2 %>-<%= phone3 %><br>
</body>
</html>