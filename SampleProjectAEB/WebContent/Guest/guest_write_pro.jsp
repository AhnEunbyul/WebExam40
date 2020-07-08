<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${row==1}">
	<script>
		alert("리얼 등록됨");
		location.href="guest_list";
	</script>
</c:if>
<c:if test="${row==0}">
	<script>
		alert("응 아니야~ \n 너 다시해야 돼");
		history.back();
	</script>
</c:if>

