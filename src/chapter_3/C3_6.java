package chapter_3;

import java.util.Stack;

public class C3_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(4);
		stack.push(5);
		stack = sort(stack);
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
	
	public static Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty())
		{
			int temp = s.pop();
			while(!r.isEmpty()&&r.peek()>temp)
			{
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}

}
