package javabackend.example.javabackend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavabackendApplicationTests {

	@Test
	void contextLoads() {
		// Test to check if the test is working
		int expected = 5;
		int actual = 2 + 3;
		assertEquals(expected, actual, "The test is not working properly.");
		if (expected == actual){
			System.out.println("The test is working properly.");
		}



	}



}
