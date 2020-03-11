package com.example.demo.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WebControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void 메인페이지_로딩() {
		// when
		String body = this.restTemplate.getForObject("/", String.class);
		
		// then
		assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
	}

}
