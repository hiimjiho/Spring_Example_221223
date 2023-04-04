package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserMapper;
import com.example.lesson04.model.User;

@Service
public class UserBO {
	@Autowired 
	private UserMapper userMapper;
	
	// input: 이름 이메일 생년월일 자기소개	output: void or int
	public void addUser(String name, String yyyymmdd, String email, String introduce) {
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	// input:X		output : user(최신 가입자)
	public User getLatestUser() {
		return userMapper.SelectLatestUser();
	}
	
	// input:name 	output:boolean
	public boolean existUserByName(String name) {
		return userMapper.existUserByName(name);
	}
}
