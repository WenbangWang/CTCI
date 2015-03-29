package chapter_2;


import linkedlist.*;

import java.util.HashMap;

public class C2_1 {

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

        deleteDupsWithMap(list.first);
		list.displayList();
	}

    private static void deleteDupsWithMap(Node<Character> node) {
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        Node<Character> previous = null;

        while(node != null) {
            if(map.containsKey(node.data)) {
                previous.next = node.next;
            } else {
                map.put(node.data, true);
                previous = node;
            }

            node = node.next;
        }
    }
	
	public static void deleteDups(Node<Character> node)
	{
		if(node==null)
			return;
		Node<Character> current = node;
		
		while(current!=null)
		{
			Node<Character> runner = current;
			while(runner.next!=null)
			{
				if(runner.next.data==current.data)
				{
					runner.next = runner.next.next;
				}
				else
				{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

}
