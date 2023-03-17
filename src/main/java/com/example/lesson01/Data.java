package com.example.lesson01;

public class Data {
	// 필드
	private int id;
	private String name;
	
	// 메소드
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {	// 
		return this.name;
	}
	
	public void setName(String name) { // 외부에서 받아온 name을 저장한다
		 this.name = name;
	}
}
