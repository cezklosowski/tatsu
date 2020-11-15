package com.cezklosowski.module.home;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest2 {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnHelloWorld() {
		// given
		String url = "http://localhost:" + port + "/hello";
		// when
		String response = this.restTemplate.getForObject(url, String.class);
		// then
		assertThat(response).isEqualTo("Hello World");
	}

	@Test
	public void shouldReturnGoAway() {
		// given
		String url = "http://localhost:" + port + "/by";
		// when
		String response = this.restTemplate.getForObject(url, String.class);
		// then
		assertThat(response).isEqualTo("Go away");
	}

}
