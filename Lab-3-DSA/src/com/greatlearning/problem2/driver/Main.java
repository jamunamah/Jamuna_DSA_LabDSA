package com.greatlearning.problem2.driver;

import java.util.Scanner;

import com.greatlearning.problem2.sumofpairs.SumOfPairs;
import com.greatlearning.problem2.sumofpairs.SumOfPairs.Node;

public class Main {
	
	public static void main(String[] args) {

		SumOfPairs sumOfPairs = new SumOfPairs();

		Scanner sc = new Scanner(System.in);
		int sum, exit = -1;

		Node root = null;

		// String status = "a";

		while (exit != 0) {

			System.out.println(

					"\n1. Insert nodes\n2. Find pairs of target value\n0. exit\nEnter your choice");

			exit = sc.nextInt();

			switch (exit) {

			case 0:

				exit = 0;

				break;

			case 1:

				int value, num;
				
				System.out.println("Enter no of values: ");
				num = sc.nextInt();
				
				Node result = null;
				
				for (int i = 0; i < num; i++) {
					System.out.println("\nInsert value at " + (i + 1) + ": ");
					value = sc.nextInt();
					
					if (root == null) {
						root = sumOfPairs.insert(root, value);
					} else {
						result = sumOfPairs.insert(root, value);
						if (result.key == value)
							i -= 1;
					}
					System.out.println("Inorder of Binary Tree\n");
					
					sumOfPairs.Inorder(root);
				}
				break;

			case 2:

				System.out.println("Enter target sum: ");

				sum = sc.nextInt();

				sumOfPairs.findPairWithSum(root, sum);

				break;

			default:

				System.out.println("Invalid Input");

			}

		}

		System.out.println("\nProgram completed successfully!!!");
		sc.close();

	}

}
