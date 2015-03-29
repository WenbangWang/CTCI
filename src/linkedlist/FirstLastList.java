package linkedlist;


public class FirstLastList<T>{
	
	public Node<T> first;
	public Node<T> last;
	private int count;
	
	public FirstLastList()
	{
		first = null;
		last = null;
		count = 0;
	}
	
	public FirstLastList(T[] t)
	{
		count = 0;
		for(int i=0;i<t.length;i++)
		{
			insertLast(t[i]);
			count++;
		}
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}
	
	public void displayList()
	{
		if(first==null)
			System.out.println("Nothing in the list!");
		else
		{
			System.out.print("LinkedList (first->last): ");
			Node<T> current = first;
			while(current!=null)
			{
				current.displayNode();
				current = current.next;
			}
		}
		System.out.println();
	}
	
	public void insertFirst(T key)
	{
		Node<T> node = new Node<T>(key);
		if(isEmpty())
			last = node;
		node.next = first;
		count++;
		first = node;
	}
	
	public void insertLast(T key)
	{
		Node<T> node = new Node<T>(key);
		if(isEmpty())
			first = node;
		else
			last.next = node;
		last = node;
		count++;
	}
	
	public Node<T> deleteFirst()
	{
		Node<T> temp = first;
		if(first.next==null)
			last = null;
		first = first.next;
		count--;
		return temp;
	}
	
	public Node<T> find(T key)
	{
		if(first==null)
		{
			System.out.println("Nothing in the list!");
			return null;
		}
		Node<T> current = first;
		while(current.data!=key)
		{
			if(current.next!=null)
				current = current.next;
			else
				return null;
		}
		count--;
		return current;
	}
	
	public Node<T> delete(T key)
	{
		if(first==null)
		{
			System.out.println("Nothing in the list!");
			return null;
		}
		Node<T> current = first;
		Node<T> previous = first;
		while(current.data!=key)
		{
			if(current.next!=null)
			{
				previous = current;
				current = current.next;
			}
			else
				return null;
		}
		if(current==first)
		{
			current = first.next;
		}
		else
		{
			previous.next = current.next;
		}
		count--;
		return current;		
	}	
	
	public int size()
	{
		return count;
	}
	public void reverse()
	{
		Node<T> current = first;
		Node<T> next = first.next;
		Node<T> loopNode = null;
		
		while(next!=null)
		{
			current.next = loopNode;
			loopNode = current;
			current = next;
			next = next.next;
		}
		current.next = loopNode;
		first = current;
	}
	
	public Node<T> reverse(Node<T> node)
	{
		Node<T> current = node;
		Node<T> next = node.next;
		Node<T> loopNode = null;
		
		while(next!=null)
		{
			current.next = loopNode;
			loopNode = current;
			current = next;
			next = next.next;
		}
		current.next = loopNode;
		node = current;
		return node;
	}


}
