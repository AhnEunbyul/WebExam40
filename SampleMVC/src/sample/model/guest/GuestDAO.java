package sample.model.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sample.util.DBManager;

public class GuestDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private GuestDAO() {
	}

	private static GuestDAO instance = new GuestDAO();

	public static GuestDAO getInstance() {
		return instance;
	}

	// 게시물 전체 카운트
	public int guestCount() {

		int row = 0;

		String sql = "SELECT COUNT(*) AS COUNTER FROM TBL_GUEST";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				row = rs.getInt("counter");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {
			}
		}
		return row;
	}

	// 게시물 전체 리스트
	public List<GuestVO> guestList() {

		List<GuestVO> list = new ArrayList<GuestVO>();

		String sql = "SELECT * FROM TBL_GUEST ORDER BY IDX DESC";

		GuestVO vo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new GuestVO();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate").substring(2, 10));
				vo.setReadcnt(rs.getInt("readcnt"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {
			}
		}
		return list;

	}

	// 게시물 등록
	public int guestWrite(GuestVO vo) {
		int row = 0;

		String sql = "INSERT INTO TBL_GUEST(IDX,NAME,SUBJECT,CONTENTS)" + " VALUES(TBL_GUEST_SEQ_IDX.NEXTVAL,?,?,?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {
			}
		}
		return row;
	}

	// idx에 맞는 게시글 가져오기
	public GuestVO guestSelect(int idx) {

		String sql = "SELECT * FROM TBL_GUEST WHERE IDX=?";

		GuestVO vo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new GuestVO();

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
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e2) {
			}
		}
		return vo;
	}

	// 조회수 증가 시키는 메소드
	public void guestCntUp(int idx) {
		String sql = "UPDATE TBL_GUEST SET READCNT = READCNT+1 WHERE IDX=?";

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
	
	// idx(특정) 게시글 수정하는 메소드
	public int guestModify(GuestVO vo) {
		String sql = "UPDATE TBL_GUEST SET NAME=?, SUBJECT=?, CONTENTS=? WHERE IDX=?";

		int row = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getIdx());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt);
			} catch (Exception e2) {
			}
		}
		return row;
	}
	
	// idx(특정) 게시글 삭제하는 메소드
	public int guestDelete(int idx) {
		String sql = "DELETE FROM TBL_GUEST WHERE IDX=?";
		
		int row = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
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
}
