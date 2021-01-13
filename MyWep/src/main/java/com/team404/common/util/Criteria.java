package com.team404.common.util;

import lombok.Data;

@Data
public class Criteria {
	//sql문에 전달할 값을 setter, getter로 갖는 기준 클래스
	
	private int pageNum; //페이지 번호
	private int amount; //데이터 개수
	private String searchType;
    private String searchName;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
