package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
	
	private GuestDAO() {}	// 다른 곳(자바파일)에서 GuestDAO를 쓸 수 없게 막아둔 것.
	
	public static GuestDAO instance = new GuestDAO();	// 자기가 자기 객체 생성(싱글톤)
														// static을 붙였기 때문에 딱 한 번 객체 생성 가능.
	public static GuestDAO getInstance() {
		return instance;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jsl40","1234");
			System.out.println("커넥션이 연결되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 방명록 전체 자료 검색
	public List<GuestVO> guestList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_GUEST ORDER BY IDX DESC";
											  // 가장 최근 것이 위로 가게
		// 리턴타입 정의
		List<GuestVO> list = new ArrayList<GuestVO>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			GuestVO vo = null;
			
			while(rs.next()) {
				vo = new GuestVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
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
		return list;
	}
	
	// 글 등록 메소드
	public void guestWrite(String name, String subject, String contents) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO TBL_GUEST(IDX,NAME,SUBJECT,CONTENTS)"
				+ "VALUES(tbl_guest_seq_idx.nextval,?,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, contents);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
	}
	
	// 글 등록 메소드-1
	public int guestWrite(GuestVO vo) {	// 오버로딩(메소드 이름은 같지만 매개변수가 다를 때)
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		int row = 0;
		String sql = "INSERT INTO TBL_GUEST(IDX,NAME,SUBJECT,CONTENTS)"
				+ " VALUES(tbl_guest_seq_idx.nextval,?,?,?)";
			
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
				
			row = pstmt.executeUpdate();
						// 하나의 sql 성공한 갯수가 들어가는 것
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return row;
	}
		
	// 기본키(글번호=idx)에 해당하는 글 추출하는 메소드
	public GuestVO guestSelect(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TBL_GUEST WHERE IDX=?";
		
		GuestVO vo = new GuestVO();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {}
		}
		
		return vo;
	}
	
	// 게시글 조회수 증가 메소드
	public void guestReadcnt (int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE TBL_GUEST SET READCNT = READCNT+1 WHERE IDX=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {}
		}
	}
	
	// 글 등록 메소드-1
	public int guestUpdate(GuestVO vo) {	// 오버로딩(메소드 이름은 같지만 매개변수가 다를 때)
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		int row = 0;
		String sql = "UPDATE TBL_GUEST SET SUBJECT=?,CONTENTS=? WHERE IDX=?";
		
				
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getIdx());
					
			row = pstmt.executeUpdate();
						// 하나의 sql 성공한 갯수가 들어가는 것
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
			
		return row;
	}
	
	// 게시글 삭제 메소드
	public int guestDelete(int idx) {	// 오버로딩(메소드 이름은 같지만 매개변수가 다를 때)
		Connection conn = null;
		PreparedStatement pstmt = null;
					
		int row = 0;
		String sql = "DELETE FROM TBL_GUEST WHERE IDX=?";
					
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
						
			row = pstmt.executeUpdate();
						// 하나의 sql 성공한 갯수가 들어가는 것
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
				
		return row;
	}	
}
