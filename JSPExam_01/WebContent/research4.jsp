<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	
	response.sendRedirect("result2.jsp?name="+name+"&gender="+gender);
			// URL이 바뀜! 즉, 정보 일회성.
			
%>