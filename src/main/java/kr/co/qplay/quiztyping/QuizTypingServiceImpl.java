package kr.co.qplay.quiztyping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizTypingServiceImpl implements QuizTypingService{
	
	@Autowired
	private QuizTypingDAO dao;

	@Override
	public QuizTypingDTO selectRand(String qt_makeType) {
		return dao.selectRand(qt_makeType);
	}
	
	@Override
	public QuizTypingDTO selectOne(QuizTypingDTO qtDTO) {
		return dao.selectOne(qtDTO);
	}

	@Override
	public List<QuizTypingDTO> listAll() {
		return dao.listAll();
	}

	@Override
	public List<QuizTypingDTO> listPart(int member_m_no) {
		return dao.listPart(member_m_no);
	}

	@Override
	public int countAll() {
		return dao.countAll();
	}
	
	@Override
	public int winCnt(int qt_no) {
		return dao.winCnt(qt_no);
	}

	@Override
	public int loseCnt(int qt_no) {
		return dao.loseCnt(qt_no);
	}

	@Override
	public int insert(QuizTypingDTO qtDTO) {
		return dao.insert(qtDTO);
	}

	@Override
	public int delete(int qt_no) {
		return dao.delete(qt_no);
	}

	@Override
	public QuizTypingDTO selectNo(int qt_no) {
		return dao.selectNo(qt_no);
	}


	
	

}
