package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//주소 API승인키
	//devU01TX0FVVEgyMDIwMTIyMzE1MzUyMTExMDU4Njg=
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}	
	
	@RequestMapping(value = "/userJoinForm", method = RequestMethod.POST)
	public String userJoinForm(UserVO vo) { //회원가입		
		
		userService.userJoin(vo);		
		
		return "user/userLogin";
	}
	
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}
		
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(UserVO vo, Model model, HttpSession session) {
//		
//		UserVO result = userService.userLogin(vo);
//		System.out.println(result);
//		if(result == null) {
//			model.addAttribute("msg", "아이디 정보를 확인하세요");
//			return "user/userLogin";
//		}else {
//			session.setAttribute("userVO", result);
//			return "redirect:/";
//		}		
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLoginForm(UserVO vo, Model model, HttpSession session) {
		
		//로그인 성공시 회원정보를 받아오고, 로그인 실패시 null을 반환
		UserVO result = userService.userLogin(vo);
		
		ModelAndView mv = new ModelAndView(); //뷰와 model정보를 동시에 저장하는 객체
		mv.setViewName("user/userLogin");
		
		//로그인 성공시 회원정보 저장, 로그인 실패시엔 msg정보 저장
		if(result != null) {
			mv.addObject("login", result);
		}else {
			mv.addObject("msg", "아이디 비밀번호를 확인하세요");
		}
		
		return mv;
	}
	
	@RequestMapping("/userMypage")
	public String userMypage(HttpSession session, Model model) {	
		
		//조인데이터에 대한 처리방법.
		UserVO vo = (UserVO) session.getAttribute("userVO");
		String userId = vo.getUserId();
		
		//1:N관계 맵핑으로 결과를 처리
		UserVO userInfo = userService.getInfo(userId);
		model.addAttribute("userInfo", userInfo);		
		
		return "user/userMypage";
	}
	
	 // 로그아웃
	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session) {
	   session.invalidate();   // 세션정보 삭제
	   return "redirect:/";  // home화면으로 이동
	}

	
	//일반컨트롤러에서는 비동기요청 메서드는 ResponseBody를 붙입니다.
	@ResponseBody //응답요청을 viewResolve로 반환하는것이 아닌, 요청이 들어온곳으로 Responser Header정보를 만들어서 보내준다.
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) { //아이디 중복체크
		
		
		int result = userService.idCheck(vo);		
		
		return result;
	}
}
