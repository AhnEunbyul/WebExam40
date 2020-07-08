<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int row = (int)request.getAttribute("row");
	if(row==1){
%>
<script>
	alert("수정되었습니다.");
	location.href="board_list";
</script>

<% }else { %>
<script>
	alert("수정에 실패했습니다.");
	history.back();
</script>
<% } %>