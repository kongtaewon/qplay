package kr.co.qplay.quizmultiple;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.qplay.memberpoint.MemberPointDTO;
import kr.co.qplay.memberpoint.MemberPointService;

@Controller
public class QuizMultipleController {

	private final static Logger logger = LoggerFactory.getLogger(QuizMultipleController.class);
	private int postnum = 0;

	@Autowired
	private QuizMultipleService service;

	@Autowired
	private MemberPointService mbpservice;

//	// 로그인창 이동
//		@GetMapping(value = "/login")
//		public String quizlogin() {
//			logger.info("이동");
//			return "login";
//		}
//
//		// 로그인 시도
//		@PostMapping(value = "/login")
//		public String login(@RequestParam Map<String, Object> map, HttpSession session, HttpServletRequest request)
//				throws Exception {
//			request.setCharacterEncoding("utf-8");
//			Map member = service.login(map);
//			logger.info("member : " + member);
//			if (member == null) {
//				return "redirect:/login";
//
//			} else {
//				session.setAttribute("member", member);
//				return "redirect:/";
//			}
//
//		}
//
//		// 로그아웃
//		@GetMapping(value = "/logout")
//		public String quizlogout(HttpSession session) {
//			session.invalidate();
//			return "redirect:/";
//		}

	// 퀴즈 선택 넘어가기
	@GetMapping(value = "/quizselect")
	public String quizgroup() {
		return "quizselect";
	}

	// 퀴즈 만들기 넘어가기
	@GetMapping(value = "/quizmake")
	public String quizmake(HttpSession session) {
		session.getAttribute("member");
		return "quizmake";
	}

	@GetMapping(value = "/quizmultiple/quizinsert")
	public String quizinsert(HttpSession session, Model model) {
		Map member = (Map) session.getAttribute("member");
		logger.info("" + member.get("m_nick"));
		model.addAttribute("member", member);
		return "quizmultiple/quizinsert";
	}

	// 퀴즈 만들기
	@PostMapping(value = "/complete")
	public String complete(HttpServletRequest request,
			@RequestParam(value = "qmc_contents", required = false) List<String> list, HttpSession session,
			MultipartHttpServletRequest multi, Model model, QuizMultipleDTO qmdto) throws Exception {

		Map member = (Map) session.getAttribute("member");

		int memberno = (int) member.get("m_no");
		
		System.out.println("roll : " + member);
		
		
		List<MemberPointDTO> memberlist = mbpservice.list(memberno);
		int memberpoint = 0;
		for (int i = 0; i < memberlist.size(); i++) {
			memberpoint = memberlist.get(i).getMs_point();
			logger.info("memberpoint : " + memberpoint);
		}

		model.addAttribute("memberpoint", memberpoint);

		String qm_quizType = request.getParameter("qm_quizType");
		String qm_question = request.getParameter("qm_question");
		String qm_hint = request.getParameter("qm_hint");

//		--------------------------------------------------------------------------------------

		String imgName = null;
		MultipartFile file = multi.getFile("file");
		if (!file.isEmpty()) {
//			String real = request.getSession().getServletContext().getRealPath("/resources/img");
			String real = "C:\\upload";
//			String real = "C:\\dev4damon\\springworkspaces\\upload";
			System.out.println(real);
			String uuid = UUID.randomUUID().toString();
			String[] uuids = uuid.toString().split("-");

			String uniqueName = uuids[0];

			imgName = uniqueName + "_" + file.getOriginalFilename();
			file.transferTo(new File(real + File.separator + imgName));
		}

		qmdto.setQm_img(imgName);

//		--------------------------------------------------------------------------------------

		qmdto = new QuizMultipleDTO((int) member.get("m_no"), (String) member.get("m_id"),
				(String) member.get("m_nick"), qm_question, (String) member.get("m_roll"), list.get(0), qm_quizType,
				qm_hint, imgName);

		service.quizinsert(qmdto);
		logger.info("qmdto : " + qmdto);

		QuizMultipleDTO oneqmdto = service.idselect(qmdto.getMember_m_nick());

		int num = oneqmdto.getQm_no();
		logger.info("num : " + num);

		String contents = null;

		for (int i = 0; i < list.size(); i++) {
			contents = list.get(i);
			logger.info("qmc_contents : " + contents);
			if (contents != "") {
				QuizMultipleChoiceDTO qmcdto = new QuizMultipleChoiceDTO(num, contents);
				service.choiceinsert(qmcdto);
			}
		}

		int result = mbpservice.decrease(memberno);
		if (result < 0) {
			logger.info("실패");
		} else {
			logger.info("성공");
		}

		return "quizmake";
	}

	// 퀴즈 보여주기
	@GetMapping(value = "/quizmultiple/quizrandom")
	public ModelAndView quizrandom(HttpSession session, @ModelAttribute("qt_makeType") String qt_makeType) {

		ModelAndView mav = new ModelAndView();

		postnum = service.count(qt_makeType);
		logger.info("선택된 문제 번호 : " + postnum);

		int memberno = 0;

		Map no = (Map) session.getAttribute("member");
		System.out.println(no);
		if (no != null) {
			memberno = (int) no.get("m_no");
			List<MemberPointDTO> list = mbpservice.list(memberno);
			System.out.println(memberno);
			int listpoint = 0;

			for (int i = 0; i < list.size(); i++) {
				listpoint = list.get(i).getMs_point();
			}
			mav.addObject("listpoint", listpoint);

		}

		QuizMultipleDTO qmdto = service.selectOne(postnum);
		logger.info("문제 : " + qmdto.getQm_no());

		List<QuizMultipleChoiceDTO> qmcdto = service.listAll(qmdto.getQm_no()); // 보기 전체

		Map<String, String> map = new HashMap<String, String>();

		// 문제 이름
		for (int i = 0; i < qmcdto.size(); i++) {
			if (qmdto.getQm_no() == qmcdto.get(i).getQuiz_multiple_qm_no()) {

				String title = qmdto.getQm_quizType();
				logger.info("title : " + title);

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

		mav.setViewName("quizmultiple/quizrandom");

		return mav;
	}

	// 결과
	@GetMapping(value = "/quizmultiple/result")
	public ModelAndView proverbresult(HttpServletRequest request, HttpSession session) throws Exception {
		String choiceCheck = request.getParameter("choice");
		int memberno = 0;
		Map no = (Map) session.getAttribute("member");

		logger.info("선택 답 : " + choiceCheck);

		logger.info("게시물 번호 : " + postnum);

		QuizMultipleDTO rootqmdtoNum = service.selectOne(postnum);
		logger.info("답 " + rootqmdtoNum.getQm_answer());

		String value = rootqmdtoNum.getQm_answer();

		service.pick(choiceCheck);

		ModelAndView mav = new ModelAndView();
		
		if (no != null) {
			
			memberno = (int) no.get("m_no");
			
			if (!choiceCheck.equals(value)) {
				
				service.losecount(postnum);
				mav.addObject("wa", "틀렸습니다");
				
			} else if (choiceCheck.equals(value)) {
				
				service.wincount(postnum);
				mbpservice.pointup(memberno);
				mav.addObject("wb", "정답입니다");
				
			}
		} else {
			
			if (!choiceCheck.equals(value)) {
				mav.addObject("wa", "틀렸습니다");
			} else if (choiceCheck.equals(value)) {
				mav.addObject("wb", "정답입니다");
			}
			
		}

		mav.setViewName("quizmultiple/result");
		return mav;
	}

	// ajax
	@ResponseBody
	@PostMapping(value = "/quizrandom2")
	public List<QuizMultipleDTO> quizrandom2(@RequestParam("qm_no") int qm_no, HttpSession session, Model model) {

		Map no = (Map) session.getAttribute("member");

		int memberno = (int) no.get("m_no");

		int point = mbpservice.update(memberno);

		logger.info("point : " + point);

		if (point < 0) {
			logger.info("사용 실패");
		} else {
			logger.info("사용 성공");
		}

		return service.joinselect(qm_no);
	}

}
