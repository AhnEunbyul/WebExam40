<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	int bun = Integer.parseInt(request.getParameter("bun"));
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	String regdate = request.getParameter("regdate");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	
	try{
	Class.forName("oracle.jdbc.OracleDriver");
		conn = 
			DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","jsl40","1234");
		;
	}catch(Exception e){
		e.printStackTrace();
	}
	String sql = "INSERT INTO TBL_SCORE_001 VALUES(?,?,?,?,?,?,?)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, bun);
	pstmt.setString(2, name);
	pstmt.setString(3, gender);
	pstmt.setInt(4, kor);
	pstmt.setInt(5, eng);
	pstmt.setInt(6, mat);
	pstmt.setString(7, regdate);
	
	int row = pstmt.executeUpdate();

	
	if(row == 1){
%>		
	<script>
		alert("학생 성적정보가 등록되었습니다.");
		location.href="bunView.jsp"
	</script>
<%
	}else {
	
%>
	<script>
		alert("등록에 실패하였습니다.");
		history.back();
	</script>
<%
	}
%>