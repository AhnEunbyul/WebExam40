<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	out.print("아이디 : " + userid + "<br>");
	out.print("이름 : " + name + "<br>");
	out.print("이메일 : " + email + "<br>");
%>