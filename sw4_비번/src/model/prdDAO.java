package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class prdDAO {
	 
	 public static Connection getConnection() throws Exception{
	 Class.forName("oracle.jdbc.OracleDriver");
	 Connection con =
	 DriverManager.getConnection
	 ("jdbc:oracle:thin:@localhost:1521:xe","jsl40","1234");
	 return con;
	 }
	 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	public void start(String sql) throws Exception {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
	}
	
	public void close() throws Exception {
		if(rs != null) rs.close(); 
		if(pstmt != null) pstmt.close(); 
		if(conn != null) conn.close(); 
	}
	
	// 칼럼 추가하는 메소드
	public int insertPrd(prdVO vo) {
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?)";
		
		int row = 0;
		
		try {
			start(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getPname());
			pstmt.setInt(3, vo.getCost());
			pstmt.setInt(4, vo.getPnum());
			pstmt.setInt(5, vo.getJnum());
			pstmt.setInt(6, vo.getSale());
			pstmt.setString(7, vo.getGcode());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (Exception e2) {}
		}
		return row;
	}
	
	// 테이블 조회하는 메소드
	public List<prdVO> selectPrd() {
		
		String sql = "SELECT * FROM PRODUCT";
		
		List<prdVO> list = new ArrayList<prdVO>();
		
		try {
			start(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				prdVO vo = new prdVO();
				
				vo.setCode(rs.getString("code"));
				vo.setPname(rs.getString("pname"));
				vo.setCost(rs.getInt("cost"));
				vo.setPnum(rs.getInt("pnum"));
				vo.setJnum(rs.getInt("jnum"));
				vo.setSale(rs.getInt("sale"));
				vo.setGcode(rs.getString("gcode"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (Exception e2) {}
		}
		return list;
	}
	
	// 그룹 코드에 맞는 그룹 이름 
}
