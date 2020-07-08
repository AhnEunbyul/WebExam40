<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../header.jsp"%>

<style>
	img {width:300px; height: 200px}
</style>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">UI디자인 포트폴리오</h2>
		<div class="sub-search">
			<form name="my" method="post" action="ui">
			<input type="hidden" name="command" value="ui_search">
				<select name="search" class="sel">
					<option value="subject" <c:if test="${search == 'subject'}">selected </c:if>>제목</option>
					<option value="contents" <c:if test="${search == 'contents'}">selected </c:if>>내용</option>
				</select>
				<input type="text" name="key" value="${key}" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
		<ul class="sub-port-content">
		<c:forEach items="${list}" var="web">
			<li>
				<span class="date"><em>${web.regdate.substring(8,10)}</em>${web.regdate.substring(0,4)}-${web.regdate.substring(5,7)}</span>
				<div class="text-wrap">
					<c:set var = "weba" value = "${web.filename}"/>
					<div class="img-wrap">
					<c:if test="${weba != null}">
						<c:if test="${fn:contains(weba,'png')}">
							<img src="upload/${weba}">
						</c:if>
						<c:if test="${fn:contains(weba,'PNG')}">
							<img src="upload/${weba}">
						</c:if>
						<c:if test="${fn:contains(weba,'jpg')}">
							<img src="upload/${weba}">
						</c:if>
						<c:if test="${fn:contains(weba,'JPG')}">
							<img src="upload/${weba}">
						</c:if>
						<c:if test="${fn:contains(weba,'txt')}">
							dgdf
							<img src="upload/존재안함.jpg">
						</c:if>
						<c:if test="${fn:contains(weba,'sql')}">
							<img src="upload/존재안함.jpg">
						</c:if>
					</c:if>
					<c:if test="${weba == null}">
						<img src="upload/존재안함.jpg">
					</c:if>
				</div>
					<div class="text-body">
						<span>No.${web.idx}</span> | <span class=""><i class="fa fa-eye"></i>${web.readcnt}</span>
						<a href="ui?command=ui_view&idx=${web.idx}&page=${page}">
							<p class="title">${web.subject}</p>
							<p class="text-cont">
							${web.contents}<br>
						</a>
					</div>
				</div>
			</li>
			</c:forEach>
		</ul>
		
		<div align="center" class="pagein">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">        
                <div align="center">${pageSkip}</div>
			  </td>
			 </tr>
		</table>
		</div>
				<%
					if(session.getValue("user") != null){
				%>
			<a href="ui?command=ui_write" class="btn-write">글쓰기</a>
				<%
					}
				%>
		</div>

</div>

<script>
	function check() {
		if(my.cont.value=="") {
			alert("검색단어입력하세요");
			my.cont.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="../footer.jsp"%>















