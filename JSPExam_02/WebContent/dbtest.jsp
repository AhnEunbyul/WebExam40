<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBTest</title>
</head>
<body>
	<%
		
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
		try {
			conn = DriverManager.getConnection(myURL,myID,myPW);
			out.print(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>