<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int bun = 10;
	String name = "홍길동";
	String nn = "";
	if(bun<20){
		nn = "미성년자";
	}
	out.print("번호 : " + bun + "<br>");
	// web은 enter가 안 먹기 때문에 ln 사용 불가능하다. 그래서 br을 넣어줘야..
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP TEST - test_01.jsp</title>
</head>
<body>
	번호 : <%= bun %><br>
	이름 : <%= name %><br>
	비고 : <%= nn %>
</body>
</html>