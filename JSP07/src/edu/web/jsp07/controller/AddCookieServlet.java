package edu.web.jsp07.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookieServlet
 */
@WebServlet(name ="/addCookieServlet",  urlPatterns = {"/add-cookie"})

public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("addCookieServlet.doGet() 호출");
		
		Cookie cookie1 = new Cookie("name", "guest");
		
		response.addCookie(cookie1);
		
		
		request.getRequestDispatcher("/WEB-INF/01_cookie_result.jsp").forward(request, response);
		
		
	}

}
