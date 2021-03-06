package com.team404.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;
import com.team404.reply.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	@Qualifier("replyService")
	private ReplyService replyService;
	
	//등록요청
	@PostMapping("/replyRegist")
	public int replyRegist(@RequestBody ReplyVO vo) {
		
		int result = replyService.replyRegist(vo);		
		
		return result; //레스트컨트롤러 return결과는 호출구문으로 갑니다.(ResponseBody)
	}	
	
    // 목록요청
    @GetMapping("/getList/{bno}/{pageNum}")
    public HashMap<String, Object> getList(@PathVariable("bno") int bno,
    								  @PathVariable("pageNum") int pageNum){
    	
    	//1. 화면에서 더보기 버튼을 생성하고, 처음실행될 때 pageNum 1번과 해당 게시글번호를 보냅니다.
    	//2. getList(bno, cri)를 받습니다.
    	//3. mybatis에 매개값이 2개 전달되는 경우@Param어노테이션을 사용합니다.
    	//4. 페이징 쿼리구문을 실행
    	
    	//데이터
    	Criteria cri = new Criteria(pageNum, 20); //20개의 데이터    	
        ArrayList<ReplyVO> list = replyService.getList(bno, cri);
        
        System.out.println(list.size());
        
        //게시글에 대한 total
        int total = replyService.getTotal(bno);
        
        //맵에 키, value로 저장해서 반환.
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", total);
        return map;
    }
    
    @PostMapping("/update")
    public int update(@RequestBody ReplyVO vo){
    	
    	int result = replyService.update(vo);    	
    	System.out.println("성공:" + result);
    	
    	return result; //업데이트 성공시 1반환, 실패시 0반환
    }
    
    @PostMapping("/delete")
    public int delete(@RequestBody ReplyVO vo) {
    	
    	int result = replyService.pwCheck(vo);    	
    	if(result == 1) { //비밀번호가 맞은경우
    		return replyService.delete(vo);
    	}else { //비밀번호 틀린경우
    		return -1;
    	}    	
//    	int result = replyService.delete(vo);    	
    	
    }
}
