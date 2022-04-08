package algorithm_day16_17;

import java.util.Scanner;

public class StringPermutation {
			/*
		 * method to print permutation of strings using iterative method
		 */
		public static void findPermutationIterative(String string) {

			int length = string.length();
			int f = factorial(length);
			for (int i = 0; i < f; i++) {
				StringBuilder sb = new StringBuilder(string);
				int temp = i;
				for (int div = length; div >= 1; div--) {
					int quotient = temp / div;
					int remainder = temp % div;
					System.out.print(sb.charAt(remainder));
					sb.deleteCharAt(remainder);
					temp = quotient;
				}
				System.out.println();
			}
		}

		public static int factorial(int n) {
			int fact = 1;
			for (int i = 1; i <= n; i++) {
				fact = fact * i;
			}
			return fact;
		}

		/*
		 * method to find string permutation using recursive approach
		 */
		public static void findPermutationRecursive(String string, int left, int right) {
			if (left == right)
				System.out.println(string);
			else {
				for (int i = left; i <= right; i++) {
					string = swap(string, left, i);
					findPermutationRecursive(string, left + 1, right);
					string = swap(string, left, i);
				}
			}
		}

		/*
		 * method to swap the characters using temp variable
		 */
		public static String swap(String a, int i, int j) {
			char temp;
			char[] charArray = a.toCharArray();
			temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
			return String.valueOf(charArray);
	
		}
		

			public static void main(String[] args) {
				System.out.println("Welcome to algorithm and data structure programs");
				
				System.out.println("Iterative method");
				StringPermutation.findPermutationIterative("abc");
				
				System.out.println("Recursive method");
				StringPermutation.findPermutationRecursive("abc", 0, 2);
				
				
				
			}
		}