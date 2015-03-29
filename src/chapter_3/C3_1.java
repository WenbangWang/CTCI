package chapter_3;


public class C3_1 {
	
	private int[] index = {0, 0, 0};
	private int[] array;
	private int size;
	
	public C3_1(int size)
	{
		array = new int[size*3];
		this.size = size;
	}
	
	public void push(int stack, int data) throws Exception
	{
		if(stack>3||stack<0)
			throw new Exception("Out of Range!");
		if(index[stack-1]>size)
		{
			System.out.println("This stack is full!");
			return;
		}
		array[index[stack-1] + (stack-1)*size] = data;
		index[stack-1]++;
	}
	
	public int pop(int stack) throws Exception
	{
		if(stack>3||stack<0)
			throw new Exception("Ouf of Range!");
		int value = array[index[stack-1] + (stack-1)*size];
		array[index[stack-1] + (stack-1)*size] = Integer.MIN_VALUE;
		index[stack-1]--;
		return value;
	}
	
	public boolean isEmpty(int stack) throws Exception
	{
		if(stack>3||stack<0)
			throw new Exception("Ouf of Range!");
		return index[stack-1]==0;
	}
	
	public int peek(int stack) throws Exception
	{
		if(stack>3||stack<0)
			throw new Exception("Ouf of Range!");
		return array[index[stack-1] + (stack-1)*size];
	}
	
	public int size(int stack) throws Exception
	{
		if(stack>3||stack<0)
			throw new Exception("Ouf of Range!");
		return index[stack-1];
	}

}
