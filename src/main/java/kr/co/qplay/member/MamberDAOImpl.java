package kr.co.qplay.member;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MamberDAOImpl implements MemberDAO{
	
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public Map login(Map<String, Object> map) {
		return sqlsession.selectOne("kr.co.qplay.memberMapper.login", map);
	}

	@Override
	public int signup(MemberDTO mDTO) {
		return sqlsession.insert("kr.co.qplay.memberMapper.signup", mDTO);
	}

	@Override
	public int delete(int m_no) {
		return sqlsession.update("kr.co.qplay.memberMapper.delete", m_no);
	}

	@Override
	public int mno(String member_m_id) {
		return sqlsession.selectOne("kr.co.qplay.memberMapper.mno", member_m_id);
	}

	@Override
	public int chgnick(MemberDTO mDTO) {
		return sqlsession.update("kr.co.qplay.memberMapper.chgnick", mDTO);
	}

	@Override
	public boolean nickcheck(MemberDTO mDTO) {
		return sqlsession.selectOne("kr.co.qplay.memberMapper.nickcheck", mDTO);
		
	}

	@Override
	public boolean idcheck(MemberDTO mDTO) {
		return sqlsession.selectOne("kr.co.qplay.memberMapper.idcheck", mDTO);
	}
	
	
	
	
	

	

}
