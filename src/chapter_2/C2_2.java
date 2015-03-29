package chapter_2;

import linkedlist.*;

public class C2_2 {

	public static int counter = 0;
	public static void main(String[] args) {
		String str = "FOLLOW UP";
		FirstLastList<Character> list = new FirstLastList<Character>();
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++)
		{
			list.insertLast(charArray[i]);
		}
		
		Node<Character> node = findk(list.first, 5);
		System.out.println(node.data);

	}
	
	public static Node<Character> recFindk(Node<Character> node, int k)
	{
		if(node==null)
			return null;
		
		Node<Character> current = recFindk(node.next, k);
		
		counter++;
		if(counter==k)
			return node;
		return current;
	}
	
	public static Node<Character> findk(Node<Character> node, int k)
	{
		
		if(node==null)
			return null;
		
		Node<Character> current = node;
		
		for(int i=0;i<k;i++)
		{
			if(current==null)
				return null;
			current = current.next;
		}
		
		if(current==null)
			return null;
		
		Node<Character> runner = node;
		
		while(current!=null)
		{
			runner = runner.next;
			current = current.next;
		}
		
		return runner;
	}

}
