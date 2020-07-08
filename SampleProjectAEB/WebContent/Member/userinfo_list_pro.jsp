<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%

	boolean flag = (boolean)request.getAttribute("flag");

	

	if(flag){

%>

<script>

	alert("회원가입 성공!");

	location.href="index.jsp";

</script>

<%

	}else{

%>

<script>

	alert("회원가입 실패!");

	histroy.back();

</script>

<%

	}

%>