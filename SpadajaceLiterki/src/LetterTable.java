import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;
import java.awt.Point;
import java.util.Hashtable;

public class LetterTable {
	/*
	 * N-wiersze
	 * M-kolumny
	 */
	public LetterTable()
        {
            sameMap = new SameLettersMap();
        }
	
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
            //tworzenie hashtable z parami liter
            sameMap = new SameLettersMap();
            sameMap.clear();
            
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
		
		for(int i=0;i<Height;i++)
		{
			for(int j=0;j<Width;j++)
			{
				if(Table[i][j]==' ') continue;
				int iTemp=i+1;
				int jTemp=j+1;
				for(;iTemp<Height;iTemp++)
				{
					if(Table[i][j]==Table[iTemp][j]) 
                                        {
                                            String l = "" + Table[i][j];
                                            Point p1 = new Point(j+1, i+1);
                                            Point p2 = new Point(j+1, iTemp+1);
                                            Pairs++;
                                            if(!sameMap.contains(l, p1))
                                                sameMap.add("" + Table[i][j], p1);
                                            if(!sameMap.contains(l, p2))
                                                sameMap.add("" + Table[i][j], p2);
                                        }
				}
				for(;jTemp<Width;jTemp++)
				{
					if(Table[i][j]==Table[i][jTemp])
                                            {
                                            String l = "" + Table[i][j];
                                            Point p1 = new Point(j+1, i+1);
                                            Point p2 = new Point(jTemp+1, i+1);
                                            Pairs++;
                                            if(!sameMap.contains(l, p1))
                                                sameMap.add("" + Table[i][j], p1);
                                            if(!sameMap.contains(l, p2))
                                                sameMap.add("" + Table[i][j], p2);
                                        }
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
        
        public char[][] getTable() {
            return Table;
        }
        
        public SameLettersMap getSameMap() {
            return sameMap;
        }
	
	private int LettersNumber;
	private int Pairs=0;
	private int Size;
	private int Width;
	private int Height;
	private char[][] Table;
        private SameLettersMap sameMap;
        
        public class SameLettersMap {
            
            private Hashtable<String, ArrayList<Point>> sameList;
            
            public SameLettersMap()
            {
                sameList = new Hashtable<String, ArrayList<Point>>();
            }
            /**
             * Dodaje Punkt p do Hashtable, wkładając go na koniec listy punktów dla danego Klucza
             * @param s Klucz
             * @param p Punkt
             */
            public void add(String s, Point p)
            {
                ArrayList<Point> temp;
                if(sameList.containsKey(s))
                {
                    temp  = sameList.get(s);
                    sameList.remove(s);
                } else temp = new ArrayList<Point>();
                temp.add(p);
                sameList.put(s, temp);
            }
            
            public boolean contains(String s, Point p)
            {
                ArrayList<Point> temp = sameList.get(s);
                if(temp!=null)
                {
                    for(int f=0;f<temp.size();f++)
                    {
                        if(temp.get(f).equals(p))
                            return true;
                    }
                }
                
                return false;
            }
            
            public ArrayList<Point> get(String key)
            {
                return sameList.get(key);
            }
            
            public void clear()
            {
                sameList.clear();
            }
            
            public String toString()
            {
                String s = "";
                Enumeration<String> keys= sameList.keys();
                Collection<ArrayList<Point>> values = sameList.values();
                Iterator iterator = values.iterator();
                
                while(keys.hasMoreElements())
                {
                    
                    s += keys.nextElement() + iterator.next().toString() + "\n";
                }
                return s;
            }
        }
	
}