package edu.spring.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex02.command.UserVO;
import edu.spring.ex02.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value="userJoin", method=RequestMethod.GET)
	public String userJoin() {
		
		return "user/userJoin";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String userLogin() {
		
		
		return "user/login";
	}
	
	@RequestMapping(value="/join" , method=RequestMethod.GET)
	public String join(UserVO vo) {
		
		System.out.println(vo.toString());
		int result=userService.join(vo);
		System.out.println(result);
		return "home";
	}
}
