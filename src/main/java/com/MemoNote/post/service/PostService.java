package com.MemoNote.post.service;

import org.springframework.stereotype.Service;

import com.MemoNote.post.domain.Post;
import com.MemoNote.post.repository.PostRepository;

@Service
public class PostService {
	
		private PostRepository postRepository;

		public boolean addPost(int userId,String title ,String contents,String imagePath) {
			
			
			Post post = Post.builder()
					.userId(userId)
					.title(title)
					.contents(contents)
					.imagePath(imagePath)
					.build();
			
			try {
				postRepository.save(post);
				return true;
			} catch(Exception e) {
				return false;
		}
			
			
		}	
}
