package com.MemoNote.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MemoNote.post.domain.Post;
import com.MemoNote.post.repository.PostRepository;

@Service
public class PostService {
	
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
		
	
		public Post getPost(int id) {
			
			Optional<Post> optionalPost = postRepository.findById(id);
			
			return optionalPost.orElse(null);
		}
	
		
		
		public boolean updatePost(int id,String title,String contents) {
			
			Optional<Post> optionalPost = postRepository.findById(id);
			
			if(optionalPost.isPresent()) {
				
				Post post = optionalPost.get();
				
				post = post.toBuilder().title(title).contents(contents).build();
				
				try {
					postRepository.save(post);
					return true;
				} catch(Exception e) {
					return false;
			}		
				
		}
			return false;
			
			
		}
			
		
}
