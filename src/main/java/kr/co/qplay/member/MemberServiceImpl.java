package kr.co.qplay.member;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO dao;

	@Override
	public Map login(Map<String, Object> map){
		return dao.login(map);
	}

	@Override
	public int signup(MemberDTO mDTO) {
		return dao.signup(mDTO);
	}

	@Override
	public int delete(int m_no) {
		return dao.delete(m_no);
	}

	@Override
	public int mno(String member_m_id) {
		return dao.mno(member_m_id);
	}

	@Override
	public int chgnick(MemberDTO mDTO) {
		return dao.chgnick(mDTO);
	}

	@Override
	public boolean nickcheck(MemberDTO mDTO) {
		return dao.nickcheck(mDTO);
	}

	@Override
	public boolean idcheck(MemberDTO mDTO) {
		return dao.idcheck(mDTO);
	}
	
	
	

}
