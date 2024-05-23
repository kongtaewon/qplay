package kr.co.qplay.quizmultiple;

import java.util.List;
import java.util.Map;

public interface QuizMultipleDAO {
	
//	public Map login(Map<String, Object> map);
	
	public List<QuizMultipleDTO> list();
	public QuizMultipleDTO selectOne(int qm_no);
	public List<QuizMultipleDTO> joinselect(int qm_no);
	public int quizinsert (QuizMultipleDTO qmdto);
	public QuizMultipleDTO idselect(String member_m_nick);
	public int wincount (int qm_no);
	public int losecount (int qm_no);
	public int count(String qm_makeType);
	
	public List<QuizMultipleChoiceDTO> listAll(int quiz_multiple_qm_no);
	public List<QuizMultipleChoiceDTO> one(int quiz_multiple_qm_no);
	public int choiceinsert (QuizMultipleChoiceDTO qmcdto);
	public int pick(String qmc_contents);
	
	
	
}
