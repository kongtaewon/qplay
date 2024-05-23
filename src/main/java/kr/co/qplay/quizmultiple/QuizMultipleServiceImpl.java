package kr.co.qplay.quizmultiple;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizMultipleServiceImpl implements QuizMultipleService {
	
	@Autowired
	private QuizMultipleDAO dao;

	@Override
	public QuizMultipleDTO idselect(String member_m_nick) {
		return dao.idselect(member_m_nick);
	}
	
//	@Override
//	public Map login(Map<String, Object> map) {
//		return dao.login(map);
//	}
	
	@Override
	public int count(String qm_makeType) {
		return dao.count(qm_makeType);
	}
	
	@Override
	public List<QuizMultipleDTO> list() {
		return dao.list();
	}

	@Override
	public QuizMultipleDTO selectOne(int qm_no) {
		return dao.selectOne(qm_no);
	}
	
	@Override
	public int wincount(int qm_no) {
		return dao.wincount(qm_no);
	}
	
	@Override
	public int losecount(int qm_no) {
		return dao.losecount(qm_no);
	}
	
	@Override
	public List<QuizMultipleDTO> joinselect(int qm_no) {
		return dao.joinselect(qm_no);
	}
	
	
	
	
	@Override
	public int quizinsert(QuizMultipleDTO qmdto) {
		// TODO Auto-generated method stub
		return dao.quizinsert(qmdto);
	}

	@Override
	public int choiceinsert(QuizMultipleChoiceDTO qmcdto) {
		// TODO Auto-generated method stub
		return dao.choiceinsert(qmcdto);
	}
	
	
	
	

	@Override
	public List<QuizMultipleChoiceDTO> listAll(int quiz_multiple_qm_no) {
		return dao.listAll(quiz_multiple_qm_no);
	}
	
	@Override
	public List<QuizMultipleChoiceDTO> one(int quiz_multiple_qm_no) {
		return dao.one(quiz_multiple_qm_no);
	}

	@Override
	public int pick(String qmc_contents) {
		return dao.pick(qmc_contents);
	}










	
	

}
