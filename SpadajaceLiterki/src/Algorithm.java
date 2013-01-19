import java.util.ArrayList;


public class Algorithm implements Runnable{
	/**
	*@Override
	*Uruchomienie watku algorytmu
	*/
	public void run() {
		Running=true;
		if(AlgorithmChoice==0) SolutionPath=A_Star(StartNode);
		else SolutionPath=IDA_Star(StartNode);
		window.SolvedAction();
		Running=false;
	}	
	/**
	 * Po otrzymaniu tablicy char[][] zwraca nowa tablice char[][]
	 * bedaca kopia otrzymanej
	 * @param src kopiowana tablica
	 * @return skopiowana tablica
	 */
	public  char[][] cloneArray(char[][] src) {
	    int length = src .length;
	    char[][] target = new char[length][src[0].length];
	    for (int i = 0; i < length; i++) {
	        System.arraycopy(src[i], 0, target[i], 0, src[i].length);
	    }
	    return target;
	}
	/**
	 * Usuwa wskazana pare liter z tablicy char[][]
	 * @param T tablica char[][]
	 * @param Y1
	 * @param X1
	 * @param Y2
	 * @param X2
	 * @return tablica po usunieciu liter
	 */
	public  char[][] removePair(char[][] T, int Y1, int X1, int Y2, int X2)
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
	/**
	 * Algorytm IDA_Star
	 * @param Start Tablica do rozwiazania
	 * @return Rozwiazanie jesli istnieje lub null jesli nie istnieje
	 */
	public  ArrayList<LetterTable> IDA_Star(LetterTable Start)
	{
		ArrayList<LetterTable> Path = new ArrayList<LetterTable>();
		ExploredNodes=0;
		LastExploredNodes=0;
		int CostLimit = ((1+Start.getLettersNumber()/2)*Start.calcPairs());
		MinLetters = Start.getLettersNumber();
		
		Path.add(Start);
		
		//wywolujemy funkcje iteracyjnego przeszukiwania w glab ze zwiekszanym, co krok petli, limitem
		while(true)
		{
			LastCostLimit=CostLimit;			
			S = DepthLimitedSearch(0, Path, CostLimit);
			if(!Running) return null;
			CostLimit = S.Cost;
			if(S.Path != null) return S.Path;
			if(CostLimit == Integer.MAX_VALUE) return null;
			LastExploredNodes=0;
		}
	
	}
	/**
	 * Przesukiwanie w glab
	 * @param StartCost aktualny koszt 
	 * @param Path aktualna sciezka
	 * @param CostLimit limit kosztu
	 * @return nowy limit kosztu, rozwiazanie jest istnieje null jesli nie istnieje
	 */
	private  Solution DepthLimitedSearch(int StartCost, ArrayList<LetterTable> Path, int CostLimit)
	{

		if(!Running) return(new Solution(0, null));
		LastExploredNodes++;
		ExploredNodes++;//w tym miejscu mozna wypisywac na ekran ile wezlow odwiedzono

		//bierzemy ostani element ze sciezki i ustawiamy jako sprawdzany wezel
		LetterTable Node = Path.get(Path.size()-1);
		if(Node.getLettersNumber()<MinLetters) 
			{
			
				MinLetters = Node.getLettersNumber();
			}
		//a tu mozna wypisac najlepsze jak dotad rozwiazanie
		int MinimumCost = StartCost + (1+Node.getLettersNumber()/2)*Node.getPairs();
		
		//jesli koszt przekracza limit to zwracamy ten koszt
		if(MinimumCost > CostLimit)
		{
			
			return new Solution(MinimumCost, null);
		}
		//jesli znaleziono rozwiazanie
		if(Node.getLettersNumber()==0) return new Solution(CostLimit, Path);
		
		
		int NextCostLimit = Integer.MAX_VALUE;
		//petla wywolujaca funkcje dla wszystkich nastepnych wezlow
		for(LetterTable LT: Node.getNextTables())
		{
			if(!Running) return(new Solution(0, null));
			int Pairs = LT.calcPairs();
			
			int NewCostLimit = Integer.MAX_VALUE;
			int NewStartCost;
			if(Pairs == 0)
			{
				if(LT.getLettersNumber()<MinLetters) MinLetters=LT.getLettersNumber();
				if(LT.getLettersNumber()==0) 
				{
					NewStartCost = StartCost;
				}
				else 
				{	
					ExploredNodes++;
					LastExploredNodes++;
					continue; //jesli nie da sie znalesc pary w tym wezle to omijamy
				}
			}
			else
			{
				NewStartCost = StartCost + Node.getLettersNumber()*(Node.getPairs()-LT.getPairs()); //liczymy koszt
				if(!Running) return(new Solution(0, null));
			}
			
			
			Path.add(LT);
			
			S = DepthLimitedSearch(NewStartCost, Path, CostLimit);
			
			NewCostLimit = S.Cost;
			
			if(S.Path != null) //zwracamy ew. znalezione rozwiazanie
			{
				return new Solution(NewCostLimit, S.Path);
			}
			else Path.remove(Path.size()-1);
			NextCostLimit = Math.min(NextCostLimit, NewCostLimit);

		}
		
		
		return new Solution(NextCostLimit, null);
	}
	/**
	 * Algorytm A*
	 * @param Start tablica do rozwiazania
	 * @return Rozwiazanie jesli istnieje lub null jesli nie istnieje
	 */
	public  ArrayList<LetterTable> A_Star(LetterTable Start)
	{
		ExploredNodes=0;//ile wezlow lacznie odwiedzono
		LastExploredNodes=0;//w A* oznacza ile wezlow dodano do zbioru G
		LastCostLimit=0;//w A* oznacza aktualna licznosc zbioru G
		 
		//Zbior G
		ArrayList<LetterTable>GSet = new ArrayList<LetterTable>();
   
		//Zbior P
		ArrayList<LetterTable>PSet = new ArrayList<LetterTable>();
		Start.setC_cost(0);
		Start.setParent(null);
		Start.calcPairs();
		
		//dodanie Start do G(0)
		GSet.add(Start);
		LastCostLimit++;
		LastExploredNodes++;
		
		MinLetters = Start.getLettersNumber();
		
		//S(0)=Start;
		LetterTable S=Start;

		boolean FoundSolution=false;
		while(!GSet.isEmpty())
    	{
			
			if(!Running) return null;
			PSet.clear();
			
			//P(i)=rozwiniecie S(i)
			for(LetterTable LT:S.getNextTables())
			{
				ExploredNodes++;
				//window.statCount(new Integereger(ExploredNodes).toString());
				LT.setParent(S);
				LT.setC_cost(S.getC_cost()+S.getLettersNumber()*(S.getPairs()-LT.calcPairs()));
				LT.setFull_cost(LT.getC_cost()+(1+LT.getLettersNumber()/2)*LT.getPairs());
				PSet.add(LT);
			}
			
			//G(i) - S(i)
			GSet.remove(S);
			LastCostLimit--;
			//G(i) suma P(i)
			boolean CanAdd;
			for(LetterTable LTP:PSet)
			{
				CanAdd=true;
				for(LetterTable LTG:GSet)
				{
					
					
					if(LTG.isEqual(LTP))
					{
						if(LTG.getFull_cost()>LTP.getFull_cost());
							LTG.setFull_cost(LTP.getFull_cost());
						CanAdd=false;
						break;
					}
				}
				if(CanAdd)
				{
					LastExploredNodes++;
					LastCostLimit++;
					GSet.add(LTP);
				}
			}
			
			int FullCost;
			int MinCost=Integer.MAX_VALUE;
			//szukanie najlepszego S(i+1)
			for(LetterTable LT : GSet)
			{
				FullCost=LT.getFull_cost();
				if (FullCost<MinCost)
				{
					MinCost = FullCost;
					S = LT;
				}
			}
			if(S.getLettersNumber()<MinLetters)
			{
				MinLetters=S.getLettersNumber();
			}
			//Jesli S(i+1) jest stanem terminalnym
			if(S.getLettersNumber()==0)
			{
				FoundSolution=true;
				break;
			}
    	}
		//odbudowa sciezki
		if(FoundSolution)
		{
			ArrayList<LetterTable> Path = new ArrayList<LetterTable>();
			for(;;)
			{
				if(S==null) return Path;
				LetterTable Parent=S.getParent();
				Path.add(0, S);
				S=Parent;
			}
		}
		else return null;
}
	/**
	 * Zwraca ile wezlow odwiedzono
	 * @return liczba odwiedzonych wezlow
	 */
	public  int getExploredNodes() {
		return ExploredNodes;
	}
	/**
	 * Zwraca najlepsze rozwiazanie
	 * @return Liczba liter
	 */
	public  int getMinLetters() {
		return MinLetters;
	}
	/**
	 * IDA* - Zwraca liczbe ostatnio odwiedzonych wezlow
	 * A* - Zwraca liczbe wezlow dodanych do zbioru G
	 * @return 
	 */
	public  int getLastExploredNodes() {
		return LastExploredNodes;
	}
	/**
	 * IDA* - Zwraca aktualny limit kosztu
	 * A* - Zwraca liczebnosc zbioru G
	 * @return
	 */
	public  int getLastCostLimit() {
		return LastCostLimit;
	}
	/**
	 * Ustawienie wykorzystywanego okna gry
	 * @param Window okno gry
	 */
	public  void setWindow(GameWindow Window) {
		window = Window;
	}
	/**
	 * Wybranie uzywanego algorytmu
	 * @param algorithmChoice 0-A* 1-IDA*
	 */
	public void setAlgorithmChoice(int algorithmChoice) {
		AlgorithmChoice = algorithmChoice;
	}
	/**
	 * Ustawienie tablicy do rozwiazania przez algorytm
	 * @param startNode tablica do rozwiazania
	 */
	public void setStartNode(LetterTable startNode) {
		StartNode = startNode;
	}
	/**
	 * Zwraca ostatnie rozwiazanie algorytmu
	 * @return Rozwiazanie algorytmu
	 */
	public ArrayList<LetterTable> getSolutionPath() {
		return SolutionPath;
	}
	/**
	 * Ustawia zmienna Running
	 * @param running
	 */
	public void setRunning(boolean running) {
		Running = running;
	}
	/**
	 * Sprawdza jak ustawiona jest zmienna Running
	 * @return Running
	 */
	public boolean isRunning() {
		return Running;
	}
	private ArrayList<LetterTable>SolutionPath = new ArrayList<LetterTable>();
	private LetterTable StartNode;
	private  int AlgorithmChoice=0;
	private  int LastCostLimit;
	private  int MinLetters; //minimalna liczba liter, ktora zostala na tablicy w trakcie wykonywania algorytmu
	private  int ExploredNodes = 0; //liczba odwiedzonych wezlow lacznie
	private  int LastExploredNodes = 0; //liczba odwiedzonych wezlow w aktualnej(ostatniej) iteracji
	private  Solution S = new Solution(); //klasa przechowujaca zmienne zwracane przez DLS
	private  GameWindow window;   //uchwyt do gui
    private boolean Running=false;   
	
}