package com.example.demo.web.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.web.PostsSaveRequestDto;
import com.example.demo.web.domain.PostsRepository;
import com.example.demo.web.dto.PostsMainResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)	// <=> .map(posts -> new PostsMainResponseDto(posts))
                .collect(Collectors.toList());
    }
}
