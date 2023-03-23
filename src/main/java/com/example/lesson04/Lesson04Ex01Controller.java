package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson04/ex01")
@Controller		// return String => jsp view
public class Lesson04Ex01Controller {
	@Autowired
	private UserBO userBO;
	
	// http://localhost/lesson04/ex01/add_user_view
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET)
	public String addUserView() {
		//	/WEB-INF/jsp/lesson04/addUser.jsp
		return "lesson04/addUser";
	}
	
	// http://localhost/lesson04/ex01/add_user
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {		// 필수가 아닐 때에 value와 required=false
		// insert DB
		
		public String insertDB() {
			int rowCount = userBO.addUser(name, yyyymmdd, email, introduce);
			return 
		}
		
		// 결과 jsp view
		return "lesson04/afterAddUser";		//return이 있는 줄에 break point를 걸어서 파람 값이 다 넘어오는지 확인해야하낟
	}
}
