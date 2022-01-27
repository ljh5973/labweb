package edu.spring.ex01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.spring.ex01.domain.Board;



@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// @RequestMapping(value = "/board/main", method = RequestMethod.GET)
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void boardMain() {
		logger.info("boardMain() 호출");
	}
	
	// @RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void boardInsert() {
		logger.info("boardInsert() 호출");
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String boardInsertPost(int bno, String title, Model model) {
		//int bno = Integer.parseInt(req.getParameter("bno"));
		//String title = req.getParameter("title");
		// Controller 메서드에서 파라미터 이름을 요청 파라미터(form 요소들의 name 속성) 이름과 동일하게 작성하면
		// Dispatcher Servlet이 요청 파라미터들을 분석해서(request.getParameter() 호출해서
		
		logger.info("boardInsertPost() 호출: bno = {}, title = {}", bno, title);
		
		model.addAttribute("bno", bno);
		model.addAttribute("title",title);
		// JSP에게 데이터를 전달할 때, Model 객체에 속성(attr)을 추가
		return "board/insert-result"; // WEB-INF/views/board/insert-result.jsp
	}
	
	@RequestMapping(value="/insert2", method=RequestMethod.GET)
	public String boardInsert2() {
	 logger.info("boardInsert2() 호출");
	 return "board/insert2";
	}
	
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String boardInsert2(@RequestParam("board-no") int bno,@RequestParam("board-title") String title, Model model) {
		// controller 클래스 메서드의 파라미터에서 사용하는 @RequestParam 어노테이션:
		// 요청 파라미터의 값을 Dispatcher Servlet이 분석해서, 파라미터에 전달할 때 사용.
		
		model.addAttribute("bno", bno);
		model.addAttribute("title", title);
		return "board/insert-result";
	}
	@RequestMapping(value="/insert3", method=RequestMethod.GET)
	public void boardInsert3() {
		
		logger.info("boardInsert3() 호출");
		
		
	}
	
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String boardInsert3(@ModelAttribute ("bno") int bno, @ModelAttribute String title, @ModelAttribute String userid) {
		
			Object[] args= {bno,title,userid};
			logger.info("boardInsert3({},{},{})", args);
			
//			model.addAttribute("bno", bno);
//			model.addAttribute("title",title);
//			model.addAttribute("userId", userid);
		
		return "board/insert3-result";
		
	}
	
	@RequestMapping(value="/insert4", method=RequestMethod.GET)
	public void boardInsert4() {
		logger.info("boardInsert4() 호출");
	}
	
	@RequestMapping(value="/insert4", method=RequestMethod.POST)
	public String boardInsert4(@ModelAttribute("board")Board board) {
		logger.info("boardInsert4({}) 호출", board);
		return "board/insert4-result";
	}
}
