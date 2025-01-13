package com.MemoNote.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MemoNote.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {

	private PostService postService;
	
	public PostRestController(PostService postService) {
		
		this.postService = postService;
	}
	
	//메모 작성화면 API  
	@PostMapping("/create")
	public Map<String,String>postlist(
			@RequestParam("title")String title
			,@RequestParam("contents")String contents
			,HttpSession session) {
		
		Map<String,String>resultMap = new HashMap<>();
		
		int userId = (Integer)session.getAttribute("userId");
		
		if(postService.addPost(userId, title, contents)) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	
	
}
