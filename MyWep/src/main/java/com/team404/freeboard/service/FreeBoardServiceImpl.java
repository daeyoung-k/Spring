package com.team404.freeboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.common.util.Criteria;
import com.team404.freeboard.mapper.FreeBoardMapper;

@Service("freeBoardService") //이 페이지가 읽히는지 확인(컴포넌트스캔)
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Autowired
	private FreeBoardMapper freeboardmapper;
	
	
	@Override
	public void regist(FreeBoardVO vo) {
		
		freeboardmapper.regist(vo);
	}

	
	//기존방식
//	@Override
//	public ArrayList<FreeBoardVO> getList() {
//		
//		return freeboardmapper.getList();
//	}
	
	@Override
	public ArrayList<FreeBoardVO> getList(Criteria cri) {
		System.out.println("getList 메서드 실행");
		return freeboardmapper.getList(cri);
	}
	@Override
	public int getTotal(Criteria cri) {
		
		return freeboardmapper.getTotal(cri);
	}


	@Override
	public FreeBoardVO getContent(int bno) {
		
		return freeboardmapper.getContent(bno);
	}


	@Override
	public int update(FreeBoardVO vo) {
		
		return freeboardmapper.update(vo);		
	}


	@Override
	public void delete(FreeBoardVO vo) {
		freeboardmapper.delete(vo);
		
	}






	


	
}
