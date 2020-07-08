<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	// 한글 안 깨지게 하는 것
	
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	String repasswd = request.getParameter("repasswd");
	String gubun = request.getParameter("gubun");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	String faArr [] = request.getParameterValues("fa");
	String job = request.getParameter("job");
	String intro = request.getParameter("intro");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원 성명 : <%= name %><br>
	회원 ID : <%= userid %><br>
	비밀번호 : <%= passwd %><br>
	주소구분 : <%= gubun %><br>
	전화번호 : <%= tel %><br>
	E-mail : <%= email %><br>
	관심분야 : <%
				for(int i = 0; i < faArr.length; i++){
					out.print(faArr[i] + "&nbsp;&nbsp;&nbsp;");
				} 
				out.print("<br>");
			%>
	직업 : <%= job %><br>
	자기소개 : <%= intro %>
</body>
</html>