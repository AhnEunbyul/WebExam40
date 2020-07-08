<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int s = 0;
	int sum(int a, int b) {
		for(int i = a; i < b; i++){
			s += i;
		}
		return s;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP TEST - test_02.jsp</title>
</head>
<body>
	결과는 <%= sum(1,10) %> 입니다.
</body>
</html>