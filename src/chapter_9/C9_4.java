package chapter_9;

import java.util.ArrayList;

public class C9_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++)
			al1.add(a[i]);
		
		ArrayList<ArrayList<Integer>> al = subset(al1);
		
		for(int i=0;i<al.size();i++)
		{
			ArrayList<Integer> temp = al.get(i);
			for(int j=0;j<temp.size();j++)
			{
				System.out.print("{" + temp.get(j) + "} ");
			}
			System.out.println();
		}
		

	}
	
	public static ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> al)
	{
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1<<al.size();
		for(int i=0;i<max;i++)
		{
			ArrayList<Integer> subset = subsetHelper(i, al);
			allsubsets.add(subset);
		}
		
		return allsubsets;
	}
	
	public static ArrayList<Integer> subsetHelper(int n, ArrayList<Integer> al)
	{
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int i=n;i>0;i>>=1)
		{
			if((i&1)==1)
				subset.add(al.get(index));
			index++;
		}
		return subset;
	}

}
