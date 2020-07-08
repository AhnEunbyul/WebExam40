<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int row = (int)request.getAttribute("row");
	if(row == 1) {
%>
	<script>
		alert("등록성공");
		location.href = "guest.do";
	</script>		
<%
	} else {
%>	
	<script>
		alert("등록실패");
		history.back();
	</script>
<%
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과 : ${row}
</body>
</html>