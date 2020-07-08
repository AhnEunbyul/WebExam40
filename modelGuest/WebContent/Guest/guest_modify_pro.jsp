<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	GuestVO vo = new GuestVO();		// 꼭 있어야 하는 건 아님.
	
	// String name = request.getParameter("name");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	
	GuestDAO dao = GuestDAO.getInstance();
	
	// 방법 1 : dao.guestUpdate();
	
	// 방법 2 : vo 불러오기
	// vo.setName(name);
	vo.setIdx(idx);
	vo.setSubject(subject);
	vo.setContents(contents);
	
	int row = dao.guestUpdate(vo);
	
	response.sendRedirect("guest_list.jsp");
%>
