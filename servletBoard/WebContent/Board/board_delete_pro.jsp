<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int row = (int)request.getAttribute("row");
	if(row == 1){
%>
	<script>
		alert("삭제되었습니다.");
		opener.location.replace("board_list");
		// 나를 호출한 부모를 부르는 명령어 : opener
		self.close();
		// 현재의 창을 닫아라
	</script>
	
<% } else { %>

	<script>
		alert("비밀번호가 맞지 않습니다.");
		history.back();
	</script>
	
<% } %>