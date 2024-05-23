package kr.co.qplay.worldcup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorldCupController {

	@Autowired
	private WorldCupService wService;

	@GetMapping(value = "/worldcup/wMain")
	public String wMain(Model model) {
		List<WorldCupDTO> wList = wService.selectWC();
		model.addAttribute("wList",wList);
		return "worldcup/wMain";
	}

	@GetMapping(value = "/worldcup/choice")
	public String choice(Model model, int w_no, int round) {
		//월드컵 제목 자동반영
		model.addAttribute("wTitle",wService.selectTitle(w_no));		
		if(round==1) { // 마지막 선택지를 선택하면
			wService.upEndCnt(w_no); //완료횟수 증가
			wService.upFinalCnt(wService.getRound(round).get(0)); // 우승횟수증가
			model.addAttribute("win",wService.getRound(round).get(0));
			return"worldcup/choiceWinner";
		}
		if(round==8) { // 처음시작
			wService.cleanList(); // 처음시작시 기존리스트들 초기화
			wService.createRound(wService.selectAll(w_no));	
			wService.upViewCnt(w_no); // 조회수증가
		}
		List<String> rList = wService.getRound(round);
		int[] ran = wService.random(round);
		model.addAttribute("w_no", w_no);
		model.addAttribute("round", round);
		model.addAttribute("exam1", rList.get(ran[0]));
		model.addAttribute("exam2", rList.get(ran[1]));
		
		return "worldcup/choice";
	}

	@PostMapping(value = "/worldcup/choice")
	public String choice(@RequestParam("win") String win, @RequestParam("lose") String lose, Model model, int w_no,
			int round) {
		//월드컵 제목 자동반영
		model.addAttribute("wTitle",wService.selectTitle(w_no));
		wService.upChoiceCnt(win); // 선택횟수증가
		wService.deleteRound(win, lose, round); // 선택한 선택지 삭제
		wService.insertRound(win, round/2); // 선택한 선택지 추가	
		if(wService.getRound(round).size()==0) {
			return "redirect:choice?w_no="+w_no+"&round="+round/2;
		}		
		List<String> rList = wService.getRound(round);
		int[] ran = wService.random(round);
		model.addAttribute("w_no", w_no);
		model.addAttribute("round", round);
		model.addAttribute("exam1", rList.get(ran[0]));
		model.addAttribute("exam2", rList.get(ran[1]));

		return "worldcup/choice";
	}

	@GetMapping(value = "/worldcup/wAdd") // 월드컵추가
	public String wAdd() {
		
		return "worldcup/wAdd";
	}
	
	@PostMapping(value="/worldcup/wAdd")
	public String wAdd(WorldCupDTO wDTO) throws UnsupportedEncodingException {
		wService.insertWC(wDTO);
		String encodedParam = URLEncoder.encode(wDTO.getW_title(), "UTF-8"); // 리다이렉트시 한글인코딩
		
		return "redirect:cAdd?w_title="+encodedParam;
	}
	
	@GetMapping(value= "/worldcup/cAdd") // 선택지추가
	public String cAdd(WorldCupDTO wDTO, Model model) {
		model.addAttribute("w_no",wService.selectWno(wDTO.getW_title()));
		return "worldcup/cAdd";	
	}
	
	@PostMapping(value= "/worldcup/cAdd")
	public String cAdd(int w_no, HttpServletRequest wc_contents) {
		String[] contents = wc_contents.getParameterValues("wc_contents");
		for(int i=0; i<contents.length; i++) {
			wChoiceDTO wDTO = new wChoiceDTO(w_no,contents[i]);
			wService.insertChoice(wDTO);
		}
		return "redirect:wMain";
	}
	
	@GetMapping(value = "/worldcup/wDel")
	public String wDel(Model model) {
		List<WorldCupDTO> wList = wService.selectWC();
		model.addAttribute("wList",wList);
		
		return "worldcup/wDel";
	}
	
	@PostMapping(value = "/worldcup/wDel")
	public String wDel(int w_no) {	
		System.out.println("번호는 : "+w_no);
		wService.delWC(w_no);
		wService.delChoice(w_no);
		return "redirect:wMain";
	}
}
