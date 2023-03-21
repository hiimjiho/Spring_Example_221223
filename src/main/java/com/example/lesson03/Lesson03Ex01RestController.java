package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {
	@Autowired
	private ReviewBO reviewBO;
	
	
	// http://localhost/lesson03/ex01?id=5
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터 2개 이상일 때에는 파리미터에 value="id"
			//@RequestParam(value="id") int id	// 필수 파라미터
			//@RequestParam(value="id", required=true) int id	// 필수 파라미터
			//@RequestParam(value="id", required=false) Integer id	//비 필수 파라미터?id=id값을 안 붙여도 나옴
			//@RequestParam(value="id", defaultValue="1") int id	// 비필수 이면서 디폴트 값은 1
			) {
		return reviewBO.getReview(id);	// list -> json
	}
}
