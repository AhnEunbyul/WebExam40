<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>





<html>

<head><title>게시판 읽기</title>

<link rel="stylesheet" type="text/css" href="/stylesheet.css">

<style type="text/css">

  a.list {text-decoration:none;color:black;font-size:10pt;}

</style>



</head>

<script>

	function kensaku(){

		if(board.key.value == ""){

			alert("검색어를 입력하세요.");

			board.key.focus();

			return

		}

		board.submit();

	}

</script>

<body bgcolor="#FFFFFF" topmargin="0" leftmargin="0">

<center>

<%@ include file = "/include/topmenu.jsp"%>

<table border="0" width="800">

  <tr>

    <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">



	<%@ include file = "/include/login_form.jsp"%></td>



	<td width="80%" valign="top">	

		<br>

    <table border="0" cellspacing="1" width="100%" align="center">

      <tr>

        <td colspan="7" align="center" valign="center" height="20">

        <font size="4" face="돋움" color="blue">

        <img src="./img/bullet-01.gif"> <b>자 유 게 시 판</b></font></td></tr>

      <tr>

        <td colspan="5" align="right" valign="middle" height="20">

		<font size="2" face="고딕">전체 : <b>${totcount}</b>건 - ${page}/ ${totpage} Pages</font></td></tr>

 	   <tr bgcolor="e3e9ff">

 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">번 호</font></td>

 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제 목</font></td>

 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>

 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>

 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>

 	   </tr>

<c:if test ="${!empty list}">

	<c:forEach var="vo" items="${list}">

			<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">

        <td align="center" height="25">

        <font face="돋움" size="2" color="#000000">${listcount}</font></td>

			<td align="left" height="20">&nbsp;

				<font face="돋움" size="2" color="#000000">

				<a class="list" href="board_view?idx=${vo.idx}&page=${page}">${vo.subject}</a></td>

					<td align="center" height="20"><font face="돋움" size="2">

					<a class="list" href="mailto:ein1027@nate.com">${vo.name}</a></font></td>

				<td align="center" height="20"><font face="돋움" size="2">${vo.regdate.substring(2,10)}</font></td>

				<td align="center" height="20"><font face="돋움" size="2">

				${vo.readcnt}</font></td>

			</tr>

			<c:set var="listcount" value="${listcount-1}" />

	</c:forEach>

</c:if>

<c:if test = "${empty list}">

	<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">

        <td align="center" height="25" colspan="5">

        <font face="돋움" size="2" color="#000000">등록된 자료가 없습니다.</font></td>

    </tr>

</c:if>



	 <div align="center">

        <table width="700" border="0" cellspacing="0" cellpadding="5">

          <tr>&nbsp;</tr><tr>

             <td colspan="5">        

                <div align="center">${pageSkip}</div>

			  </td>

			 </tr>

		</table>



	<table width="600">

		<tr>

			<td width="25%"> &nbsp;</td>

			<td width="50%" align="center">

				<table>

					<form name="board" method ="post" action="board_list">	

					<!-- 검색어를 이용하여 글제목, 작성자, 글내용 중에 하나를 입력 받아 처리하기 위한 부분 -->

						<tr>

							<td>

								<select name="search">

									<option value="subject" <c:if test="${search == 'subject'}">selected </c:if>>글제목</option>

									<option value="name" <c:if test="${search == 'name'}">selected </c:if>>작성자</option>

									<option value="contents" <c:if test="${search == 'contents'}">selected </c:if>>글내용</option>

								</select>

							</td>

							<td> <input type="text" size=20 name="key" value="${key}"></td>

							<td> <a href="#" onClick="kensaku()"><img src="./img/search2.gif" border="0"></a></td>

						</tr>

					</form>

				</table>

			</td>

			<td width="25%" align="right">

			<% 

			if(session.getAttribute("vo") != null){

			%>

			<a href="board_write?page=${page}"><img src="./img/write.gif" border="0"></a>

			<%}%>

			</td>

		</tr>

	</table>

	</center>

</body>

<%@ include file = "/include/copyright.jsp"%>

</html>
