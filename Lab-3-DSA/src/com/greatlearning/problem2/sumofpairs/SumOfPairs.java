package com.greatlearning.problem2.sumofpairs;

import java.util.HashSet;
import java.util.Scanner;

public class SumOfPairs {

	Scanner sc = new Scanner(System.in);

	// Represent a node of binary search tree - Node data structure

	public class Node {

		public int key;
		Node left;
		Node right;
	}

	// creation of new node
	public Node newNode(int data) {

		Node temp = new Node();
		temp.key = data;

		temp.left = null;
		temp.right = null;

		return temp;
	}

	// Insert node in BST

	public Node insert(Node root, int key) {

		Node newnode = newNode(key);

		// the next two lines help maintain the path through which we came

		Node x = root; // current node, which will go until null keeps going down the subtree
		Node current_pointer = null; // y maintains pointer to x, aka previous current parent

		while (x != null) {

			current_pointer = x;
			if (key < x.key)
				x = x.left; // copy to left
			else if (key > x.key)
				x = x.right; // copy to right
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}

		// If the root is null, the tree is empty.
		if (current_pointer == null)
			current_pointer = newnode; // insert as a new node
		// assign new node node to the left child
		else if (key < current_pointer.key)
			current_pointer.left = newnode;
		// assign the new node to the right child
		else
			current_pointer.right = newnode;
		// return pointer to new node
		return current_pointer;
	}

	// Inorder traversal
	public void Inorder(Node root) {
		if (root == null)
			return;
		else {
			Inorder(root.left);
			System.out.print(root.key + " ");
			Inorder(root.right);
		}
	}

	// Find pairs
	public boolean findTargetPair(Node root, int sum, HashSet<Integer> set) {

		if (root == null) {
			return false;
		}

		if (findTargetPair(root.left, sum, set)) {

			return true;
		}

		if (set.contains(sum - root.key)) {

			System.out.println("Pair is found " + (sum - root.key) + ", " + root.key);
			return true;
		} else
			set.add(root.key);

		return findTargetPair(root.right, sum, set);

	}

	public void findPairWithSum(Node root, int sum) {

		HashSet<Integer> set = new HashSet<Integer>();

		if (!findTargetPair(root, sum, set)) {
			System.out.println("Pairs do not exist");
		}

		// findTargetPair(root, sum, set); if all pairs are not required
	}
}
