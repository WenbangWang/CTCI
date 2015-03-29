package chapter_9;


public class C9_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 35;
        int[] array = new int[n + 1];

        for(int i=0; i<array.length; i++) {
            array[i] = -1;
        }

		System.out.println(countStep(n));

	}

	public static int countStep(int n)
	{
		if(n==0)
			return 1;
		else if(n<0)
			return 0;
		else
			return countStep(n-1)+countStep(n-2)+countStep(n-3);
	}

	public static int countStepDP(int n, int[] max)
	{
		if(n==0)
			return 1;
		else if(n<0)
			return 0;
		else if(max[n]>=0)
			return max[n];
		else {
            max[n] = countStepDP(n-1, max)+countStepDP(n-2, max)+countStepDP(n-3, max);

            return max[n];
        }
	}


}
