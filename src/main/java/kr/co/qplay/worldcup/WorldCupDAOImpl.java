package kr.co.qplay.worldcup;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class WorldCupDAOImpl implements WorldCupDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final static String namespace = "kr.co.qplay.worldcup.";
	
	@Override
	public List<wChoiceDTO> selectAll(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"selectAll",w_no);
	}

	@Override
	public List<WorldCupDTO> selectWC() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"selectWC");
	}

	@Override
	public String selectTitle(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"selectTitle",w_no);
	}
	
	@Override
	public int selectWno(String w_title) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"selectWno",w_title);
	}
	//조회수 증가
	@Override 
	public int upViewCnt(int w_no) { 
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"upViewCnt",w_no);
	}

	@Override
	public int upEndCnt(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"upEndCnt",w_no);
	}

	@Override
	public int upChoiceCnt(String wc_contents) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"upChoiceCnt",wc_contents);
	}

	@Override
	public int upFinalCnt(String wc_contents) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"upFinalCnt",wc_contents);
	}

	@Override
	public int insertWC(WorldCupDTO wDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"insertWC",wDTO);
	}

	@Override
	public int insertChoice(wChoiceDTO cDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"insertChoice",cDTO);
	}

	@Override
	public int delWC(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"delWC",w_no);
	}

	@Override
	public int delChoice(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"delChoice",w_no);
	}

	

}
