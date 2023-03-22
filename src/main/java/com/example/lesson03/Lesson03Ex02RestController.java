package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {
		Review review = new Review();	// 일반 java bean
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("박지호");
		review.setPoint(3.5);
		review.setReview("혼자 먹기 적당하네요");
		
		// review 내용을 null로 하더라도 쿼리에 컬럼을 넣어주어야 한다
		
		int rowCount = reviewBO.addReview(review);
		
		return "성공된 행의 개수:" + rowCount;
	}
	// http://localhost/lesson03/ex02/2
	@RequestMapping("/2")
	public String ex02_2() {
		int rowCount = reviewBO.addReviewAsFiled(4, "콤비네이션R", "삐융", 5.0, "맛있게 잘 먹었습니다");
		return "성공한 행의 개수:" + rowCount;
	}
	
}
