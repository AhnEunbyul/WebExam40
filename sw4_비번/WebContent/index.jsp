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
	
	.navi ul li {list-style: none; padding: 20px 35px; background-color: #FFFFA7}
	.navi ul {margin-left: 0}
	ul li {float: left; overflow: auto; margin-right: 8px; box-shadow: 2px 2px}
	a {color: #000; text-decoration: none; display: block;}
	
</style>
</head>
<body>
	<div class = "main">
		<header>
			<h1 class = "logo">생산관리 시스템</h1>
			<p>생산관리 메인메뉴</p>
			<nav class = "navi">
				<ul>
					<a href = "insert.do"><li>제품입력</li></a>
					<a href = "select.do"><li>제품조회</li></a>
					<a href = "#"><li>우선생산제품</li></a>
					<a href = "#"><li>이익순위</li></a>
					<a href = "#"><li>그룹별재고수량</li></a>
				</ul>
			</nav>
		</header>
	</div>
</body>
</html>