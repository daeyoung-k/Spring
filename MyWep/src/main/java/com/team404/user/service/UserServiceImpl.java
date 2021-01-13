package com.team404.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.UserVO;
import com.team404.user.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public int idCheck(UserVO vo) { //아이디 중복체크
		
		return userMapper.idCheck(vo);
	}


	@Override
	public int userJoin(UserVO vo) { //회원가입
		
		return userMapper.userJoin(vo);
	}


	@Override
	public UserVO userLogin(UserVO vo) {
		
		return userMapper.userLogin(vo);
	}


	@Override
	public UserVO getInfo(String userId) {
		
		return userMapper.getInfo(userId);
	}
	
}
