package com.practice.demo.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringUtility {
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("before test class");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("before each test");
	}

	@Test
	public void testIsPalindrome() {
		System.out.println("testing is palindrome");
		boolean expectedValue =  StringUtility.isPalindrome("PALLAP");		
		
		assertTrue(expectedValue);
		
		assertEquals(StringUtility.isPalindrome("abc"), false);
		
	}
	
	@Test
	public void testCountVowels() {
		System.out.println("testing count vowels");
		
		assertEquals(StringUtility.countVowels("apple"), 2);
		assertEquals(StringUtility.countVowels("lly"), 0);
	}
	
	@AfterEach
	public  void afterEach() {
		System.out.println("testing after each");
		
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("testing after class");
	}
	
}
