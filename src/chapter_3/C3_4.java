package chapter_3;

import java.util.Stack;


public class C3_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int a = 3;
		
		Tower[] towers = new Tower[n];
		C3_4 c = new C3_4();
		
		for(int i=0; i<3; i++)
		{
			towers[i] = c.new Tower(i);
		}
		
		for(int i=a-1; i>=0;i--)
		{
			towers[0].add(i);
		}
		
		towers[0].moveDisks(a, towers[2], towers[1]);

	}
	
	public class Tower
	{
		private Stack<Integer> stack;
		private int index;
		
		public Tower(int i)
		{
			stack = new Stack<Integer>();
			index = i;
		}
		
		public int index()
		{
			return index;
		}
		
		public void add(int d)
		{
			if(!stack.isEmpty()&&stack.peek()<=d)
			{
				System.out.println("Error on Placing plate " + d);
			}
			else
				stack.push(d);
		}
		
		public void moveTopTo(Tower t)
		{
			int top = stack.pop();
			t.add(top);
			System.out.println("Move Disk " + top + " From " + index() + " To " + t.index());
		}
		
		public void moveDisks(int n, Tower destination, Tower buffer)
		{
			if(n>0)
			{
				moveDisks(n-1, buffer, destination);
				moveTopTo(destination);
				buffer.moveDisks(n-1, destination, this);
			}
		}
	}

}
