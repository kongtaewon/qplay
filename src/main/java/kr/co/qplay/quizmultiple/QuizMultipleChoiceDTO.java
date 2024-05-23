package kr.co.qplay.quizmultiple;

/*
qmc_no int AI PK 
quiz_multiple_qm_no int 
qmc_contents varchar(45) 
qmc_choiceCnt int 
qmc_img varchar(45)
 */

public class QuizMultipleChoiceDTO {

	private int qmc_no; // 객관식 선택지 번호
	private int quiz_multiple_qm_no; // 객관식 번호
	private String qmc_contents; // 객관식 선택지 내용
	private int qmc_choiceCnt; // 선택지 선택 횟수
	private String qmc_img; // 선택지 이미지
	
	public QuizMultipleChoiceDTO(int quiz_multiple_qm_no, String qmc_contents) {
		super();
		this.quiz_multiple_qm_no = quiz_multiple_qm_no;
		this.qmc_contents = qmc_contents;
	}

	public int getQmc_no() {
		return qmc_no;
	}

	public void setQmc_no(int qmc_no) {
		this.qmc_no = qmc_no;
	}

	public int getQuiz_multiple_qm_no() {
		return quiz_multiple_qm_no;
	}

	public void setQuiz_multiple_qm_no(int quiz_multiple_qm_no) {
		this.quiz_multiple_qm_no = quiz_multiple_qm_no;
	}

	public String getQmc_contents() {
		return qmc_contents;
	}

	public void setQmc_contents(String qmc_contents) {
		this.qmc_contents = qmc_contents;
	}

	public int getQmc_choiceCnt() {
		return qmc_choiceCnt;
	}

	public void setQmc_choiceCnt(int qmc_choiceCnt) {
		this.qmc_choiceCnt = qmc_choiceCnt;
	}

	public String getQmc_img() {
		return qmc_img;
	}

	public void setQmc_img(String qmc_img) {
		this.qmc_img = qmc_img;
	}

	@Override
	public String toString() {
		return "QuizMultipleChoiceDTO [qmc_no=" + qmc_no + ", quiz_multiple_qm_no=" + quiz_multiple_qm_no
				+ ", qmc_contents=" + qmc_contents + ", qmc_choiceCnt=" + qmc_choiceCnt + ", qmc_img=" + qmc_img + "]";
	}

}
