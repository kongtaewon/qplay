package kr.co.qplay.boardfree;

public class BoardFreeReplyDTO {
	
	private int bfr_no;	 //댓글 번호
	private	int board_free_bf_no;//게시물 번호
	private	int member_m_no;//회원 번호
	private	String member_m_id;//회원 아이디
	private	String member_m_nick;//회원 닉네임
	private	String bfr_contents;//댓글 내용
	private	String bfr_password;//댓글 비밀번호
	private	int bfr_upCnt;//댓글 추천수
	private	int bfr_downCnt;//댓글 비추수
	private	String bfr_regDate;//댓글 작성일
	private String bfr_delDate;//댓글 삭제일
	
	public BoardFreeReplyDTO() {}

	public BoardFreeReplyDTO(int bfr_no, int board_free_bf_no, int member_m_no, String member_m_id,
			String member_m_nick, String bfr_contents, String bfr_password, int bfr_upCnt, int bfr_downCnt,
			String bfr_regDate, String bfr_delDate) {
		super();
		this.bfr_no = bfr_no;
		this.board_free_bf_no = board_free_bf_no;
		this.member_m_no = member_m_no;
		this.member_m_id = member_m_id;
		this.member_m_nick = member_m_nick;
		this.bfr_contents = bfr_contents;
		this.bfr_password = bfr_password;
		this.bfr_upCnt = bfr_upCnt;
		this.bfr_downCnt = bfr_downCnt;
		this.bfr_regDate = bfr_regDate;
		this.bfr_delDate = bfr_delDate;
	}

	public int getBfr_no() {
		return bfr_no;
	}

	public void setBfr_no(int bfr_no) {
		this.bfr_no = bfr_no;
	}

	public int getBoard_free_bf_no() {
		return board_free_bf_no;
	}

	public void setBoard_free_bf_no(int board_free_bf_no) {
		this.board_free_bf_no = board_free_bf_no;
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

	public String getBfr_contents() {
		return bfr_contents;
	}

	public void setBfr_contents(String bfr_contents) {
		this.bfr_contents = bfr_contents;
	}

	public String getBfr_password() {
		return bfr_password;
	}

	public void setBfr_password(String bfr_password) {
		this.bfr_password = bfr_password;
	}

	public int getBfr_upCnt() {
		return bfr_upCnt;
	}

	public void setBfr_upCnt(int bfr_upCnt) {
		this.bfr_upCnt = bfr_upCnt;
	}

	public int getBfr_downCnt() {
		return bfr_downCnt;
	}

	public void setBfr_downCnt(int bfr_downCnt) {
		this.bfr_downCnt = bfr_downCnt;
	}

	public String getBfr_regDate() {
		return bfr_regDate;
	}

	public void setBfr_regDate(String bfr_regDate) {
		this.bfr_regDate = bfr_regDate;
	}

	public String getBfr_delDate() {
		return bfr_delDate;
	}

	public void setBfr_delDate(String bfr_delDate) {
		this.bfr_delDate = bfr_delDate;
	}

	@Override
	public String toString() {
		return "boardfreereplyDTO [bfr_no=" + bfr_no + ", board_free_bf_no=" + board_free_bf_no + ", member_m_no="
				+ member_m_no + ", member_m_id=" + member_m_id + ", member_m_nick=" + member_m_nick + ", bfr_contents="
				+ bfr_contents + ", bfr_password=" + bfr_password + ", bfr_upCnt=" + bfr_upCnt + ", bfr_downCnt="
				+ bfr_downCnt + ", bfr_regDate=" + bfr_regDate + ", bfr_delDate=" + bfr_delDate + "]";
	}
	
	
}
