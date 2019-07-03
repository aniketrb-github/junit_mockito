package com.in28mins.data.api;

import java.util.List;

/** 
 * Some External Service that is our application
 * 
 * @author Aniket Bharsakale
 */
public interface ITodoService {
	public List<String> retrieveTodoList(String user);
}
