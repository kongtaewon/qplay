package kr.co.qplay.worldcup;

public class wChoiceDTO {

	private int wc_no;
	private int w_no;
	private String wc_contents;
	private int	wc_choiceCnt;
	private int	wc_finalCnt;
	private String wc_img;
	
	public wChoiceDTO() {
		
	}
	
	public wChoiceDTO(int wc_no, int w_no, String wc_contents, int wc_choiceCnt, int wc_finalCnt,
			String wc_img) {
		super();
		this.wc_no = wc_no;
		this.w_no = w_no;
		this.wc_contents = wc_contents;
		this.wc_choiceCnt = wc_choiceCnt;
		this.wc_finalCnt = wc_finalCnt;
		this.wc_img = wc_img;
	}
	
	

	public wChoiceDTO(int w_no, String wc_contents) {
		super();
		this.w_no = w_no;
		this.wc_contents = wc_contents;
	}

	public int getWc_no() {
		return wc_no;
	}

	public void setWc_no(int wc_no) {
		this.wc_no = wc_no;
	}

	public int getW_no() {
		return w_no;
	}

	public void setW_no(int w_no) {
		this.w_no = w_no;
	}

	public String getWc_contents() {
		return wc_contents;
	}

	public void setWc_contents(String wc_contents) {
		this.wc_contents = wc_contents;
	}

	public int getWc_choiceCnt() {
		return wc_choiceCnt;
	}

	public void setWc_choiceCnt(int wc_choiceCnt) {
		this.wc_choiceCnt = wc_choiceCnt;
	}

	public int getWc_finalCnt() {
		return wc_finalCnt;
	}

	public void setWc_finalCnt(int wc_finalCnt) {
		this.wc_finalCnt = wc_finalCnt;
	}

	public String getWc_img() {
		return wc_img;
	}

	public void setWc_img(String wc_img) {
		this.wc_img = wc_img;
	}

	@Override
	public String toString() {
		return "WorldCupChoiceDTO [wc_no=" + wc_no + ", w_no=" + w_no + ", wc_contents=" + wc_contents
				+ ", wc_choiceCnt=" + wc_choiceCnt + ", wc_finalCnt=" + wc_finalCnt + ", wc_img=" + wc_img + "]";
	}
	
	
}
