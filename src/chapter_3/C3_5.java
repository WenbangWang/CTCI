package chapter_3;

import java.util.Stack;

public class C3_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		C3_5 c = new C3_5();
		MyQueue queue = c.new MyQueue();
		for(int i=0;i<10;i++)
			queue.enqueue(i);
		
		System.out.println(queue.dequeue());
		for(int i=10;i<20;i++)
			queue.enqueue(i);
		int size = queue.size();
		for(int i=0;i<size;i++)
		{
			System.out.println("i: "+i);
			System.out.println(queue.dequeue());
		}

	}
	
	public class MyQueue
	{
		private Stack<Integer> queue;
		private Stack<Integer> buffer;
		
		public MyQueue()
		{
			queue = new Stack<Integer>();
			buffer = new Stack<Integer>();
		}
		
		public int size()
		{
			return queue.size()+buffer.size();
		}
		
		public void shiftStack()
		{
			if(queue.isEmpty())
			{
				while(!buffer.isEmpty())
				{
					queue.push(buffer.pop());
				}
			}
		}
		
		public void enqueue(int d)
		{
			buffer.push(d);
		}
		
		public int dequeue()
		{
			shiftStack();
			return queue.pop();
		}
	}

}
