<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "model.member.*" %>

<%

	MemberVO vo = null;

	if(session.getAttribute("vo") != null){

		vo = (MemberVO)session.getAttribute("vo");

	}

%>

<center>

<html>

   <head><title>게시판 작성</title>

    <link rel="stylesheet" type="text/css" href="/stylesheet.css">



</head>

<script>

	function send(){

		

		if(board.subject.value==""){

			alert("제목을 입력 하세요");

			board.pass.focus();

			return;

		}

		if(board.contents.value==""){

			alert("내용을 입력 하세요");

			board.pass.focus();

			return;

		}

		

		

		if(board.pass.value==""){

			alert("비밀번호를 입력 하세요");

			board.pass.focus();

			return;

		}

		

		alert("등록되었습니다.");

		board.submit();

	}

	function reset(){

		history.back();

	}

</script>



 <body topmargin="0" leftmargin="0">

 <%@ include file = "/include/topmenu.jsp"%>

 <table border="0" width="800">

 <tr>

   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">



   <%@ include file = "/include/login_form.jsp"%>



   </td>



   <td width="80%" valign="top">&nbsp;<br>

     <img src="./img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>반갑습니다</b></font>

     <font size="2"> - 글쓰기</font><p>

     <img src="./img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;

     <img src="./img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>

     <form method="post" name="board" action="board_write">



	  <table border="0">

       <tr>

         <td width="5%" align="right"><img src="./img/bullet-02.gif"></td>

         <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>

         <td width="80%">

         <input type="text" size="20" name="name" value=${vo.name } readonly></td>

       </tr>

       <tr>

         <td align="right">&nbsp;</td>

         <td ><font size="2 face="돋움"">메일주소</font></td>

         <td>

          <input type="text" size="20" name="email" value=${vo.email } readonly></td>

       </tr>

	   <tr>

         <td align="right"><img src="./img/bullet-02.gif"></td>

         <td><font size="2" face="돋움">제목</font></td>

         <td><input type="text" size="60" name="subject" ></td>

       </tr>

       <tr>

         <td align="right"><img src="./img/bullet-02.gif"></td>

         <td><font size="2" face="돋움">내용</font></td>

         <td><textarea wrap="physical" rows="10" name="contents" cols="60"></textarea></td>

       </tr>

	   <tr>

         <td align="right"><img src="./img/bullet-02.gif"></td>

         <td><font size="2" face="돋움">비밀번호</font></td>

          <td><input type="password" size="10" name="pass" ><font size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>

        </tr>

        <tr></tr>

		<tr>

          <td align="right">&nbsp;</td>

          <td><font size="2">&nbsp;</font></td>

          <td>

                     <a href="javascript:send()"><img src="./img/save.gif" border=0></a>&nbsp;&nbsp;&nbsp;

                     <a href="javascript:reset()"><img src="./img/cancle.gif" border=0></a>

          </td>

        </tr>

      </table>

      </form>

    </td>

  </tr>

  </table>

  </center>

  </body>

  </html>tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60"></textarea></td>
       </tr>
	   <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" name="pass" ><font size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>
        </tr>
        <tr></tr>
		<tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
                     <a href="#"><img src="./img/save.gif" border=0></a>&nbsp;&nbsp;&nbsp;
                     <a href="#"><img src="./img/cancle.gif" border=0></a>
          </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
  </table>
  </body>
  </html>
