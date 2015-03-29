package chapter_17;

public class C17_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(trailZero(11));

	}
	
	public static int trailZero(int n)
	{
		int count = 0;
		
		for(int i=5;n/i>0;i*=5)
		{
			count += n/i;
		}
		
		return count;
	}

}
