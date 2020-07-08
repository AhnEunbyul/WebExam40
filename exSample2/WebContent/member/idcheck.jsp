<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${check}">
	<script>
		alert("아이디가 존재합니다.")
		history.back();
	</script>
</c:if>
<c:if test="${!check}">
	<script>
		alert("사용가능한 아이디입니다.")
		history.back();
		opener.document.membe.pwd.focus();
	</script>
</c:if>