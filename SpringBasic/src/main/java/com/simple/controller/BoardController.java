package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	
	
	@RequestMapping("/boardRegister")
	public String boardRegister() {		
		return "service/boardRegister";
	}
	
	@RequestMapping("/boardResult")
	public String boardResult() {
		return "service/boardResult";
	}
	
	
	@RequestMapping("/boardForm")
	public String boardForm(BoardVO vo,
							RedirectAttributes ra,
							Model model) {		
		
		if(vo.getName().equals("")) {
			ra.addFlashAttribute("msg", "이름을 입력하세요");
			return "redirect:/service/boardRegister";
		}else if(vo.getTitle().equals("")) {
			ra.addFlashAttribute("msg", "제목을 입력하세요");
			return "redirect:/service/boardRegister";
		}else {			
			boardService.boardRegist(vo);
			return "service/boardResult";
		}
		
		
		
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		ArrayList<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
		return "service/boardList";
	}
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num) {
		boardService.boardDelete(num);
		return "redirect:/service/boardList";
	}
	
	
}
