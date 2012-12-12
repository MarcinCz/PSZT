import java.util.ArrayList;


public class Algorithm {

	public static char[][] cloneArray(char[][] src) {
	    int length = src.length;
	    char[][] target = new char[length][src[0].length];
	    for (int i = 0; i < length; i++) {
	        System.arraycopy(src[i], 0, target[i], 0, src[i].length);
	    }
	    return target;
	}
	
	public static char[][] removePair(char[][] T, int Y1, int X1, int Y2, int X2)
	{
		for(;Y1>0;Y1--)
		{
			T[Y1][X1]=T[Y1-1][X1];
		}
		T[0][X1]=' ';
		
		for(;Y2>0;Y2--)
		{
			T[Y2][X2]=T[Y2-1][X2];
		}
		T[0][X2]=' ';
		
		return T;
	}
	
	public static ArrayList<LetterTable> IDA_Star(LetterTable Start)
	{
		double CostLimit = Start.getLettersNumber();
		Path.add(Start);
		
		while(true)
		{
			S = DepthLimitedSearch(0, Path, CostLimit);
			Path = S.Path;
			CostLimit = S.Cost;
			if(Path != null) return Path;
			if(CostLimit == Double.MAX_VALUE) return null;
		}
	
	}
	
	private static Solution DepthLimitedSearch(double StartCost, ArrayList<LetterTable> Path, double CostLimit)
	{
		LetterTable Node = Path.get(Path.size()-1);
		double MinimumCost = StartCost + Node.getLettersNumber();
		
		if(MinimumCost > CostLimit)
		{
			
			return S.newSolution(MinimumCost, null);
		}
		if(Node.getLettersNumber()==0) return S.newSolution(CostLimit, Path);
		
		double NextCostLimit = Double.MAX_VALUE;
		for(LetterTable LT: Node.getNextTables())
		{
			int Pairs = LT.calcPairs();
			if(Pairs == 0) continue;
			double NewStartCost = StartCost + (double)(1/Pairs);
			Path.add(LT);
			S = DepthLimitedSearch(NewStartCost, Path, CostLimit);
			if(S.Path!=null) Path = S.Path;
			else Path.remove(Path.size()-1);
			double NewCostLimit = S.Cost;
			if(S.Path != null)
			{
				return S.newSolution(NewCostLimit, Path);
			}
			NextCostLimit = NewCostLimit;
		}
		
		
		return S.newSolution(NextCostLimit, null);
	}
	
	
	//private static int NextCostLimit;
	//private static int MinimumCost;
	//private static LetterTable Node;
	private static Solution S = new Solution();
	private static ArrayList<LetterTable> Path = new ArrayList<LetterTable>();
}
