/**
 * Columns:
member_m_no int AI PK 
member_m_id varchar(45) PK 
member_m_nick varchar(45) PK 
ms_point int 
ms_pointTotal int 
ms_level int 
ms_exp int 
ms_winCnt int 
ms_loseCnt int 
ms_dailyWin int 
ms_dailyWinCheck int 
ms_makeCnt int 
ms_secDate datetime
 * 
 */

package kr.co.qplay.memberscore;

public class MemberScoreDTO {
	
	private int member_m_no;
	private String member_m_id;
	private String member_m_nick;
	private int ms_point;
	private int ms_pointTotal;
	private int ms_level;
	private int ms_exp;
	private int ms_winCnt;
	private int ms_loseCnt;
	private int ms_dailyWin;
	private int ms_dailyWinCheck;
	private int ms_makeCnt;
	private String ms_secDate;
	
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
	public int getMs_point() {
		return ms_point;
	}
	public void setMs_point(int ms_point) {
		this.ms_point = ms_point;
	}
	public int getMs_pointTotal() {
		return ms_pointTotal;
	}
	public void setMs_pointTotal(int ms_pointTotal) {
		this.ms_pointTotal = ms_pointTotal;
	}
	public int getMs_level() {
		return ms_level;
	}
	public void setMs_level(int ms_level) {
		this.ms_level = ms_level;
	}
	public int getMs_exp() {
		return ms_exp;
	}
	public void setMs_exp(int ms_exp) {
		this.ms_exp = ms_exp;
	}
	public int getMs_winCnt() {
		return ms_winCnt;
	}
	public void setMs_winCnt(int ms_winCnt) {
		this.ms_winCnt = ms_winCnt;
	}
	public int getMs_loseCnt() {
		return ms_loseCnt;
	}
	public void setMs_loseCnt(int ms_loseCnt) {
		this.ms_loseCnt = ms_loseCnt;
	}
	public int getMs_dailyWin() {
		return ms_dailyWin;
	}
	public void setMs_dailyWin(int ms_dailyWin) {
		this.ms_dailyWin = ms_dailyWin;
	}
	public int getMs_dailyWinCheck() {
		return ms_dailyWinCheck;
	}
	public void setMs_dailyWinCheck(int ms_dailyWinCheck) {
		this.ms_dailyWinCheck = ms_dailyWinCheck;
	}
	public int getMs_makeCnt() {
		return ms_makeCnt;
	}
	public void setMs_makeCnt(int ms_makeCnt) {
		this.ms_makeCnt = ms_makeCnt;
	}
	public String getMs_secDate() {
		return ms_secDate;
	}
	public void setMs_secDate(String ms_secDate) {
		this.ms_secDate = ms_secDate;
	}
	@Override
	public String toString() {
		return "MemberScoreDTO [member_m_no=" + member_m_no + ", member_m_id=" + member_m_id + ", member_m_nick="
				+ member_m_nick + ", ms_point=" + ms_point + ", ms_pointTotal=" + ms_pointTotal + ", ms_level="
				+ ms_level + ", ms_exp=" + ms_exp + ", ms_winCnt=" + ms_winCnt + ", ms_loseCnt=" + ms_loseCnt
				+ ", ms_dailyWin=" + ms_dailyWin + ", ms_dailyWinCheck=" + ms_dailyWinCheck + ", ms_makeCnt="
				+ ms_makeCnt + ", ms_secDate=" + ms_secDate + "]";
	}
	
	
	
	

}
