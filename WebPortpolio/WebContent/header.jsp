<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>안은별의 포트폴리오</title>
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<link href="css/common.css" rel="stylesheet">
	<link href="css/mystyle.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

  <script>
    $(function(){
    	
      $('.slider').bxSlider({
    	  mode: 'fade',
    	  captions: true
      });
      
      $(".sitemap").click(function() {
			$(".sitewrap").slideDown();
		})
	  $("#close").click(function() {
			$(".sitewrap").slideUp();
		})
		
	  $(".nav > nav > .navi > li").hover(function() {
		  $(this).children(".navi2").stop().slideDown();
	  }, function() {
		  $(this).children(".navi2").stop().slideUp();
	  });
		
    });
  </script>
</head>
<body>
	<div class="header">
		<header>
			<div class="topnav">
				<ul>
					<%
						if(session.getValue("user") == null){
					%>
					<li><a href="login.do">ログイン</a></li>
					<li><a href="insert.do">会員加入</a></li>
					<li><a href="javascript:void(0)" class="sitemap">サイト</a></li>
					<%
						}else{
					%>
					<li><a href="logout.do">ログアウト</a></li>
					<li><a href="javascript:void(0)" class="sitemap">サイト</a></li>
					<%
						}
					%>
				</ul>
			</div>
			<div class="navigation">
				<h1 class="logo"><a href="index.do" style="text-decoration: none;">ホシナのサイト</a></h1>
				<div class="nav">
					<nav>
						<ul class="navi">
							<li><a href="syoukai.do"> ご紹介</a>
								<ul class="navi2">
									<li><a href="rirekisyo.do">履歴書</a></li>
									<li><a href="jicosyoukai.do">自己紹介書</a></li>
								</ul>
							</li>
							<li><a href="portfolio.do">ポートフォリオ</a>
							</li>
							<li><a href="board.do">フリーボード</a>
								<ul class="navi2">
									<li><a href="qa.do">Q&A</a></li>
									<li><a href="guest.do">芳名録</a></li>
								</ul>
							</li>
							<li><a href="diary.do">日記</a>
								<ul class="navi2">
									<li><a href="s_diary.do">就職日記</a></li>
									<li><a href="k_diary.do">開発日記</a></li>
								</ul>
							</li>
							<li><a href="contact.do">CONTACT</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
	</div>
	
	<div class="line"></div>
	
	<div class="sitewrap">
		<span class="fa fa-close" id="close" style="cursor:pointer"></span>
		<div class="inner">
			<span class="map">내소개</span>
			<span class="map">포트폴리오</span>
			<span class="map">자유게시판</span>
			<span class="map">내일기</span>
			<span class="map">CONTACT</span>
		</div>
	</div>
	
	
	
	
	
	
	
	
	