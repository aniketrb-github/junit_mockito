package com.in28mins.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.in28mins.data.api.ITodoService;
import com.in28mins.data.api.TodoServiceStub;

/**
 * JUnit Class for TodoBusinessImpl class
 * Here we write a test case using the dev defined Stud class which
 * provides a dummy data for dummy user
 *  
 * @author Aniket Bharsakale
 */
public class TodoBusinessImplStubUnitTest {
	ITodoService todoServiceMock;
	
	@BeforeAll
	static void beforeEverything() {
		System.out.println("Super Duper initialization before all gets started !");
	}
	
	@BeforeEach
	void init() {
		todoServiceMock = mock(ITodoService.class);
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleanup after each method is executed!");
	}
	
	@AfterAll 
	static void superCleanUp() {
		System.out.println("Final Shminal Cleanup after all is executed!");
	}
	
	@Test
	@DisplayName("retrieveTodosRelatedToSpring() method using Solid Mock")
	void testRetrieveTodosRelatedToSpring_UsingMock() {
		// creates a mock for this particular interface/class
		todoServiceMock = mock(ITodoService.class);

		// mock data creation : here an dummy list is created
		when(todoServiceMock.retrieveTodoList("dummyUser"))
				.thenReturn(Arrays.asList("Spring MVC", "Spring Boot", "Spring Batch", "Hibernate", "MySQL", "AWS"));

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser");

		assertEquals("should return 3 spring named objects", 3, filteredTodoList.size());
	}
	
	@Test
	@DisplayName("retrieveTodosRelatedToSpring() method using Empty Mock")
	void testRetrieveTodosRelatedToSpring_UsingMockWithEmptyList() {
		// creates a mock for this particular interface/class
		todoServiceMock = mock(ITodoService.class);

		// mock data creation : Empty list as mock data
		when(todoServiceMock.retrieveTodoList("dummyUser")).thenReturn(Arrays.asList());

		// using the mock data to feed the Impl class
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// invoking our main unit testing method
		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser");

		assertEquals("should return 3 spring named objects", 0, filteredTodoList.size());
	}	
	
	@Test
	@DisplayName("retrieveTodosRelatedToSpring() method using dev created Stub")
	void testRetrieveTodosRelatedToSpring_UsingStub() {
		ITodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser");	
		assertEquals("should return 3 spring named objects", 3, filteredTodoList.size());
	}
	
	@Test
	@DisplayName("retrieveTodosRelatedToSpring() method using dev created empty Stub")
	void testRetrieveTodosRelatedToSpring_UsingEmptyStub() {
		ITodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser1");	
		assertEquals("should return empty list i.e 0 objects", 0, filteredTodoList.size());
	}
}
