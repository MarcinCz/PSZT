import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;
import java.awt.Point;
import java.util.Hashtable;

public class LetterTable {
	/**
	 * 
	 */
	public LetterTable()
        {
            sameMap = new SameLettersMap();
        }
	
	
	/**
	 * tworzy pusta tablice literek MxN
	 * @param N wiersze
	 * @param M kolumny
	 */
	public void createEmpty(int N, int M)
	{
		Width = M;
		Height = N;
		Size = N*M;
	}
	
	
	/**
	 * generuje tablice literek MxN zapelniona literkami
	 * @param N wiersze
	 * @param M kolumny
	 * @throws Exception 
	 */
	public void generate(int N, int M) throws Exception
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
			throw(new Exception("Zly wymiar"));
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
    /**
     * Zwraca tablice w postaci String
     */
	public String toString()
	{
            String output = "";
            for(int i=0;i<Height;i++)
            {
                    for(int j=0;j<Width;j++)
                    {
                            output += Table[i][j];
                    }
                    output += "\n";
            }
            return output;
	}
        
	
	/**
	 * liczy ile jest mozliwych par do wybrania
	 * @return liczba par do zdjecia
	 */
	public int calcPairs()
	{
		sameMap.clear();
                Pairs = 0;
                
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
                                            Point p1 = new Point(j+1, i+1);
                                            Point p2 = new Point(j+1, iTemp+1);
                                            Pairs++;
                                            sameMap.add(p1, p2);
                                            sameMap.add(p2, p1);
                                        }
				}
				for(;jTemp<Width;jTemp++)
				{
					if(Table[i][j]==Table[i][jTemp])
                                            {
                                            
                                            Point p1 = new Point(j+1, i+1);
                                            Point p2 = new Point(jTemp+1, i+1);
                                            Pairs++;
                                            sameMap.add(p1, p2);
                                            sameMap.add(p2, p1);
                                        }
				}
			}
			
		}
                
		return Pairs;
	}
	
	/**
	 * zwraca wektor wszystkich mozliwych tablic po usunieciu pary
	 * @return wektor wszystkich mozliwych tablic po usunieciu pary
	 */
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
						TableTemp=Alg.cloneArray(Table);
						Alg.removePair(TableTemp, i, j, iTemp, j);
						
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
						TableTemp=Alg.cloneArray(Table);
						Alg.removePair(TableTemp, i, j, i, jTemp);
						
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
	/**
	 * Ustawia tablice char[][]
	 * @param T tablica char[][]
	 */
	public void setTable(char[][] T)
	{
		Table=T;
	}
	/**
	 * Ustawia liczbe liter do zdjecia
	 * @param L liczba liter do zdjecia
	 */
	public void setLettersNumber(int L)
	{
		LettersNumber=L;
	}
	/**
	 * Zwraca liczbe liter do zdjecia
	 * @return Liczba liter do zdjecia
	 */
	public int getLettersNumber() {
		return LettersNumber;
	}
	/**
	 * Zwraca ustawiona liczbe par do zdjecia
	 * @return Liczba par do zdjecia
	 */
	public int getPairs() {
		return Pairs;
	}
    /**
     * Zwraca wektor usunietych z tablicy punktow    
     * @return Wektor usunietych z tablicu punktow
     */
    public ArrayList<Integer> getPointsDeleted() {
		return PointsDeleted;
	}
    /**
     * Dodaje usuniete punkty do wektora usunietych punktow
     * @param Y1
     * @param X1
     * @param Y2
     * @param X2
     */
	public void addPointsDeleted(Integer Y1, Integer X1, Integer Y2, Integer X2) {
		PointsDeleted.add(Y1);
		PointsDeleted.add(X1);
		PointsDeleted.add(Y2);
		PointsDeleted.add(X2);
	}
    /**
     * Sprawdza czy otrzymana tablica char[][] jest taka sama jak tablica danego obiektu 
     * @param tab otrzymywana tablica char[][]
     * @return true jesli tak, false jesli nie
     */
    public boolean isEqual(LetterTable tab)
	{
		char[][] tabTable=tab.getTable();
		if (C_cost!=tab.getC_cost() || Pairs!=tab.getPairs() || LettersNumber != tab.getLettersNumber() )
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
    /**
     * Zwraca posiadana tablice char[][]
     * @return tablica char[][]
     */
    public char[][] getTable() {
            return Table;
    }
    /**
     * Ustawia koszt C danego wezla
     * @param c_cost koszt C
     */
    public void setC_cost(int c_cost) {
		C_cost = c_cost;
	}
    /**
     * Zwraca koszt C danego wezla
     * @return koszt C
     */
	public int getC_cost() {
		return C_cost;
	}
	/**
	 * Ustawia wezel poprzedzajacy dany wezel
	 * @param parent wezel poprzedzajacy
	 */
	public void setParent(LetterTable parent) {
		Parent = parent;
	}
	/**
	 * Zwraca wezel poprzedzajacy dany wezel
	 * @return wezel poprzedzajacy
	 */
	public LetterTable getParent() {
		return Parent;
	}
	/**
	 * Ustawia pelny koszt wezla
	 * @param full_cost pelny koszt wezla
	 */
    public void setFull_cost(int full_cost) {
		Full_cost = full_cost;
	}
    /**
     * Zwraca pelny koszt wezla
     * @return pelny koszt wezla
     */
	public int getFull_cost() {
		return Full_cost;
	}
    
    public SameLettersMap getSameMap() {
        return sameMap;
    }
    
    public void setLetter(char c,Point p)
    {
        Table[(int)p.getY()][(int)p.getX()] = c;
    }
    
    public char getLetter(Point p)
    {
        return Table[(int)p.getY()][(int)p.getX()];
    }

    private LetterTable Parent;
	private int C_cost;
	private int Full_cost;
	private ArrayList<Integer> PointsDeleted = new ArrayList<Integer>();//kolejnosc Y1,X1,Y2,X2
	private int LettersNumber;
	private int Pairs=0;
	private int Size;
	private int Width;
	private int Height;
	private char[][] Table;
	private Algorithm Alg=new Algorithm();
	private SameLettersMap sameMap;
        
    public class SameLettersMap {
        
        private Hashtable<Point, ArrayList<Point>> sameList;
        
        public SameLettersMap()
        {
            sameList = new Hashtable<Point, ArrayList<Point>>();
        }
        /**
         * Dodaje Punkt value do Hashtable, wkładając go na koniec listy punktów dla danego Klucza
         * @param key Klucz
         * @param value Punkt
         */
        public void add(Point key, Point value)
        {
            ArrayList<Point> temp;
            if(sameList.containsKey(key))
            {
                temp  = sameList.get(key);
                sameList.remove(key);
            } else temp = new ArrayList<Point>();
            temp.add(value);
            sameList.put(key, temp);
        }
        
        public ArrayList<Point> get(Point key)
        {
            return sameList.get(key);
        }
        
        public void clear()
        {
            sameList.clear();
        }
        
        public String toString()
        {
            String s = "Pary:\n";
            Enumeration<Point> keys= sameList.keys();
            Collection<ArrayList<Point>> values = sameList.values();
            Iterator<ArrayList<Point>> iterator = values.iterator();
            
            while(keys.hasMoreElements())
            {
                
                s += keys.nextElement() + iterator.next().toString() + "\n";
            }
            return s;
        }
    }
	
}