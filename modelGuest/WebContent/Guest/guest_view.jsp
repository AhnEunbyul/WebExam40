<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,model.*"%>
<%!
	String lineBreak(String str){
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '\n'){
				buf.append("<br>");
			}else{
				buf.append(str.charAt(i));
			}
		}
		return new String(buf);
	}
%>
<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	GuestDAO dao = GuestDAO.getInstance();
	
	// 쿠키검사
	boolean check = false; // 내가 넘겨준 쿠키가 있는지 없는지에 대한 체크!
	Cookie info = null;
	Cookie[] cookies = request.getCookies(); // request를 이용해 모든 쿠키의 값을 가져옴
	
	for(int i = 0 ; i < cookies.length; i++){
		info = cookies[i];
		if(info.getName().equals("guest"+idx)){
			check = true;
		}
	//	out.print(info.getName() + ":" + info.getValue() + "<br>");
	}
	
	String newValue = "" + System.currentTimeMillis();
	if(!check){ // 쿠키가 존재하지 않으면
		dao.guestReadcnt(idx); // 조회수 누적
		info = new Cookie("guest" + idx, newValue); 
		// idx 중요함!!!!! 주로 guest 부분은 자기 도메인으로 하는 경우가 많음. 
		info.setMaxAge(60*60); // 세션(쿠키)를 유지하는 시간표시. 1시간표시. (하루일 경우 : 24*60*60)
		response.addCookie(info);
	}
	
	
	GuestVO vo = dao.guestSelect(idx);
			
%>

 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>방명록 내용 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
 <script language="javascript">
 <!--
 function del_list() {
   var urlString;
    urlString = "guest_delete.jsp" ;
    window.open(urlString, "del_list"," resizable=no,x=150,y=150,width=300,height=170");
 }
 //-->
 </script>
 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">방 명 록</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움">
                 <%= vo.getSubject() %></font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              <%= vo.getName() %>  </font>/ <font size="2" face="돋움"><%= vo.getRegdate() %> / <%= vo.getReadcnt() %>번 읽음</font>
             <p>
             <%= lineBreak(vo.getContents()) %></p>
           </td>
         </tr>
       </table>

      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 목록보기 -->
       <a href="guest_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
       <a href="guest_modify.jsp?idx=<%= idx %>"><img src="./img/edit.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
       <a href="guest_delete.jsp?idx=<%= idx %>"><img src="./img/del.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>
