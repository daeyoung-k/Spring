package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;


@Service("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	private ArrayList<BoardVO> list = new ArrayList<>();

	@Override
	public void boardRegist(BoardVO vo) {		
		list.add(vo);
		System.out.println(list);
		
	}

	@Override
	public ArrayList<BoardVO> getList() {		
		return list;
	}

	@Override
	public void boardDelete(int num) {		
		list.remove(num);
		
	}

}