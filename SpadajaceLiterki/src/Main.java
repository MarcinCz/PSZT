import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {

		LetterTable L= new LetterTable();
		L.generate(6, 5);
		L.print();
		System.out.println("Rozwiazanie:\n");
		
		ArrayList<LetterTable> ALT = Algorithm.IDA_Star(L);
		if(ALT != null) for(LetterTable LT: ALT)
		{
			System.out.println("Par: "+LT.getPairs());
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
		
		System.out.println("Odwiedzono "+Algorithm.getLastExploredNodes()+" wezlow w ostatniej iteracji i "+
		Algorithm.getExploredNodes()+" wezlow lacznie.");
		System.out.println("Koszt uzyty w ostaniej iteracji to "+Algorithm.getLastCostLimit());
	}

}
