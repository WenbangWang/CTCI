package chapter_2;

import linkedlist.FirstLastList;
import linkedlist.Node;

public class C2_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "aaabbbccc";
		FirstLastList<Character> list = new FirstLastList<Character>();
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++)
		{
			list.insertLast(charArray[i]);
		}
		
		Node<Character> node = list.first.next.next.next;
		if(deleteNode(node))
			list.displayList();

	}
	
	public static boolean deleteNode(Node<Character> node)
	{
		if(node==null|node.next==null)
			return false;
		
		Node<Character> next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}

}
