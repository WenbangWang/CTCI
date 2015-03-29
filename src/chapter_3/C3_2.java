package chapter_3;

import java.util.Stack;

public class C3_2 {
	
	private int min;
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public C3_2()
	{
		min = Integer.MAX_VALUE;
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int data)
	{
		if(data<=min)
		{
			min = data;
			minStack.push(min);
		}
		stack.push(data);
	}
	
	public int pop()
	{
		int temp = stack.pop();
		if(temp==minStack.peek())
			min = minStack.pop();
		return temp;
	}
	
	public int min()
	{
		return min;
	}

}
