package kr.co.qplay.worldcup;

import java.util.List;

public interface WorldCupService {
	
	public List<wChoiceDTO> selectAll(int w_no); // 선택지 전체
	public int[] random(int round); // 선택지 2개를 뽑기위한 랜덤숫자 생성
	public List<WorldCupDTO> selectWC(); // 월드컵리스트 가져오기
	public String selectTitle(int w_no); // 월드컵 제목 가져오기
	public int selectWno(String w_title); // 월드컵 번호 가져오기
	// 선택지 리스트 
	public void cleanList(); // 리스트 초기화
	public void createRound(List<wChoiceDTO> list); // 초기 리스트
	public void insertRound(String win, int round); // 선택지 리스트에 추가
	public void deleteRound(String win, String lose, int round); // 선택한 후보들 선택지에서 제외
	public List<String> getRound(int round); // 리스트 가져오기
	public int upViewCnt(int w_no);//조회수증가
	public int upEndCnt(int w_no); // 완료횟수증가
	public int upChoiceCnt(String wc_contents); // 선택횟수증가
	public int upFinalCnt(String wc_contents); // 우승횟수증가
	public int insertWC(WorldCupDTO wDTO); // 월드컵추가
	public int insertChoice(wChoiceDTO cDTO); // 신규월드컵 선택지추가
	public int delWC(int w_no); //월드컵삭제
	public int delChoice(int w_no); // 선택지삭제

}
