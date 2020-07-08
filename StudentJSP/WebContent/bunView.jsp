<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
	Class.forName("oracle.jdbc.OracleDriver");
		conn = 
			DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","jsl40","1234");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	String sql = "SELECT * FROM TBL_SCORE_001";
	
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생성적정보조회</title>
<style>
	* {padding: 0; margin: 0}
	.header {text-align: center; background-color: #38ADC1; padding: 20px 0}
	.logo {color: #fff;}
	.navi {background-color: #6EE3F7; padding: 12px 0; overflow: hidden;}
	.navi ul li {list-style: none; float: left; padding: 0 20px; text-align: center}
	a {text-decoration: none; color: #000}
	.title {text-align: center; padding: 30px 0}
	table td {border: 1px solid; width: 100px; text-align: center}
	table {margin-bottom: 50px}
	.btn_group {text-align: center}
	footer {text-align: center; background-color: #4ABFD3; padding: 20px 0}
	footer p {color: #000;}
</style>
</head>
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
		<h1 class="title">학생성적조회 화면</h1>
		<center>
			<table>
				<tr>
					<td><b>번호</b></td>
					<td><b>이름</b></td>
					<td><b>성별</b></td>
					<td><b>국어</b></td>
					<td><b>영어</b></td>
					<td><b>수학</b></td>
					<td><b>총점</b></td>
					<td><b>평균</b></td>
					<td><b>등급</b></td>
				</tr>
		<%
			while(rs.next()){
				int bun = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				int kor = rs.getInt(4);
				int eng = rs.getInt(5);
				int mat = rs.getInt(6);
				String regdate = rs.getString(7);
				
				DecimalFormat df= new DecimalFormat("####.00");
				int sum = kor + eng + mat;
				double avg = sum/3.;
				String avg1=df.format(avg);
		%>
				<tr>
					<td><%= bun %></td>
					<td><%= name %></td>
		<%
				if(gender.equalsIgnoreCase("m")){
		%>
					<td>남자</td>
		<%
				} else if(gender.equalsIgnoreCase("f")){
		%>
					<td>여자</td>
		<%
				}
		%>
					<td><%= kor %></td>
					<td><%= eng %></td>
					<td><%= mat %></td>
					<td><%= sum %></td>
					<td><%= avg1 %></td>
		<%
				if(avg >= 90 && avg <=100){
		%>
					<td>수</td>
		<%
				}else if(avg >= 80 && avg <=89){
		%>
					<td>우</td>
		<%
				}else if(avg >= 70 && avg <=79){
		%>
					<td>미</td>
		<%
				}else if(avg >= 60 && avg <=69){
		%>
					<td>양</td>
		<%
				}else if(avg <= 59){
		%>
					<td>가</td>
		<%
				}
		%>
				</tr>
		<%
			}
		%>
			</table>
		</center>
	</section>
	<footer>
		<p>
			<b>HRDKOREA Copyright@2019 All rights reserved. Human Resources
				Development Service of Korea</b>
		</p>
	</footer>
</body>
</html>