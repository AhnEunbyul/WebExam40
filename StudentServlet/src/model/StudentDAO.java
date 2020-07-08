package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDAO {
	private StudentDAO() {}
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = 
				DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521:xe","jsl40","1234");
		return con;
	}
	
	// 필요한 메소드들 입력 시작
	
	
	
	
	
}
