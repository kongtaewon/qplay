package kr.co.qplay.quizmultiple;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuizMultipleDAOImpl implements QuizMultipleDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private static final String namespace = "kr.co.qplay.quizMultipleMapper";
	
	@Override
	public QuizMultipleDTO idselect(String member_m_nick) {
		return sqlsession.selectOne(namespace + ".idselect", member_m_nick);
	}
	
//	@Override
//	public Map login(Map<String, Object> map) {
//		return sqlsession.selectOne(namespace + ".login", map);
//	}
	
	// root, member 총 수
	@Override
	public int count(String qm_makeType) {
		return sqlsession.selectOne(namespace + ".cnt", qm_makeType);
	}
	
	// 전체 리스트
	@Override
	public List<QuizMultipleDTO> list() {
		return sqlsession.selectList(namespace + ".quiztypeselect");
	}
	
	// 게시물 번호로 전체 검색
	@Override
	public QuizMultipleDTO selectOne(int qm_no) {
		return sqlsession.selectOne(namespace + ".selectlist", qm_no);
	}
	
	
	// 맞춘 횟수
	@Override
	public int wincount(int qm_no) {
		return sqlsession.update(namespace + ".success", qm_no);
	}

	// 틀린 횟수
	@Override
	public int losecount(int qm_no) {
		return sqlsession.update(namespace + ".failure", qm_no);
	}
	
	
	
	@Override
	public int quizinsert(QuizMultipleDTO qmdto) {
		return sqlsession.insert(namespace + ".quizinsert", qmdto);
	}

	@Override
	public int choiceinsert(QuizMultipleChoiceDTO qmcdto) {
		return sqlsession.insert(namespace + ".choiceinsert", qmcdto);
	}
	
	// join
	@Override
	public List<QuizMultipleDTO> joinselect(int qm_no) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + ".pointresult", qm_no);
	}
	
	
	
	
	
	// 답 전체 검색
	@Override
	public List<QuizMultipleChoiceDTO> listAll(int quiz_multiple_qm_no) {
		return sqlsession.selectList(namespace + ".list", quiz_multiple_qm_no);
	}
	
	// 보기 전체 검색
	@Override
	public List<QuizMultipleChoiceDTO> one(int quiz_multiple_qm_no) {
		return sqlsession.selectList(namespace + ".listone", quiz_multiple_qm_no);
	}
	
	@Override
	public int pick(String qmc_contents) {
		return sqlsession.update(namespace + ".pick", qmc_contents);
	}













}
