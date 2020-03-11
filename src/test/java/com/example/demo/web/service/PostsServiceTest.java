package com.example.demo.web.service;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.PostsSaveRequestDto;
import com.example.demo.web.domain.Posts;
import com.example.demo.web.domain.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostsServiceTest {

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void Dto데이터가_Posts테이블에_저장된다() {
		// given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("tester")
				.content("테스트")
				.title("테스트 타이틀")
				.build();
		
		// when
		postsService.save(dto);
		
		// then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
				
	}

}
