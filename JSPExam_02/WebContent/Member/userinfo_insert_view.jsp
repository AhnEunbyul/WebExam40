<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>

<%
	request.setCharacterEncoding("UTF-8");

	String fa[] = request.getParameterValues("fa");
	String str = "1";
	if(fa != null){
		str = fa[0];
		for(int i = 1; i < fa.length; i++){
			str = str + "/" + fa[i];
		}
	}
%>

<jsp:useBean id = "userinfo" class="model.userinfoVO">
	<jsp:setProperty name="userinfo" property="*" />
</jsp:useBean>

회원 성명 : <%= userinfo.getName() %> <br>
회원 ID : <%= userinfo.getUserid() %> <br>
비밀번호 : <%= userinfo.getPasswd() %> <br>
주소구분 : <%= userinfo.getGubun() %> <br>
전화번호 : <%= userinfo.getTel() %> <br>
E-mail : <%= userinfo.getEmail() %> <br>
관심분야 : <%= str %> <br>
직업 : <%= userinfo.getJob() %> <br>
자기소개 : <%= userinfo.getIntro() %> <br>