package chapter_9;

public class C9_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(path(0,0,1,2));

	}
	
	public static int path(int x, int y, int maxX, int maxY)
	{
		if(x>maxX||y>maxY)
			return 0;
		else if(x==maxX&&y==maxY)
			return 1;
		else 
			return path(x+1, y, maxX, maxY)+path(x, y+1, maxX, maxY);
	}


}
