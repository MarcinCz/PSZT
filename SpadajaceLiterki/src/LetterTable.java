package spadajaceliterki;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextArea;


public class LetterTable {
	/*
	 * N-wysokosc
	 * M-szerokosc
	 */
	
	
	//tworzy pusta tablice literek NxM
	public void createEmpty(int N, int M)
	{
		Width = N;
		Height = M;
		Size = N*M;
	}
	
	//generuje tablice literek NxM zapelniona literkami
	public void generate(int N, int M)
	{
		Table = new char[N][M];
		Width = N;
		Height = M;
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
			Table[(Position/Height)][(Position%Height)]=Letter;
			
			//powtarzamy
			Position=Positions.remove(Generator.nextInt(Positions.size()));
			Table[(Position/Height)][(Position%Height)]=Letter;
		}
		
	}
        
	public String toString()
	{
            String output = "";
            for(int i=0;i<Width;i++)
            {
                    for(int j=0;j<Height;j++)
                    {
                            output += Table[i][j];
                    }
                    output += "\n";
            }
            return output;
	}
        
	//liczy ile jest mozliwych par do wybrania
	public int calcPairs()
	{
		
		for(int i=0;i<Width;i++)
		{
			for(int j=0;j<Height;j++)
			{
				int iTemp=i+1;
				int jTemp=j+1;
				for(;iTemp<Width;iTemp++)
				{
					if(Table[i][j]==Table[iTemp][j]) Pairs++;
				}
				for(;jTemp<Height;jTemp++)
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
		for(int i=0;i<Width;i++)
		{
			for(int j=0;j<Height;j++)
			{
				int iTemp=i+1;
				int jTemp=j+1;
				for(;iTemp<Width;iTemp++)
				{
					//jesli znajdzie pare w poziomie
					if(Table[i][j]==Table[iTemp][j])
					{
						//tworzy nowa tablice char[][] i usuwa pare el.
						TableTemp=Algorithm.cloneArray(Table);
						Algorithm.removePair(TableTemp, i, j, iTemp, j);
						
						//tworzy nowa tablice liter i dodaje do listy
						LetterTable LTableTemp=new LetterTable();
						LTableTemp.createEmpty(Width, Height);
						LTableTemp.setLettersNumber(LettersNumber-2);
						LTableTemp.setTable(TableTemp);
						Tables.add(LTableTemp);
					}
				}
				for(;jTemp<Height;jTemp++)
				{
					//jesli znajdzie w pionie
					if(Table[i][j]==Table[i][jTemp]) 
					{
						//tworzy nowa tablice char[][] i usuwa pare el.
						TableTemp=Algorithm.cloneArray(Table);
						Algorithm.removePair(TableTemp, i, j, i, jTemp);
						
						//tworzy nowa tablice liter i dodaje do listy
						LetterTable LTableTemp=new LetterTable();
						LTableTemp.createEmpty(Width, Height);
						LTableTemp.setLettersNumber(LettersNumber-2);
						LTableTemp.setTable(TableTemp);
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
	
	private int LettersNumber;
	private int Pairs=0;
	private int Size;
	private int Width;
	private int Height;
	private char[][] Table;
	
}
