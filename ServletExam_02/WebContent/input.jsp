<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input.jsp</title>
</head>
<body>
	<form name = "frm" method = "post">
		<table border = "1" width = "380">
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pw"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea name = "contents" rows = "3" cols = "30"></textarea></td>
			</tr>
		</table>
	</form>
</body>
</html>