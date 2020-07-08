<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String last_email = (String)request.getAttribute("last_email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 내역</title>
</head>
<body>
	이름 : <b>${name}</b><br>
	주민번호 : <b>${first_id} - ${last_id} </b><br>
	아 이 디 : <b>${userid} </b><br>
	비밀번호 : <b>${pw} </b><br>
	이 메 일 : <b>${email} @ ${SelectEmail}</b><br>
	우편번호 : <b>${addrNum} </b><br>
	주소 : <b>${first_addr} ${last_addr} </b><br>
	핸드폰번호 : <b>${phone} </b><br>
	직업 : <b>${job} </b><br>
	관심분야 : <b>${coffeeStr} </b><br>
	
	<br><a href='javascript:history.go(-1)'>다시</a>
	
</body>
</html>