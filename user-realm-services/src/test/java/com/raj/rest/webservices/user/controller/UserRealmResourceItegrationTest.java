package com.raj.rest.webservices.user.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRealmResourceItegrationTest{
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();

	
	@Test
	public void testRetrieveAllUser() throws JSONException, IOException, JsonProcessingException {
		
		
////		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
////
////		ResponseEntity<String> response = restTemplate.exchange(
////				createURLWithPort("/service/user/realm"),
////				HttpMethod.GET, entity, String.class);
////
////		String expected = "{id:Course1,name:Spring,description:10 Steps}";
////
////		JSONAssert.assertEquals(expected, response.getBody(), false);
//	
//		ResponseEntity<String> response = restTemplate.getForEntity("/service/user/realm", String.class);
//		 
//	    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//	 
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    JsonNode responseJson = objectMapper.readTree(response.getBody());
//	 
//	    assertThat(responseJson.isMissingNode(), is(false));
//	    assertThat(responseJson.toString(), equalTo("[]"));
	}
	
//	private String createURLWithPort(String uri) {
//		return "http://localhost:" + port + uri;
//	}
	

	
}

