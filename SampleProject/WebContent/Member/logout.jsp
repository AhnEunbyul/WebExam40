<%@ page contentType="text/html; charset=UTF-8" %>
<%
	session.invalidate();
%>
<html>
<head>
<title>로그아웃 처리 </title>
</head>
<script>
	alert("로그아웃 되었습니다.");
	location.href="index.jsp";
</script>
<html>
