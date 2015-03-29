package chapter_17;

public class C17_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(findMinSequence(array));
	}
	
	public static int findEndOfLeft(int[] array)
	{
		for(int i=1;i<array.length;i++)
		{
			if(array[i]<array[i-1])
				return i-1;
		}
		return array.length-1;
	}
	
	public static int findStartOfRight(int[] array)
	{
		for(int i=array.length-2;i>=0;i--)
		{
			if(array[i]>array[i+1])
				return i+1;
		}
		return 0;
	}
	
	public static int shrinkLeft(int[] array, int minIndex, int end)
	{
		int min = array[minIndex];
		for(int i=end;i>=0;i--)
		{
			if(array[i]<min)
				return i;
		}
		return 0;
	}
	
	public static int shrinkRight(int[] array, int maxIndex, int start)
	{
		int max = array[maxIndex];
		for(int i=start;i<array.length;i++)
		{
			if(array[i]>max)
				return i;
		}
		return array.length-1;
	}
	
	public static int findMinSequence(int[] array)
	{
		int left = findEndOfLeft(array);
		int right = findStartOfRight(array);
		System.out.println("left:"+left);
		System.out.println("right:"+right);
		if(left==array.length-1)
			return 0;
		if(left==0&&right==array.length-1)
			return array.length;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int minIndex = 0;
		int maxIndex = 0;
		for(int i=left+1;i<right;i++)
		{
			if(array[i]<min)
			{
				min = array[i];
				minIndex = i;
			}
			if(array[i]>max)
			{
				max = array[i];
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);
		System.out.println(minIndex);
		return shrinkRight(array, maxIndex, right)-shrinkLeft(array, minIndex, left);
	}

}
