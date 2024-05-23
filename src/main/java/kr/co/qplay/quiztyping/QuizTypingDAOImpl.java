package kr.co.qplay.quiztyping;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuizTypingDAOImpl implements QuizTypingDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public QuizTypingDTO selectRand(String qt_makeType) {
		return sqlSession.selectOne("kr.co.qplay.quizTypingMapper.selectRand", qt_makeType);
	}
	
	@Override
	public QuizTypingDTO selectOne(QuizTypingDTO qtDTO) {
		return sqlSession.selectOne("kr.co.qplay.quizTypingMapper.selectOne", qtDTO);
	}

	@Override
	public List<QuizTypingDTO> listAll() {
		return sqlSession.selectList("kr.co.qplay.quizTypingMapper.listAll");
	}

	@Override
	public List<QuizTypingDTO> listPart(int member_m_no) {
		return sqlSession.selectList("kr.co.qplay.quizTypingMapper.listPart", member_m_no);
	}
	
	@Override
	public int countAll() {
		return sqlSession.selectOne("kr.co.qplay.quizTypingMapper.countAll");
	}

	@Override
	public int winCnt(int qt_no) {
		return sqlSession.update("kr.co.qplay.quizTypingMapper.winCnt", qt_no);
	}

	@Override
	public int loseCnt(int qt_no) {
		return sqlSession.update("kr.co.qplay.quizTypingMapper.loseCnt", qt_no);
		
	}

	@Override
	public int insert(QuizTypingDTO qtDTO) {
		return sqlSession.update("kr.co.qplay.quizTypingMapper.insert", qtDTO);
	}

	@Override
	public int delete(int qt_no) {
		return sqlSession.update("kr.co.qplay.quizTypingMapper.delete", qt_no);
	}

	@Override
	public QuizTypingDTO selectNo(int qt_no) {
		return sqlSession.selectOne("kr.co.qplay.quizTypingMapper.selectNo", qt_no);
	}

	
	

}
