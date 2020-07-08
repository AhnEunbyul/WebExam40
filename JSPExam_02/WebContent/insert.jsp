<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert.jsp</title>
</head>
<body>
	<form name="frm" method="post" action="insert_bean.jsp">
		아이디 : <input type="text" name="userid"><br>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="email"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>