<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
	request.setCharacterEncoding("UTF-8");

	insertBean insert1 = new insertBean();
	insert1.setUserid(request.getParameter("userid"));
	insert1.setName(request.getParameter("name"));
	insert1.setEmail(request.getParameter("email"));
%>


<jsp:useBean id = "insert" class="model.insertBean">
			 <!-- insert라는 객체를 생성해줌! -->
	<jsp:setProperty name="insert" property="*" />
									<!-- 이 클래스의 모든 항목을 *로 표시 -->
</jsp:useBean>

<%
	insert.setRegdate("2020-02-26");
%>

아이디 : <%= insert1.getUserid() %>

아이디 : <%= insert.getUserid() %> <br>
이름 : <%= insert.getName() %> <br>
이메일 : <%= insert.getEmail() %> <br>
등록일 : <%= insert.getRegdate() %>

