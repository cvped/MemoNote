package com.MemoNote.user.service;

import org.springframework.stereotype.Service;

import com.MemoNote.user.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	
	
	public boolean addUser(
		 String loginId
		,String name
		,String password
		,String  phoneNumber) {
		
		int count = userRepository.insertUser(loginId, password, name, phoneNumber);
		
		if(count == 1) {
			return true;
		}else {
			return false;
		}
	
	}
}
