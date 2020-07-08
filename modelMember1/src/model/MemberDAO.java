package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
private MemberDAO() {}	// 다른 곳(자바파일)에서 GuestDAO를 쓸 수 없게 막아둔 것.
	
	public static MemberDAO instance = new MemberDAO();	// 자기가 자기 객체 생성(싱글톤)
														// static을 붙였기 때문에 딱 한 번 객체 생성 가능.
	public static MemberDAO getInstance() {
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
	
	// 회원정보 등록 메소드
	public boolean memberInsert(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query="insert into tbl_member(idx,name,userid,passwd,gubun,zipcode,addr1,addr2,tel,email,job,intro,favorite) "
				+ "values(tbl_member_seq_idx.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean flag = false;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getGubun());
			pstmt.setString(5, vo.getZipcode());
			pstmt.setString(6, vo.getAddr1());
			pstmt.setString(7, vo.getAddr2());
			pstmt.setString(8, vo.getTel());
			pstmt.setString(9, vo.getEmail());
			pstmt.setString(10, vo.getJob());
			pstmt.setString(11, vo.getIntro());
			pstmt.setString(12, vo.getFavorite());
			flag = pstmt.execute();
			}catch (Exception e) {
			System.out.println(	e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {}
		}
		
		
		return flag;
	}
	// id 중복 검사 메소드
	public int memberIDCheck(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="select count(*) from tbl_member where userid=?";
		int check = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query); // 쿼리문 넣는건 따옴표 넣는거 아닙니다요 ㅠㅠ ㅋㅋㅋㅋㅋㅋ ps.안은별
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt(1);
			}
		}catch (Exception e) {e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {}
		}
		
		
		return check;
	}
	// 우편번호 검색 메소드
	public List<ZipcodeVO> zipcodeList(String addr){
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ZIPCODE WHERE DONG LIKE '%" + addr + "%'";
		//String sql2 = "SELECT * FROM ZIPCODE WHERE DONG LIKE ?";
		
		try {
			conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			//pstmt = conn.prepareStatement(sql2);
//			pstmt.setString(1, "%"+addr+"%");
			//pstmt.setString(1, addr);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipcodeVO vo = new ZipcodeVO();
				
				vo.setZipcode(rs.getString("zipcode"));
				vo.setSido(rs.getString("sido"));
				vo.setGugun(rs.getString("gugun"));
				vo.setDong(rs.getString("dong"));
				vo.setBunji(rs.getString("bunji"));
				list.add(vo);
			}
			System.out.println(rs.getString("zipcode"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	// 회원 전체 목록 검색 메소드
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="select * from tbl_member";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setIdx(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setPasswd(rs.getString(4));
				vo.setGubun(rs.getString(5));
				vo.setZipcode(rs.getString(6));
				vo.setAddr1(rs.getString(7));
				vo.setAddr2(rs.getString(8));
				vo.setTel(rs.getString(9));
				vo.setEmail(rs.getString(10));
				vo.setJob(rs.getString(11));
				vo.setIntro(rs.getString(12));
				vo.setFavorite(rs.getString(13));
				vo.setFirst_time(rs.getString(14));
				vo.setLast_time(rs.getString(15));
				list.add(vo);
			}
			
		}catch (Exception e) {

		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {}
		}
		return list;
	}
	// 로그인(id, pass 체크) 검사 메소드
	public int memberLogin(String userid, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT PASSWD FROM TBL_MEMBER WHERE USERID=?";
		
		int row = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 아이디가 있음
				String pass = rs.getString("passwd");
				if(pass.equals(passwd)) {
					// 로그인에 성공한 부분
					sql = "UPDATE TBL_MEMBER SET LAST_TIME = SYSDATE WHERE USERID=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.executeUpdate();
					
					row = 1;
				}else {
					// 로그인 실패 (비밀번호 오류)
					row = 0;
				}
			}else { // 아이디도 없음
				row = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e2) {}
		}
		return row;
		
	}
	
	// id 또는 기본키에 해당하는 회원 정보 검색 메소드
	
	// 회원정보 수정 메소드
	
}
