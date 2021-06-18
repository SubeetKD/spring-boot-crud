package com.example.demo.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.restClient.RestClient;

@SpringBootTest
@TestInstance(Lifecycle.PER_METHOD)
class UserServiceTest {

	@Autowired
	private UserService service;
	
	@Mock
	private UserRepository repo;
	
	@Nested
	@DisplayName("Test for adding user")
	class TestAddUser {

		@Test
		@DisplayName(" Normal adding of user.")
		void addUser() {
			User user = new User("Subeet Kumar Dutta");
			when(repo.save(user)).thenReturn(user);

			User savedUser = service.addUser(user);

			// NOTE: the generated id is different, so pass it like this.
//			System.out.println("The id of the generated user is " + user.getId());

			assertThat(savedUser).isEqualTo(user);
			// assertThat(savedUser.getId()).isEqualTo(user.getId());
			// assertThat(savedUser.getName()).isEqualTo(user.getName());
		}
		
		/*
		 * Testing That creation of user take place.
		 * The addition of adhar info should take place at controller, so that testing can be done.
		 * Currently this is hitting the database and mocking is not working as expected.
		 */
		@Test
		@DisplayName(" Test the api for retriving information.")
		void testUserCreation() throws IOException {
			// Given
			User user = new User("Subeet kumar Dutta");
			when(repo.save(user)).thenReturn(user);
			
			// when
			User savedUser = service.addUser(user);
			
			System.out.println("The adhar number is : " + user.getAdharNumber());
			System.out.println("The adhar number is : " + savedUser.getAdharNumber());
			
			// then
			assertThat(user).isEqualTo(savedUser);
		}
		
		/*
		 * TODO: Complete this.
		 * Get the additional info from the rest service.
		 * chech if creation of entity is taking place or not.
		 */
//		@Test
//		@DisplayName(" getting the adhar.")
//		void testAdhar() {
//			User user = new User("Subeet");
//			when(repo.save(user)).thenReturn(user);
//		}
		
		@Test
		@DisplayName(" If user name is empty.")
		void emptyName() {
			// given
			User user = new User(1, "");
			when(repo.save(user)).thenReturn(user);
			
			// when
			// Hello executable = () -> service.addUser(user);
			
			// then;
			assertThrows(BusinessException.class, () -> service.addUser(user), "Should Throw Buiseness exception" );
		}

		@Test
		@DisplayName(" If name is null")
		void nullName() {
			// given
			User user = new User(1, null);
			when(repo.save(user)).thenReturn(user);

			// when service.addUser(user)

			// then
			assertThrows(BusinessException.class, () -> service.addUser(user), "Name is null");
		}

		void testIllegalArugments() {
			// given
			// TODO: How to do IllegalArgumentsException in spring boot.
		}
	}
}
