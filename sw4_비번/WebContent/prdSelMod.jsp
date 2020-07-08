<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리 시스템</title>
<style>
	@font-face { font-family: 'NanumBarunGothic';
	src: url('/fonts/NanumBarunGothic.eot');
	src: url('/fonts/NanumBarunGothic.eot') format('embedded-opentype'),
	url('/fonts/NanumBarunGothic.woff') format('woff');}
	
	body {font-family: 'NanumGothic', 'serif';}
	.btn_group {margin-left: 30px}
</style>
</head>
<script>
	function sel(){
		alert("조회 합니다.")
		if(frm.code.value)
	}
	function mod(){
		alert("수정하시겠습니까?")
		location.href = "modify.do?code=${code}"
	}
	function del(){
		alert("삭제하시겠습니까?")
		alert("안돼 못지워 돌아가")
		history.back();
	}
	function goMain(){
		alert("메인화면으로 돌아갑니다.")
		location.href = "navi.do";
	}
</script>
<body>
	<h1>생산관리 조회 & 수정 화면</h1>
	<p>생산관리 조회화면</p>
	<form method = "post" name = "frm" action = "select.do">
		<ul>
			<li>제품코드
				<input type = "text" name = "code">
			</li>
			<li>제품이름
				<input type = "text" name = "pname">
			</li>
			<li>제품원가
				<input type = "text" name = "cost">
			</li>
			<li>목표수량
				<input type = "text" name = "pnum">
			</li>
			<li>재고수량
				<input type = "text" name = "jnum">
			</li>
			<li>출 &nbsp;고 가 
				<input type = "text" name = "sale">
			</li>
			<li>그룹이름
				<select name = "gcode">
					<option value = "A">컴퓨터</option>
					<option value = "B">냉장고</option>
					<option value = "C">냉장고소모품</option>
				</select>
			</li>
		</ul>
		<div class = "btn_group">
		<input type = "button" value = "조 회" style = "padding: 8px 20px; background-color: #FFFFA7; box-shadow: 3px 3px" onClick = "sel()">
		<input type = "button" value = "수 정" style = "padding: 8px 20px; background-color: #FFFFA7; box-shadow: 3px 3px" onClick = "mod()">
		<input type = "button" value = "삭 제" style = "padding: 8px 20px; background-color: #FFFFA7; box-shadow: 3px 3px" onClick = "del()">
		<input type = "button" value = "메인화면" style = "padding: 8px 20px; background-color: #FFFFA7; box-shadow: 3px 3px" onClick = "goMain()">
		</div>
	</form>
</body>
</html>