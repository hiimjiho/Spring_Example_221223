package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewMapper;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// input: X  output: List<Review>
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	// input: review 	output: int(성공한 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	//addReviewAsFiled(4, "콤비네이션R", "삐융", 5.0, "맛있게 잘 먹었습니다");
	public int addReviewAsFiled(int storeId, String menu, String userName,
			Double point, String review) {
		return reviewMapper.insertReview(storeIdlll, menulll, userNamelll, pointlll, reviewlll);
	}
	
}
