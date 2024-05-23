package kr.co.qplay.quizmultiple;

import org.springframework.web.multipart.MultipartFile;

/*
qm_no int AI PK 
member_m_no int 
member_m_id varchar(45) 
member_m_nick varchar(45) 
qm_question varchar(45) 
qm_answer int 
qm_makeType varchar(45) 
qm_quizType varchar(45) 
qm_regDate datetime 
qm_winCnt int 
qm_loseCnt int 
qm_hint varchar(45) 
qm_img varchar(45) 
qm_delDate datetime
 */
public class QuizMultipleDTO {

	private int qm_no; // 객관식 번호
	private int member_m_no; // 회원 번호
	private String member_m_id; // 회원 아이디
	private String member_m_nick; // 회원 닉네임
	private String qm_question; // 객관식 문제
	private String qm_answer; // 객관식 답
	private String qm_makeType; // 객관식 만든사람 타입 / member/ admin
	private String qm_quizType; // 객관식 문제 유형 / 속담
	private String qm_regDate; // 객관식 생성일
	private int qm_winCnt; // 객관식 성공횟수
	private int qm_loseCnt; // 객관식 실패 횟수
	private String qm_hint; // 객관식 힌트
	private String qm_img; // 이미지
	private String qm_delDate; // 삭제일
	
	public QuizMultipleDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public QuizMultipleDTO(int member_m_no, String member_m_id, String member_m_nick, String qm_question,
			String qm_answer, String qm_makeType, String qm_quizType, String qm_hint, String qm_img) {
		super();
		this.member_m_no = member_m_no;
		this.member_m_id = member_m_id;
		this.member_m_nick = member_m_nick;
		this.qm_question = qm_question;
		this.qm_answer = qm_answer;
		this.qm_makeType = qm_makeType;
		this.qm_quizType = qm_quizType;
		this.qm_hint = qm_hint;
		this.qm_img = qm_img;
	}
	
	public QuizMultipleDTO(int member_m_no, String member_m_id, String member_m_nick, String qm_question,
			String qm_answer, String qm_makeType, String qm_quizType, String qm_hint) {
		super();
		this.member_m_no = member_m_no;
		this.member_m_id = member_m_id;
		this.member_m_nick = member_m_nick;
		this.qm_question = qm_question;
		this.qm_answer = qm_answer;
		this.qm_makeType = qm_makeType;
		this.qm_quizType = qm_quizType;
		this.qm_hint = qm_hint;
	}

	public int getQm_no() {
		return qm_no;
	}

	public void setQm_no(int qm_no) {
		this.qm_no = qm_no;
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

	public String getQm_question() {
		return qm_question;
	}

	public void setQm_question(String qm_question) {
		this.qm_question = qm_question;
	}

	public String getQm_answer() {
		return qm_answer;
	}

	public void setQm_answer(String qm_answer) {
		this.qm_answer = qm_answer;
	}

	public String getQm_makeType() {
		return qm_makeType;
	}

	public void setQm_makeType(String qm_makeType) {
		this.qm_makeType = qm_makeType;
	}

	public String getQm_quizType() {
		return qm_quizType;
	}

	public void setQm_quizType(String qm_quizType) {
		this.qm_quizType = qm_quizType;
	}

	public String getQm_regDate() {
		return qm_regDate;
	}

	public void setQm_regDate(String qm_regDate) {
		this.qm_regDate = qm_regDate;
	}

	public int getQm_winCnt() {
		return qm_winCnt;
	}

	public void setQm_winCnt(int qm_winCnt) {
		this.qm_winCnt = qm_winCnt;
	}

	public int getQm_loseCnt() {
		return qm_loseCnt;
	}

	public void setQm_loseCnt(int qm_loseCnt) {
		this.qm_loseCnt = qm_loseCnt;
	}

	public String getQm_hint() {
		return qm_hint;
	}

	public void setQm_hint(String qm_hint) {
		this.qm_hint = qm_hint;
	}

	public String getQm_img() {
		return qm_img;
	}

	public void setQm_img(String qm_img) {
		this.qm_img = qm_img;
	}

	public String getQm_delDate() {
		return qm_delDate;
	}

	public void setQm_delDate(String qm_delDate) {
		this.qm_delDate = qm_delDate;
	}

	@Override
	public String toString() {
		return "QuizMultipleDTO [qm_no=" + qm_no + ", member_m_no=" + member_m_no + ", member_m_id=" + member_m_id
				+ ", member_m_nick=" + member_m_nick + ", qm_question=" + qm_question + ", qm_answer=" + qm_answer
				+ ", qm_makeType=" + qm_makeType + ", qm_quizType=" + qm_quizType + ", qm_regDate=" + qm_regDate
				+ ", qm_winCnt=" + qm_winCnt + ", qm_loseCnt=" + qm_loseCnt + ", qm_hint=" + qm_hint + ", qm_img="
				+ qm_img + ", qm_delDate=" + qm_delDate + "]";
	}

}
