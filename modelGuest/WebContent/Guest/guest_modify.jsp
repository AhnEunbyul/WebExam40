<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.*"%>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	GuestDAO dao = GuestDAO.getInstance();
	GuestVO vo = dao.guestSelect(idx);		// 수정하기 부분은 view에서 썼던 메소드 가져와서 써도 상관 없음 !
%>
 <html>
   <head><title>방명록 수정</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">

<script>
	function in_check() {
		alert("수정이 완료되었습니다.");
		input.submit();
	}
</script>
</head>

 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">

   <!-- 다음에 추가할 부분 "-->

   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="./img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>방 명 록</b></font>
     <font size="2"> - 수정하기</font><p>
     <img src="./img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="./img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     
		 <form method="post" action="guest_modify_pro.jsp" name="input">
			<input type="hidden" name="idx" value="<%= idx %>">
      <input type="hidden" name="page" value="">

      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="./img/bullet-02.gif"></td>
         <td width="15%"><font size="2 face="돋움"">이름</font></td>
         <td width="80%">
         <input type="text" size="20" name="name" value="<%= vo.getName() %>" readonly></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject" value="<%= vo.getSubject() %>"></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60" ><%= vo.getContents() %></textarea></td>
       </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td><input type="button" value="수정하기" onClick="in_check();">&nbsp;
          <input type="button" value="돌아가기" onClick="history.back();"></td></tr>
      </table>
      </form>
    </td></tr>
  </table>
  </body>
  </html>
   