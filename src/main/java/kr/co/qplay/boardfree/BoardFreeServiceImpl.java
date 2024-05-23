package kr.co.qplay.boardfree;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFreeServiceImpl implements BoardFreeService {

	@Autowired
	private BoardFreeDAO dao;
	
//	로그인(임시)
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.login(map);
	}

//	게시판 전체 조회
	@Override
	public List<BoardFreeDTO> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}
	
//	글 읽기, no ->게시물 번호
	@Override
	public BoardFreeDTO selectOne(int bf_no) {
		// TODO Auto-generated method stub
		return dao.selectOne(bf_no);
	}

//	글 작성
	@Override
	public int insert(BoardFreeDTO dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

//	글 수정
	@Override
	public int update(BoardFreeDTO dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

//	조회수 증가
	@Override
	public int viewCnt(int no) {
		// TODO Auto-generated method stub
		return dao.viewCnt(no);
	}
//  글 삭제
	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

//	댓글 쓰기
	@Override
	public int reply(BoardFreeReplyDTO replydto) {
		// TODO Auto-generated method stub
		return dao.reply(replydto);
	}
//	게시물번호에 해당하는 댓글 조회
	@Override
	public List<BoardFreeReplyDTO> getDetai1(int bfr_no) {
		// TODO Auto-generated method stub
		return dao.getDetai1(bfr_no);
	}

//	닉네임가져오기
	@Override
	public String nick(String nick) {
		// TODO Auto-generated method stub
		return dao.nick(nick);
	}

//	댓글 수정 보기(수정폼)
	@Override
	public BoardFreeReplyDTO DetailReply(int bfr_no) {
		// TODO Auto-generated method stub
		return dao.DetailReply(bfr_no);
	}

//	댓글 수정
	public int replyupdate(BoardFreeReplyDTO replydto) {
		// TODO Auto-generated method stub
		return dao.replyupdate(replydto);
	}

//	댓글 삭제
	@Override
	public int replyDelete(int bfr_no) {
		// TODO Auto-generated method stub
		return dao.replyDelete(bfr_no);
	}

//	페이징
	@Override
	public List<BoardFreeDTO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

//	페이징
	@Override
	public List<BoardFreeDTO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

//	페이징
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

//	검색
	@Override
	public List<BoardFreeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

//	검색
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}

//	추천
	@Override
	public void updateLike(int no) {
		// TODO Auto-generated method stub
		dao.updateLike(no);
		
	}
	
//	추천 취소
	@Override
	public void updateLikeCancel(int no) {
		// TODO Auto-generated method stub
		dao.updateLikeCancel(no);
		
	}

//	게시글 추천 시 Like 테이블에 insert
	@Override
	public void insertLike(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.insertLike(no, member_m_nick);
	}

//	게시글 추천취소 시 delete
	@Override
	public void deleteLike(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.deleteLike(no, member_m_nick);
	}

//	게시글 추천 중복방지
	@Override
	public int likeCheck(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		return dao.likeCheck(no, member_m_nick);
	}

//	게시글 추천 시 Check를 1로 만들어서 중복방지
	@Override
	public void updateLikeCheck(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.updateLikeCheck(no, member_m_nick);
	}

//	게시글 추천취소 시 다시 0
	@Override
	public void updateLikeCheckCancel(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.updateLikeCheckCancel(no, member_m_nick);
		
	}

//	비추천
	@Override
	public void downlike(int no) {
		// TODO Auto-generated method stub
		dao.downlike(no);
		
	}

//	비추천 취소
	@Override
	public void downlikeCancel(int no) {
		// TODO Auto-generated method stub
		dao.downlikeCancel(no);
	}

//	게시글 싫어요 board_down 테이블에 insert
	@Override
	public void insertdown(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.insertdown(no, member_m_nick);
		
	}

//	게시글 싫어요 취소 시 delete
	@Override
	public void deletedown(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.deletedown(no, member_m_nick);
		
	}

//	게시글 싫어요 중복방지
	@Override
	public int downCheck(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		return dao.downCheck(no, member_m_nick);
	}

//	게시글 싫어요 시 Check를 1로 만들어서 중복방지
	@Override
	public void downLikeCheck(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.downLikeCheck(no, member_m_nick);
	}

//	게시글 싫어요 취소 시 다시 0
	@Override
	public void downLikeCheckCancel(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		dao.downLikeCheckCancel(no, member_m_nick);
	}






	
	

}
