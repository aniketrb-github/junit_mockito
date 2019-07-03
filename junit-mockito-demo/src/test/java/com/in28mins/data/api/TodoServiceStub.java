package com.in28mins.data.api;

import java.util.Arrays;
import java.util.List;

/**
 * This is a dev defined class which provides mock data 
 * for our junit testing scenario.
 * 
 * @author Aniket Bharsakale
 */
public class TodoServiceStub implements ITodoService {

	@Override
	public List<String> retrieveTodoList(String user) {
		if(user.equals("dummyUser"))
			return Arrays.asList("Spring MVC", "Spring Boot", "Spring Batch", "Hibernate", "MySQL", "AWS");
		else if(user.equals("dummyUser1"))
			return Arrays.asList();
		return null;
	}

}
