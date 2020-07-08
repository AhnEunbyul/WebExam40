<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none;}
	.logo {color:#fff; text-align:center;background-color:#0040FF;
	      padding:16px 0;}

	.navi{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	
	.navi ul,li{float:left; padding:0 20px; text-align:center;}
	.content{background-color:#E6E6E6; padding:16px; height:300px;} 
	.title{text-align:center;padding:22px;}
	.footer{padding:16px 0; text-align:center;background-color:#0040FF;}
	.content table{width:500px; margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group{text-align:center;}	
</style>
<script>
	function send(){
		if(frm.custno.value==""){
			alert("회원번호가 입력되지 않았습니다");
			frm.custno.focus();
			return;
		}
		if(frm.custname.value==""){
			alert("회원이름이 입력되지 않았습니다");
			frm.custname.focus();
			return;
		}
		if(frm.phone.value==""){
			alert("전화번호가 입력되지 않았습니다");
			frm.phone.focus();
			return;			
		}
		// 라디오, 체크박스 유효성 검사
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
		//select
		if(frm.grade.selectedIndex==0){
			alert("고객등급이 선택되지 않았습니다");
			frm.grade.focus()
			return;									
		}
		//select
		if(frm.city.value=""){
			alert("도시코드가 입력되지 않았습니다");
			frm.city.focus()
			return;									
		}
		alert("회원정보를 등록합니다");
		frm.submit();
	}
	
	function del(){
		alert("입력된 모든 항목을 삭제합니다");
		frm.reset();
		frm.custname.focus();
	}
</script>
</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo">(과정평가형 정보처리산업기사) 도서 관리 프로그램  ver3.0</h1>
			<nav>
				<ul class="navi">
					<li><a href="memInsert.jsp">회원등록</a></li>
					<li><a href="memList.jsp">회원목록조회</a></li>
					<li><a href="lentInsert.jsp">도서대출등록</a></li>
					<li><a href="lentList.jsp">도서대출현황</a></li>
					<li><a href="bookInsert.jsp">도서등록</a></li>
					<li><a href="bookLentList.jsp">도서별 대출현황</a></li>
					<li><a href="index.jsp">홈으로</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">과정평가형 자격 CBQ(도서등록)</h2>
					<form name="frm" method="post" action="insert_pro.jsp">
						<table>
							<tr>
								<th>도서코드</th>
								<td><input type="text" name="custno" > 정수 3자리(101)</td>
							</tr>
							<tr>
								<th>도서이름</th>
								<td><input type="text" name="custname"></td>
							</tr>
							<tr>
								<th>수량</th>
								<td><input type="text" name="phone">
								</td>
							</tr>
							<tr>
								<td colspan="2" class="btn_group">
									<input type="button" value="등록하기" onClick="send()">
									<input type="button" value="취소하기" onClick="del()">
								</td>
							</tr>
						</table>
					</form>
			</div>
		</section>
	</div>

	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources 
			Development Serivce of Korea</p>
		</footer>
	</div>

</body>
</html>