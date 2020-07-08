<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>


<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">회원가입</h2>
	</div>
	
	<div class="write-form">
		<table summery="회원가입 글쓰기 테이블 입니다">
			<caption class="readonly">회원가입 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			<form name="membe" method="post" action="member">
			<input type = "hidden" name = "command" value = "member_insert_pro">
				<fieldset>
					<legend class="readonly">입력폼</legend>
					<tr>
						<th scope="row">
							<label for="id">아이디 <b>필수입력</b></label>
						</th>
						<td>
							<input type="text" name="userid" id="id" class="minput"> 
						</td>
						<div style="width:8%; float:right;padding:10px;
							height:50px; margin-top:3px;">
							<input type="submit" value="중복확인" alt="중복확인"  onClick = "return formcheck()"
							style="background: #FF4000; color:#fff;
							width:100%; height:100%; border:0 none; cursor:pointer;">
						</div>
					</tr>
					<tr>
						<th scope="row"><lavel for="pass1">패스워드</lavel></th>
						<td><input type="password" name="pwd" id="pass1" class="minput"></td>
					</tr>
					<tr>
						<th scope="row">패스워드 확인</th>
						<td><input type="password" name="repwd" class="minput"></td>
					</tr>
					<tr>
						<th scope="row">이름</th>
						<td><input type="text" name="name" class="minput"></td>
					</tr>
					<tr>
						<th><label for="phone">전화번호<span class="must"></span></label></th>
						<td><input type="text" name="phone" id="phone" class="minput">
						<span class="tc_point"> &nbsp;&nbsp;xxx-xxxx-xxxx의 형식을 맞춰주세요.</span>
						</td>
					</tr>
					<tr>
						<th scope="row">이메일</th>
						<td>
							<input type="text" name="em" class="minput">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="전송" class="btn-write" onclick="formcheck()">
							<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='member?command=index'">
						</td>
					</tr>
					</fieldset>
				</form>
			</tbody>
		</table>
	</div>
		
</div>

<script>
	function formcheck() {
		//아이디 유효성
		var puserid = /^[a-z0-9]{5,14}$/; //영문,숫자 5~14자
		var userid = membe.userid.value;
		if(userid==""){
			alert("아이디를 입력해주세요.");
			membe.userid.focus();
			return false;
		}
		if(!userid.match(puserid)){
			alert("아이디 형식을 맞춰주세요.");
			membe.userid.focus();
			return false;
		}
		
		
		//비밀번호 유효성
		var pwd = membe.pwd.value;
		if (pwd == "") {
			alert("비밀번호를 입력해주세요..");
			membe.pwd.focus();
			return false;
		}
		var pattern1 = /[0-9]/; // 숫자 
		var pattern2 = /[a-zA-Z]/; // 문자
		var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
		if (pwd.match(pattern1)){
			if(pwd.match(pattern2)){
				if(pwd.match(pattern3)){
					if(pwd.length>8 && pwd.length< 14 ){
					}else{
						alert("비밀번호는 특수문자,숫자,영문 조합으로 9~13자로 작성해 주십시오.");
						membe.pwd.focus();
						return false;
					}
				}else{
					alert("비밀번호는 특수문자,숫자,영문 조합으로 9~13자로 작성해 주십시오.");
					membe.pwd.focus();
					return false;
				}
			}else{
				alert("비밀번호는 특수문자,숫자,영문 조합으로 9~13자로 작성해 주십시오.");
				membe.pwd.focus();
				return false;
			}
		}else{
			alert("비밀번호는 특수문자,숫자,영문 조합으로 9~13자로 작성해 주십시오.");
			membe.pwd.focus();
			return false;
		}

		//비밀번호 확인 유효성

		var repwd=membe.repwd.value;
		if(repwd==""){
			membe.repwd.value=membe.pwd.value;
		}
		if(repwd != ""){
			if(repwd!=pwd){
			alert("입력한 비밀번호가 같지 않습니다");
			membe.repwd.focus();
			return false;
			}
		}
		
		//이름 유효성
		var pname = /^[가-힣]{2,8}$/; //한글만 입력 2~8자
		var name = membe.name.value;
		if(name==""){
			alert("이름을 입력해주세요.");
			membe.name.focus();
			return false;
		}
		if(!name.match(pname)){
			alert("이름 형식을 맞춰주세요.");
			membe.name.focus();
			return false;
		}

		//전화번호 유효성
		var pphone = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
		var phone = membe.phone.value;
		if (phone == "") {
			alert("전화번호를 입력해주세요.");
			membe.phone.focus();
			return false;
		}
		if(!phone.match(pphone)){
			alert("전화번호 형식을 맞춰주세요.");
			membe.phone.focus();
			return false;
		}

		//이메일 유효성
		var pemail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var email = membe.em.value;
		if (email == "") {
			alert("이메일을 입력해주세요.");
			membe.email.focus();
			return false;
		}
		if(!email.match(pemail)){
			alert("이메일 형식을 맞춰주세요.");
			membe.email.focus();
			return false;
		}
		alert("등록하시겠습니까?");
		membe.submit();
	}
</script>

<%@ include file="../footer.jsp"%>















