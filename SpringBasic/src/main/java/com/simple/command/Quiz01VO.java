package com.simple.command;

public class Quiz01VO {
	
	private String year;
	private int month;
	private String day;
	private String id;
	private String pw;
	private String name;
	private String email;
	
	public Quiz01VO() {
		
	}
	
	public Quiz01VO(String year, int month, String day, String id, String pw, String name, String email) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
}
