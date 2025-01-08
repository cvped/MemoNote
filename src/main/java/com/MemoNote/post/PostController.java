package com.MemoNote.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/post")
@Controller
public class PostController {

	// 리스트 화면
	@GetMapping("/list-view")
	public String create() {
		return "post/list";
	}

}
