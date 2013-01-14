import java.util.ArrayList;
import java.util.Random;


public class LetterTable {
	/*
	 * N-wysokosc
	 * M-szerokosc
	 */
	
	
	//tworzy pusta tablice literek MxN
	public void createEmpty(int N, int M)
	{
		Width = M;
		Height = N;
		Size = N*M;
		
	}
	
	//generuje tablice literek MxN zapelniona literkami
	public void generate(int N, int M)
	{
		Table = new char[N][M];
		Width = M;
		Height = N;
		Size = N*M;
		LettersNumber = N*M;
		
		if((N*M)%2!=0)
		{
			System.out.println("Zle wymiary");
			return;
		}
		
		
		ArrayList<Integer> Positions=new ArrayList<Integer>();//z tego losujemy gdzie wstawiamy literki
		
		for(int i=0; i < Size; i++)
		{
			Positions.add(new Integer(i));
		}
		
		char Letter;
		int Position;
		Random Generator=new Random(System.currentTimeMillis());
		
		//petla po wszystkich pozycjach
		while(!Positions.isEmpty())
		{
			Letter ='A';
			Letter += Generator.nextInt(26);
			
			//bierzemy jeden z numerow ktory pozostal na liscie pozycji
			Position=Positions.remove(Generator.nextInt(Positions.size()));
			Table[(Position/Width)][(Position%Width)]=Letter;
			
			//powtarzamy
			Position=Positions.remove(Generator.nextInt(Positions.size()));
			Table[(Position/Width)][(Position%Width)]=Letter;
		}
		
	}
	public void print()
	{
		for(int i=0;i<Height;i++)
		{
			for(int j=0;j<Width;j++)
			{
				System.out.print(Table[i][j]);
			}
			System.out.println();
		}
	}
	//liczy ile jest mozliwych par do wybrania
	public int calcPairs()
	{
		Pairs=0;
		for(int i=0;i<Height;i++)
		{
			for(int j=0;j<Width;j++)
			{
				if(Table[i][j]==' ') continue;
				int iTemp=i+1;
				int jTemp=j+1;
				for(;iTemp<Height;iTemp++)
				{
					if(Table[i][j]==Table[iTemp][j]) Pairs++;
				}
				for(;jTemp<Width;jTemp++)
				{
					if(Table[i][j]==Table[i][jTemp]) Pairs++;
				}
			}
			
		}
		return Pairs;
	}
	//zwraca wektor wszystkich mozliwych tablic po usunieciu pary
	public ArrayList<LetterTable> getNextTables()
	{
		ArrayList<LetterTable> Tables=new ArrayList<LetterTable>();
		char[][] TableTemp;
		
		//szukanie par
		for(int i=0;i<Height;i++)
		{
			for(int j=0;j<Width;j++)
			{
				if(Table[i][j]==' ') continue;
				
				int iTemp=i+1;
				int jTemp=j+1;
				for(;iTemp<Height;iTemp++)
				{
					//jesli znajdzie pare w pionie
					if(Table[i][j]==Table[iTemp][j])
					{
						//tworzy nowa tablice char[][] i usuwa pare el.
						TableTemp=Algorithm.cloneArray(Table);
						Algorithm.removePair(TableTemp, i, j, iTemp, j);
						
						//tworzy nowa tablice liter i dodaje do listy
						LetterTable LTableTemp=new LetterTable();
						LTableTemp.createEmpty(Height,Width);
						LTableTemp.setLettersNumber(LettersNumber-2);
						LTableTemp.setTable(TableTemp);
						LTableTemp.addPointsDeleted(i, j, iTemp, j);
						Tables.add(LTableTemp);
					}
				}
				for(;jTemp<Width;jTemp++)
				{
					//jesli znajdzie w poziomie
					if(Table[i][j]==Table[i][jTemp]) 
					{
						//tworzy nowa tablice char[][] i usuwa pare el.
						TableTemp=Algorithm.cloneArray(Table);
						Algorithm.removePair(TableTemp, i, j, i, jTemp);
						
						//tworzy nowa tablice liter i dodaje do listy
						LetterTable LTableTemp=new LetterTable();
						LTableTemp.createEmpty(Height,Width);
						LTableTemp.setLettersNumber(LettersNumber-2);
						LTableTemp.setTable(TableTemp);
						LTableTemp.addPointsDeleted(i, j, i, jTemp);
						Tables.add(LTableTemp);
					}
				}
			}
			
		}
		return Tables;
	}
	
	public void setTable(char[][] T)
	{
		Table=T;
	}
	
	public void setLettersNumber(int L)
	{
		LettersNumber=L;
	}
	
	public int getLettersNumber() {
		return LettersNumber;
	}
	public int getPairs() {
		return Pairs;
	}
	public ArrayList<Integer> getPointsDeleted() {
		return PointsDeleted;
	}
	public void addPointsDeleted(Integer Y1, Integer X1, Integer Y2, Integer X2) {
		PointsDeleted.add(Y1);
		PointsDeleted.add(X1);
		PointsDeleted.add(Y2);
		PointsDeleted.add(X2);
	}
	public boolean isEqual(LetterTable tab)
	{
		char[][] tabTable=tab.getTable();
		if (LettersNumber != tab.getLettersNumber())
			return false;
		
		for (int i=Width-1;i>=0;i--)
		{
			for(int j=Height-1;j>=0;j--)
			{
				if (Table[j][i] != tabTable[j][i])
					return false;
			}
		}
		return true;
	}

	public char[][] getTable() {
		return Table;
	}
	public void setC_cost(int c_cost) {
		C_cost = c_cost;
	}
	public int getC_cost() {
		return C_cost;
	}
	public void setParent(LetterTable parent) {
		Parent = parent;
	}
	public LetterTable getParent() {
		return Parent;
	}
	public void setFull_cost(double full_cost) {
		Full_cost = full_cost;
	}
	public double getFull_cost() {
		return Full_cost;
	}
	private LetterTable Parent;
	private int C_cost;
	private double Full_cost;
	private ArrayList<Integer> PointsDeleted = new ArrayList<Integer>();//kolejnosc Y1,X1,Y2,X2
	private int LettersNumber;
	private int Pairs=0;
	private int Size;
	private int Width;
	private int Height;
	private char[][] Table;
	
}
