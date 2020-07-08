<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">Q&A</h2>
	</div>
	
	<div class="write-form">
		<table summery="질문답변 글쓰기 테이블 입니다">
			<caption class="readonly">포트폴리오 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			<form name="my" method="post" action="qa2" enctype="multipart/form-data" onsubmit="return formcheck();">
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" placeholder="제목입력하세요"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="contents"></textarea></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="userid"></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td><input type="file" name="filename"></td>
					</tr>
					<tr>
						<th><label for="passwd">패스워드</label></th>
						<td><input type="password" name="pwd" id="passwd" class="minput"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="전송" class="btn-write">
							<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='qa?command=qa_index'">
						</td>
					</tr>
				</form>
			</tbody>
		</table>
	</div>
		
</div>

<script>
	function formcheck() {
		if(my.title.value=="") {
			alert("제목입력하세요");
			my.subject.focus();
			return false;
		}
		if(my.content.value=="") {
			alert("내용입력하세요");
			my.contnets.focus();
			return false;
		}
		return true;
	}
</script>

<%@ include file="../footer.jsp"%>















