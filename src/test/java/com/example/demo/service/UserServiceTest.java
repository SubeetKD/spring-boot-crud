package com.example.demo.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

			assertThat(savedUser).isEqualTo(user);
		}
		
		@Test
		@DisplayName(" Test the api for retriving information.")
		void testUserCreation() throws IOException {
			// Given
			User user = new User("Subeet kumar Dutta");
			when(repo.save(user)).thenReturn(user);
			
			// when
			User savedUser = service.addUser(user);
			
			// then
			assertThat(user).isEqualTo(savedUser);
		}
		
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
