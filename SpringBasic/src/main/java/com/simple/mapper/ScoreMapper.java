package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreMapper {
	
	//서버클래스에서 구현할 메서드를 추상메서드로 선언
	public void scoreRegist(ScoreVO vo); //등록
	public ArrayList<ScoreVO> getList(); //목록
	public void scoreDelete(int index); //삭제
}
