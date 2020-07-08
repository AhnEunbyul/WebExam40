<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생성적관리 프로그램</title>
<style>
	* {padding: 0; margin: 0}
	.header {text-align: center; background-color: #38ADC1; padding: 20px 0}
	.logo {color: #fff;}
	.navi {background-color: #6EE3F7; padding: 12px 0; overflow: hidden;}
	.navi ul li {list-style: none; float: left; padding: 0 20px; text-align: center}
	a {text-decoration: none; color: #000}
	.title {text-align: center; padding: 30px 0}
	table th,td {border: 1px solid}
	table th {width: 100px}
	table td {width: 400px}
	table {margin-bottom: 50px}
	.btn_group {text-align: center}
	footer {text-align: center; background-color: #4ABFD3; padding: 20px 0}
	footer p {color: #000;}
</style>
</head>
<script type="text/javascript">
	function send(){
		if(frm.bun.value == ""){
			alert("번호가 입력되지 않았습니다.")
			frm.bun.focus();
			return
		}
		
		// 번호 유효성 체크 변수
		var bunf = /^[0-9]{4}$/;
		if(!frm.bun.value.match(bunf)){
			alert("번호의 입력이 잘못되었습니다.")
			frm.bun.focus();
			return
		}
		if(frm.name.value == ""){
			alert("이름이 입력되지 않았습니다.")
			frm.name.focus();
			return
		}
		for(i = 0, flag = 0; i < frm.gender.length; i++){
			if(frm.gender[i].checked){
				flag = 1;
				break;
			}
		}
		if(!flag){
			alert("성별이 선택되지 않았습니다");
			return;						
		}
		if(frm.kor.value == ""){
			alert("국어점수가 입력되지 않았습니다.")
			frm.kor.focus();
			return
		}
		// 국어 점수 유효성 체크 변수
		var kor = parseInt(frm.kor.value);
		if(!(kor >= 0 && kor <= 100)){
			alert("점수의 입력이 잘못되었습니다.");
			document.frm.kor.focus();
			return
		}
		if(frm.eng.value == ""){
			alert("영어점수가 입력되지 않았습니다.")
			frm.eng.focus();
			return
		}
		// 영어 점수 유효성 체크 변수
		var eng = parseInt(frm.eng.value);
		if(!(eng >= 0 && eng <= 100)){
			alert("점수의 입력이 잘못되었습니다.");
			document.frm.eng.focus();
			return
		}
		if(frm.mat.value == ""){
			alert("수학점수가 입력되지 않았습니다.")
			frm.mat.focus();
			return
		}
		// 수학 점수 유효성 체크 변수
		var mat = parseInt(frm.mat.value);
		if(!(mat >= 0 && mat <= 100)){
			alert("점수의 입력이 잘못되었습니다.");
			document.frm.mat.focus();
			return
		}
		
		alert("등록하시겠습니까?");
		frm.submit();
	}
	function del(){
		frm.reset();
		frm.bun.focus();
	}
	
</script>
<body>
	<div class="header">
			<header>
				<h1 class="logo">(과정평가형 정보처리산업기사)학생성적 관리 프로그램ver2009-06</h1>
			</header>
		</div>
		<div class="menu">
			<nav class="navi">
				<ul>
					<a href="InsertBun.jsp"><li>학생성적등록</li></a>
					<a href="bunView.jsp"><li>학생성적조회</li></a>
					<a href="index.jsp"><li>홈으로</li></a>
				</ul>
			</nav>
		</div>
			<section>
				<h1 class="title">학생성적관리 프로그램</h1>
				<center>
				<form method="post" name="frm" action="InsertBun_pro.jsp">
					<table>
						<tr>
							<th>번호</th>
							<td><input type="text" name="bun">(4자리:1101)</td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<th>성별</th>
							<td>
								<input type="radio" name="gender" value="m">남자
								<input type="radio" name="gender" value="f">여자
							</td>
						</tr>
						<tr>
							<th>국어</th>
							<td><input type="text" name="kor">(0~100)</td>
						</tr>
						<tr>
							<th>영어</th>
							<td><input type="text" name="eng">(0~100)</td>
						</tr>
						<tr>
							<th>수학</th>
							<td><input type="text" name="mat">(0~100)</td>
						</tr>
						<tr>
							<th>등록일자</th>
							<td><input type="date" name="regdate"></td>
							<script>
								var today = new Date();
						        var dd = today.getDate();
						        var mm = today.getMonth()+1; // Jan is 0
						        var yyyy = today.getFullYear();
						 
						        if(dd<10){
						            dd = '0'+dd
						        }
						        if(mm<10){
						            mm = '0'+mm
						        }
						 
						        today = yyyy+""+mm+""+dd;
						        frm.regdate.value=today;
							</script>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="등록하기" onClick="send()">
								<input type="button" value="다시쓰기" onClick="del()">
							</td>
						</tr>
					</table>
				</form>
				</center>
			</section>
		<footer>
			<p><b>HRDKOREA Copyright@2019 All rights reserved. 
				Human Resources Development Service of Korea</b></p>
		</footer>
</body>
</html>