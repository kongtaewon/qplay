package kr.co.qplay.commom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Authentication implements HandlerInterceptor{

//	Controller가 요청을 처리하기전에 호출하는 메소드
	@Override //컨트롤러 들어오기전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//클라이언트에 부여한 세션을 가져오기
		HttpSession session =request.getSession();
		
		if(session.getAttribute("member") == null) {
			// 로그인으로 이동시키기
			response.sendRedirect(request.getContextPath() +"/login");
			return false;
		}
		//로그인이 되어 있으면 그냥 통과
		return true;
	}

//	예외가 발생하지 않은 경우에 Controller가 작업이 끝나면 호출되는 메소드
	@Override //예외가 없을때 처리가 됨
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	예외가 발생여부에 상관없이 Controller가 작업이 끝나면 호출되는 메소드
	@Override //예외상관없이 무조건 처리
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
