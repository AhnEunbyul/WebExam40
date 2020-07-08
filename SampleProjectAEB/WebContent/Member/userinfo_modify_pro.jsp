<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%

	

	int row = (int)request.getAttribute("row");



	if(row == 1){

%>



<script>

alert("수정 성공하였습니다.");

location.href = "index.jsp"

</script>



<%

	}else{

%>

<script>

alert("수정 실패하였습니다.");

history.back();

</script>

<%

	}

%>