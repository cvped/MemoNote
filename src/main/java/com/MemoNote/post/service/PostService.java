package com.MemoNote.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemoNote.post.domain.Post;
import com.MemoNote.post.repository.PostRepository;

@Service
public class PostService {
	
		@Autowired
		private  PostRepository postRepository;
		
		public PostService(PostRepository postRepository) {
			this.postRepository = postRepository;
		}

		public boolean addPost(int userId, String title ,String contents) {
			
			
			Post post = Post.builder()
					.userId(userId)
					.title(title)
					.contents(contents)
					.build();
			
			try {
				postRepository.save(post);
				return true;
			} catch(Exception e) {
				return false;
		}
			
			
		}	
		
		public List<Post> getPostList(int userId) {
			
			return postRepository.findByUserIdOrderByIdDesc(userId);
		}
		
		
	
		
}
