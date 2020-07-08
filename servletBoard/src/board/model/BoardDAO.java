package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.util.DBManager;

public class BoardDAO {
	DBManager manager = DBManager.getInstance();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 게시글 전체 카운트 메소드(갯수! -> int 형식으로 받아야)
	public int boardCount (){
		String sql = "SELECT COUNT(*) AS COUNTER FROM TBL_BOARD";
		
		int cnt = 0; // 리턴타입
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// 딱 한 개의 값을 꺼내올 때는 if 가능!
				cnt = rs.getInt("counter");	// count(*) 이름을 as로 지정해줬기에 사용 가능
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
		return cnt;
	}
	// 게시글 전체 목록 메소드
	public List<BoardVO> boardList (){
		String sql = "SELECT * FROM TBL_BOARD ORDER BY IDX DESC";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			BoardVO vo = null;
			while(rs.next()) {	// 딱 한 개의 값을 꺼내올 때는 if 가능!
				vo = new BoardVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setName(rs.getString("name"));
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
	
	// 게시글 글쓰기 메소드
	public int boardWrite(BoardVO vo) {
		String sql = "INSERT INTO TBL_BOARD(IDX,NAME,EMAIL,SUBJECT,CONTENTS,PASS)"
				+ " VALUES(TBL_BOARD_SEQ_IDX.NEXTVAL,?,?,?,?,?)";
		
		int row = 0;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getSubject());
			pstmt.setString(4, vo.getContents());
			pstmt.setString(5, vo.getPass());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {}
		}
		return row;
	}
	
	// idx값에 따라 내용 보여주는 메소드
	public BoardVO boardSelect(int idx) {
		String sql = "SELECT * FROM TBL_BOARD WHERE IDX=?";
		BoardVO vo = new BoardVO();
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setPass(rs.getString("pass"));
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
	
	// 조회수 증가 시키는 메소드
	public void boardCntUp(int idx) {
		String sql = "UPDATE TBL_BOARD SET READCNT = READCNT+1 WHERE IDX=?";
		
		try {
			conn = manager.getConnection();
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
	
	// 삭제시키는 메소드
	public int boardDelete(int idx, String pass) {
		String sql = "DELETE FROM TBL_BOARD WHERE IDX=? AND PASS=?";
		
		int row = 0;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {}
		}
		return row;
	}
	
	// idx(특정) 게시글 수정하는 메소드
	public int boardModify(BoardVO vo) {
		String sql = "UPDATE TBL_BOARD SET EMAIL=?, SUBJECT=?, CONTENTS=? "
				+ "WHERE IDX=? AND PASS=?";
		
		int row = 0;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getIdx());
			pstmt.setString(5, vo.getPass());
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {}
		}
		return row;
	}
	
}
