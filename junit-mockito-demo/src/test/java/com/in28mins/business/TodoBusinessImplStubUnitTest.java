package com.in28mins.business;

import static org.junit.Assert.assertEquals;

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


}
