package com.MemoNote.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MemoNote.user.service.UserService;

@RequestMapping("/user")
@RestController
public class UserRestController {

	private UserService userService;
	
	// API
	@PostMapping("/join")
	public Map<String,String>join(
			@RequestParam("loginId") String loginId
			,@RequestParam("name") String name
			,@RequestParam("password")String password
			,@RequestParam("phoneNumber")int phoneNumber) {
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, name, password, password)) {
			resultMap.put("result", "success");
		}else{
			resultMap.put("result", "fail");
		}
		return resultMap;		
	}
}
