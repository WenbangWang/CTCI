package chapter_9;

import java.util.ArrayList;

public class C9_9 {
	
	private final static int num = 8;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[num];
		eightQueens(0,0,columns,result);
		for(int i=0;i<result.size();i++)
		{
			for(int j=0;j<num;j++)
			{
				System.out.print("{" + j + "," + result.get(i)[j] + "}");
			}
			System.out.println();
		}

	}
	
	public static boolean checkValid(Integer[] columns, int row1, int column1)
	{
		for(int row2=0;row2<row1;row2++)
		{
			int column2 = columns[row2];
			
			if(column2==column1)
				return false;
			if((row1-row2)==(Math.abs(column1-column2)))
				return false;
		}
		return true;
	}
	
	public static void eightQueens(int row, int column, Integer[] columns, ArrayList<Integer[]> result)
	{
		if(row==num)
		{
			result.add(columns.clone());
		}
		else
		{
			for(int col=0;col<num;col++)
			{
				if(checkValid(columns,row, col))
				{
					columns[row] = col;
					eightQueens(row+1, column, columns, result);
				}
			}
		}
	}

}
