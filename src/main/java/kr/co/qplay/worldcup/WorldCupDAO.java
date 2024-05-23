package kr.co.qplay.worldcup;

import java.util.List;

public interface WorldCupDAO {
	
	public List<wChoiceDTO> selectAll(int w_no); // 월드컵선택지 가져오기
	public List<WorldCupDTO> selectWC(); // 월드컵정보가져오기
	public String selectTitle(int w_no); //월드컵제목 가져오기
	public int selectWno(String w_title); // 월드컵번호 가져오기
	public int upViewCnt(int w_no); // 조회수증가
	public int upEndCnt(int w_no); // 완료횟수증가
	public int upChoiceCnt(String wc_contents); // 선택횟수증가
	public int upFinalCnt(String wc_contents); // 우승횟수증가
	public int insertWC(WorldCupDTO wDTO); // 월드컵추가
	public int insertChoice(wChoiceDTO cDTO); // 신규월드컵 선택지추가
	public int delWC(int w_no); //월드컵삭제
	public int delChoice(int w_no); // 선택지삭제
}
