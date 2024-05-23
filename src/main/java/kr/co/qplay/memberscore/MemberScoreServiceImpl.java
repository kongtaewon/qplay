package kr.co.qplay.memberscore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberScoreServiceImpl implements MemberScoreService{

	@Autowired
	private MemberScoreDAO dao;
	
	@Override
	public int winCnt(int member_m_no) {
		return dao.winCnt(member_m_no);
	}

	@Override
	public int loseCnt(int member_m_no) {
		return dao.loseCnt(member_m_no);
	}

	@Override
	public int makeCntUp(int member_m_no) {
		return dao.makeCntUp(member_m_no);
	}

	@Override
	public int makeCntDown(int member_m_no) {
		return dao.makeCntDown(member_m_no);
	}

	@Override
	public int signup(MemberScoreDTO msDTO) {
		return dao.signup(msDTO);
	}

	@Override
	public int delete(int member_m_no) {
		return dao.delete(member_m_no);
	}

	@Override
	public MemberScoreDTO detail(int m_no) {
		return dao.detail(m_no);
	}
	
	

}
