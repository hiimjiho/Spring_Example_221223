package com.example.quiz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.quiz.bo.SiteBO;

@Controller
@RequestMapping("/quiz")
public class quiz01Controller {
	@Autowired
	private SiteBO siteBO;
	
	// http://localhost/quiz/quiz01
	@GetMapping("/quiz01")
	public String quiz01_1() {
		return "quiz/favoriteSite";
	}
	
	@ResponseBody
	@PostMapping("/quiz01_1")
	public Map<String, Object> quiz01_1(
			@RequestParam("name") String name,
			@RequestParam("url") String url){
		Map<String, Object> result = new HashMap<>();
		
		int rowCount = siteBO.getSite(name, url);
		
		if(rowCount > 0) {
			result.put("code", 1);
			result.put("성공", result);
		}
		
	}
}
