package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.web.domain.PostsRepository;
import com.example.demo.web.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
//	private PostsRepository postsRepository;
	private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
//		postsRepository.save(dto.toEntity());
		return postsService.save(dto);
	}
}
