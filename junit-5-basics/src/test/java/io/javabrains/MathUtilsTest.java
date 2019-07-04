 package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * JUnit Test class for MathUtils
 * @author Aniket Bharsakale
 */
public class MathUtilsTest {

	MathUtils mathUtils;
	
	@BeforeAll
	static void beforeEachInit() {
		System.out.println("|Before Everything starts|");
	}
	
	// before executing each @Test method execution
	@BeforeEach
	public void init() {
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanUp () {
		System.out.print("|Code Cleaning up|");
	}
	
	@Nested
	class AddTest {

		@Test
		@DisplayName("add() test method for positive numbers")
		void testAdd_poisitiveNumbers() {
			int expected = 3;
			int actual = mathUtils.add(1, 2);
			assertEquals(expected, actual, "add() method should add two Positive numbers");
		}

		@Test
		@DisplayName("add() test method for negative numbers")
		void testAdd_NegativeNumbers() {
			assertEquals(-2, mathUtils.add(-1, -1), "add() method should add two Negative numbers");
		}
		
		@Test
		@DisplayName("add() test method for Postive & Negative Numbers")
		void testAdd_PositiveNegativeNos() {
			assertEquals(5, mathUtils.add(10, -5), "add() method should add a positive & a negative number" );
		}

	}

	@Nested
	class DivideTest {

		@Test
		@DisplayName("divide() test case for dividing 2 numbers")
		void testDivide_ByTwosNos() {
			assertAll( 
					() -> assertEquals(1, mathUtils.divide(14, 14), "divide() should divide the given 2 positive numbers"),
					() -> assertEquals(-1, mathUtils.divide(14, -14), "divide() should divide the a positive numerator with a negative denominator number"),
					() -> assertEquals(-1, mathUtils.divide(-14, 14), "divide() should divide the a negative numerator with a positive denominator number"),
					() -> assertEquals(1, mathUtils.divide(-14, -14), "divide() should divide the given 2 negative numbers"),
					() -> assertEquals(0, mathUtils.divide(0, 14), "divide() should divide the given 2 numbers")
					);
		}

		@Test
		@DisplayName("divide() test case for divide by zero")
		void testDivide_ByZero() {
			 assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0), "Divide by Zero should throw ");
		}
		
	}

}
   