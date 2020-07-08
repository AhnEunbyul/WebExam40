<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어서오세요 ^ㅡ^</title>
</head>
<body>
	<form method = "post" name = "join" action = "JoinServlet">
		<table name = "join_table" width = "1000px">
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type = "text" name = "first_id"> -
					<input type = "password" name = "last_id">
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pw"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type = "password" name = "re_pw"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type = "text" name = "email"> @
					<input type = "text" name = "last_email">
					<select id = "SelectEmail" name = "SelectEmail" size = "1">
						<option value = "naver.com">naver.com</option>
						<option value = "hanmail.net">hanmail.net</option>
						<option value = "nate.com">nate.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type = "text" name = "addrNum"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type = "text" name = "first_addr">
					<input type = "text" name = "last_addr">
				</td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td><input type = "text" name = "phone"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><select id = "job" name = "job" size = "1">
						<option value = "0">선택하세요</option>
						<option value = "학생">학생</option>
						<option value = "주부">주부</option>
						<option value = "공무원">공무원</option>
						<option value = "컴퓨터/인터넷">컴퓨터/인터넷</option>
						<option value = "무직">무직</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>메일/SMS 정보 수신</td>
				<td><input type = "radio" id = "smsCheck" name = "smsCheck" value = "수신">수신
					<input type = "radio" id = "smsCheck" name = "smsCheck" value = "수신거부">수신거부
				</td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td>
					<input type = "checkbox" name = "coffee" value = "생두">생두
					<input type = "checkbox" name = "coffee" value = "원두">원두
					<input type = "checkbox" name = "coffee" value = "로스팅">로스팅
					<input type = "checkbox" name = "coffee" value = "핸드드립">핸드드립
					<input type = "checkbox" name = "coffee" value = "에스프레소">에스프레소
					<input type = "checkbox" name = "coffee" value = "창업">창업
				</td>
			</tr>
			<br>
			<tr>
				<td colspan = "2" align = "center">
					<br>
					<input type = "submit" value = "회원가입">
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>