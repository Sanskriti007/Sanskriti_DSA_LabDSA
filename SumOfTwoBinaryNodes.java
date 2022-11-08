package com.datastructure.assignment;

import java.util.HashSet;
import java.util.Scanner;

public class SumOfTwoBinaryNodes {

		static class Node {
			int data;
			Node left, right;
		};

		static Node NewNode(int data)
		{
			Node temp = new Node();
			temp.data = data;
			temp.left = null;
			temp.right = null;
			return temp;
		}

		static Node insert(Node root, int key)
		{
			if (root == null)
				return NewNode(key);
			if (key < root.data)
				root.left = insert(root.left, key);
			else
				root.right = insert(root.right, key);
			return root;
		}

		static boolean findBTPair(Node root, int sum,HashSet<Integer> set)
		{
			if (root == null)
				return false;

			if (findBTPair(root.left,sum,set))
				return true;

			if (set.contains(sum - root.data)) {
				System.out.println("Pair (" + (sum - root.data)+","+ root.data+")");
				return true;
			}
			else
				set.add(root.data);

			return findBTPair(root.right,sum,set);
		}

		static void findPair(Node root, int sum)
		{
			HashSet<Integer> set = new HashSet<Integer>();
			if (!findBTPair(root, sum, set))
				System.out.print("Pair do not exit" + "\n");
		}

		
		public static void main(String[] args)
		{
			Node root = null;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number of nodes: ");
			int num=sc.nextInt();
			for(int i=0;i<num;i++) {
				System.out.println("Enter Node of Binary Tree: ");
			root = insert(root, sc.nextInt());
			}
            System.out.println("Enter the sum: ");
			int sum = sc.nextInt();
			findPair(root, sum);
			sc.close();
		}
	}


