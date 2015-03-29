package chapter_9;

import java.util.ArrayList;

public class C9_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> al = generateParen(3);
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}

	}
	
	public static ArrayList<String> generateParen(int count)
	{
		ArrayList<String> al = new ArrayList<String>();
		char[] str = new char[count*2];
		addParen(al, count, count, str, 0);
		return al;
	}
	
	public static void addParen(ArrayList<String> al, int left, int right, char[] str, int count)
	{
		if(left<0||right<left)
			return;
		if(left==0&&right==0)
		{
			String s = String.copyValueOf(str);
			al.add(s);
		}
		else
		{
			if(left>0)
			{
				str[count] = '(';
				addParen(al, left-1, right, str, count+1);
			}
			if(right>0)
			{
				str[count] = ')';
				addParen(al, left, right-1, str, count+1);
			}
		}
		
	}

}
