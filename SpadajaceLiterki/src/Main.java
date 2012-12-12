import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {

		LetterTable L= new LetterTable();
		L.generate(5, 8);
		L.print();
		System.out.println(L.calcPairs()+"  "+L.getLettersNumber());
		
		ArrayList<LetterTable> A=new ArrayList<LetterTable>();
		A=L.getNextTables();
		for(int i=0;i<A.size();i++)
		{
			A.get(i).print();
			System.out.println(A.get(i).calcPairs()+"  "+A.get(i).getLettersNumber());
			System.out.println();
		}
	}

}
