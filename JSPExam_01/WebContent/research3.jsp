<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	
	request.setAttribute("name", name);
	request.setAttribute("gender", gender);
	
	RequestDispatcher dispater = request.getRequestDispatcher("result.jsp");
	
	dispater.forward(request, response);
			
%>