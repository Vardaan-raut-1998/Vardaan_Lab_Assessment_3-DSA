package Problem_2_BST;

import java.util.HashSet;

public class FindSumPair {

	static class TreeNode 
	{
		int key;
		TreeNode left, right;

		public TreeNode(int key) {
			this.key = key;
			this.left = this.right = null;
		}

	}

	private static TreeNode insertTreeNode(TreeNode root, int key) 
	{
		// when root is empty
		if (root == null) {
			// create new node and return:
			return new TreeNode(key);
		}
		// if root key value is greater then key,then insert in left subtree
		if (root.key > key)
			root.left = insertTreeNode(root.left, key);
		// if root key value is smaller then key,then insert in right subtree
		else if (key > root.key)
			root.right = insertTreeNode(root.right, key);
		else {
			// this node is not going to insert in BST
			System.out.println("Duplicate value not allowed in BST :");
			return root;
		}
		return root;
     }

	//  InOrder traversal  BST(ascending order)
	 static void inOrder(TreeNode root) {
		if (root == null)
			return;
		else {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
			}
	 }

	 // function to return is pair exists
	 private static boolean find_Pair(TreeNode root, int sum) 
	 {
		// create HashSet to check is item present in Set [with O(1)].
		HashSet<Integer> data = new HashSet<Integer>();
		return isPairExists(root, data, sum);
	 }

	private static boolean isPairExists(TreeNode root, HashSet<Integer> data, int sum)
	{
		// Base condition
		if (root == null)
			return false;
		int altvalue = sum - root.key;

		if (data.contains(altvalue)) {
			System.out.println("\n\nThe sum pair exists for sum " + sum + " : " + root.key + " & " + altvalue);
			return true;
		} else {
			data.add(root.key);
		}
		boolean conclusion= isPairExists(root.left, data, sum) || isPairExists(root.right, data, sum);
		return conclusion;
	}

	public static void main(String[] args) {
		TreeNode root = null;
		// HardCoded as instructed
		root = insertTreeNode(root, 40);
		root = insertTreeNode(root, 20);
		root = insertTreeNode(root, 60);
		root = insertTreeNode(root, 10);
		root = insertTreeNode(root, 30);
		root = insertTreeNode(root, 50);
		root = insertTreeNode(root, 70);

		// BST as given input
		System.out.println("Tree constructed :");
		System.out.println("\nIn Order traversal of Tree :");
		inOrder(root);
		// Input sum to find out is pair present in tree -> HardCoded
		int sum = 130;
		// Result -> is pair exists
		//(if exists then first pair encountered from root will return true)
		boolean result = find_Pair(root, sum);
		if (!result) {
			System.out.println("\n No Such Pair Exists :");
		}
		System.out.println("\n-------Program Completed Successfully-------");
	}
}
