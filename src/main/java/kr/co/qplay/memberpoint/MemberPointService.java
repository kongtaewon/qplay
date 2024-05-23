package kr.co.qplay.memberpoint;

import java.util.List;

public interface MemberPointService {
	
	public int update(int member_m_no);
	public List<MemberPointDTO> list(int member_m_no);
	public int pointup(int member_m_no);
	public int decrease(int member_m_no);
	
}
