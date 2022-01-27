package edu.spring.ex02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.command.UserVO;
import edu.spring.ex02.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int join(UserVO vo) {
		// TODO Auto-generated method stub
		return userMapper.join(vo);
	}

}
