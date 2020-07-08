package model.board;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import util.DBManager;

public class BoardDAO {

	DBManager manager = DBManager.getInstance();

	Connection conn = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	// 게시글 전체 카운트

	public int boardCount() {

		String query = "select count(*) as counter from tbl_board";

		int cnt = 0;

		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("counter"); // cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {}
		}
		return cnt;
	}

	// 게시글중 조건에 맞는 게시글 전체 갯수 카운트

	public int boardCount(String s_query) {

		String query = "select count(*) as counter from tbl_board where " + s_query;

		int cnt = 0;

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				cnt = rs.getInt("counter"); // cnt = rs.getInt(1);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return cnt;

	}

	// 조건에 맞는 게시글 갯수 카운트

	public int boardCount(String search, String key) {

		String query = "select count(*) as counter from tbl_board where " + search + " like '%" + key + "%'";

		int cnt = 0;

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				cnt = rs.getInt("counter"); // cnt = rs.getInt(1);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return cnt;

	}

	// 게시글 전체 목록 메소드

	public List<BoardVO> boardList() {

		String query = "select * from tbl_board order by idx desc";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

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

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return list;

	}

	// 게시글(시작,끝) 불러오기

	public List<BoardVO> boardList(int pagestart, int endpage) {

		String query = "select X.* from (select rownum rnum, A.* from ("

				+ "select * from tbl_board order by regdate desc) A " + "where rownum <= ?) X where X.rnum > ?";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {

			conn = manager.getConnection();

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

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

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

			conn = manager.getConnection();

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

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return list;

	}

	// 게시글 등록

	public int boardWrite(BoardVO vo) {

		String query = "insert into tbl_board(idx,name,email,subject,contents,pass) "

				+ " values (tbl_board_seq_idx.nextval,?,?,?,?,?)";

		int row = 0;

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

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

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return row;

	}

	public void boardCntUp(int idx) {

		String query = "update tbl_board set readcnt=readcnt+1 where idx=?";

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, idx);

			pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

	}

	public BoardVO boardSelect(int idx) {

		String query = "select * from tbl_board where idx=?order by idx desc";

		BoardVO vo = null;

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new BoardVO();

				vo.setIdx(rs.getInt("idx"));

				vo.setName(rs.getString("name"));

				vo.setEmail(rs.getString("email"));

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

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return vo;

	}

	// 게시글 삭제

	public int boardDelete(int idx, String pass) {

		String query = "delete from tbl_board where idx=? and pass=?";

		int row = 0;

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, idx);

			pstmt.setString(2, pass);

			row = pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return row;

	}

	// 게시글 수정

	public int boardUpdate(BoardVO vo, int idx) {

		String query = "update tbl_board set email=?,subject=?,contents=? where idx=?";

		int row = 0;

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getEmail());

			pstmt.setString(2, vo.getSubject());

			pstmt.setString(3, vo.getContents());

			pstmt.setInt(4, idx);

			row = pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return row;

	}

	// 게시글 검색

	public List<BoardVO> boardList(String search, String key) {

//			String query = "select * from tbl_board where ? like ? order by idx desc";

		String query2 = "select * from tbl_board where " + search + " like '%" + key + "%' order by idx desc";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {

			conn = manager.getConnection();

			pstmt = conn.prepareStatement(query2);

//				pstmt.setString(1, "'"+search+"'");

//				pstmt.setString(2, "%"+key+"%");

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

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

			}

		}

		return list;

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

			} catch (Exception e2) {
			}

		}

		return row;

	}

}