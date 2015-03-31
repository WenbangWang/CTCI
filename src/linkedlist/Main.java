package linkedlist;

import java.util.Arrays;

public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Integer[] i1 = {2,5,3,7,8,2};
		Integer[] i2 = {4,6,3,5,6,7,9};
		Arrays.sort(i1);
		Arrays.sort(i2);
		LinkedList_0<Integer> list1 = new LinkedList_0<Integer>(i1);
		LinkedList_0<Integer> list2 = new LinkedList_0<Integer>(i2);
		
		LinkedList_0<Integer> result = new LinkedList_0<Integer>(mergeLinkedList(list1.first, list2.first));
		System.out.println(result.size());
		result.displayList();
	}
	
	public static Node<Integer> mergeLinkedList(Node<Integer> node1, Node<Integer> node2)
	{
		if(node1==null&&node2!=null)
			return node2;
		else if(node2==null&&node1!=null)
			return node1;
		else if(node1==null&node2==null)
			return null;
		
		Node<Integer> first = new Node<Integer>();
		Node<Integer> current = first;
		
		while(node1!=null&&node2!=null)
		{
			if(node1.data>node2.data)
			{
				current.data = node2.data;
				node2 = node2.next;
			}
			else
			{
				current.data = node1.data;
				node1 = node1.next;
			}
			current.next = new Node<Integer>();
			current = current.next;
		}
		while(node1!=null)
		{
			current.data = node1.data;
			node1 = node1.next;
			current.next = new Node<Integer>();
			current = current.next;
		}
		
		while(node2!=null)
		{
			current.data = node2.data;
			node2 = node2.next;
			current.next = new Node<Integer>();
			current = current.next;
		}
		return first;
		
	}

}
