package edu.web.jsp08.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 로그인 되어 있으면, 요청(request)를 계속 진행.
		// 로그인 되어 있지 않으면, 요청을 계쏙 진행하지 않고 로그인 페이지로 이동
		
		
		// 로그인 되어 있는지 체크
		
		 HttpServletRequest httpRequest=(HttpServletRequest) request;
		 HttpSession session=httpRequest.getSession();
		 String signInUser=(String) session.getAttribute("signInUser");
		 
		 
		 HttpServletResponse httpResponse=(HttpServletResponse) response;
		 if(signInUser!= null) { // 세션에 속성이 저장된 경우 -> 로그인 되어 있는 경우
			 // 요청을 다음 필터 체인으로 전달해서 계속 진행
			 chain.doFilter(request, response);
		 }else { // 세션에 속성이 저장되지 않은 경우 -> 로그인 되어 있지 않은 경우
			 // chian.doFilter()를 호출하지 않고, 로그인 페이지로 리다이렉트
			 httpResponse.sendRedirect("../signin");
		 }
		 
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
