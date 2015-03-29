package chapter_9;

import java.util.ArrayList;

public class C9_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abc";
		ArrayList<String> al = getPerm(str);
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}

	}
	
	public static ArrayList<String> getPerm(String str)
	{
		if(str==null)
			return null;
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length()==0)
		{
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerm(remainder);
		
		for(String word: words)
		{
			System.out.println(word);
			for(int i=0;i<=word.length();i++)
			{
				String temp = insertCharAt(word, first, i);
				permutations.add(temp);
			}
		}
		
		return permutations;
		
	}
	
	public static String insertCharAt(String word, char c, int i)
	{
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start+c+end;
	}

}
