<%@page import="model.member.*"%>

<%@page import="java.util.List"%>

<%@ page contentType="text/html; charset=UTF-8" %>

<%

	request.setCharacterEncoding("UTF-8");

	String addr=null;

	if(request.getAttribute("addr") != null){

		addr = (String)request.getAttribute("addr");

	}



	List<ZipcodeVO> list = (List<ZipcodeVO>)request.getAttribute("list");

	out.print(list);

%>

<HTML>

<HEAD>

<TITLE>우편번호 찾기</TITLE>



<STYLE TYPE="text/css">

<!--

body { font-family: 돋움, Verdana; font-size: 9pt}

td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000}

a    { font-family: 돋움, Verdana; color: #000000; text-decoration: none}

     a:link { font-family:돋움; font-size:9pt; text-decoration:none}

     a:visited { font-family:돋움; font-size:9pt; text-decoration:none}

     a:hover { font-family:돋움; text-decoration:underline }

-->

</STYLE>



<script>

	function check(){

		if(zip.addr.value == ""){

			alert("동 이름 입력 해라");

			zip.addr.focus();

			return false;

		}

		return true;

	}

	

	function sendAddr(zipcode,sido,gugun,dong,bunji){

		addr = sido + " " + gugun + " " + dong + " " + bunji;

		opener.member.addr1.value = addr;

		opener.member.zip.value = zipcode;

		self.close();

	}

</script>





</HEAD>



<BODY BGCOLOR="#FFFFFF" onLoad="document.inquiry.addr.focus();">

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>

  <TR BGCOLOR=#7AAAD5>

    <td align=left><img src="Member/img/u_b02.gif"></td>

    <td align=center><FONT COLOR="#FFFFFF"><b>우편번호 찾기</FONT></td>

    <td align=right><img src= "Member/img/u_b03.gif"></td>

  </tr>

</table>



<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330><TR><TD BGCOLOR=#948DCF>

  <TABLE CELLPADDING=0 CELLSPACING=1 BORDER=0 WIDTH=330><TR><TD>

    <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=3 WIDTH=100% BGCOLOR=#FFFFFF>

    <FORM NAME="zip" METHOD="post" ACTION="post_check" onSubmit="return check();">

      <TR>

        <TD ALIGN=CENTER><br>

          동이름 입력 : <INPUT NAME="addr" TYPE="text" style="width:120">

          <INPUT TYPE="image" src="Member/img/u_bt08.gif" hspace=10>

        </TD>

      </TR>

      <TR>

        <TD ALIGN=CENTER>

        ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.

        </TD>

      </TR>

	

	  <%

		for(int x = 0 ; x < list.size(); x++){      

      %>

      <TR>

        <TD>

			<a href = "javascript:sendAddr('<%= list.get(x).getZipcode() %>', '<%= list.get(x).getSido() %>',

			'<%= list.get(x).getGugun() %>' , '<%= list.get(x).getDong() %>',

			'<%= list.get(x).getBunji() %>')">

			<%= list.get(x).getZipcode() %> &nbsp; <%= list.get(x).getSido() %> &nbsp;

			<%= list.get(x).getGugun() %> &nbsp; <%= list.get(x).getDong() %> &nbsp;

			<%= list.get(x).getBunji() %> </a>

        </TD>

      </TR>

	<%

		}

	%>



    </FORM>

    </TABLE>

  </TD></TR></TABLE>

</TD></TR></TABLE>



<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>

  <TR BGCOLOR=#7AAAD5>

    <td align=left><img src="Member/img/u_b04.gif"></td>

    <td align=right><img src="Member/img/u_b05.gif"></td>

  </tr>

  <tr>

    <td colspan=2 align=center>

      <img src="Member/img/u_bt13.gif" border=0 vspace=5>    </td>

  </tr>

</table>

</BODY>

</HTML>