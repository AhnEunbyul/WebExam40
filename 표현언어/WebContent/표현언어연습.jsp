<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	\${5+2} : ${5+2} <br>
	\${5/2} : ${5/2} <br>
	\${5 div2} <br>
	\${6 mod 4} : ${6 mod 4} <br>
	\${5 > 2} : ${5 > 2} <br>
	\${2 gt 10} : ${2 gt 10} <br>
	<%
		String input = null;
	%>
	\${empty input} : ${empty input} <br>
</body>
</html>