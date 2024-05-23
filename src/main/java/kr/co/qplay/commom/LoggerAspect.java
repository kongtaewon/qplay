package kr.co.qplay.commom;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// advice : 공통업무를 지원하는 클래스 (구현)

@Component
@Aspect
public class LoggerAspect {
	
	protected Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	//@before(해당 대상이 호출전)
	// 컨트롤러의 모든 메소드에 대한 수행시간을 출력해보기
	@Around("execution (* kr.co.dong.controller.*Controller.*(..))")//@Around 전부 또는 시작과 끝
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		// 핵심업무 실행전
		Object result = null;
		String type = joinPoint.getSignature().getDeclaringTypeName();
		long start = System.currentTimeMillis();
		
		//핵심업무 실행
		result = joinPoint.proceed();
		
		//핵심업무 실행 후
		long end = System.currentTimeMillis();
		log.info("->" + type + ": 수행시간" + (end - start) + "밀리초" );
				
		
		return result;
	}

}
