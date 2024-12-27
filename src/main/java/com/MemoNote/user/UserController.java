package com.MemoNote.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

	// 회원가입 화면
	@GetMapping("/join-view")
	public String inputJoin() {
		return "user/join";
	}
	
	
}
