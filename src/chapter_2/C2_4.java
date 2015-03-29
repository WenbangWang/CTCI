package chapter_2;

import linkedlist.*;

public class C2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArray = {1,4,5,6,7,8,2,4,5,7,2,6,7,3,4,};
		FirstLastList<Integer> list = new FirstLastList<Integer>();
		
		for(int i=0;i<intArray.length;i++)
		{
			list.insertLast(intArray[i]);
		}
		
		Node<Integer> node = partition(list.first, 3);
		if(node!=null)
		{
			list.first = node;
			list.displayList();
		}
		
	}
	
	public static Node<Integer> partition(Node<Integer> node, int x)
	{
		if(node==null)
			return null;
		Node<Integer> before = null;
		Node<Integer> after = null;
		
		while(node!=null)
		{
			Node<Integer> next = node.next;
			if(node.data<x)
			{
				node.next = before;
				before = node;
			}
			else
			{
				node.next = after;
				after = node;
			}
			node = next;
		}
		if(before==null)
			return after;
		Node<Integer> head = before;
		
		while(before.next!=null)
		{
			before = before.next;
		}
		before.next = after;
		return head;
		
	}

}
