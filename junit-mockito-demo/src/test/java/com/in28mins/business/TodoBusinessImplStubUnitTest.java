package com.in28mins.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

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

	@Test
	void testRetrieveTodosRelatedToSpring_UsingMock() {
		// creates a mock for this particular interface/class
		ITodoService todoServiceMock = mock(ITodoService.class);
		
		// mock data creation : here an dummy list is created
		when(todoServiceMock.retrieveTodoList("dummyUser")).thenReturn(Arrays.asList("Spring MVC", "Spring Boot", "Spring Batch", "Hibernate", "MySQL", "AWS"));

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser");
		
		assertEquals("should return 3 spring named objects", 3, filteredTodoList.size());
	}
	
	@Test
	void testRetrieveTodosRelatedToSpring_UsingMockWithEmptyList() {
		// creates a mock for this particular interface/class
		ITodoService todoServiceMock = mock(ITodoService.class);
		
		// mock data creation : here an empty list is created
		when(todoServiceMock.retrieveTodoList("dummyUser")).thenReturn(Arrays.asList());

		// using the mock data to feed the Impl class
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// invoking our main unit testing method
		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser");
		
		assertEquals("should return 3 spring named objects", 0, filteredTodoList.size());
	}	
	
	
	
	
	/*
	@Test
	void testRetrieveTodosRelatedToSpring_UsingStub() {
		ITodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser");	
		assertEquals("should return 3 spring named objects", 3, filteredTodoList.size());
	}
	
	@Test
	void testRetrieveTodosRelatedToSpring_UsingEmptyStub() {
		ITodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodoList = todoBusinessImpl.retrieveTodosRelatedToSpring("dummyUser1");	
		assertEquals("should return empty list i.e 0 objects", 1, filteredTodoList.size());
	}
*/

}
