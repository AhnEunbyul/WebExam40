package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sun.misc.BASE64Decoder;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) throws Exception {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	// 로그인 
	
	public int login(String userid, String pwd) {
		String sql = "SELECT PWD FROM MEMBER WHERE USERID=?";
		BASE64Decoder base64Decoder = new BASE64Decoder();
		
		int check = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pass = rs.getString("pwd");
				String passwd = new String(base64Decoder.decodeBuffer(pass));
				if(passwd.equals(pwd)) {
					check = 1; // 로그인 성공
				}else {
					check = 0; // 비밀번호 오류
				}
			}else {
				check = -1; // rs가 읽어오질 못함 -> 아이디 X
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
		return check;
	}
	
	//회원가입

	public int insert(MemberVO vo) {
		String sql = "insert into member values(member_seq_idx.nextval,?,?,?,?,?,?)";
		
		int row = 0;
		
		try {
			conn = getConnection();
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
				close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}
