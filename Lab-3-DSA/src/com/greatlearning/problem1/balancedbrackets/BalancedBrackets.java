package com.greatlearning.problem1.balancedbrackets;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {

	public boolean areBracketsBalanced(String str) {

		// Using dynamic construct
		Deque<Character> myStack = new ArrayDeque<Character>();

		// Stack<Character> myStack = new Stack<Character>();

		// Traversing the bracket expression
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {
				// Push the element into the stack
				myStack.push(ch);
				continue;
			}

			if (myStack.isEmpty())
				return false;

			char check;

			switch (ch) {
			case ')':
				check = myStack.pop();
				if (check == '{' || check == '[') // unbalanced situation
					return false;
				break;

			case '}':
				check = myStack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = myStack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (myStack.isEmpty());
	}

}