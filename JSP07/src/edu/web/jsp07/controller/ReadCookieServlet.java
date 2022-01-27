package edu.web.jsp07.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookieServlet
 */
@WebServlet(name="/readCookieServlet", urlPatterns = {"/get-cookie"})
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("readCookieServlet.doGet() 호출");
		
		// 클라이언트(브라우저)가 요청에 실어서  보낸 Cookie를 WAS에서 확인하는 방법
		
		Cookie[] cookies=request.getCookies();
		
		// getCookie() 메서드는 브라우저에서 전송된 쿠키가 없는 경우에는 null을 리턴.
		if(cookies != null) { // 쿠키 배열이 null이 아닌 경우에

			for(Cookie c: cookies) {
				String name=c.getName();
				String value=c.getValue();
				
				System.out.println("name : "+ name);
				System.out.println("value : " + value);
				
				// 서버에서 응답을 보낼 때 클라이언트가 (브라우저) 가 저장하고 있는 쿠키를 만료시키는 방법
				if(name.equals("nickName")){
					
					Cookie nickName = new Cookie("nickName", null);
					
					// 새로 생성된 쿠키의 만료 기간은 0초로 설정
					nickName.setMaxAge(0);
					// 쿠키를 응답(response)에 포함.
					response.addCookie(nickName);
				}
			}
			
		}
		
		request.getRequestDispatcher("/WEB-INF/02_read_result.jsp").forward(request, response);
	}

}
