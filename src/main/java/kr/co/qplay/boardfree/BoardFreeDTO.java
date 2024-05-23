package kr.co.qplay.boardfree;

public class BoardFreeDTO {
	
	private int bf_no; //게시물 번호
	private int member_m_no; //회원 번호 
	private String member_m_id; //회원 아이디
	private String member_m_nick; //회원 닉네임
	private String bf_title; //게시물 제목
	private String bf_contents; //게시물 내용
	private String bf_regDate; //게시물 작성일
	private int bf_viewCnt; //게시판 조회수
	private int bf_upCnt; //게시물 추천수
	private int bf_downCnt; //게시물 비추수
	private String bf_img; //게시물 이미지 경로
	private String bf_delDate;//게시물 삭제일
	
	public BoardFreeDTO(){
	}

	public BoardFreeDTO(int bf_no, int member_m_no, String member_m_id, String member_m_nick, String bf_title,
			 String bf_contents, String bf_regDate, int bf_viewCnt, int bf_upCnt, int bf_downCnt,
			String bf_img, String bf_delDate) {
		super();
		this.bf_no = bf_no;
		this.member_m_no = member_m_no;
		this.member_m_id = member_m_id;
		this.member_m_nick = member_m_nick;
		this.bf_title = bf_title;
		this.bf_contents = bf_contents;
		this.bf_regDate = bf_regDate;
		this.bf_viewCnt = bf_viewCnt;
		this.bf_upCnt = bf_upCnt;
		this.bf_downCnt = bf_downCnt;
		this.bf_img = bf_img;
		this.bf_delDate = bf_delDate;
	}

	public int getBf_no() {
		return bf_no;
	}

	public void setBf_no(int bf_no) {
		this.bf_no = bf_no;
	}

	public int getMember_m_no() {
		return member_m_no;
	}

	public void setMember_m_no(int member_m_no) {
		this.member_m_no = member_m_no;
	}

	public String getMember_m_id() {
		return member_m_id;
	}

	public void setMember_m_id(String member_m_id) {
		this.member_m_id = member_m_id;
	}

	public String getMember_m_nick() {
		return member_m_nick;
	}

	public void setMember_m_nick(String member_m_nick) {
		this.member_m_nick = member_m_nick;
	}

	public String getBf_title() {
		return bf_title;
	}

	public void setBf_title(String bf_title) {
		this.bf_title = bf_title;
	}

	public String getBf_contents() {
		return bf_contents;
	}

	public void setBf_contents(String bf_contents) {
		this.bf_contents = bf_contents;
	}

	public String getBf_regDate() {
		return bf_regDate;
	}

	public void setBf_regDate(String bf_regDate) {
		this.bf_regDate = bf_regDate;
	}

	public int getBf_viewCnt() {
		return bf_viewCnt;
	}

	public void setBf_viewCnt(int bf_viewCnt) {
		this.bf_viewCnt = bf_viewCnt;
	}

	public int getBf_upCnt() {
		return bf_upCnt;
	}

	public void setBf_upCnt(int bf_upCnt) {
		this.bf_upCnt = bf_upCnt;
	}

	public int getBf_downCnt() {
		return bf_downCnt;
	}

	public void setBf_downCnt(int bf_downCnt) {
		this.bf_downCnt = bf_downCnt;
	}

	public String getBf_img() {
		return bf_img;
	}

	public void setBf_img(String bf_img) {
		this.bf_img = bf_img;
	}

	public String getBf_delDate() {
		return bf_delDate;
	}

	public void setBf_delDate(String bf_delDate) {
		this.bf_delDate = bf_delDate;
	}

	@Override
	public String toString() {
		return "BoardFreeDTO [bf_no=" + bf_no + ", member_m_no=" + member_m_no + ", member_m_id=" + member_m_id
				+ ", member_m_nick=" + member_m_nick + ", bf_title=" + bf_title + ", bf_contents=" + bf_contents
				+ ", bf_regDate=" + bf_regDate + ", bf_viewCnt=" + bf_viewCnt + ", bf_upCnt=" + bf_upCnt
				+ ", bf_downCnt=" + bf_downCnt + ", bf_img=" + bf_img + ", bf_delDate=" + bf_delDate + "]";
	}


	
	
	
	
	
	

}
