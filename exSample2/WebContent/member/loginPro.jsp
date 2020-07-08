<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${row == 1}">
	<script>
		alert("환영합니다.");
		<%
			session.setAttribute("user", request.getParameter("userid"));
			session.setMaxInactiveInterval(1800);
		%>
		location.href="member?command=index";
	</script>
</c:if>
<c:if test="${row == 0}">
	<script>
		alert("비밀번호가 알맞지 않습니다.");
		history.back();
	</script>
</c:if>
<c:if test="${row == -1}">
	<script>
		alert("아이디가 존재하지 않습니다.");
		history.back();
	</script>
</c:if>