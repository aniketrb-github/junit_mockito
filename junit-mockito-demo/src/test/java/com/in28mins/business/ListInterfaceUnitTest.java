package com.in28mins.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListInterfaceUnitTest {
	@SuppressWarnings("rawtypes")
	List listMock;

	// the class/interface to be mocked, new instance is created freshly before each @Test execution
	@BeforeEach
	void init() {
		listMock = mock(List.class);
	}

	@Test
	@DisplayName("list.size() method of List")
	void testListSize_UsingMock() {

		// creating a mock/stub data
		when(listMock.size()).thenReturn(4);
		
		// unit testing the scenario we prepared 
		assertEquals(" invoking list.size() shall return value:4 ", 4, listMock.size());
	}
	
	@Test
	@DisplayName("list.get(index) method of List")
	void testListGet_UsingMock() {
		
		// anyInt() is Argument Matcher - for any integer input it will return 223232 as output
		when(listMock.get(anyInt())).thenReturn(223232);
		
		// invoke list.get() with any index number as input arg
		assertEquals("on invoking list.get(0), it should return value: 223232", 223232, listMock.get(10));
		assertEquals("on invoking list.get(1), it should return value: 223232", 223232, listMock.get(144));
	}
	
	/**
	 * Here we can test if our method to which we test can throw an Exception
	 * For this method you need to use the Junit 4 runner -> Run as configs
	 */
	@org.junit.Test/**/(expected = RuntimeException.class)/**/
	@DisplayName("list.get(index) method of List for exception check")
	public void testListForAnException_UsingMock() {
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Some Runtime Exception was thrown!"));
		
		listMock.get(1);
	}

}
