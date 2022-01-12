package edu.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.board.BoardMainController;
import edu.web.controller.user.UserMainController;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet(
		name="frontControllerServlet",
		urlPatterns= {"", "/board/*","/user/*"}
)

// WebSevlet Annotation의 urlPatterns 설정값:
// - Servlet 클래스가 처리할 URL 주소들의 배열
// - URL 주소에서 Context Path 아래의 주소들을 설정
// ex) URL 주소가 "http://localhost:8080/JSP05/board/main"라면 매핑 패턴은 " /board/main"
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	// 요청(request)과 응답(response)을 처리하는 Controller 객체들과
	// controller에 매핑된 요청 주소를 저장하는 변수
	private Map<String , Action> commands;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	
    // WAS(Web Application Server)가  서블릿 (Servlet) 클래스 객체를 생성할 때 호출
    // 서블릿 객체가 생성될 때 필요한 초기화 작업(환경 설정) 등을 담당.
	public void init() throws ServletException {
		// 요청 주소와 요청 주소를 처리할 Controller 클래스의 객체를 매핑시켜서 등록.
		commands = new HashMap<String, Action>();
		commands.put("/", new MainController()); // context path 요청을 처리할 controller
		
		commands.put("/board/main", new BoardMainController());
		commands.put("/user/main", new UserMainController());

	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Client에서 request가 올 때마다 WAS가 호출하는 메서드
		System.out.println("frontControllerServlet.service() method call");
		
		// 요청 파라미터(request parameter)에 포함되어 있는 한글을 처리하기 위해서
		request.setCharacterEncoding("UTF-8");
		
		
		// request 객체가 가지고 있는 정보들
		// URL: 프로토콜(protocol) + 서버 주소(이름) + 포트번호 +URI
		StringBuffer url= request.getRequestURL();
		System.out.println("Request URL: "+ url);
		
		String uri= request.getRequestURI();
		System.out.println("Request URI: "+ uri);
		
		String contextPath= request.getContextPath();
		System.out.println("ContextPath: " + contextPath);
		
		String path= uri.substring(contextPath.length());
		System.out.println("path : "+ path);
		
		
		// 위임 (delegation) 패턴 사용: 요청 주소를 처리하기 위한 Controller 객체 찾음.
		Action controller= commands.get(path);
		
		// Controller가 request를 처리한 후에 View를 만들기 위한 JSP 파일 경로를 리턴받음.
		String view = controller.execute(request, response);
		
		System.out.println("view : "+ view);
		// TODO: forward vs redirect 선택
		
		// 요청을 이동 (forward, redirect)
		request.getRequestDispatcher(view).forward(request, response);
	}
	

}
