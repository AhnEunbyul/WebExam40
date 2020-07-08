<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<script>
function fn_save(){
	//이름 유효성
	var pname = /^[가-힣]{2,4}$/; //한글만 입력 2~4자
	var name = member.name.value;
	if(name==""){
		alert("이름을 입력해주세요.");
		member.name.focus();
		return;
	}
	if(!name.match(pname)){
		alert("이름 형식을 맞춰주세요.");
		member.name.focus();
		return;
	}
	
	//아이디 유효성
	var puserid = /^[a-z0-9]{5,14}$/; //영문,숫자 5~14자
	var userid = member.userid.value;
	if(userid==""){
		alert("아이디를 입력해주세요.");
		member.userid.focus();
		return;
	}
	if(!userid.match(puserid)){
		alert("아이디 형식을 맞춰주세요.");
		member.userid.focus();
		return;
	}
	
	//비밀번호 유효성

	var pwd = member.pwd.value;
	if (pwd == "") {
		alert("비밀번호를 입력해주세요..");
		member.pwd.focus();
		return;
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
					member.pwd.focus();
					return;
				}
			}else{
				alert("비밀번호는 특수문자,숫자,영문 조합으로 9~13자로 작성해 주십시오.");
				member.pwd.focus();
				return;
			}
		}else{
			alert("비밀번호는 특수문자,숫자,영문 조합으로 9~13자로 작성해 주십시오.");
			member.pwd.focus();
			return;
		}
	}else{
		alert("비밀번호는 특수문자,숫자,영문 조합으로 9~13자로 작성해 주십시오.");
		member.pwd.focus();
		return;
	}

	//비밀번호 확인 유효성

	var repwd=member.repwd.value;
	if(repwd==""){
		member.repwd.value=member.pwd.value;
	}
	if(repwd != ""){
		if(repwd!=pwd){
		alert("입력한 비밀번호가 같지 않습니다");
		member.repwd.focus();
		return;
		}
	}

	//전화번호 유효성
	var pphone = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	var phone = member.phone.value;
	if (phone == "") {
		alert("전화번호를 입력해주세요..");
		member.phone.focus();
		return;
	}
	if(!phone.match(pphone)){
		alert("전화번호 형식을 맞춰주세요.");
		member.phone.focus();
		return;
	}

	//이메일 유효성
	var pemail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var email = member.em.value;
	if (email == "") {
		alert("이메일을 입력해주세요..");
		member.email.focus();
		return;
	}
	if(!email.match(pemail)){
		alert("이메일 형식을 맞춰주세요.");
		member.email.focus();
		return;
	}
	
	member.submit();
}
</script>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="JSL">
<meta name="Keywords"
	content="반응형홈페이지,  JAVA, JSP, PHP, 대전직업전문학교, 대전국비지원, 국비무료">
<meta name="Description" content="응용SW개발자를 위한 반응형 홈페이지">
<title>JSL인재개발원</title>
<link href="../css/font-awesome.min.css" rel="stylesheet">
<link href="../css/common.css" rel="stylesheet">
<link href="../css/layout.css" rel='stylesheet'>
<!--
  	jquery언어 사용법
	1. jquey.js을 기반으로 프로그램을 작성하기 때문에 jquery.js 파일을 다운 또는 CDN 방식으로 링크를 건다
	2. $(function() {
		실행문;
	});
  -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="../js/jquery-3.3.1.min.js"></script>


</head>
<body>
	<!-- 
 웹문서 만들기 기본 공식
 1. 요소를 어떻게 묶을 것인가? 그룹만들기
 2. 그룹안에 적절한 태그 사용
 3. class 이름 붙이고 css 적용
 -->
	<%@include file="/header.jsp"%>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>회원가입</h2>
		<div class="container">
			<div class="location">
				<ul>
					<li class="btn_home"><a href="index.html"><i
							class="fa fa-home btn_plus"></i></a></li>
					<li class="dropdown"><a href="">커뮤니티<i
							class="fa fa-plus btn_plus"></i></a>
						<div class="dropdown_menu">
							<a href="gratings.html">공지사항</a> <a href="allclass.html">학과및모집안내</a>
							<a href="portfolio.html">포트폴리오</a> <a href="online.html">온라인접수</a>
							<a href="notice.html">커뮤니티</a>
						</div></li>
					<li class="dropdown"><a href="">공지사항<i
							class="fa fa-plus btn_plus"></i></a>
						<div class="dropdown_menu">
							<a href="notice.html">공지사항</a> <a href="qa.html">질문과답변</a> <a
								href="faq.html">FAQ</a>
						</div></li>
				</ul>
			</div>
		</div>
		<!-- container end -->
	</div>

	<div class="container">
		<div class="con_title">
			<h1>내정보(개인회원)</h1>
			<p>HOME / 마이페이지 / 내정보(개인회원)</p>
		</div>
		<div class="join_write col_989">
			<div class="list_con">
				<ul class="icon_type1">
					<li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게
						제공되지 않습니다.</li>
				</ul>
			</div>
			<form name=member method=post action=MemberInsert>
				<table class="table_write02"
					summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
					<caption>회원가입을 위한 정보입력표</caption>
					<colgroup>
						<col width="160px">
						<col width="auto">
					</colgroup>
					<tbody id="joinDataBody">
						<tr>
							<th><label for="name">이름</label></th>
							<td><input type="text" name="name" id="mbrName" class="w300">
							</td>
						</tr>
						<tr>
							<th><label for="id">아이디<span class="must"><b>필수입력</b></span></label></th>
							<td><input type="text" name="userid" id="mbrId" class="w300">
							<p class="guideTxt">
								<span class="tc_point">영문 숫자 5~14</span>
							</td>
						</tr>
						<tr>
							<th><label for="pw">비밀번호<!-- <span class="must"><b>필수입력</b></span> --></label></th>
							<td><input type="password" name="pwd" id="scrtNo"
								class="w300">
								<p class="guideTxt">
									<span class="tc_point">영문(대문자 구분), 숫자, 특수문자의 조합</span>으로 9~13자로
									작성해 주십시오.
								</p></td>
						</tr>
						<tr>
							<th><label for="pw_confirm">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
							<td><input type="password" name="repwd" id="scrtNoConfirm"
								class="w300">
								<p class="guideTxt">
									<span class="tc_point">비밀번호 미입력시 기존비밀번호가 유지됩니다.</span>
								</p></td>
						</tr>
						<!-- <tr>
                        <th>소속<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
                            <select name="mbrClCd" id="mbrClCd">
                                <option value="">선택</option>
                                
                                    <option value="01">기업</option>
                                
                                    <option value="02">교수자</option>
                                
                                    <option value="03">미취업자</option>
                                
                                    <option value="04">기타</option>
                                
                            </select>
                            <ul id="posCdData" style="display: none;">
                            
                                <li id="posCdVal" poscd="10" posname="협회" postype="01">
                            
                                </li><li id="posCdVal" poscd="11" posname="단체" postype="01">
                            
                                </li><li id="posCdVal" poscd="12" posname="일반기업" postype="01">
                            
                                </li><li id="posCdVal" poscd="20" posname="전문대학" postype="02">
                            
                                </li><li id="posCdVal" poscd="21" posname="폴리텍대학" postype="02">
                            
                                </li><li id="posCdVal" poscd="22" posname="4년제대학" postype="02">
                            
                                </li><li id="posCdVal" poscd="23" posname="일반고" postype="02">
                            
                                </li><li id="posCdVal" poscd="24" posname="마이스터고" postype="02">
                            
                                </li><li id="posCdVal" poscd="25" posname="특성화고" postype="02">
                            
                                </li><li id="posCdVal" poscd="26" posname="직업훈련기관" postype="02">
                            
                                </li><li id="posCdVal" poscd="30" posname="학생" postype="03">
                            
                                </li><li id="posCdVal" poscd="31" posname="일반인" postype="03">
                            
                                </li><li id="posCdVal" poscd="40" posname="공공기관" postype="04">
                            
                                </li><li id="posCdVal" poscd="41" posname="공공단체" postype="04">
                            
                                </li><li id="posCdVal" poscd="42" posname="소속기관" postype="04">
                            
                            </li></ul>
                            <label for="posCd" class="blind">소속2차 카테고리 선택</label>
                            <select name="posCd" id="posCd">
                                
                            <option value="">선택</option><option value="10">협회</option><option value="11">단체</option><option value="12">일반기업</option></select>
                            <input type="text" name="posName" id="posName" class="w200" value=""><label for="belong" class="blind">소속입력</label>
                            <p class="guideTxt">학생 신분은 '미취업자-학생' 소속으로 선택해주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                            <input type="hidden" name="telNo" id="telNo" value="">
                            <label for="phone_number1" class="blind">유선전화 앞번호 선택</label>
                            <select name="telNo1" id="telNo1" class="w95">
                                <option value="">선택</option>
                                
                                    <option value="02">02</option>
                                
                                    <option value="031">031</option>
                                
                                    <option value="032">032</option>
                                
                                    <option value="033">033</option>
                                
                                    <option value="041">041</option>
                                
                                    <option value="042">042</option>
                                
                                    <option value="043">043</option>
                                
                                    <option value="044">044</option>
                                
                                    <option value="049">049</option>
                                
                                    <option value="051">051</option>
                                
                                    <option value="052">052</option>
                                
                                    <option value="053">053</option>
                                
                                    <option value="054">054</option>
                                
                                    <option value="055">055</option>
                                
                                    <option value="061">061</option>
                                
                                    <option value="062">062</option>
                                
                                    <option value="063">063</option>
                                
                                    <option value="064">064</option>
                                
                                    <option value="070">070</option>
                                
                                    <option value="080">080</option>
                                
                                    <option value="0303">0303</option>
                                
                                    <option value="0502">0502</option>
                                
                                    <option value="0504">0504</option>
                                
                                    <option value="0505">0505</option>
                                
                                    <option value="0506">0506</option>
                                
                                    <option value="0507">0507</option>
                                
                                    <option value="1544">1544</option>
                                
                                    <option value="1566">1566</option>
                                
                                    <option value="1577">1577</option>
                                
                                    <option value="1588">1588</option>
                                
                                    <option value="1599">1599</option>
                                
                                    <option value="1600">1600</option>
                                
                                    <option value="1644">1644</option>
                                
                                    <option value="1661">1661</option>
                                
                                    <option value="1666">1666</option>
                                
                                    <option value="1670">1670</option>
                                
                                    <option value="1688">1688</option>
                                
                            </select>
                            <input type="text" name="telNo2" id="telNo2" class="w95" value="" maxlength="3"><label for="phone_number2" class="blind">중간번호</label>
                            <input type="text" name="telNo3" id="telNo3" class="w95" value="" maxlength="4"><label for="phone_number3" class="blind">마직막번호</label>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <input type="hidden" name="mphonNo" id="mphonNo" value="">
                            <label for="mphonNo1" class="blind">휴대전화 앞번호 선택</label>
                            <select name="mphonNo1" id="mphonNo1" class="w95">
                                <option value="">선택</option>
                                
                                    <option value="010">010</option>
                                
                                    <option value="011">011</option>
                                
                                    <option value="016">016</option>
                                
                                    <option value="017">017</option>
                                
                                    <option value="018">018</option>
                                
                                    <option value="019">019</option>
                                
                            </select>
                            <input type="text" name="mphonNo2" id="mphonNo2" class="w95" value="7920" maxlength="4"><label for="mphonNo2" class="blind">중간번호</label>
                            <input type="text" name="mphonNo3" id="mphonNo3" class="w95" value="1435" maxlength="4"><label for="mphonNo3" class="blind">마직막번호</label>
                        </td>
                    </tr> -->
						<tr>
							<th><label for="phone">전화번호<span class="must"><b>필수입력</b></span></label></th>
							<td><input type="text" name="phone" id="email" class="w300">
							<p class="guideTxt">
									<span class="tc_point">xxx-xxxx-xxxx의 형식을 맞춰주세요.</span>
								</p>
							</td>
						</tr>
						<tr>
							<th><label for="email">이메일<span class="must"><b>필수입력</b></span></label></th>
							<td><input type="email" name="em" id="email" class="w300">
							</td>
						</tr>
						<!-- <tr>
                        <th>주소<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <input type="text" name="zipNo" id="zipNo" disabled="disabled" placeholder="우편번호" class="w120" value="34839"><label for="zipNo" class="blind">우편번호</label>
                            <a id="btn_findJuso" href="javascript:gfn_com_openJusoPopup('fn_jusoCallBack');" class="btn_form btn_DeepGray">주소검색</a>
                            <hr>
                            <input type="text" name="addr" id="addr" disabled="disabled" placeholder="주소" class="w550" value="대전 중구 선화동 1∼66"><label for="addr" class="blind">주소</label>
                            <hr>
                            <input type="text" name="detlAddr" id="detlAddr" placeholder="상세주소" class="w550" value="32-5 대우직업전문학교"><label for="detlAddr" class="blind">상세주소</label>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="myslfConfQuest">본인확인질문</label></th>
                        <td>
                            <select name="myslfConfQuest" id="myslfConfQuest">
                                <option value="">선택</option>
                                
                                    <option value="01">가장 기억에 남는 장소는?</option>
                                
                                    <option value="02">나의 좌우명은?</option>
                                
                                    <option value="03">나의 보물 제1호는?</option>
                                
                                    <option value="06">오래도록 기억하고 싶은 날짜는?</option>
                                
                                    <option value="11">내가 존경하는 인물은?</option>
                                
                                    <option value="12">다시 태어나면 되고 싶은 것은?</option>
                                
                                    <option value="15">내 휴대폰 1번에 등록된 사람은?</option>
                                
                                    <option value="16">나의 출신 초등학교는?</option>
                                
                                    <option value="17">우리집 애완동물의 이름은?</option>
                                
                                    <option value="20">좋아하는 스포츠 팀 이름은?</option>
                                
                                    <option value="21">본인의 출생지는 ?</option>
                                
                            </select>
                        </td>
                    </tr>
                    <tr> 
                        <th><label for="myslfConfAns">본인확인답</label></th>
                        <td>
                            <input type="text" name="myslfConfAns" id="myslfConfAns" class="w300" value="예수님">
                        </td>
                    </tr>
                    <tr>
                        <th>SNS계정연동</th>
                        <td>
	                    	<ul class="join_sns">
			                   <li class="naver">
			                    	<input type="hidden" id="naverYn" value="">
			                        <div id="naver_id_login" class="blind"><a href="https://nid.naver.com/oauth2.0/authorize?response_type=token&amp;client_id=KHOG8V_PSvFjJoo7WpGL&amp;redirect_uri=https%3A%2F%2Fwww.ncs.go.kr%2Flogin%2FloginNaverCallBack.do&amp;state=" onclick="window.open(this.href, 'naverloginpop', 'titlebar=1, resizable=1, scrollbars=yes, width=600, height=550'); return false" id="naver_id_login_anchor"><img src="https://static.nid.naver.com/oauth/button_g.PNG" title="네이버 아이디로 로그인" width="40" height="40" border="0"></a> </div>
			                    	<button onclick="fn_loginNaver()" class="btnGet">네이버 연동</button> <!-- ◀ 연동된 계정은 class에 On 추가해주세요 
			                    	  ◀ 연동된 계정에만 연동해제 버튼이 생겨요 
			                    </li>
			                    <li class="kakao">
			                    	<input type="hidden" id="kakaoYn" value="">
			                        <a id="kakao_id_login" class="blind" href="javascript:;"></a>
			                    	<button onclick="fn_kakaoLogin()" class="btnGet">카카오톡 연동</button>
			                    	 
		                    	</li>
			                    <li class="face">
			                    	<input type="hidden" id="faceYn" value="">
			                    	<button onclick="fn_facebookLogin()" class="btnGet">페이스북 연동</button>
			                    	 
		                    	</li>
			                </ul>
                        </td>
                    </tr>
                    <tr>
                        <th>주활용사이트</th>
                        <td>
                        <input type="hidden" name="siteGbn" id="siteGbn" value="">
                        
                            <input type="radio" name="siteGbnChk" id="siteGbn01" chkvalue="01"><label for="siteGbn01">능력중심채용</label>
                        
                            <input type="radio" name="siteGbnChk" id="siteGbn02" chkvalue="02"><label for="siteGbn02">기업활용</label>
                        
                            <input type="radio" name="siteGbnChk" id="siteGbn03" chkvalue="03"><label for="siteGbn03">교육·훈련설계</label>
                        
                        </td>
                    </tr>
                    <tr>
                        <th>알림여부</th>
                        <td>
                            <input type="hidden" name="alarmAgreeYn" id="alarmAgreeYn" value="N">
                            <input type="checkbox" name="alarmAgree" id="alarmAgree"><label for="alarmAgree">NCS 홈페이지에서 제공하는 SMS, 카톡알림 등의 서비스 이용에 동의합니다.</label>
                        </td>
                    </tr>
                </tbody> -->
				</table>
		</div>
	</div>
	<!-- end contents -->

	<div class="btnArea Acenter pt60 pb100">
		<a href="javascript:history.go(-1);"
			class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a> <a
			href="javascript:fn_save();"
			class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
	</div>
	</form>


	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>


	<%@include file="/footer.jsp"%>

</body>
</html>









