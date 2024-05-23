/**
 * Columns:
qt_no int AI PK 
member_m_no int 
member_m_id varchar(45) 
member_m_nick varchar(45) 
qt_question varchar(45) 
qt_answer varchar(45) 
qt_answerView varchar(45) 
qt_makeType varchar(45) 
qt_quizType varchar(45) 
qt_regDate datetime 
qt_winCnt int 
qt_loseCnt int 
qt_hint varchar(45) 
qt_img varchar(45) 
qt_delDate datetime
 * 
 */

package kr.co.qplay.quiztyping;



public class QuizTypingDTO {
	
	private int qt_no;
	private int member_m_no;
	private String member_m_id;
	private String member_m_nick;
	private String qt_question;
	private String qt_answer;
	private String qt_answerView;
	private String qt_makeType;
	private String qt_quizType;
	private String qt_regDate;
	private int qt_winCnt;
	private int qt_loseCnt;
	private String qt_hint;
	private String qt_img;
	private String qt_delDate;
	
	public int getQt_no() {
		return qt_no;
	}
	public void setQt_no(int qt_no) {
		this.qt_no = qt_no;
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
	public String getQt_question() {
		return qt_question;
	}
	public void setQt_question(String qt_question) {
		this.qt_question = qt_question;
	}
	public String getQt_answer() {
		return qt_answer;
	}
	public void setQt_answer(String qt_answer) {
		this.qt_answer = qt_answer;
	}
	public String getQt_answerView() {
		return qt_answerView;
	}
	public void setQt_answerView(String qt_answerView) {
		this.qt_answerView = qt_answerView;
	}
	public String getQt_makeType() {
		return qt_makeType;
	}
	public void setQt_makeType(String qt_makeType) {
		this.qt_makeType = qt_makeType;
	}
	public String getQt_quizType() {
		return qt_quizType;
	}
	public void setQt_quizType(String qt_quizType) {
		this.qt_quizType = qt_quizType;
	}
	public String getQt_regDate() {
		return qt_regDate;
	}
	public void setQt_regDate(String qt_regDate) {
		this.qt_regDate = qt_regDate;
	}
	public int getQt_winCnt() {
		return qt_winCnt;
	}
	public void setQt_winCnt(int qt_winCnt) {
		this.qt_winCnt = qt_winCnt;
	}
	public int getQt_loseCnt() {
		return qt_loseCnt;
	}
	public void setQt_loseCnt(int qt_loseCnt) {
		this.qt_loseCnt = qt_loseCnt;
	}
	public String getQt_hint() {
		return qt_hint;
	}
	public void setQt_hint(String qt_hint) {
		this.qt_hint = qt_hint;
	}
	public String getQt_img() {
		return qt_img;
	}
	public void setQt_img(String qt_img) {
		this.qt_img = qt_img;
	}
	public String getQt_delDate() {
		return qt_delDate;
	}
	public void setQt_delDate(String qt_delDate) {
		this.qt_delDate = qt_delDate;
	}
	@Override
	public String toString() {
		return "QuizTypingDTO [qt_no=" + qt_no + ", member_m_no=" + member_m_no + ", member_m_id=" + member_m_id
				+ ", member_m_nick=" + member_m_nick + ", qt_question=" + qt_question + ", qt_answer=" + qt_answer
				+ ", qt_answerView=" + qt_answerView + ", qt_makeType=" + qt_makeType + ", qt_quizType=" + qt_quizType
				+ ", qt_regDate=" + qt_regDate + ", qt_winCnt=" + qt_winCnt + ", qt_loseCnt=" + qt_loseCnt
				+ ", qt_hint=" + qt_hint + ", qt_img=" + qt_img + ", qt_delDate=" + qt_delDate + "]";
	}
	
	

}
