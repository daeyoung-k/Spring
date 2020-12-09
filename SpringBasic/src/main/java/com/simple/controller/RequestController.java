package com.simple.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller //컴포넌트 스캔이 읽어서 빈으로 생성
@RequestMapping("/request")
public class RequestController {
	
	//req_ex01화면처리 메서드
	//'void형' 메서드는 들어온 요청경로 그대로 뷰리졸버로 값이 반환됩니다.
//	@RequestMapping("/request/req_ex01")
//	public void req_ex01() {
//		System.out.println("실행됨");
//	}
	
	@RequestMapping("/req_ex01")
	public String req_ex01() {
		
		return "request/req_ex01";
	}
	//basic1 요청처리(get방식만 허용)
	@RequestMapping(value="/basic1", method=RequestMethod.GET)
	public void basic1() {
		System.out.println("basic1요청");
	}
	//basic2 요청처리(post방식만 허용)
	@RequestMapping(value="/basic2",method = RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2요청");
	}
	
	@GetMapping("/basic3")
	public void basic3() {
		System.out.println("basic3요청");
	}
	
	@PostMapping("/basic4")
	public void basic4() {
		System.out.println("basic4요청");
	}
	
	
	//=====================요청파라미터 처리하기=============================
	
	//req_ex02화면처리
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		
		return "request/req_ex02";
	}
	
	//1st
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		
//		return "request/req_ex02_result";
//	}
	
//	//2nd - 어노테이션 방법
//	@RequestMapping("/param")
//	public String param(@RequestParam("id") String id,
//						@RequestParam("pw") String pw,
//						@RequestParam("name") String name,
//						@RequestParam("age") int age,
//						@RequestParam(value="inter", required = false, defaultValue = "") ArrayList<String> list
//						) {
//		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(name);
//		System.out.println(age);
//		//필수가 아닌 파라미터 일경우에는 required = false옵션을 지정할 수 있습니다.
//		//필수가 아닌 파라미터 값일 경우에는 null을 지정하게 되는데 기본값의 설정으로 defaultValue옵션을 쓰면 됩니다.
//		System.out.println(list.toString());
//		
//		return "request/req_ex02_result";
//	}
	
	//3nd
	//커맨드객체를 사용하는 방법
	@RequestMapping("/param")
	public String param(ReqVO vo) {
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getInter().toString());
		
		return "request/req_ex02_result";
	}
	
	//========================문제========================
	
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw
						) {
		System.out.println(id);
		System.out.println(pw);
		
		return "request/req_ex02_result";
	}
	
	
	
	
}
