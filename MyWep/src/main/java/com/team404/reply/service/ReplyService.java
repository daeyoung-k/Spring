package com.team404.reply.service;

import java.util.ArrayList;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;

public interface ReplyService {
	
	public int replyRegist(ReplyVO vo);
	public ArrayList<ReplyVO> getList(int bno, Criteria cri);
	public int getTotal(int bno); //게시글에 대한 댓글개수
	
	public int update(ReplyVO vo); //댓글수정
	public int delete(ReplyVO vo); //비밀번호 검증
	public int pwCheck(ReplyVO vo); //댓글 삭제
}
