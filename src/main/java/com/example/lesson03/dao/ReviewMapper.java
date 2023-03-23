package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewMapper {
	
	public Review selectReview(@Param("id") int id);
	
	public int insertReview(Review review);
	
	
	// @param이 있기 때문에 하나의 맵이 xml로 넘어간다.
	public int insertReviewAsFiled(
			@Param("storeId") int storeId23,
			@Param("menu") String menu23,
			@Param("userName") String userName23,
			@Param("point") Double point23,
			@Param("review") String review23);
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	
	public void deleteReviewById(int id); 
}
