package kr.co.qplay.quiztyping;

import java.util.List;

public interface QuizTypingService {
	
	
	public QuizTypingDTO selectRand(String qt_makeType);
	
	public QuizTypingDTO selectOne(QuizTypingDTO qtDTO);
	
	public QuizTypingDTO selectNo(int qt_no);
			
	public List<QuizTypingDTO> listAll();
	
	public List<QuizTypingDTO> listPart(int member_m_no);
	
	public int countAll();
	
	public int winCnt(int qt_no);
	
	public int loseCnt(int qt_no);
	
	public int insert(QuizTypingDTO qtDTO);
	
	public int delete(int qt_no);
	

}
