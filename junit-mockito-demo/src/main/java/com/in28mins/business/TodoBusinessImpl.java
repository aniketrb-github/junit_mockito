package com.in28mins.business;

import java.util.ArrayList;
import java.util.List;

import com.in28mins.data.api.ITodoService;
/**
 * For this class we weill be doing JUnit Testing
 * @author Aniket Bharsakale
 */
public class TodoBusinessImpl {
	// some dependency we have in this class
	private ITodoService todoService;

	public TodoBusinessImpl(ITodoService todoService) {
		this.todoService = todoService;
	}
	
	/** 
	 * This is the System Under Test (SUT)
	 * This method is some business logic in our application
	 * for which we'll be writing JUnit test cases 
	 * @param user
	 * @return List of todoss
	 */
	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<>();
		List<String> allTodosList = todoService.retrieveTodoList(user);
		for(String todo : allTodosList) {
			if(todo.contains("Spring"))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}
}
