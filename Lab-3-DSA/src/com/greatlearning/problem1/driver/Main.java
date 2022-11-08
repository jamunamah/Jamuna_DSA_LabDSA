package com.greatlearning.problem1.driver;

import com.greatlearning.problem1.balancedbrackets.BalancedBrackets;

// Driver code
public class Main {

	public static void main(String[] args) {

		BalancedBrackets balancedbrackets = new BalancedBrackets();
		String str = "{[{]}";

		boolean result = balancedbrackets.areBracketsBalanced(str);

		// Printing result
		if (result)
			System.out.println("The entered string has Balanced Brackets.");
		else
			System.out.println("The entered string does not contain Balanced Brackets.");

		System.out.println("\nProgram completed successfully!!!");

	}

}
