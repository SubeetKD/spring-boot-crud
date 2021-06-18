package com.example.demo.restClient;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_METHOD)
class RestClientTest {

	@Test
	@DisplayName("Testing the fake api")
	void testConstantApi() {
		String curname = "112121212";
		
		String response = RestClient.getAdhar();
		
		assertThat(response).isNotEqualTo(curname);
	}
	
}
