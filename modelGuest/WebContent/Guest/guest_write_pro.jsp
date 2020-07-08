<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	GuestVO vo = new GuestVO();		// 꼭 있어야 하는 건 아님.
	
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	
	GuestDAO dao = GuestDAO.getInstance();
	
	// 방법 1 : dao.guestWrite(name, subject, contents);
	
	// 방법 2 : vo 불러오기
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContents(contents);
	
	int row = dao.guestWrite(vo);
	response.sendRedirect("guest_list.jsp"); // 밑에 script 작동 안하고 무조건 list로 가게 하는 것
%>
