package sample.model.qa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sample.model.ui.uiVO;
import sample.util.DBManager;

public class qaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private qaDAO() {}
	private static qaDAO instance = new qaDAO();
	
	public static qaDAO getInstance() {
		return instance;
	}
	
	// 전체 자료 검색
	public List<qaVO> qa_list(){
		String sql = "SELECT * FROM QA ORDER BY IDX DESC";
		
		List<qaVO> list = new ArrayList<qaVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				qaVO vo = new qaVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRecnt(rs.getInt("recnt"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
		return list;
	}
	
	// 게시글 등록하는 메소드
	public int qa_write(qaVO vo) {
		String sql = "INSERT INTO QA(IDX,SUBJECT,CONTENTS,USERID,PWD,NAME,REGDATE,READCNT,RECNT)"
				+ " VALUES(QA_SEQ_IDX.NEXTVAL,?,?,?,?,?,SYSDATE,?,?)";
		
		int row = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getUserid());
			pstmt.setString(4, vo.getPwd());
			pstmt.setString(5, vo.getName());
			pstmt.setInt(6, vo.getReadcnt());
			pstmt.setInt(7, vo.getRecnt());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt);
			} catch (Exception e2) {}
		}
		return row;
	}
	
	// idx에 맞는 글 가져오기
	public qaVO qa_select(int idx) {
		String sql = "SELECT * FROM QA WHERE IDX=?";

		qaVO vo = new qaVO();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setFilename(rs.getString("filename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
		return vo;
	}
	
	// 조회수 증가
	public void qaCntUp(int idx) {
		String sql = "UPDATE QA SET READCNT = READCNT+1 WHERE IDX=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
	}
	
	
	
	
}
