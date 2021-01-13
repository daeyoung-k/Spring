package com.team404.user.mapper;

import com.team404.command.UserVO;

public interface UserMapper {
	
	public int idCheck(UserVO vo); //아이디 중복체크
	public int userJoin(UserVO vo); //회원가입
	public UserVO userLogin(UserVO vo); //로그인
	public UserVO getInfo(String userId);
}
