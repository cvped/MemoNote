package com.MemoNote.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// 수정 화면 API
	@PutMapping("/update")
	public Map<String,String> updatelist(
			@RequestParam("id")int id
			,@RequestParam("title")String title
			,@RequestParam("contents")String contents) {
		
		Map<String,String> resultMap = new HashMap<>();
		if(postService.updatePost(id, title, contents)) {
			resultMap.put("result", "success");
		}else{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	@DeleteMapping("/delete")
	public Map<String, String> deleteMemo(
			@RequestParam("id") int id) {
		
		Map<String, String> resultMap = new HashMap<>();
		if(postService.deletePost(id)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	
	
	
	
}
	
	

