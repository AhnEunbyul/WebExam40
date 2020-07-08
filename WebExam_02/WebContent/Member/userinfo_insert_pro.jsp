<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String name = null;
	if(request.getParameter("name") != null){
		name = request.getParameter("name");
	}
	String userid = request.getParameter("userid");			// 아이디
	String passwd = request.getParameter("passwd");			// 비밀번호
	String gubun = request.getParameter("gubun");			// 주소구분
	String tel = request.getParameter("tel");				// 전화
	String email = request.getParameter("email");			// 이메일
	String fa[] = request.getParameterValues("fa");			// 관심분야
	String str = null; // 아무것도 안 들어올 것은 대비해서 만듦
	if(fa != null){
		str = fa[0];
		for(int i = 1; i < fa.length; i++){
			str = str + "," + fa[i];	// 넘어온 자료들을 ,로 구분시켜줌
		}
	}
	String job = request.getParameter("job");				// 직업
	String intro = request.getParameter("intro");			// 자기소개
	
	out.print(str + "<br>");
	
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
				for(int i = 0; i < fa.length; i++){
					out.print(fa[i] + "&nbsp;&nbsp;&nbsp;");
				} 
				out.print("<br>");
			%>
	직업 : <%= job %><br>
	자기소개 : <%= intro %>
</body>
</html>