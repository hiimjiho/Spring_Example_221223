package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson04/ex01")
@Controller   // return string => jsp view
public class Lesson04Ex01Controller {
	@Autowired
	private UserBO userBO;

	// http://localhost/lesson04/ex01/add_user_view
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET)
	public String addUserView() {
		//      /WEB-INF/jsp/lesson04/addUser.jsp
		return "lesson04/addUser";
	}
	
	// http://localhost/lesson04/ex01/add_user
	@PostMapping("/add_user") 
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// insert DB
		String rowCount = userBO.addUser(name, yyyymmdd, email, introduce);
		// UserBO UserMapper  userMapper.xml  User
		// 결과 jsp view
		return "lesson04/afterAddUser" + rowCount;
	}
}
