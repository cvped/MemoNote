package com.MemoNote.post;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MemoNote.post.domain.Post;
import com.MemoNote.post.service.PostService;

import jakarta.servlet.http.HttpSession;




@RequestMapping("/post")
@Controller
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// 리스트 화면
	@GetMapping("/list-view")
	public String list(
			Model model
			,HttpSession session) {

		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> list = postService.getPostList(userId);
		
		model.addAttribute("list", list);
		
		
		return "post/list";
	}
	
	//  메모 작성 페이지
	@GetMapping("/create-view")
	public String create() {
		return "post/create";
	}
	
	@GetMapping("/detail-view")
	public String detail() {
		return "post/detail";
	}
	

}
