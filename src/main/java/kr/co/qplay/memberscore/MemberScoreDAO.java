package kr.co.qplay.memberscore;

public interface MemberScoreDAO {
	
	public MemberScoreDTO detail(int m_no);
	
	public int signup(MemberScoreDTO msDTO);
	
	public int delete(int member_m_no);
	
	public int winCnt(int member_m_no);
	
	public int loseCnt(int member_m_no);
	
	public int makeCntUp(int member_m_no);
	
	public int makeCntDown(int member_m_no);

}
