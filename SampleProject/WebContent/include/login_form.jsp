<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>Login</title>

 </head>

 <body>
   <table width="100%" height="120" border="0">
   <%
		String user = (String)session.getAttribute("user");
		// 만약 user가 존재하지 않으면 String user = null이 됨!
	 %>
	 <%
		if(user == null){
	 %> 
   <form name="login_form" action="" method="post" >
     <tr>
       <td colspan="2" bgcolor="#6FA0E" height="20" align="center">
         <font size="2" color="white"><b>Member Login</b></font>
       </td>
     </tr>
     <tr>
       <td ><font size="2">아 이 디</font></td>
       <td ><input type="text" size="10" name="userid"></td>
     </tr>
     <tr>
       <td><font size="2">비밀번호</font></td>
			 <td>
         <input type="password" size="10" name="passwd">
       </td>
     </tr>
     <tr>
       <td>
       	 <a href="login.do"><img src="include/img/login1.gif" border="0"></a>
       </td>
	   <td>
         <a href="insert.do"><img src="include/img/regist.gif" border="0"></a>
       </td>
     </tr>
 </form>
 <% }else if(user != null){ %>
 </table>
 <table width="100%" height="120" border="0">
   <tr>
     <td bgcolor="#6FA0E" align="center" height="20">
       <font size="2" color="white">${name} 님!</font>
     </td>
   </tr>
   <tr>
     <td align="center">
       <font size="2">
       <a href="logout.do">로그아웃</a><br>
       <a href="userinfo_view.jsp">회원정보수정</a>
       <a href="userinfo_del.jsp">회원탈퇴</a>

       </font>
     </td>
   </tr>
   <% } %>  

 </table>
 </body>
 </html>
