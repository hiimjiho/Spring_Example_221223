package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController		// @Controller + @ResponseBody
public class Lesson01Ex01RestController {
	
	@RequestMapping("/3")
	// http://localhost:8080/lesson01/ex01/3
	public String ex01_3() {
	return "<h3>RestController를 사용해서 String을 return해본다</h3>";
	}
	
	@RequestMapping("/4")
	// http://localhost:8080/lesson01/ex01/4
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		return map;
	}
	
	@RequestMapping("/5")
	// http://localhost:8080/lesson01/ex01/5
	public Data ex01_5() {
		Data data = new Data();	// 일반 자바 bean(객체)
		data.setId(1);
		data.setName("박지호");
		return data;
	}
	
	@RequestMapping("/6")
	// http://localhost:8080/lesson01/ex01/6
	public ResponseEntity<Data> ex01_6(){
		Data data = new Data(); // 자바 bean
		data.setId(1);
		data.setName("박지호");
		
		//return new ResponseEntity<>(data, HttpStatus.OK);	// 200 ok
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);	// 500 error	
	}
}
