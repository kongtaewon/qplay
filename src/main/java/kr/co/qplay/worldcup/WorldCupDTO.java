package kr.co.qplay.worldcup;

public class WorldCupDTO {
	
	private int w_no;
	private String w_title;
	private String w_contents;
	private int w_round;
	private int w_viewCnt;
	private int w_endCnt;
	private String w_regDate;
	private String w_delDate;
	
	public WorldCupDTO() {
		
	};
	
	public WorldCupDTO(int w_no, String w_title, String w_contents,int w_round, int w_viewCnt, int w_endCnt, String w_regDate,
			String w_delDate) {
		super();
		this.w_no = w_no;
		this.w_title = w_title;
		this.w_contents = w_contents;
		this.w_round = w_round;
		this.w_viewCnt = w_viewCnt;
		this.w_endCnt = w_endCnt;
		this.w_regDate = w_regDate;
		this.w_delDate = w_delDate;
	}

	public int getW_no() {
		return w_no;
	}

	public void setW_no(int w_no) {
		this.w_no = w_no;
	}

	public String getW_title() {
		return w_title;
	}

	public void setW_title(String w_title) {
		this.w_title = w_title;
	}

	public String getW_contents() {
		return w_contents;
	}

	public void setW_contents(String w_contents) {
		this.w_contents = w_contents;
	}
	
	public int getW_round() {
		return w_round;
	}

	public void setW_round(int w_round) {
		this.w_round = w_round;
	}

	public int getW_viewCnt() {
		return w_viewCnt;
	}

	public void setW_viewCnt(int w_viewCnt) {
		this.w_viewCnt = w_viewCnt;
	}

	public int getW_endCnt() {
		return w_endCnt;
	}

	public void setW_endCnt(int w_endCnt) {
		this.w_endCnt = w_endCnt;
	}

	public String getW_regDate() {
		return w_regDate;
	}

	public void setW_regDate(String w_regDate) {
		this.w_regDate = w_regDate;
	}

	public String getW_delDate() {
		return w_delDate;
	}

	public void setW_delDate(String w_delDate) {
		this.w_delDate = w_delDate;
	}

	
	@Override
	public String toString() {
		return "WorldcupDTO [w_no=" + w_no + ", w_title=" + w_title + ", w_contents=" + w_contents + ", w_viewCnt="
				+ w_viewCnt + ", w_endCnt=" + w_endCnt + ", w_regDate=" + w_regDate + ", w_delDate=" + w_delDate + "]";
	}
	
	
	
	
	
}
