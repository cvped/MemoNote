package com.MemoNote.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MemoNote.post.service.PostService;

@RequestMapping("/post")
@Controller
public class PostController {

	
	@GetMapping("/list-view")
	public String create() {
		return "post/list";
	}

}
