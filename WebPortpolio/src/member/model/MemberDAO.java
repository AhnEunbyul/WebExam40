package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager manager = DBManager.getInstance();
	
	// 회원가입
	public int insert(MemberVO vo) {
		String sql = "INSERT INTO MEMBER VALUES(MEMBER_SEQ_IDX.NEXTVAL,?,?,?,?,?,?)";
		
		int row = 0;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getRepwd());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getEmail());

			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return row;
	}
	
	// 회원가입 때 아이디 중복 체크
	public int idCheck(String userid) {
		String sql = "SELECT USERID FROM MEMBER WHERE USERID=?";
		
		int check = 0;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) check = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return check;
	}
	
	// 로그인
	
}
