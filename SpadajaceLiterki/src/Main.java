import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {

		LetterTable L= new LetterTable();
		L.generate(6, 6);
		L.print();
		System.out.println("Rozwiazanie:\n");
		/*System.out.println(L.calcPairs()+"  "+L.getLettersNumber());
		
		ArrayList<LetterTable> A=new ArrayList<LetterTable>();
		A=L.getNextTables();
		for(int i=0;i<A.size();i++)
		{
			A.get(i).print();
			System.out.println(A.get(i).calcPairs()+"  "+A.get(i).getLettersNumber());
			System.out.println();
		}*/
		
		ArrayList<LetterTable> ALT = Algorithm.IDA_Star(L);
		if(ALT != null) for(LetterTable LT: ALT)
		{
			System.out.print("Usunieto: ");
			for(Integer E: LT.getPointsDeleted())
			{
				System.out.print(E+" ");
			}
			System.out.println();
			LT.print();
			System.out.println("----------------------");
			
		}
		else System.out.println("Nie da sie. W najlepszym rozwiazaniu zostalo "+Algorithm.getMinLetters()+" liter.");
		
		System.out.println("Odwiedzono "+Algorithm.getExploredNodes()+" wezlow.");
	}

}
