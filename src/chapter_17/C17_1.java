package chapter_17;

public class C17_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,2,3,4,5,6,7,8,9};
		swapInPlace(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print("{" + array[i] + "}");
		}

	}
	
	public static void swapInPlace(int[] array)
	{
		int p = 0;
		int q = array.length-1;
		
		while(q>p)
		{
			array[p] = array[p]^array[q];
			array[q] = array[p]^array[q];
			array[p] = array[p++]^array[q--];
		}
	}

}
