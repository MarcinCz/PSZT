import java.util.ArrayList;


public class Solution {
	public Solution newSolution(double C, ArrayList<LetterTable> P)
	{
		Solution S=new Solution();
		S.Cost = C;
		S.Path = P;
		
		return S;
	}

	public double Cost;
	public ArrayList<LetterTable> Path;
}