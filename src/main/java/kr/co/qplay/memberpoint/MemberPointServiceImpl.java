package kr.co.qplay.memberpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberPointServiceImpl implements MemberPointService {
	
	@Autowired
	private MemberPointDAO dao;

	@Override
	public int update(int member_m_no) {
		System.out.println(member_m_no);
		return dao.update(member_m_no);
	}

	@Override
	public List<MemberPointDTO> list(int member_m_no) {
		return dao.list(member_m_no);
	}

	@Override
	public int pointup(int member_m_no) {
		return dao.pointup(member_m_no);
	}

	@Override
	public int decrease(int member_m_no) {
		return dao.decrease(member_m_no);
	}
	
	
}
