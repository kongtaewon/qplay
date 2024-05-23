package kr.co.qplay.member;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.reflect.MethodDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.qplay.memberscore.MemberScoreDTO;
import kr.co.qplay.memberscore.MemberScoreService;
import kr.co.qplay.quiztyping.QuizTypingDAO;
import kr.co.qplay.quiztyping.QuizTypingDTO;
import kr.co.qplay.quiztyping.QuizTypingService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mSv;
	
	@Autowired
	private MemberScoreService msSv;
	
	@Autowired
	private QuizTypingService qtSv;
	
//	로그인 화면으로 이동
	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
//	로그인 처리 후 메인으로 이동
	@PostMapping("login")
	public ModelAndView login(@RequestParam Map<String, Object> map,
							  HttpSession session){
		ModelAndView mv=new ModelAndView();
		Map<String, Object> member= mSv.login(map);
		if(member==null) {
			mv.setViewName("login");
		}
		else {
			session.setAttribute("member", member);
			mv.setViewName("main");
		}
		return mv;
	}
	
//	로그아웃 처리 후 메인으로 이동
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		session.invalidate();
		mv.setViewName("main");
		return mv;
	}
	
//	회원가입 폼으로 이동
	@GetMapping("signup")
	public ModelAndView signUp() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
//	회원가입 + 회원 전적 생성 후 계정 결과창으로 이동
	@PostMapping("signup")
	public ModelAndView signUp(@ModelAttribute ("mDTO") MemberDTO mDTO) {
		ModelAndView mv=new ModelAndView();
		int upResult=mSv.signup(mDTO);
		if(upResult>0) {
			MemberScoreDTO msDTO=new MemberScoreDTO();
			msDTO.setMember_m_no(mSv.mno(mDTO.getM_id()));
			msDTO.setMember_m_id(mDTO.getM_id());
			msDTO.setMember_m_nick(mDTO.getM_nick());
			msSv.signup(msDTO);
		}
		mv.addObject("upResult", upResult);
		mv.setViewName("accresult");
		return mv;
	}
	
//	id 중복 체크
	@ResponseBody
	@PostMapping("idcheck")
	public ModelAndView idcheck(@RequestParam ("idDTO") MemberDTO idDTO) {
		ModelAndView mv=new ModelAndView();
		int idResult=1;
		if(mSv.idcheck(idDTO)) {
			idResult=-1;
		}
		mv.addObject("idResult", idResult);
		return mv;
		
	}
	
	
//	회원 탈퇴 + 회원 전적 삭제 처리 후 계정 결과창으로 이동
	@GetMapping("deletemember")
	public ModelAndView delete(@ModelAttribute ("m_no") int m_no) {
		ModelAndView mv=new ModelAndView();
		int delResult=mSv.delete(m_no);
		if(delResult>0) {
			msSv.delete(m_no);
		}
		mv.addObject("delResult", delResult);
		mv.setViewName("accresult");
		return mv;
	}
	
//	회원 정보창으로 이동
	@GetMapping("memberdetail")
	public ModelAndView memberDetail() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("memberdetail");
		return mv;
	}
	
//	회원 닉네임 변경창으로 이동
	@GetMapping("membernick")
	public ModelAndView membernick(@ModelAttribute ("tempDTO") MemberDTO tempDTO) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("tempDTO", tempDTO);
		mv.setViewName("membernick");
		return mv;
	}
	
//	회원 닉네임 변경 처리
	@PostMapping("membernick")
	public ModelAndView chgnick(@ModelAttribute("mDTO") MemberDTO mDTO,
								@ModelAttribute("newNick") String newNick) {
		ModelAndView mv=new ModelAndView();
		int nickResult;
		mDTO.setM_nick(newNick);
		if(mSv.nickcheck(mDTO)) {
			nickResult=-1;
		}
		else {
			nickResult=mSv.chgnick(mDTO);
		}
		mv.addObject("nickResult", nickResult);
		mv.setViewName("memberdetail");
		return mv;
	}
	
	
	
	
//	회원 한 명의 전적 확인 처리
	@GetMapping("myscore")
	public ModelAndView score(@ModelAttribute("m_no") int m_no) {
		ModelAndView mv=new ModelAndView();
		MemberScoreDTO msDTO=msSv.detail(m_no);
		mv.addObject("msDTO", msDTO);
		mv.setViewName("myscore");
		return mv;
	}
	
//	회원 한 명의 창작 퀴즈 확인 처리
	@GetMapping("mymake")
	public ModelAndView makeList(@ModelAttribute("m_no") int m_no) {
		ModelAndView mv=new ModelAndView();
		List<QuizTypingDTO> qtlist=qtSv.listPart(m_no);
		mv.addObject("qtlist", qtlist);
		
		mv.setViewName("mymake");
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
