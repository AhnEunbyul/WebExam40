<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%

	String name = request.getParameter("name");
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
	
	String sql = "INSERT INTO TBL_GUEST(IDX,NAME,SUBJECT,CONTENTS)"
			+ "VALUES(TBL_GUEST_SEQ_IDX.NEXTVAL,?,?,?)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, subject);
	pstmt.setString(3, contents);
	
	int row = pstmt.executeUpdate();
	
	if(row == 1){
%>
	<script>
		alert("등록완료");
		location.href="guest_list.jsp";
	</script>
<%
	}else {
%>
	<script>
		alert("등록실패");
		history.back();
	</script>
<%
	};
%>