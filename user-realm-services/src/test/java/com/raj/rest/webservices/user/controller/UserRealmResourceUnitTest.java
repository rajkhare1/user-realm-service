package com.raj.rest.webservices.user.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.raj.rest.webservices.user.User;
import com.raj.rest.webservices.user.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserRealmController.class)
public class UserRealmResourceUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserRepository userRepoMock;
	
	
	
	
	
	String exampleJson = "{\"id\":1,\"name\":\"realmName\",\"description\":\"realmDescription\",\"key\":\"realmKey\"}";
	
	@Test
	public void testRetrieveAllUser() throws Exception{
		
		 List<User> users = new ArrayList(List.of(1,"realmName","realmDescription","realmKey"));
		 when(userRepoMock.findAll()).thenReturn(users);
		 
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/service/user/realm").accept(
					MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println(result.getResponse());
			
			String expected = "{id:1,name:realmName,realmDescription:realmKey}";
			
			JSONAssert.assertNotEquals(expected,result.getResponse()
					.getContentAsString(), false);

	}
	
	@Test
	public void testRetrieveUser() throws Exception{
		
		User user = new User();
		user.setId(1);
		user.setName("realmName");
		user.setDescription("realmDescription");
		user.setKey("realmKey");
		
		 when(userRepoMock.findById(user.getId())).getMock();
		 
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/service/user/realm/1").accept(
					MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println(result.getResponse());
			
			String expected = "{id:1,name:realmName,realmDescription:realmKey}";
			
			JSONAssert.assertNotEquals(expected,result.getResponse()
					.getContentAsString(), false);

	}
	
	
	@Test
	public void testCreateUser() throws Exception{
//			User user = new User();
//			user.setName("realmName");
//			user.setDescription("realmDescription");
//	
//			when(userRepoMock.save(user)).thenReturn(user);
//			
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
//					"/service/user/realm").accept(
//					MediaType.APPLICATION_JSON).content(exampleJson)
//					.contentType(MediaType.APPLICATION_JSON);;
//			
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			System.out.println(result.getResponse());
//			MockHttpServletResponse response = result.getResponse();
//			
//			assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//	
//			assertEquals("http://localhost/service/user/realm",
//					response.getHeader(HttpHeaders.LOCATION));

	}


}
