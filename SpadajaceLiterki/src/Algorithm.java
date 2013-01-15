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
	
	public static ArrayList<LetterTable> IDA_Star(LetterTable Start, GameWindow gw)
	{
		window = gw;
		double CostLimit = ((1+Start.getLettersNumber()/2)*Start.calcPairs());
		MinLetters = Start.getLettersNumber();
		ArrayList<LetterTable>Path = new ArrayList<LetterTable>();
		Path.add(Start);
		
		//wywolujemy funkcje iteracyjnego przeszukiwania w glab ze zwiekszanym, co krok petli, limitem
		while(true)
		{
			LastCostLimit=CostLimit;
			sayln("Koszt: "+CostLimit);
			S = DepthLimitedSearch(0, Path, CostLimit);
			//Path = S.Path;
			CostLimit = S.Cost;
			if(S.Path != null) return S.Path;
			if(CostLimit == Double.MAX_VALUE) return null;
			sayln("Odwiedzono "+LastExploredNodes);
			LastExploredNodes=0;
		}
	
	}
	
	private static Solution DepthLimitedSearch(double StartCost, ArrayList<LetterTable> Path, double CostLimit)
	{
		LastExploredNodes++;
		ExploredNodes++;//w tym miejscu mozna wypisywac na ekran ile wezlow odwiedzono
		if(ExploredNodes%1000000==0) sayln("Lacznie "+ExploredNodes);
		
		//bierzemy ostani element ze sciezki i ustawiamy jako sprawdzany wezel
		LetterTable Node = Path.get(Path.size()-1);
		if(Node.getLettersNumber()<MinLetters) MinLetters = Node.getLettersNumber();
		//a tu mozna wypisac najlepsze jak dotad rozwiazanie
		double MinimumCost = StartCost + (1+Node.getLettersNumber()/2)*Node.getPairs();
		
		//jesli koszt przekracza limit to zwracamy ten koszt
		if(MinimumCost > CostLimit)
		{
			
			return S.newSolution(MinimumCost, null);
		}
		//jesli znaleziono rozwiazanie
		if(Node.getLettersNumber()==0) return S.newSolution(CostLimit, Path);
		
		
		double NextCostLimit = Double.MAX_VALUE;
		//petla wywylujaca funkcje dla wszystkich nastepnych wezlow
		for(LetterTable LT: Node.getNextTables())
		{
			int Pairs = LT.calcPairs();
			
			double NewCostLimit = Double.MAX_VALUE;
			double NewStartCost;
			if(Pairs == 0)
			{
				if(LT.getLettersNumber()==0) 
				{
					NewStartCost = StartCost;
				}
				else continue; //jesli nie da sie znalesc pary w tym wezle to omijamy
			}
			else
			{
				NewStartCost = StartCost + Node.getLettersNumber()*(Node.getPairs()-LT.getPairs()); //liczymy koszt
			}
			
			
			ArrayList<LetterTable> NewPath=new ArrayList<LetterTable>(Path);
			NewPath.add(LT);
			
			S = DepthLimitedSearch(NewStartCost, NewPath, CostLimit);
			
			NewCostLimit = S.Cost;
			
			if(S.Path != null) //zwracamy ew. znalezione rozwiazanie
			{
				return S.newSolution(NewCostLimit, S.Path);
			}
			NextCostLimit = Math.min(NextCostLimit, NewCostLimit);
			//if(NewCostLimit>CostLimit && NewCostLimit<NextCostLimit) NextCostLimit = NewCostLimit;
			//na stronie dyskusji o IDA* na wikipedii ktos napisal, ze tak powinno byc zamiast 
			//tej linijki wyzej, ale wg mnie dobrze jest tak jak jest na wiki
		}
		
		
		return S.newSolution(NextCostLimit, null);
	}
	
	public static ArrayList<LetterTable> A_Star(LetterTable Start, GameWindow gw)
	{
		window = gw;
		 //Zbior G
	
		ArrayList<LetterTable>GSet = new ArrayList<LetterTable>();
   
		//Zbior P
		ArrayList<LetterTable>PSet = new ArrayList<LetterTable>();
		Start.setC_cost(0);
		Start.setParent(null);
		Start.calcPairs();
		//dodanie Start do G(0)
		GSet.add(Start);
		
		MinLetters = Start.getLettersNumber();
		
		//S(0)=Start;
		LetterTable S=Start;

		boolean FoundSolution=false;
		while(!GSet.isEmpty())
    	{
			PSet.clear();
			
			//P(i)=rozwiniecie S(i)
			for(LetterTable LT:S.getNextTables())
			{
				ExploredNodes++;
				if(ExploredNodes%10000==0) sayln("Lacznie "+ExploredNodes);
				LT.setParent(S);
				LT.setC_cost(S.getC_cost()+S.getLettersNumber()*(S.getPairs()-LT.calcPairs()));
				LT.setFull_cost(LT.getC_cost()+(1+LT.getLettersNumber()/2)*LT.getPairs());
				PSet.add(LT);
			}
			
			//G(i) - S(i)
			GSet.remove(S);
			
			//G(i) suma P(i)
			boolean CanAdd;
			for(LetterTable LTP:PSet)
			{
				CanAdd=true;
				for(LetterTable LTG:GSet)
				{
					
					if(LTG.isEqual(LTP))
					{
						CanAdd=false;
						break;
					}
					
				}
				if(CanAdd) GSet.add(LTP);
			}
			
			
			double FullCost;
			double MinCost=Double.MAX_VALUE;
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
		
	public static int getExploredNodes() {
		return ExploredNodes;
	}
	public static int getMinLetters() {
		return MinLetters;
	}
	public static int getLastExploredNodes() {
		return LastExploredNodes;
	}
	public static double getLastCostLimit() {
		return LastCostLimit;
	}
	private static double LastCostLimit;
	private static int MinLetters; //minimalna liczba liter, ktora zostala na tablicy w trakcie wykonywania algorytmu
	private static int ExploredNodes = 0; //liczba odwiedzonych wezlow lacznie
	private static int LastExploredNodes = 0; //liczba odwiedzonych wezlow w aktualnej(ostatniej) iteracji
	private static Solution S = new Solution(); //klasa przechowujaca zmienne zwracane przez DLS
	private static GameWindow window;   //uchwyt do gui
        
        
        private static void sayln(String s){
            window.getLoggerArea().append(s + "\n");
        }
}