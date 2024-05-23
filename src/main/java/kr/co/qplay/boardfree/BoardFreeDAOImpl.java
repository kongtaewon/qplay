package kr.co.qplay.boardfree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFreeDAOImpl implements BoardFreeDAO {
	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "kr.co.qplay.boardfreeMapper.";

//	로그인(임시)
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "login", map);
	}

//	게시판 전체 조회
	@Override
	public List<BoardFreeDTO> listAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "listAll");
	}

// 	글 읽기, no ->게시물 번호
	@Override
	public BoardFreeDTO selectOne(int bf_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectOne", bf_no);
	}

//	글 작성
	@Override
	public int insert(BoardFreeDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "insert", dto);
	}

//	글 수정
	@Override
	public int update(BoardFreeDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "update", dto);
	}

//	조회수 증가
	@Override
	public int viewCnt(int no) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "viewCnt", no);
	}

//	글 삭제
	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "delete", no);
	}

//	댓글 쓰기
	@Override
	public int reply(BoardFreeReplyDTO replydto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "reply", replydto);
	}

//	게시물번호에 해당하는 댓글 조회
	@Override
	public List<BoardFreeReplyDTO> getDetai1(int bfr_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "detail1", bfr_no);
	}

//	닉네임 가져오기
	@Override
	public String nick(String nick) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "nick", nick);
	}

//	댓글 수정 보기(수정폼)
	@Override
	public BoardFreeReplyDTO DetailReply(int bfr_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "DetailReply", bfr_no);
	}

//	댓글 수정
	@Override
	public int replyupdate(BoardFreeReplyDTO replydto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "replyupdate", replydto);
	}

//	댓글 삭제
	@Override
	public int replyDelete(int bfr_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "replyDelete", bfr_no);
	}

//	페이징
	@Override
	public List<BoardFreeDTO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub

		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return sqlSession.selectList(namespace + "listPage", page);
	}

//	페이징
	@Override
	public List<BoardFreeDTO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +"listCriteria",cri);
	}

//	페이징
	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"countPaging",cri);
	}

//	검색
	@Override
	public List<BoardFreeDTO> listSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "listSearch",cri);
	}

//	검색
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "listSearchCount", cri);
	}

//	추천
	@Override
	public void updateLike(int no) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + "updateLike",no);
		
	}
	
//	추천 취소
	@Override
	public void updateLikeCancel(int no) {
		sqlSession.update(namespace + "updateLikeCancel", no);
		
	}
//	게시글 추천 시 Like 테이블에 insert
	@Override
	public void insertLike(int no, String member_m_nick) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.insert(namespace + "insertLike", map);
	}
	
//	게시글 추천취소 시 delete
	@Override
	public void deleteLike(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.delete(namespace + "deleteLike", map);
		
	}
	
//	게시글 추천 중복방지
	@Override
	public int likeCheck(int no, String member_m_nick) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		
		return sqlSession.selectOne(namespace + "likeCheck", map);
	}
	
//	게시글 추천 시 Check를 1로 만들어서 중복방지
	@Override
	public void updateLikeCheck(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.update(namespace + "updateLikeCheck", map);
		
	}
	
//	게시글 추천취소 시 다시 0
	@Override
	public void updateLikeCheckCancel(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.update(namespace + "updateLikeCheckCancel", map);
		
	}

//	비추천
	@Override
	public void downlike(int no) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + "downlike", no);
		
	}

//	비추천 취소
	@Override
	public void downlikeCancel(int no) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + "downlikeCancel", no);
		
	}

//	게시글 싫어요 board_down 테이블에 insert
	@Override
	public void insertdown(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.insert(namespace + "insertdown", map);
	}

//	게시글 싫어요 취소 시 delete
	@Override
	public void deletedown(int no, String member_m_nick) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.delete(namespace + "deletedown", map);
	}

//	게시글 싫어요 중복방지
	@Override
	public int downCheck(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		return sqlSession.selectOne(namespace + "downCheck",map);
	}

//	게시글 싫어요 시 Check를 1로 만들어서 중복방지
	@Override
	public void downLikeCheck(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.update(namespace + "downLikeCheck", map);
		
	}

//	게시글 싫어요 취소 시 다시 0
	@Override
	public void downLikeCheckCancel(int no, String member_m_nick) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_m_nick", member_m_nick);
		map.put("no", no);
		sqlSession.update(namespace + "downLikeCheckCancel" ,map);
		
	}

}
