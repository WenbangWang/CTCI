package chapter_17;

public class C17_5_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String solution = "RGBB";
		String guess = "GRGB";
		
		Result result = slot(guess,solution);
		
		if(result!=null)
		{
			System.out.println(result.getHits());
			System.out.println(result.getQseudoHits());
		}
	}
	
	public static Result slot(String guess, String solution)
	{
		if(guess.length()!=solution.length()||guess.length()!=4||solution.length()!=4)
			return null;
		C17_5_1 c = new C17_5_1();
		Slots guessSlot = c.new Slots(guess);
		Slots solutionSlot = c.new Slots(solution);
		if(!guessSlot.valid()||!solutionSlot.valid())
			return null;
		int hits = 0;
		int qseudoHits = 0;
		
		for(int i=0;i<guess.length();i++)
		{
			if(guessSlot.slots[i].getColor()==solutionSlot.slots[i].getColor())
				hits++;
		}
		
		for(int i=0;i<guess.length();i++)
		{
			for(int j=0;j<guess.length();j++)
			{
				if(i!=j)
				{
					if(guessSlot.slots[i].getColor()==solutionSlot.slots[j].getColor())
						qseudoHits++;
				}
			}
		}
		Result result= c.new Result();
		
		result.setHits(hits);
		result.setQseudoHits(qseudoHits);
		return result;
	}
	
	public class Result
	{
		private int hits;
		private int qseudoHits;
		
		public Result()
		{
			
		}
		
		
		public int getHits() {
			return hits;
		}

		public void setHits(int hits) {
			this.hits = hits;
		}

		public int getQseudoHits() {
			return qseudoHits;
		}

		public void setQseudoHits(int qseudoHits) {
			this.qseudoHits = qseudoHits;
		}
	}
	
	public class Slot
	{
		private char color;
		
		Slot(char c)
		{
			if(c=='R'||c=='G'||c=='B')
				color = c;
			else
				color = 'N';
		}
		
		char getColor()
		{
			return this.color;
		}
		
		boolean valid()
		{
			return color=='N'?false:true;
		}
	}
	
	public class Slots
	{
		Slot[] slots;
		private boolean valid;
		
		Slots(String str)
		{
			slots = new Slot[str.length()];
			valid = true;
			char[] array = str.toCharArray();
			for(int i=0;i<array.length;i++)
			{
				slots[i] = new Slot(array[i]);
				if(!slots[i].valid())
				{
					valid = false;
					break;
				}
			}
		}
		
		boolean valid()
		{
			return valid;
		}
	}

}
