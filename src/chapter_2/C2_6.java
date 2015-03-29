package chapter_2;

import linkedlist.*;

public class C2_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] array = {1,4,5,2,3,6,7};
		FirstLastList<Integer> list = new FirstLastList<Integer>(array);
		
		list.last.next = list.first.next.next.next.next;
		Node<Integer> node = findHead(list.first);
		
		node.displayNode();

	}
	
	public static Node<Integer> findHead(Node<Integer> node)
	{
		if(node==null)
			return null;
		Node<Integer> slow = node;
		Node<Integer> fast = node;
		
		while(fast!=null&&fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast)
				break;
		}
		
		if(fast==null||fast.next==null)
			return null;
		
		slow = node;
		while(slow!=fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}

}
