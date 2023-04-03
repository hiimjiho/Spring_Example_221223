package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;
@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO; 
	
	// http://localhost/lesson06/ex01/add_user_view
	@GetMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	// AJAX 통신으로 오는 요청 결과는 반드시 String이다.	responsebody를 반드시 붙여주어야 한다.
	@PostMapping("/add_user")
	@ResponseBody
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,	// 비필수 파라미터
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "성공";
	}
	
	@GetMapping("/result_view")
	public String resultView() {
		return "lesson06/result";
	}
}