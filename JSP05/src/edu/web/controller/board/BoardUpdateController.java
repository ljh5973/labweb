package edu.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.Board;
import edu.web.persistence.BoardDaoImpl;
import edu.web.service.BoardService;
import edu.web.service.BoardServiceImpl;

public class BoardUpdateController implements Action{

	
	private BoardService boardService= BoardServiceImpl.getInstance();
	private BoardDaoImpl boardDaoImpl= BoardDaoImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardUpdateController.execute() 메서드 호출");
		
		String method=request.getMethod();
		
		if(method.equals("GET")) {
			return doGet(request, response);
		}else {
			
			return doPost(request,response);
		}
		
		
	}


	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		// 게시글을 수정 할 수있는 UI를 보여줌
		
		System.out.println("boardUpdateController.doGet() 메서드 호출");
		
		// 요청 파라미터 bno값을 읽음.
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		// 글 번호 bno에 해당하는 게시글의 내요을 수정 가능한 form 양식으로 만들어서 보여줌.
		
		Board board=boardService.select(bno);
		// 게시글을 request에 포함시켜서 뷰(JSP)로 포워드

		request.setAttribute("board", board);
		return "/WEB-INF/board/board-update.jsp";
	}

	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		// 수정된 게시글의 내용을 DB에 update -> 상세 보기 페이지 or 게시판 메인 페이지
		
		System.out.println("boardUpdateController.doPost() 메서드 호출");
		// POST 방식의 요청 파라미터에 포함된 글 번호, 제목, 내용을 읽음.
		int bno=Integer.parseInt(request.getParameter("bno"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Board board=boardService.select(bno);
		
		board.setTitle(title);
		board.setContent(content);
		
		int result= boardService.update(board);
		
		return "redirect:main";
	}
	
}
