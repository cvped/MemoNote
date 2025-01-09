package com.MemoNote.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

	// 회원가입 화면
	@GetMapping("/join-view")
	public String joinview() {
		return "user/join";
	}
	// 로그인 화면
	@GetMapping("/login-view")
	public String loginview() {
		return "user/login";
	}
	
	// 로그아웃 
	@GetMapping("/logout-view")
	public String logoutview(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		
		return "redirect:login-view";
	}

	
}
