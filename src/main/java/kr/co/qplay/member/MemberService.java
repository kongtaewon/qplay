package kr.co.qplay.member;

import java.util.Map;

public interface MemberService {
	
	public Map login(Map<String, Object> map);
	
	public int signup(MemberDTO mDTO);
	
	public int delete(int m_no);
	
	public int mno(String member_m_id);
	
	public int chgnick(MemberDTO mDTO);
	
	public boolean nickcheck(MemberDTO mDTO);
	
	public boolean idcheck(MemberDTO mDTO);
	

}
