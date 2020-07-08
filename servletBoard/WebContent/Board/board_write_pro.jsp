<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int row = (int)request.getAttribute("row");
	if(row==1){
%>
<script>
	alert("등록되었습니다.");
	location.href="board_list";
</script>

<% }else { %>
<script>
	alert("등록에 실패했습니다. \n 다음에 다시 하셔");
	history.back();
</script>
<% } %>
