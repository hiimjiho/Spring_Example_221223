package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04/ex01")
@Controller   // return string => jsp view
public class Lesson04Ex01Controller {
	@Autowired
	private UserBO userBO;
	
	// 회원 가입 페이지 버튼을 누르면
	// http://localhost/lesson04/ex01/add_user_view
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET)
	public String addUserView() {
		//      /WEB-INF/jsp/lesson04/addUser.jsp
		return "lesson04/addUser";
	}
	
	// 여기서 insert
	// http://localhost/lesson04/ex01/add_user
	@PostMapping("/add_user") 
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// insert DB
		userBO.addUser(name, yyyymmdd, email, introduce);
		// UserBO UserMapper  userMapper.xml  User
		// 결과 jsp view
		return "lesson04/afterAddUser";
	}
	
	// http://localhost/lesson04/ex01/get_latest_user_view
	@GetMapping("/get_latest_user_view")
	public String getLatestUserView(Model model) {
		// 가장 최근에 가입된 사람 한명 select DB
		User user = userBO.getLatestUser();
		model.addAttribute("user", user);
		model.addAttribute("title", "회원 정보");
		return "lesson04/getLatestUser";
	}
	
}
