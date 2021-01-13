
package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.common.util.Criteria;
import com.team404.common.util.PageVO;
import com.team404.freeboard.service.FreeBoardService;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;
	
//	//글 상세
//	@RequestMapping(value="/freeDetail", method = RequestMethod.GET)
//	public String freeDetail(@RequestParam("bno") int bno,
//							 Model model) {
//		
//		//화면으로 넘어갈때 bno기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		return "freeBoard/freeDetail";		
//	}
//	//글 수정
//	@RequestMapping(value="freeModify", method = RequestMethod.GET)
//	public String freeModify(@RequestParam("bno") int bno,
//			Model model) {
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		
//		return "freeBoard/freeModify";		
//	}
	//글수정 글상세 코드가 같아서 하나로 묶음.
	@RequestMapping(value={"/freeModify", "/freeDetail"}, method = RequestMethod.GET)
	public void freeModify(@RequestParam("bno") int bno,
			Model model) {
		FreeBoardVO vo = freeBoardService.getContent(bno);
		model.addAttribute("vo", vo);	
		
		//void형 메서드는 요청의 결과가 디스패쳐 서블릿으로 return됩니다.			
	}
	
	//글 목록
	@RequestMapping("/freeList")
	public String freeList(Model model, Criteria cri) {
		
		//기본방식
//		ArrayList<FreeBoardVO> list = freeBoardService.getList();
//		model.addAttribute("list", list);
		
		//페이지방식
//		int total = freeBoardService.getTotal();		
//		PageVO pageVO = new PageVO(cri, total); //		
//		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
//		//화면에 전달할 값들
//		model.addAttribute("list", list);
//		model.addAttribute("pageVO", pageVO);
		
		
		//3. 검색과 페이지
//		System.out.println(cri.toString());
		
		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
//		System.out.println(list.toString());
		
		int total = freeBoardService.getTotal(cri);		
		PageVO pageVO = new PageVO(cri, total); 		
		//화면에 전달할 값들
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		return "freeBoard/freeList";
	}
	
	
	
	
	
	//글 등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	//글 등록
	@RequestMapping(value="/registForm", method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo,
							 RedirectAttributes ra) {
		
		freeBoardService.regist(vo);
		ra.addFlashAttribute("msg", "정상적으로 등록처리 됐습니다");
		
		return "redirect:/freeBoard/freeList";
	}
	
	//글 수정
	@RequestMapping(value="/modifyForm", method = RequestMethod.POST)
	public String modifyForm(FreeBoardVO vo, RedirectAttributes ra) {
		
		int result = freeBoardService.update(vo);
		
//		System.out.println("결과: " + result);
		if(result == 1) { //업데이트 성공
			ra.addFlashAttribute("msg", "수정하였습니다.");
		}else {
			ra.addFlashAttribute("msg", "실패하였습니다.");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	
	//글 삭제
	@RequestMapping(value="/deleteForm", method = RequestMethod.POST)
	public String deleteForm(FreeBoardVO vo) {		
		
		freeBoardService.delete(vo);
		
		return "redirect:/freeBoard/freeList";
	}
	
	
}
















