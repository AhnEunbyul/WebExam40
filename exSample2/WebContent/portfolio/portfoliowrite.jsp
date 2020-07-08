<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">안은별 포트폴리오</h2>
	</div>
	
	<div class="write-form">
	<form name="my" method="post" action="port2" enctype="multipart/form-data" onSubmit="return formcheck();">
	<!-- Action으로 보내면 request가 두 번 일어나기 때문에 file에서 오류가 남으로 서블릿 형태 컨트롤러를 하나 더 만들어 바로 동작시키게 함. -->
	<input type="hidden" name="command" value="port_web_write_pro">
	<!-- 이거는 그래서 없어도 됨. 왜냐하면 컨트롤러에서 command를 안 받았기 때문에 값은 먹었지만 동작은 하지 않는다! -->
		<table>
			<caption class="readonly">포트폴리오 입력폼</caption>			
			<colgroup>
				<col class="w20">
				<col class="w80">
			</colgroup>
			<tbody>
			
					<tr>
						<th><label for="title">제목</label></th>
						<td><input type="text" name="subject" id="title"></td>
					</tr>
					<tr>
						<th><label for="content">내용</th>
						<td><textarea name="contents" id="content" title="내용을 입력하세요"></textarea></td>
					</tr>
					<tr>
						<th><label for="writer">작성자</label></th>
						<td><input type="text" name="mgn_name" id="writer"></td>
					</tr>
					<tr>
						<th><label for="appfile">첨부</label></th>
						<td><input type="file" name="filename" id="appfile"></td>
					</tr>
					<tr>
						<th><label for="passwd">패스워드</label></th>
						<td><input type="password" name="pwd" id="passwd" class="minput"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="전송" class="btn-write">
							<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='port?command=port_web'">
						</td>
					</tr>
				
			</tbody>
		</table>
		</form>
	</div>
		
</div>

<script>
	function formcheck() {
		if(my.subject.value == "") {
			alert("제목을 입력하세요");
			my.subject.focus();
			return false;
		}
		if(my.contents.value == "") {
			alert("내용을 입력하세요");
			my.contents.focus();
			return false;
		}
		if(my.mgn_name.value == "") {
			alert("작성자를 입력하세요");
			my.mgn_name.focus();
			return false;
		}
		if(my.pwd.value == "") {
			alert("비밀번호를 입력하세요");
			my.pwd.focus();
			return false;
		}
		return true;
	}
	
	
</script>

<%@ include file="../footer.jsp"%>















