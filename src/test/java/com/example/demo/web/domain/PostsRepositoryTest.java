package com.example.demo.web.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postRepository;
	
	@After
	public void cleanUp() {
		postRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		// given
		postRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("tester")
				.build());
		
		// when
		List<Posts> postsList = postRepository.findAll();
		
		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 본문"));		
	}
	
	@Test
	public void BaseTimeEntiy_등록() {
		// given
		LocalDateTime now = LocalDateTime.now();
		postRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("tester")
				.build());
		
		// when
		List<Posts> postsList = postRepository.findAll();
		
		// then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
		
	}
}
