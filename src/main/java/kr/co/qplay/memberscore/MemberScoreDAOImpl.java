package kr.co.qplay.memberscore;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberScoreDAOImpl implements MemberScoreDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int winCnt(int member_m_no) {
		return sqlSession.update("kr.co.qplay.memberScoreMapper.winCnt", member_m_no);
	}

	@Override
	public int loseCnt(int member_m_no) {
		return sqlSession.update("kr.co.qplay.memberScoreMapper.loseCnt", member_m_no);
	}

	@Override
	public int makeCntUp(int member_m_no) {
		return sqlSession.update("kr.co.qplay.memberScoreMapper.makeCntUp", member_m_no);
	}

	@Override
	public int makeCntDown(int member_m_no) {
		return sqlSession.update("kr.co.qplay.memberScoreMapper.makeCntDown", member_m_no);
	}

	@Override
	public int signup(MemberScoreDTO msDTO) {
		return sqlSession.insert("kr.co.qplay.memberScoreMapper.signup", msDTO);
	}

	@Override
	public int delete(int member_m_no) {
		return sqlSession.update("kr.co.qplay.memberScoreMapper.delete", member_m_no);
	}

	@Override
	public MemberScoreDTO detail(int m_no) {
		return sqlSession.selectOne("kr.co.qplay.memberScoreMapper.detail", m_no);
	}
	
	

}
