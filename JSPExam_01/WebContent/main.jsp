<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>

<% 
	Calendar date = Calendar.getInstance();
	SimpleDateFormat df = new SimpleDateFormat("yyyy년MM월dd일"); 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<p></p>
	HOME
<p></p>
	오늘 날짜는 <%= df.format(date.getTime()) %> 입니다.
	<br>
<p></p>
</body>
</html>

<%@ include file="footer.jsp" %>