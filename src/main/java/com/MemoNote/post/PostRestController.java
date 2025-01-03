package com.MemoNote.post;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {

	
	public postlist(
			@RequestParam("title")String title
			,@RequestParam("contents")String contents
			,@RequestParam("imagePath")String imagePath) {
		
		
		
	}
}
