package chapter_3;

import java.util.ArrayList;
import java.util.Stack;

public class C3_3 {
	
	private int count;
	private int th;
	private int stackNum;
	private ArrayList<Stack<Integer>> stacks;
	
	public C3_3(int th)
	{
		this.th = th;
		count = 1;
		stackNum = 0;
		stacks = new ArrayList<Stack<Integer>>();
	}
	
	public void push(int data)
	{
		if(++count>th)
		{
			count = 1;
			stackNum++;
		}
		if(stacks.get(stackNum)==null)
		{
			Stack<Integer> stack = new Stack<Integer>();
			stacks.add(stack);
		}
		stacks.get(stackNum).push(data);
	}
	
	public int pop()
	{
		int value = stacks.get(stackNum).pop();
		if(--count<1)
		{
			count = th;
			stacks.remove(stackNum);
			stackNum--;
		}
		return value;
	}
	
	

}
