package kr.co.qplay.boardfree;

public class member {

	private int m_no; // 회원 번호 PK NN
	private String m_id; // 회원 아이디 PK NN
	private String m_nick;// 회원 닉네임 PK NN
	private String m_password; // 비밀번호 NN
	private String m_roll; // 권한 분류 NN
	private int m_loginCheck;// 로그인 보상 체크 NN
	private String m_regDate; // 가입일 NN
	private String m_img; // 프로필 이미지 경로
	private String m_nickStyle;// 닉네임 스타일
	private String m_banRank;// 차단 등급
	private String m_loginLast;// 최종 로그인
	private String m_banDate;// 차단일
	private String m_secDate;// 탈퇴일
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_roll() {
		return m_roll;
	}
	public void setM_roll(String m_roll) {
		this.m_roll = m_roll;
	}
	public int getM_loginCheck() {
		return m_loginCheck;
	}
	public void setM_loginCheck(int m_loginCheck) {
		this.m_loginCheck = m_loginCheck;
	}
	public String getM_regDate() {
		return m_regDate;
	}
	public void setM_regDate(String m_regDate) {
		this.m_regDate = m_regDate;
	}
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	public String getM_nickStyle() {
		return m_nickStyle;
	}
	public void setM_nickStyle(String m_nickStyle) {
		this.m_nickStyle = m_nickStyle;
	}
	public String getM_banRank() {
		return m_banRank;
	}
	public void setM_banRank(String m_banRank) {
		this.m_banRank = m_banRank;
	}
	public String getM_loginLast() {
		return m_loginLast;
	}
	public void setM_loginLast(String m_loginLast) {
		this.m_loginLast = m_loginLast;
	}
	public String getM_banDate() {
		return m_banDate;
	}
	public void setM_banDate(String m_banDate) {
		this.m_banDate = m_banDate;
	}
	public String getM_secDate() {
		return m_secDate;
	}
	public void setM_secDate(String m_secDate) {
		this.m_secDate = m_secDate;
	}
	@Override
	public String toString() {
		return "member [m_no=" + m_no + ", m_id=" + m_id + ", m_nick=" + m_nick + ", m_password=" + m_password
				+ ", m_roll=" + m_roll + ", m_loginCheck=" + m_loginCheck + ", m_regDate=" + m_regDate + ", m_img="
				+ m_img + ", m_nickStyle=" + m_nickStyle + ", m_banRank=" + m_banRank + ", m_loginLast=" + m_loginLast
				+ ", m_banDate=" + m_banDate + ", m_secDate=" + m_secDate + "]";
	}
	
	

}
