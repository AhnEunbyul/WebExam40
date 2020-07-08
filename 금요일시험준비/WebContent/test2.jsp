<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 프로그램 ver2.0</title>
<style>
	* {padding : 0; margin : 0;}
	.logo {text-align: center; background-color: #F15F5F; color: #fff; padding : 15px 0;}
	.navi {background-color: #FFB9B9; padding : 10px 0; overflow: hidden;}
	.navi ul li {list-style: none; float: left; text-align: center; padding : 0 20px}
	a {color : #000; text-decoration: none}
	.title {text-align: center; padding: 20px}
	 table th, td {border: solid 1px; }
	 table {width : 500px; margin:0 auto; padding-bottom: 30px}
	.btn_group {text-align: center}
	 
	
	.footer {background-color: #CD3B3B; padding: 10px 0}
	.footer p {text-align: center; color: #fff}
	
</style>
</head>
<script>
	function send(){
		if(frm.number.value == ""){
			alert("대출번호가 입력되지 않았습니다.");
			frm.number.focus();
			return;	
		}
		if(frm.name.value == ""){
			alert("이름이 입력되지 않았습니다.");
			frm.name.focus();
			return;	
		}
		if(frm.phone.value == ""){
			alert("번호가 입력되지 않았습니다.");
			frm.phone.focus();
			return;	
		}
		
		for(i=0, flag=0; i<frm.gender.length; i++){
			if(frm.gender[i].checked){
				flag=1;
				break;
			}
		}
		if(!flag){
			alert("성별이 체크되지 않았습니다");
			return;						
		}
		
		if(frm.bookCode.value == ""){
			alert("도서코드를 입력하지 않았습니다.");
			frm.name.focus();
			return;	
		}
		if(frm.book_out.value == ""){
			alert("대출일자를 입력하지 않았습니다.");
			frm.phone.focus();
			return;	
		}
		
		alert("회원정보를 등록합니다");
		frm.submit();
		
	}
	function del(){
		alert("입력된 모든항목을 삭제합니다");
		frm.reset();
		frm.number.focus();
	}
</script>
<body>
	<div class="header">
	<header>
		<h1 class="logo">(과정평가형 정보처리산업기사) 도서 관리 프로그램 ver2.0</h1>
		<nav class="navi">
			<ul>
				<a href="test2.jsp"><li>도서대출</li></a>
				<a href="#"><li>도서대출현황조회</li></a>
				<a href="#"><li>도서반납</li></a>
				<a href="#"><li>도서등록</li></a>
				<a href="#"><li>도서별대출현황조회</li></a>
				<a href="test.jsp"><li>홈으로</li></a>
			</ul>
		</nav>
	</header>
	</div>
	<div class="section">
	<section>
		<div class="contents">
		<h2 class="title">과정평가형 자격 CBQ</h2>
		<form name="frm" method="post" action="test.jsp">
			<table>
				<tr>
					<th>대출번호</th>
					<td><input type="text" name ="number">정수 4자리(1001)</td>
				</tr>
				<tr>
					<th>고객성명</th>
					<td><input type="text" name ="name"></td>
				</tr>
				<tr>
					<th>고객전화</th>
					<td><input type="text" name ="phone"></td>
				</tr>
				<tr>
					<th>회원성별</th>
					<td>
						<input type="radio" name ="gender" value="m">남자
						<input type="radio" name ="gender" value="f">여자
					</td>
				</tr>
				<tr>
					<th>도서코드</th>
					<td><input type="text" name ="bookCode"></td>
				</tr>
				<tr>
					<th>대출일자</th>
					<td><input type="text" name ="book_out">예)20200207</td>
				</tr>
				<tr>
					<td colspan = "2" class = "btn_group">
						<input type="button" value="등록하기" onClick="send()">
						<input type="button" value="다시쓰기" onClick="del()">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</section>
	</div>
	<div class="footer">
	<footer>
		<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources Development Serivce of Korea</p>
	</footer>
	</div>
</body>
</html>