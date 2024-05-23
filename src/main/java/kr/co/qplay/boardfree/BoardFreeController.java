package kr.co.qplay.boardfree;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BoardFreeController {
	private static final Logger logger = LoggerFactory.getLogger(BoardFreeController.class);

	@Autowired
	private BoardFreeService servic;
//  로그인
	@GetMapping(value ="boardfree/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		logger.info("로그인폼으로 이동 =====>");
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping(value = "boardfree/login")
	public String login(@RequestParam Map<String, Object> map,HttpSession session,
			HttpServletRequest request) throws Exception {
		
		request.setCharacterEncoding("utf-8"); // 한글깨지는 거 방지
		logger.info("데이터베이스로 전송");	// 데이터 잘 나오는지 확인
		Map user = servic.login(map);
		
		if(user == null) { //로그인 실패
			return "redirect:login";
		}else {	// 로그인 성공 --> 세션부여
			session.setAttribute("user", user);
			return "redirect:/boardfree/list"; //로그인 성공하면 홈페이로 보냄
		}
	}
	
//	로그아웃
	@GetMapping(value = "boardfrees/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/boardfree/list";
	}
	
//	게시판 전체조회는 SearchBoardController에 있음
	
//	@RequestMapping(value="boardfree/listPage", method = RequestMethod.GET)
//	public String listPage(@ModelAttribute("cri") Criteria cri, Model model)throws Exception{
//		logger.info(cri.toString());
//		
//		model.addAttribute("list", servic.listCriteria(cri));
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		//pageMaker.setTotalCount(1000); 임시용
//		pageMaker.setTotalCount(servic.listCountCriteria(cri));
//		
//		model.addAttribute("pageMaker", pageMaker);
//		
//		return "listPage";
//	}
//	@RequestMapping(value="boardfree/list", method = RequestMethod.GET)
//	public String listPage(@ModelAttribute("cri") Criteria cri, Model model)throws Exception{
//		logger.info(cri.toString());
//		
//		model.addAttribute("list", servic.listCriteria(cri));
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		//pageMaker.setTotalCount(1000); 임시용
//		pageMaker.setTotalCount(servic.listCountCriteria(cri));
//		
//		model.addAttribute("pageMaker", pageMaker);
//		
//		return "list";
//	} ----------------- 페이징 했던 거---------------------------- 
	


//	게시판 글 선택해서 읽기
	@GetMapping(value = "boardfree/read")
	public ModelAndView selectOne(@RequestParam("bf_no") int no) throws Exception {
		ModelAndView mav = new ModelAndView();
		BoardFreeDTO dto = servic.selectOne(no);
		System.out.println("asdaf"+no);
		mav.addObject("board", dto);
		servic.viewCnt(no);
		List<BoardFreeReplyDTO> replylist = servic.getDetai1(no);
		mav.addObject("list", replylist);
		mav.setViewName("read");
		return mav;
	}

//	글 작성(폼)
	@GetMapping(value = "write")
	public ModelAndView insert(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("member") == null) {
			mav.setViewName("login");
		}else {
			mav.setViewName("write");
		}
		return mav;
	}

//	글 작성
	@PostMapping(value = "write")
	public ModelAndView insert2(BoardFreeDTO dto) {
		ModelAndView mav = new ModelAndView();
		servic.insert(dto);
		List<BoardFreeDTO> list = servic.listAll();
		mav.addObject("list", list);
		mav.setViewName("redirect:/boardfree/list");
		return mav;
	}

//	글 수정(폼)
	@GetMapping(value = "boardfree/update")
	public ModelAndView update(@RequestParam("bf_no") int no) {
		ModelAndView mav = new ModelAndView();
		BoardFreeDTO dto = servic.selectOne(no);
		mav.addObject("board", dto);
		mav.setViewName("update");
		return mav;
	}

//	글 수정
	@PostMapping(value = "boardfree/update")
	public ModelAndView update1(BoardFreeDTO dto) {
		ModelAndView mav = new ModelAndView();
		List<BoardFreeDTO> list = servic.listAll();
		if (dto.getBf_title().equals("") || dto.getBf_contents().equals("")) {
			mav.setViewName("update");
			BoardFreeDTO dtoo = servic.selectOne(dto.getBf_no());
			mav.addObject("board", dtoo);
		} else {
			servic.update(dto);
			mav.addObject("list", list);
			mav.setViewName("redirect:/boardfree/list");
		}
		return mav;
	}

//	글 삭제
	@GetMapping(value = "boardfree/delete")
	public ModelAndView delete(HttpSession session ,int bf_no,BoardFreeDTO dto,member member)throws Exception  {
		ModelAndView mav = new ModelAndView();
			servic.delete(bf_no);
			mav.addObject("list", servic.listAll());
			mav.setViewName("redirect:/boardfree/list");
			return mav;
	}
	
//	ajax 댓글에 대한 매핑과 메소드를 구현
//	board/replylist 매핑설정
//	글번호가 요청되어야 함 댓글 목록 가져오기
	@ResponseBody
	@PostMapping(value="boardfree/replylist")
	public List<BoardFreeReplyDTO> replylist(HttpSession httpSession,@RequestParam("board_free_bf_no") int bf_no){
		httpSession.getAttribute("user");
		
		return servic.getDetai1(bf_no);
	}
	
//	댓글 쓰기
	@ResponseBody
	@PostMapping(value="boardfree/reply")
	public int reply(BoardFreeReplyDTO boardFreeReplyDTO) {
		return servic.reply(boardFreeReplyDTO);
	}
	
//	댓글 수정
	@ResponseBody
	@PostMapping(value="boardfree/replyupdate")
	public int replyupdate(BoardFreeReplyDTO boardFreeReplyDTO) {
		return servic.replyupdate(boardFreeReplyDTO);
	}
	
//	댓글 삭제
	@ResponseBody
	@PostMapping(value="boardfree/replyDelete")
	public int replyDelete(int bfr_no) {
		return servic.replyDelete(bfr_no);
	}
	
//	게시글 추천
	@ResponseBody
	@PostMapping(value="boardfree/updateLike")
	public int updateLike(int bf_no, String member_m_nick)throws Exception{
		int likeCheck = servic.likeCheck(bf_no, member_m_nick);
		
		if(likeCheck == 0) { 	// 추천 처음 누름
		servic.insertLike(bf_no, member_m_nick); //  like 테이블에 들어가게 만듬
		servic.updateLike(bf_no); // 게시판 테이블 + 1
		servic.updateLikeCheck(bf_no, member_m_nick);	// like 테이블 +1이됨
		}else if(likeCheck == 1) {	// 추천 취소
			servic.updateLikeCheckCancel(bf_no, member_m_nick);	// like 테이블 -1이됨
			servic.updateLikeCancel(bf_no);	// 게시판 테이블 - 1
			servic.deleteLike(bf_no, member_m_nick); //  like 테이블에 들어가게 만듬
		}
		return likeCheck;
	}
	
//	게시글 비추천
	@ResponseBody
	@PostMapping(value="boardfree/downlike")
	public int downlike(int bf_no, String member_m_nick)throws Exception{
		int downCheck = servic.downCheck(bf_no, member_m_nick);
		
		if(downCheck == 0) {	// 비추천 안누름
			servic.insertdown(bf_no, member_m_nick);
			servic.downlike(bf_no);
			servic.downCheck(bf_no, member_m_nick);
		}else if(downCheck == 1){ // 비추천 취소
			servic.downLikeCheckCancel(bf_no, member_m_nick);
			servic.downlikeCancel(bf_no);
			servic.deletedown(bf_no, member_m_nick);
		}
		return downCheck;
	}
	


}
