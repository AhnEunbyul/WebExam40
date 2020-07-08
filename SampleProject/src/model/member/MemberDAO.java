package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class MemberDAO {
	
	// 회원정보 등록 메소드
	public boolean memberInsert(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO TBL_MEMBER(IDX,NAME,USERID,PASSWD,TEL,EMAIL) "
				+ "VALUES(TBL_MEMBER_SEQ_IDX.NEXTVAL,?,?,?,?,?)";
		boolean check = false;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());

			check = pstmt.execute();
		}catch (Exception e) {
			System.out.println(	e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {}
		}
		return check;
	}
	
	// ID 중복 체크 메소드
	public int memberIDCheck(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM TBL_MEMBER WHERE USERID=?";
		
		int check = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt(1);
			}
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
	
	// 로그인 메소드 (userid, passwd)체크
	public int memberLogin(String userid, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT PASSWD FROM TBL_MEMBER WHERE USERID=?";
		
		int check = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pass = rs.getString("passwd");
				if(pass.equals(passwd)) {
					// 로그인 성공
					sql = "UPDATE TBL_MEMBER SET LAST_TIME = SYSDATE WHERE USERID=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					rs = pstmt.executeQuery();
					check = 1;
				}else {
					// 로그인 실패(비밀번호 오류)
					check = 0;
				}
			}else {
				// 로그인 실패(아이디 없음)
				check = -1;
			}
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
	
	// 로그인 했을 때 이름으로 뜨게 하는 메소드
	public String memberNameView(String userid, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT NAME FROM TBL_MEMBER WHERE USERID=? AND PASSWD=?";
		
		String check = "";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				check = rs.getString(1);
			}
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
}
