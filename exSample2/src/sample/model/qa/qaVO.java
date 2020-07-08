package sample.model.qa;

public class qaVO {
	private int idx;			// 게시글 번호
	private String subject;		// 게시글 제목
	private String contents;	// 게시글 내용
	private String userid;		// 게시글 작성자 아이디
	private String pwd;			// 게시글 작성자 비밀번호
	private String name;		// 게시글 작성자 이름
	private String filename;	// 게시글 파일 첨부
	private String regdate;		// 게시글 작성일자
	private int readcnt;		// 게시글 조회수
	private int recnt;			// 게시글 댓글의 수
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getRecnt() {
		return recnt;
	}
	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}
	
	
}
