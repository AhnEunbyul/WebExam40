package sample.model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sample.util.DBManager;
import sun.misc.BASE64Decoder;

public class memberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private memberDAO() {}
	private static memberDAO instance = new memberDAO();
	
	public static memberDAO getInstance() {
		return instance;
	}
	
	// 회원가입
	public int insert(memberVO vo) {
		String sql = "INSERT INTO MEMBER VALUES(MEMBER_SEQ_IDX.NEXTVAL,?,?,?,?,?,?)";

		int row = 0;

		try {
			conn = DBManager.getConnection();
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
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 회원가입 때 아이디 중복 체크
	public boolean idCheck(String userid) {
		String sql = "SELECT USERID FROM MEMBER WHERE LIKE ?";
		
		boolean check = false;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("userid").equals(userid)) {
					check = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
		return check;
	}
	
	// 로그인
	public int login(String userid, String pwd) {
		String sql = "SELECT PWD FROM MEMBER WHERE USERID=?";
		BASE64Decoder base64Decoder = new BASE64Decoder();
		
		int row = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pass = rs.getString("pwd"); // DB에 저장된 비밀번호와
				String passwd = new String(base64Decoder.decodeBuffer(pass)); // 복호화 된 비밀번호가
				if(pwd.equals(passwd)) { // 같다면
					row = 1; // 로그인 성공
				}else {
					row = 0; // 비밀번호 오류
				}
			}else {
				row = -1; // 아이디가 존재하지 않음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
		return row;
	}
	
	
	
	
}
