package com.example.quiz.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quiz.dao.SellerMapper;

@Service
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;
	public void insertSeller(String nickname, String profileImageUrl, double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
}
