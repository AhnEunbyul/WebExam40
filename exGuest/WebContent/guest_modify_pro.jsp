<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");

	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jsl40";
	String myPW = "1234";
	
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	out.print("드라이버 로딩");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = DriverManager.getConnection(myURL,myID,myPW);
		out.print(conn);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	String sql = "UPDATE TBL_GUEST SET SUBJECT=?, CONTENTS=?, WHERE IDX=?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, subject);
	pstmt.setString(2, contents);
	pstmt.setInt(3, idx);
	
	int row = pstmt.executeUpdate();
	
	if(row == 1){
%>
	<script>
		alert("수정완료");
		location.href="guest_list.jsp";
	</script>
<%
	}else {
%>
	<script>
		alert("수정실패");
		history.back();
	</script>
<%
	};
%>