<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	int idx = Integer.parseInt(request.getParameter("idx"));

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
	
	String sql = "DELETE FROM TBL_GUEST WHERE IDX=?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, idx);
	
	int row = pstmt.executeUpdate();
	
	if(row == 1){
%>
	<script>
		alert("삭제완료");
		location.href="guest_list.jsp";
	</script>
<%
	}else {
%>
	<script>
		alert("삭제실패");
		history.back();
	</script>
<%
	};
%>