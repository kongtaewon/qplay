package kr.co.qplay.quizmultiple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.qplay.memberpoint.MemberPointDTO;
import kr.co.qplay.memberpoint.MemberPointService;

@Controller
public class QuizMultipleMemeberController {

	private final static Logger logger = LoggerFactory.getLogger(QuizMultipleMemeberController.class);
	private int postnum = 0;

	@Autowired
	private QuizMultipleService service;
	
	@Autowired
	private MemberPointService mbpservice;

	// 퀴즈 보여주기
	@GetMapping(value = "/quizmultiple/quizmemberrandom")
	public ModelAndView quizmemberrandom(HttpSession session) {

		ModelAndView mav = new ModelAndView();
		
		postnum = service.count("member");
		logger.info("선택된 문제 번호 : " + postnum);

		Map no = (Map) session.getAttribute("member");
		
		if (no != null) {
			int memberno = (int) no.get("m_no");
			
			List<MemberPointDTO> list = mbpservice.list(memberno);
			
			int listpoint = 0;
			
			for (int i = 0; i < list.size(); i++) {
				listpoint = list.get(i).getMs_point();
			}
			
			mav.addObject("listpoint", listpoint);
			
		}
		
		Map<String, String> map = new HashMap<String, String>();

		QuizMultipleDTO qmdto = service.selectOne(postnum);
		logger.info("문제 : " + qmdto.getQm_no());
		logger.info("질문 : " + qmdto.getQm_question());
		logger.info("질문 : " + qmdto.getQm_quizType());
		
		List<QuizMultipleChoiceDTO> qmcdtolist = service.listAll(qmdto.getQm_no()); // 보기 전체

		// 문제 이름
		for (int i = 0; i < qmcdtolist.size(); i++) {
			if (qmdto.getQm_no() == qmcdtolist.get(i).getQuiz_multiple_qm_no()) {

				String title = qmdto.getQm_quizType();
				String hint = qmdto.getQm_hint();
				logger.info("title : " + title);
				logger.info("hint : " + hint);
				
				mav.addObject("hint", hint);
				mav.addObject("title", title);
				mav.addObject("ra", qmdto);
				
			}
			
		}
		
		List<QuizMultipleChoiceDTO> qmcContents = service.one(qmdto.getQm_no()); // 보기

		// 보기 이름
		for (int i = 0; i < qmcContents.size(); i++) {
			map.put(Integer.toString(i + 1), qmcContents.get(i).getQmc_contents());
			logger.info("map" + map.values());
		}

		mav.addObject("rb", map.values());

		mav.setViewName("quizmultiple/quizmemberrandom");

		return mav;
	}

	// 결과
	@GetMapping(value = "/quizmultiple/memberresult")
	public ModelAndView proverbresult(HttpServletRequest request) throws Exception {
		String choiceCheck = request.getParameter("choice");

		logger.info("선택 답 : " + choiceCheck);

		logger.info("게시물 번호 : " + postnum);

		QuizMultipleDTO rootqmdtoNum = service.selectOne(postnum);
		logger.info("답 " + rootqmdtoNum.getQm_answer());

		String value = rootqmdtoNum.getQm_answer();

		service.pick(choiceCheck);

		ModelAndView mav = new ModelAndView();
		if (!choiceCheck.equals(value)) {
			service.losecount(postnum);
			mav.addObject("wa", "답이 틀렸습니다");
		} else if (choiceCheck.equals(value)) {
			service.wincount(postnum);
			mav.addObject("wb", "정답입니다");
		}


		mav.setViewName("quizmultiple/memberresult");
		return mav;
	}

}
