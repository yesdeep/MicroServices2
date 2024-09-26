package com.practice.demo.utility;

public class StringUtility {
	public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
	
	
	public static int countVowels(String input) {
        if (input == null) return 0;
        int count = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
