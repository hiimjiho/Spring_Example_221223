package com.example.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quiz.bo.SellerBO;
@RequestMapping("/quiz")
@Controller
public class quizController {
	@Autowired
	private SellerBO sellerBO;
	
	@GetMapping("/1")
	public String quiz01_1() {
		return "quiz/quiz01";
	}
	
	@PostMapping("/2")
	public String quiz01_2(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		sellerBO.insertSeller(nickname, profileImageUrl, temperature);
		return "quiz/afterAddSeller";
	}
}
