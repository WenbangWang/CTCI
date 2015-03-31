package chapter_4;

import java.util.ArrayList;

import linkedlist.*;
import tree.*;

public class C4_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<LinkedList_0<TreeNode>> al = new ArrayList<LinkedList_0<TreeNode>>();
		BSearchTree tree = new BSearchTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		al = insertLinkedList(tree.root);
		for(int i=0;i<al.size();i++)
		{
			Node<TreeNode> node = al.get(i).first;
			while(node!=null)
			{
				node.data.display();
				node = node.next;
			}
		}

	}
	
	public static ArrayList<LinkedList_0<TreeNode>> insertLinkedList(TreeNode root)
	{
		ArrayList<LinkedList_0<TreeNode>> result = new ArrayList<LinkedList_0<TreeNode>>();
		LinkedList_0<TreeNode> list = new LinkedList_0<TreeNode>();
		if(root!=null)
			list.insertFirst(root);
		while(list.size()!=0)
		{
			result.add(list);
			LinkedList_0<TreeNode> parents = list;
			list = new LinkedList_0<TreeNode>();
			Node<TreeNode> node = parents.first;
			TreeNode parent = node.data;
			while(parent!=null)
			{
				if(parent.leftChild!=null)
					list.insertFirst(parent.leftChild);
				if(parent.rightChild!=null)
					list.insertFirst(parent.rightChild);
				node = node.next;
				parent = node.data;
			}
			result.add(list);
		}
		return result;
	}

}
