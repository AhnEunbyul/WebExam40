<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.slider img {width:1920px; height:720px}
</style>
	
	<div class="slider">
	    <div><img src="images/bg1.jpg" alt="" ></div>
	    <div><img src="images/a2.jpg" alt="" title="나에게 주는 만큼"></div>
	    <div><img src="images/a3.jpg" alt="" title="나에게도 많은 축복이 있습니다"></div>
  	</div>

	
	<div class="indexgallery">
			<div class="indextitle">
				<h2>안은별<br>포트폴리오</h2>
				<span><a href="portpolio.do">MORE</a></span>
			</div>
			<ul>
				<li><a href=""><img src="images/2_N.png"></a></li>
				<li><a href=""><img src="images/shop2.jpg"></a></li>
				<li><a href=""><img src="images/shop3.jpg"></a></li>
			</ul>
	</div>
	
	
	<div class="bbs_wrap">
		<div class="bbs_left">
			<h2 class="title">내일기</h2>
			<ul>
				<li><a href="#">화면구현은 어떻게 하는가</a></li>
				<li><a href="#">홈페이지 혼자 만들어보기</a></li>
				<li><a href="#">지구여행 얼마 남았는가</a> </li>
				<li><a href="#">일본취업 나도 해보자</a></li>
				<li><a href="#">하다보면 할수 있다</a></li>
			</ul>
			<a href="notice.do"><span class="fa fa-plus plus"></span></a>
		</div>
		<div class="bbs_right">
			<h2 class="title">Q&A</h2>
			<c:forEach items="${list}" var="qa">
			<ul>
				<li><a href="qa?command=qa_view&idx=${qa.idx}">${qa.subject}</a></li>

			</ul>
			</c:forEach>
			<a href="qa?command=qa_index"><span class="fa fa-plus plus"></span></a>
		</div>
	</div>
	
<%@ include file="footer.jsp" %>












