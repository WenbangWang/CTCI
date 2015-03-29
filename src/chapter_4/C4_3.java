package chapter_4;

import tree.*;

public class C4_3 {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,2,3,4,5,6,7,8,9};
		BSearchTree tree = insertTree(array);
		tree.inOrder(tree.root);
	}
	
	public static BSearchTree insertTree(int[] array)
	{
		BSearchTree tree = new BSearchTree();
		insert(tree.root, array, 0, array.length-1);
		return tree;
	}
	
	public static void insert(TreeNode node, int[] array, int start, int end)
	{
		if(start>end)
			return;
		int mid = (start+end)/2;
		node.data = array[mid];
		if(start<=mid-1)
			node.leftChild = new TreeNode();
		insert(node.leftChild, array, start, mid-1);
		if(mid+1<=end)
			node.rightChild = new TreeNode();
		insert(node.rightChild, array, mid+1, end);
	}

	
	

}
