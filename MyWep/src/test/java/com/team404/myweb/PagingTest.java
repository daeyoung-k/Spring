package com.team404.myweb;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team404.command.FreeBoardVO;
import com.team404.common.util.Criteria;
import com.team404.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springconfig/DB-context.xml")
public class PagingTest {
	
	@Autowired
	private TestMapper testmapper;
	
//	@Test
//	public void Test() {
//		
//		for(int i = 1; i <= 100; i++) {
//			FreeBoardVO vo = new FreeBoardVO();
//			vo.setTitle("제목" + i);
//			vo.setWriter("이름"+i);
//			vo.setContent("내용"+i);
//			
//			testmapper.insertTest(vo);
//		}
//	}
	
	@Test //데이터 조회 테스트
	public void Test2() {
//		Criteria cri = new Criteria(3, 10); //3번 페이지의 10 데이터
		Criteria cri = new Criteria(); //1번 페이지의 10 데이터
		ArrayList<FreeBoardVO> list = testmapper.selectTest(cri);
		System.out.println(list.toString());
	}
}
