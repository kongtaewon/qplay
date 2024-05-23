package kr.co.qplay.worldcup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldCupServiceImpl implements WorldCupService {

	@Autowired
	private WorldCupDAO wDao;

	private List<String> round8 = new ArrayList<String>();
	private List<String> round4 = new ArrayList<String>();
	private List<String> round2 = new ArrayList<String>();
	private List<String> round1 = new ArrayList<String>();
	private HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();

	public void mapper() {
		map.put(8, round8);
		map.put(4, round4);
		map.put(2, round2);
		map.put(1, round1);
	}

	@Override
	public List<wChoiceDTO> selectAll(int w_no) {
		// TODO Auto-generated method stub
		return wDao.selectAll(w_no);
	}
	
	@Override
	public List<WorldCupDTO> selectWC() {
		// TODO Auto-generated method stub
		return wDao.selectWC();
	}
	
	@Override
	public String selectTitle(int w_no) {
		// TODO Auto-generated method stub
		return wDao.selectTitle(w_no);
	}
	
	@Override
	public int selectWno(String w_title) {
		// TODO Auto-generated method stub
		return wDao.selectWno(w_title);
	}

	@Override
	public int[] random(int round) {
		mapper();
		
		int ran[] = new int[2];
		ran[0] = (int) (Math.random() * map.get(round).size());
		System.out.println(ran[0]);
		for (int j = 0; j < 1; j++) {
			ran[1] = (int) (Math.random() * map.get(round).size());
			if (ran[0] == ran[1]) {
				j--;
			}		
		}
		return ran;
	}

	//선택지
	@Override
	public void cleanList() {
		round8.clear();
		round4.clear();
		round2.clear();
		round1.clear();
	}

	@Override
	public void createRound(List<wChoiceDTO> list) {
		for (int i = 0; i < list.size(); i++) {
			round8.add(list.get(i).getWc_contents());
		}
	}

	@Override
	public void insertRound(String win, int round) {
		mapper();

		map.get(round).add(win);
	}

	@Override
	public void deleteRound(String win, String lose, int round) {
		mapper();

		map.get(round).remove(win);
		map.get(round).remove(lose);
	}

	@Override
	public List<String> getRound(int round) {
		mapper();

		return map.get(round);
	}

	@Override
	public int upViewCnt(int w_no) {
		// TODO Auto-generated method stub
		return wDao.upViewCnt(w_no);
	}

	@Override
	public int upEndCnt(int w_no) {
		// TODO Auto-generated method stub
		return wDao.upEndCnt(w_no);
	}

	@Override
	public int upChoiceCnt(String wc_contents) {
		// TODO Auto-generated method stub
		return wDao.upChoiceCnt(wc_contents);
	}

	@Override
	public int upFinalCnt(String wc_contents) {
		// TODO Auto-generated method stub
		return wDao.upFinalCnt(wc_contents);
	}

	@Override
	public int insertWC(WorldCupDTO wDTO) {
		// TODO Auto-generated method stub
		return wDao.insertWC(wDTO);
	}

	@Override
	public int insertChoice(wChoiceDTO cDTO) {
		// TODO Auto-generated method stub
		return wDao.insertChoice(cDTO);
	}

	@Override
	public int delWC(int w_no) {
		// TODO Auto-generated method stub
		return wDao.delWC(w_no);
	}

	@Override
	public int delChoice(int w_no) {
		// TODO Auto-generated method stub
		return wDao.delChoice(w_no);
	}

	

	
}
