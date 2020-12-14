package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.command.BoardVO;
import com.simple.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class JDBCMybatis {
	
	//1. 세션팩토리 빈 주입 확인
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;
	
	//2.TestMapper인터페이스 주입
	@Autowired
	private TestMapper testMapper;
	
//	@Test
//	public void test() {
//		System.out.println(sqlSessionFactory);
//	}
	
	@Test
	public void testGetTime() {
		System.out.println(testMapper.getTime());
	}
	
	//insert구문의 값을 전달할 때는, 단일값 or VO를 통해서 전달 or Map으로 전달
//	@Test
//	public void insetTest() {
//		
//		for(int i = 1; i <= 10; i++) {
//			
//			BoardVO vo = new BoardVO();
//			vo.setName("홍길동" + i);
//			vo.setTitle("테스트" + i);
//			vo.setContent("테스트!" + i);
//			
//			testMapper.insert(vo);
//		}
//	}
	
	//Map을 통한 전달 구문
//	@Test
//	public void insertTest() {
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "홍길자");
//		map.put("title", "맵을 통한 추가");
//		map.put("content", "맵통추 입니다");
//		testMapper.insert(map);
//	}
	
	
	@Test
	public void selectTest() {
		ArrayList<BoardVO> list = testMapper.getList();
		System.out.println("반환결과: " + list.toString());
	}
	
	//10번 게시글의 단일 조회
	@Test
	public void selectTest1() {
		BoardVO vo = testMapper.getList1(10);
		System.out.println("단일조회 반환결과: " + vo.toString());
	}
	
	@Test
	public void getListTwo() {
		ArrayList<BoardVO> list = testMapper.getListTwo("홍길동", "테스트");
		System.out.println("두개파라미터전달결과: " + list.toString());
		
	}
	
	//게시글 수정 테스트
	//VO객체를 이용해서 수정내용 (글 제목, 글 내용)을 입력하고
	//10번 게시글을 수정해보세요
	@Test
	public void update() {
		try {
			
			BoardVO vo= new BoardVO();
			vo.setNum(10);
			vo.setTitle("수제수");
			vo.setContent("수정된 내용은 임수정입니다");
			int result = testMapper.update(vo); //성공시 1 실패시 0
			System.out.println("업데이트 여부: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제 테스트
	//delete태그를 이용합니다.
	//3번 게시글을 삭제하는 구문을 작성(삭제 결과여부도 확인)
	@Test
	public void delete() {
		try {
			
			BoardVO vo = new BoardVO();
			vo.setNum(3);
			
			int result = testMapper.delete(vo);
			System.out.println("삭제 여부:" + result );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
