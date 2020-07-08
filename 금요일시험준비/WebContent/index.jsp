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
				<h2 class="title">과정평가형 자격 CBQ</h2>
					<br>국가직무능력표준(NCS:National Competency Standards)으로 설계된 교육*훈련과정을 체계적으로 이수하고 내외부 평가를 거쳐 취득하는 국가기술자격입니다.<br>
					<br>산업현장 중심의 교육평가로 더 커지는 능력!<br>
					<br>알고 있는 것에 할 수 있는 것을 더하는<br>
					<br>과정평가형 자격은<br>
					<br>현장 중심형 인재육성을 지원 합니다.<br>
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