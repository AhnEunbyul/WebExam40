<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	BoardVO vo = new BoardVO();		// 꼭 있어야 하는 건 아님.
	
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String pass = request.getParameter("pass");
	
	BoardDAO dao = BoardDAO.getInstance();
	
	// 방법 1 : dao.guestWrite(name, subject, contents);
	
	// 방법 2 : vo 불러오기
	vo.setName(name);
	vo.setEmail(email);
	vo.setSubject(subject);
	vo.setContents(contents);
	vo.setPass(pass);
	
	int row = dao.boardWrite(vo);
	response.sendRedirect("board_list.jsp");

%>