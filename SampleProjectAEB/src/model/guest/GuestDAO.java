package model.guest;



import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;



import model.board.BoardVO;

import util.DBManager;



public class GuestDAO {



	// 방명록 전체 리스트

	public List<GuestVO> guestList() {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		// 쿼리문 정의

		String query = "select * from tbl_guest order by idx desc";

		// 리턴타입 정의 (리턴타입에 맞는놈 정의)

		List<GuestVO> list = new ArrayList<GuestVO>();



		try {

			conn = DBManager.getInstance().getConnection();

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			GuestVO vo = null;

			while (rs.next()) {

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

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return list;

	}



	// 등록메소드-2 (오버로딩)

	public int guestWrite(GuestVO vo) {

		Connection conn = null;

		PreparedStatement pstmt = null;



		int row = 0;



		String query = "insert into tbl_guest(idx,name,subject,contents) " + " values(tbl_guest_seq_idx.nextval,?,?,?)";



		try {

			conn = DBManager.getInstance().getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getName());

			pstmt.setString(2, vo.getSubject());

			pstmt.setString(3, vo.getContents());



			row = pstmt.executeUpdate();

			// 로우에 성공한 갯수가 들어감



		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

		return row;



	}



	// 기본키(글번호)에 해당하는 글 추출하는 메소드

	public GuestVO guestSelect(int idx) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		GuestVO vo = null;

		String query = "select * from tbl_guest where idx=?";



		try {

			vo = new GuestVO();

			conn = DBManager.getInstance().getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();

			if (rs.next()) {

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

				if (rs != null)

					rs.close();

				if (pstmt != null)

					pstmt.close();

				if (conn != null)

					conn.close();

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

		return vo;



	}



	// 조회수 증가 메소드

	public void guestReadcnt(int idx) {

		Connection conn = null;

		PreparedStatement pstmt = null;



		String query = "update tbl_guest set readcnt = readcnt+1 where idx=?";



		try {

			conn = DBManager.getInstance().getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, idx);

			pstmt.executeQuery();



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



	// 게시글(시작,끝) 불러오기

	public List<GuestVO> GuestList(int pagestart, int endpage) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String query = "select X.* from (select rownum rnum, A.* from ("

				+ "select * from tbl_guest order by regdate desc) A " + "where rownum <= ?) X where X.rnum > ?";



		List<GuestVO> list = new ArrayList<GuestVO>();



		try {

			conn = DBManager.getInstance().getConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, endpage);

			pstmt.setInt(2, pagestart);

			rs = pstmt.executeQuery();

			GuestVO vo = null;

			while (rs.next()) {

				vo = new GuestVO();

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



	// 게시글 전체 카운트

	public int guestCount() {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String query = "select count(*) as counter from tbl_guest";

		int cnt = 0;

		try {

			conn = DBManager.getInstance().getConnection();

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



}
