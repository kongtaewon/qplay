/**
m_no int AI PK 
m_id varchar(45) PK 
m_nick varchar(45) PK 
m_password varchar(45) 
m_roll varchar(45) 
m_loginCheck int 
m_regDate datetime 
m_img varchar(45) 
m_nickStyle varchar(45) 
m_banRank varchar(45) 
m_loginLast datetime 
m_banDate datetime 
m_secDate datetime
 * 
 * 
 */



package kr.co.qplay.member;

public class MemberDTO {
	
	private int m_no;
	private String m_id;
	private String m_nick;
	private String m_password;
	private String m_roll;
	private int m_loginCheck;
	private String m_regDate;
	private String m_img;
	private String m_nickStyle;
	private String m_banRank;
	private String m_loginDate;
	private String m_banDate;
	private String m_secDate;
	
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
	public String getM_loginDate() {
		return m_loginDate;
	}
	public void setM_loginDate(String m_loginDate) {
		this.m_loginDate = m_loginDate;
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
		return "memberDTO [m_no=" + m_no + ", m_id=" + m_id + ", m_nick=" + m_nick + ", m_password=" + m_password
				+ ", m_roll=" + m_roll + ", m_loginCheck=" + m_loginCheck + ", m_regDate=" + m_regDate + ", m_img="
				+ m_img + ", m_nickStyle=" + m_nickStyle + ", m_banRank=" + m_banRank + ", m_loginDate=" + m_loginDate
				+ ", m_banDate=" + m_banDate + ", m_secDate=" + m_secDate + "]";
	}
	
	
	
	
}
