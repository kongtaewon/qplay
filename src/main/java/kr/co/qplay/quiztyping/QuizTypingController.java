package kr.co.qplay.quiztyping;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.qplay.member.MemberService;
import kr.co.qplay.memberscore.MemberScoreService;

@Controller
public class QuizTypingController {
	
	@Autowired
	private QuizTypingService qtSv;
	
	@Autowired
	private MemberScoreService msSv;
	
	@Autowired
	private MemberService mSv;
	
	@Autowired
	private ServletContext sc;
	
//	퀴즈 창작 선택 화면으로 이동 (주관식 or 객관식 선택창)
//	@GetMapping("/quizmake")
//	public ModelAndView quizMake() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("quizmake");
//		return mv;
//	}
	
//	주관식 퀴즈 창작 폼으로 이동
	@GetMapping("/qtmake")
	public ModelAndView qtMakeForm() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("quiztyping/qtmake");
		return mv;
	}
	
//	주관식 퀴즈 창작 처리
	@PostMapping("/qtmake")
	public ModelAndView qtMake(@ModelAttribute("qtDTO") QuizTypingDTO qtDTO,
								MultipartHttpServletRequest multi) throws Throwable {
		
		ModelAndView mv=new ModelAndView();
		String imgName=null;
		MultipartFile file=multi.getFile("file");
		
		if(!file.isEmpty()) {
			String uploadPath="C:\\dev4damon\\springworkspaces\\upload";
			System.out.println(uploadPath);
			String uuid=UUID.randomUUID().toString();
			imgName=uuid+"_"+file.getOriginalFilename();
			file.transferTo(new File(uploadPath+File.separator+imgName));
		}
		qtDTO.setQt_img(imgName);
		int result=qtSv.insert(qtDTO);
		msSv.makeCntUp(qtDTO.getMember_m_no());
		String resultText="퀴즈가 등록되었습니다.";
		if(result!=1) {
			resultText="퀴즈 등록에 실패했습니다.";
		}
		mv.addObject("resultText", resultText);
		mv.addObject("result", result);
		mv.setViewName("quiztyping/qtmakeresult");
		return mv;
	}
	
//	퀴즈 풀이 선택창으로 이동
//	@GetMapping("/quizselect")
//	public ModelAndView quizSelect() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("quizselect");
//		return mv;
//	}
	
//	퀴즈 풀이로 이동 (공식 or 회원 창작)
	@GetMapping("/qtquestion")
	public ModelAndView qtQuestion(@ModelAttribute("qt_makeType") String qt_makeType) {
		ModelAndView mv=new ModelAndView();
		QuizTypingDTO qt=qtSv.selectRand(qt_makeType);
		mv.addObject("qt", qt);
		mv.setViewName("quiztyping/qtquestion");
		return mv;
	}
	
//	퀴즈 풀이 결과 처리
	@PostMapping("/qtresult")
	public ModelAndView qtResult(@ModelAttribute("qtDTO") QuizTypingDTO qtDTO,
								HttpSession session){
								
		ModelAndView mv=new ModelAndView();
		Map member = (Map) session.getAttribute("member");
		QuizTypingDTO oriDTO=qtSv.selectNo(qtDTO.getQt_no());
		int result=0;
		String answer=null;
		if(!oriDTO.getQt_answer().equalsIgnoreCase(qtDTO.getQt_answer())) {
			result=-1;
			qtSv.loseCnt(oriDTO.getQt_no());
			answer=oriDTO.getQt_answer();
			if(member!=null)
			msSv.loseCnt((int)member.get("m_no"));
		}
		else {
			result=1;
			qtSv.winCnt(oriDTO.getQt_no());
			if(member!=null)
			msSv.winCnt((int)member.get("m_no"));
		}
		mv.addObject("result", result);
		mv.addObject("answer", answer);
		mv.setViewName("quiztyping/qtresult");
		return mv;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
