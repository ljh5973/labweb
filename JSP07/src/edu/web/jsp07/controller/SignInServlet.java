package edu.web.jsp07.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.jsp07.service.UserService;
import edu.web.jsp07.service.UserServiceImpl;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet(name = "signInServlet", urlPatterns = { "/signin" })
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private UserService userService=UserServiceImpl.getInstance();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("SignInServlet.doGet() 메서드 호출");
	
	request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("SignInServlet.doPost() 메서드 호출");
		String id=request.getParameter("userId");
		String pw=request.getParameter("pwd");
		
		

		// 아이디/비밀번호가 일치하는 사용자 계정이 있는 지 체크
		
		boolean result=userService.checkSignIn(id, pw);
		
		System.out.println("result = "+ result);
		if(result) {	// 일치하는 사용자가 있는 경우 -> 로그인 성공
			// 세션은 서버가 관리 세션에 사용자 정보를 저장
			
			HttpSession session=request.getSession();	// 요청 객체에서 Session 객체를 찾음
			session.setAttribute("userId", id);
			session.setAttribute("pwd", pw);
			response.sendRedirect("main");
		}else {	// 일치하는 사용자가 없는 경우 -> 로그인 실패
			// 로그인 페이지로 redirect
			response.sendRedirect("signin");
		}
		
		
		
	}

}
