package kr.co.qplay.boardfree;

import java.util.List;
import java.util.Map;



public interface BoardFreeService {
//	로그인(임시)
	public Map login(Map<String, Object> map);	
	
//	 게시판 전체 조회
	public List<BoardFreeDTO> listAll();
	
//	닉네임 가져오기
	public String nick(String moMember);

//	글 읽기, no ->게시물 번호
	public BoardFreeDTO selectOne(int bf_no);
	
//	글 작성
	public int insert(BoardFreeDTO dto);
	
//	글 수정
	public int update(BoardFreeDTO dto);
	
//	조회수 증가, no ->게시물 번호
	public int viewCnt(int no);
	
//	글 삭제, no ->게시물 번호
	public int delete(int no);
	
//	댓글 쓰기
	public int reply(BoardFreeReplyDTO replydto);
	
//	게시물번호에 해당하는 댓글 조회
	public List<BoardFreeReplyDTO> getDetai1(int bfr_no);
	
//	댓글 수정 보기(수정폼)
	public BoardFreeReplyDTO DetailReply(int bfr_no);
	
//	댓글 수정
	public int replyupdate(BoardFreeReplyDTO replydto);
	
//	댓글 삭제
	public int replyDelete(int bfr_no);
	
//	페이징 처리
	public List<BoardFreeDTO> listCriteria(Criteria cri)throws Exception;
	
//	페이징
	public List<BoardFreeDTO> listPage(int page)throws Exception;
	
//	페이징 수정부분
	public int listCountCriteria(Criteria cri)throws Exception;
	
//	검색
	public List<BoardFreeDTO> listSearchCriteria(SearchCriteria cri)throws Exception;
	
//	검색
	public int listSearchCount(SearchCriteria cri)throws Exception;
	
//	추천
	public void updateLike(int no);
	
//	추천 취소
	public void updateLikeCancel(int no);
	
//	게시글 추천 시 Like 테이블에 insert
	public void insertLike(int no, String  member_m_nick);
	
//	게시글 추천취소 시 delete
	public void deleteLike(int no, String  member_m_nick);
	
//	게시글 추천 중복방지
	public int likeCheck(int no, String  member_m_nick);
	
//	게시글 추천 시 Check를 1로 만들어서 중복방지
	public void updateLikeCheck(int no, String  member_m_nick);
	
//	게시글 추천취소 시 다시 0
	public void updateLikeCheckCancel(int no, String  member_m_nick);
	
//	비추천
	public void downlike(int no);
	
//	비추천 취소
	public void downlikeCancel(int no);
	
//	게시글 싫어요 board_down 테이블에 insert
	public void insertdown(int no, String  member_m_nick);
	
//	게시글 싫어요 취소 시 delete
	public void deletedown(int no, String  member_m_nick);
	
//	게시글 싫어요 중복방지
	public int downCheck(int no, String  member_m_nick);
	
//	게시글 싫어요 시 Check를 1로 만들어서 중복방지
	public void downLikeCheck(int no, String  member_m_nick);
	
//	게시글 싫어요 취소 시 다시 0
	public void downLikeCheckCancel(int no, String  member_m_nick);

	


}
