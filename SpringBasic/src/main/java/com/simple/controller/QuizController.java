package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	@RequestMapping("/quiz01_ok")
	public String quiz01_ok() {
		return "quiz/quiz01_ok";
	}
	
	@RequestMapping(value="sendBirth", method = RequestMethod.POST)
	public String sendBirth(Quiz01VO vo,
							RedirectAttributes ra) {
		
		String year = vo.getYear();
		int month = vo.getMonth();
		String day = vo.getDay();
		
		if(month >= 10) {
			System.out.println(year + month + day);
		}else {			
			System.out.println(year +"0"+month + day);
		}
		
		ra.addFlashAttribute("year", vo.getYear());
		ra.addFlashAttribute("month", vo.getMonth());
		ra.addFlashAttribute("day", vo.getDay());
		return "redirect:/quiz/quiz01_ok";
	}
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	@RequestMapping("/quiz02_ok")
	public String quiz02_ok() {
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping(value="join", method = RequestMethod.POST )
	public String join(Quiz01VO vo,
					   RedirectAttributes ra) {
		
		ra.addFlashAttribute("id", vo.getId());
		ra.addFlashAttribute("pw", vo.getPw());
		ra.addFlashAttribute("name", vo.getName());
		ra.addFlashAttribute("email", vo.getEmail());
		
		return "redirect:/quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	@RequestMapping("/quiz03_ok")
	public String quiz03_ok() {
		return "quiz/quiz03_ok";
	}
	
	//본인풀이
	@RequestMapping(value="join2",method = RequestMethod.POST)
	public String join2(Quiz01VO vo,
						@RequestParam("pw_check") String pwc,
						RedirectAttributes ra) {
		
		if(vo.getId() == "") {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(vo.getPw().equals(pwc)) {
			ra.addFlashAttribute("id", vo.getId());
			return "redirect:/quiz/quiz03_ok";
		}else {
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}		
	}
	
	//선생님 풀이
//	@RequestMapping("/join2")
//	public String join2(@RequestParam(value = "id", required = false , defaultValue = "") String id,
//						@RequestParam(value = "pw") String pw,
//						@RequestParam(value = "pw_check") String pwc,
//						RedirectAttributes ra,
//						Model model) {
//		
//		if(id.equals("")) {
//			ra.addFlashAttribute("msg","아이디를 입력하세요");
//			return "redirect:/quiz/quiz03";
//		}else if(!pw.equals(pwc)) {
//			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
//			return "redirect:/quiz/quiz03";
//		}else {
//			model.addAttribute("id",id);
//			return "quiz/quiz03_ok";
//		}
//	}
	
	
	
	
	
	
}
