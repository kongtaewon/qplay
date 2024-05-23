package kr.co.qplay.memberpoint;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberPointDAOImpl implements MemberPointDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	private static final String namespace = "kr.co.qplay.memberPointMapper";

	@Override
	public int update(int member_m_no) {
		System.out.println(member_m_no);
		return sqlsession.update(namespace + ".pointpay", member_m_no);
	}

	@Override
	public List<MemberPointDTO> list(int member_m_no) {
		return sqlsession.selectList(namespace + ".list", member_m_no);
	}

	@Override
	public int pointup(int member_m_no) {
		return sqlsession.update(namespace + ".point", member_m_no);
	}

	@Override
	public int decrease(int member_m_no) {
		return sqlsession.update(namespace + ".decrease", member_m_no);
	}

	

	
	
	
}
