<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>


<div class="contain" style="padding: 150px 0">
	
	<div class="write-form" style="width:50%; margin:0 auto; border:1px solid #ccc; padding:20px;">
		<form name = "frm" method = "post" action = "login.do">
			<fieldset>
				<legend class="readonly">로그인그룹</legend>
				<div style="width:70%; float:left;">
					<label for="id" class="readonly">아이디</label>
					<input type="text" name="userid" id="id" placeholder="아이디">
					<label for="pw" class="readonly">패스워드</label>
					<input type="password" name="pwd" id="pw" placeholder="패스워드">
				</div>
				<div style="width:28%; float:right;padding:15px;
				height:132px; margin-top:3px;">
					<input type="button" value="로그인" alt="로그인"  onClick = " return formcheck()"
					style="background: #FF4000; color:#fff;
					width:100%; height:100%; border:0 none; cursor:pointer;">
				</div>
				<p style="clear:both;padding-top:20px; text-align:center;">아이디찾기 | 패스워드찾기 | 회원가입</p>
			</fieldset>
		</form>	
	</div>
		
</div>

<script>
	function formcheck() {
		if(frm.userid.value == "") {
			alert("아이디를 입력하세요");
			frm.userid.focus();
			return false;
		}
		if(frm.pwd.value == "") {
			alert("비밀번호를 입력하세요");
			frm.pwd.focus();
			return false;
		}
		frm.submit();
	}
</script>

<%@ include file="../footer.jsp"%>














