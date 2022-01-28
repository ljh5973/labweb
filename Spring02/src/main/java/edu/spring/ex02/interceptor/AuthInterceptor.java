package edu.spring.ex02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

// 로그인 상태인 지 아닌 지를(세션에 로그인 아이디가 저장되어 있는지)를 체크해서,
// 로그인 상태이면 원래 가고자 했던 페이지로 이동
// 로그인 안 한 상태이면 로그인 페이지로 redirect.
public class AuthInterceptor implements HandlerInterceptor{

	
	private static final Logger log= LoggerFactory.getLogger(AuthInterceptor.class);
	
	
	// 요청 URL과 요청 방식에 매핑된 Controller method가 호출되기 전에
	// Request와 Response를 가로채서 실행되는 메서드
	// 요청 처리 전에 해야 할 일을 작성함.
	// 리턴 값의 의미 : (1) true -> 다음 handler chain이 실행됨 다음 단계로 진행하겠다. (2) false -> 요청 처리를 진행하지 않는다.  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("preHandle() 호출");
		
		// 로그인 상태 여부 체크 : (1) 로그인 OK -> 진행 (2) 로그인 NO -> signin page.
		
		HttpSession session= request.getSession();
		
		String signInUserId= (String) session.getAttribute("signInUserId");
		
		if(signInUserId!=null) {
			
			log.info("로그인 아이디 : {}", signInUserId);
			return true;
		}else {
			// 로그인 정보 X
			// redirect
			
			log.info("로그인 안됨.");
			//요청 URL 정보를 찾아서, signin 요청에 요청 파라미터를 추가.
			
			String reqUrl=request.getRequestURL().toString();
			log.debug("reqUrl ={}",reqUrl);
			
			//질의 문자열이 있는 지 확인.
			String query= request.getQueryString();
			String target="";
			
			
			if(query==null) {
				target=UriUtils.encode(reqUrl, "UTF-8");
			}else {
				target=UriUtils.encode(reqUrl+"?"+query,"UTF-8");
			}
			
			UriUtils.encode(reqUrl, "UTF-8");	//특수 기호(:/,)들을 UTF-8으로 변환
			
			log.debug("URI 디코딩 후 : {})", target);
			
			response.sendRedirect("/ex02/user/signin?url="+target) ;
			return false;
		}
		
		
		
		
	}
	
	
	
	// Controller method가 return 한 후 view(jsp 파일)에 모델 객체가 전달되기 전에 호출되는 method.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle() 호출");
	}
	
	// view(jsp file)가 호출되어서 화면(UI)가 완성된 이후 호출되는 method.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion() 호출");
	}
}
