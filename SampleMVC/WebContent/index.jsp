<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "sample.model.guest.*" %>
<%
	GuestDAO dao = GuestDAO.getInstance();
	int row = dao.guestCount();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SampleMVC</title>
</head>
<body>
	<h3>SampleMVC Project</h3>
	
	자료 건수 : <%= row %>
</body>
</html>