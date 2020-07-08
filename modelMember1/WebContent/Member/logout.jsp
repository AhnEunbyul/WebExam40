<%@ page contentType="text/html; charset=UTF-8" %>

<%
	session.invalidate();
%>
<html>
<head>
<title>로그아웃 처리 </title>
</head>
<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href="userinfo_list.jsp";
</script>

<html>
