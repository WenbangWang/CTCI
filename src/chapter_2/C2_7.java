package chapter_2;

import java.util.Stack;

import linkedlist.*;

public class C2_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] array = {1,2,3,4,5,5,4,3,2,1};
		LinkedList<Integer> list = new LinkedList<Integer>(array);
		
		if(palindrome(list.first))
			System.out.println("T");
		else
			System.out.println("F");
	}
	
	public static boolean palindrome(Node<Integer> node)
	{
		if(node==null)
			return false;
		Stack<Integer> stack = new Stack<Integer>();
		Node<Integer> slow = node;
		Node<Integer> fast = node;
		
		while(fast!=null&&fast.next!=null)
		{
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast!=null)
			slow = slow.next;
		
		while(slow!=null)
		{
			int t = stack.pop();
			if(t!=slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}

}
