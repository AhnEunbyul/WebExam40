package sample.model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sample.util.DBManager;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	// 게시글 전체 카운트 메소드(갯수! -> int 형식으로 받아야)
	public int boardCount() {
		String sql = "SELECT COUNT(*) AS COUNTER FROM TBL_BOARD";

		int cnt = 0; // 리턴타입

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 딱 한 개의 값을 꺼내올 때는 if 가능!
				cnt = rs.getInt("counter"); // count(*) 이름을 as로 지정해줬기에 사용 가능
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
		return cnt;
	}
	
	// 게시글 전체 목록 메소드
	public List<BoardVO> boardList() {
		String sql = "SELECT * FROM TBL_BOARD ORDER BY IDX DESC";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			BoardVO vo = null;
			while (rs.next()) {
				vo = new BoardVO();

				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate").substring(2,10));
				vo.setReadcnt(rs.getInt("readcnt"));

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
	
	// idx값에 따라 내용 보여주는 메소드
	public BoardVO boardSelect(int idx) {
		String sql = "SELECT * FROM TBL_BOARD WHERE IDX=?";
		BoardVO vo = new BoardVO();

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
				vo.setPass(rs.getString("pass"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
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
	
	// 조회수 증가 시키는 메소드
	public void boardCntUp(int idx) {
		String sql = "UPDATE TBL_BOARD SET READCNT = READCNT+1 WHERE IDX=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt);
			} catch (Exception e2) {}
		}
	}
	
	// 게시글 글쓰기 메소드
	public int boardWrite(BoardVO vo) {
		String sql = "INSERT INTO TBL_BOARD(IDX,NAME,EMAIL,SUBJECT,CONTENTS,PASS)"
				+ " VALUES(TBL_BOARD_SEQ_IDX.NEXTVAL,?,?,?,?,?)";

		int row = 0;

		try {
			conn = DBManager.getConnection();
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
				DBManager.close(conn, pstmt);
			} catch (Exception e2) {}
		}
		return row;
	}
	
	public int boardModify(BoardVO vo) {
		String sql = "UPDATE TBL_BOARD SET EMAIL=?, SUBJECT=?, CONTENTS=? " 
					+ "WHERE IDX=? AND PASS=?";

		int row = 0;

		try {
			conn = DBManager.getConnection();
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
				DBManager.close(conn, pstmt);
			} catch (Exception e2) {}
		}
		return row;
	}
	
	// 삭제시키는 메소드
	public int boardDelete(int idx, String pass) {
		String sql = "DELETE FROM TBL_BOARD WHERE IDX=? AND PASS=?";

		int row = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
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
	
	// 게시글중 조건에 맞는 게시글 전체 갯수 카운트
	public int boardCount(String s_query) {
		String sql = "SELECT COUNT(*) AS COUNTER FROM TBL_BOARD WHERE " + s_query;

		int cnt = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("counter"); // cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {}
		}
		return cnt;
	}
	
	// 게시글(시작,끝) 불러오기

	public List<BoardVO> boardList(int pagestart, int endpage) {

		String query = "select X.* from (select rownum rnum, A.* from ("
				+ "select * from tbl_board order by regdate desc) A " + "where rownum <= ?) X where X.rnum > ?";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);

			rs = pstmt.executeQuery();

			BoardVO vo = null;

			while (rs.next()) {
				vo = new BoardVO();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));

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
	
	// 검색조건이 있을때의 메소드

	public List<BoardVO> boardList(String s_query, int pagestart, int endpage) {

		String query = "select X.* from (select rownum rnum, A.* from ("
				+ "select * from tbl_board order by regdate desc) A "
				+ " where " + s_query + " and rownum <= ?) X where " + s_query + " and X.rnum > ?";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();

			BoardVO vo = null;

			while (rs.next()) {
				vo = new BoardVO();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));

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
}
