
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

/**
 * Implementująca przycisk posiadający współrzędne w dwu wymiarowym układzie odniesienia
 * @author karol
 */
public class GeoButton extends JToggleButton implements MouseListener{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Point coordinates;
    private GameWindow gameWindow;
    private Border selectedBorder;
    
    /**
     * Tworzy przycisk z tekstem, współrzędnymi i uchwytem, do okna, w którym jest wyświetlany
     * @param c litera wstawiana jako tekst przycisku
     * @param x wspolrzedna pozioma x
     * @param y wspolrzedna pionowa y
     * @param f uchwyt do glownego okna, ktorym przycisk jest wyswietlany
     */
    public GeoButton(char c, int x, int y, GameWindow f)
    {
        this.setText("" + c);
        this.coordinates = new Point(x, y);
        this.gameWindow = f;
        if(gameWindow.getTab()==1){
            this.addMouseListener(this);
        } else {
            MouseListener[] mouse = this.getMouseListeners();
            for(int i=0;i<mouse.length;i++)
            {
                this.removeMouseListener(mouse[i]);
            }
        }
    }
    
    /**
     * Zwraca wpolrzedne przycisku w postaci obiektu Point
     * @return 
     */
    public Point getPoint()
    {
        return coordinates;
    }
    
    /**
     * Zwraca obramowanie przycisku, kiedy jest zaznaczony
     * @return 
     */
    public Border getSelectedBorder()
    {
        return selectedBorder;
    }
    
    /**
     * Ustawia obramowanie przycisku, kiedy jest zaznaczony
     * @param b Obramowanie
     */
    public void setSelectedBorder(Border b)
    {
        this.selectedBorder = b;
    }

    /**
     * Obsluga klikniecia myszka na przycisk. Jesli wczesniej nie kliknieto zadnego przycisku, to zmienia obramowanie przycisku.
     * W przeciwnym wypadku, sprawdza, czy poprzednio klikniety przycisk, to przycisk z identyczna liteka. Jesli tak, to przyciski
     * sa zdejmowane. W przeciwnym wypadku, oba przyciski zostaja odznaczone.
     * @param me Zdarzenie myszy
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        Point firstPoint = gameWindow.getSelectedPoint();
                
        if(firstPoint==null)
        {
            this.setSelected(true);
            selectedBorder = BorderFactory.createLineBorder(Color.yellow, 3);
            this.setBorder(selectedBorder);
            gameWindow.setSelectedPoint(this.coordinates);
        } else {
            ArrayList<Point> sameLettersCoordinates = gameWindow.getLetterTable().getSameMap().get(this.coordinates);
            Hashtable<Point, GeoButton> points_to_buttons = gameWindow.getPoints_to_buttons();
            
            if(sameLettersCoordinates!= null && sameLettersCoordinates.contains(firstPoint))
            {
                //usuwanie literek
                removeLetterPair(firstPoint, this.coordinates);
                gameWindow.setSelectedPoint(null);
            } else {
                //odznaczenie literek
                points_to_buttons.get(firstPoint).setSelectedBorder(null);
                points_to_buttons.get(firstPoint).setSelected(false);
                this.setSelected(false);
                gameWindow.setSelectedPoint(null);
            }
        }
    }
    
    /**
     * Funkcja nie obslugiwana
     */
    @Override
    public void mousePressed(MouseEvent me) {
    }

    /**
     * Funkcja nie obslugiwana
     */
    @Override
    public void mouseReleased(MouseEvent me) {
    }

    /**
     * Obsluguje zdarzenie najechania myszka na przycisk. Ustawia szczegolne obramowanie przyciskow o 
     * wsporzednej x lub y takiej samej jak wporzedna x lub y przycisku, na ktory najechano myszka.
     * @param me Zdarzenie myszy
     */
    @Override
    public void mouseEntered(MouseEvent me) {
        this.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        setSameLettersBorder(BorderFactory.createLineBorder(Color.black, 4));
        
    }

    /**
     * Obsluguje zdarzenie odjechania myszka znad przycisku. Usuwa szczegolne obramowanie przyciskow o 
     * wsporzednej x lub y takiej samej jak wporzedna x lub y przycisku, znad ktorego przesunieto myszke.
     * @param me Zdarzenie myszy
     */
    @Override
    public void mouseExited(MouseEvent me) {
        this.setBorder(selectedBorder);
        setSameLettersBorder(null);
    }
    
    /**
     * Ustawia szczegolne obramowanie przyciskow o wspolrzednej x lub y identycznej ze wsporzedna
     * x lub y tego przycisku
     * @param b Obramowanie przycisku
     */
    private void setSameLettersBorder(Border b)
    {
        ArrayList<Point> sameLettersCoordinates = gameWindow.getLetterTable().getSameMap().get(this.coordinates);
        Hashtable<Point, GeoButton> points_to_buttons = gameWindow.getPoints_to_buttons();
        
        if(sameLettersCoordinates!=null)
        {
            for(Point point : sameLettersCoordinates)
            {
                if(points_to_buttons.get(point).getSelectedBorder()==null)
                    points_to_buttons.get(point).setBorder(b);
            }
        }
    }
    
    /**
     * Usuwa z tablicy liter pare identycznych literek
     * @param p1 Wspolrzedne pierwszego przycisku
     * @param p2 Wspolrzedne drugiego przycisku
     */
    private void removeLetterPair(Point p1, Point p2)
    {
        char l1 = gameWindow.getLetterTable().getLetter(new Point((int)p1.getX()-1, (int)p1.getY()-1));
        char l2 = gameWindow.getLetterTable().getLetter(new Point((int)p2.getX()-1, (int)p2.getY()-1));
        removeLetter(p1);
        removeLetter(p2);
        
        gameWindow.log("Usuwanie liter " + l1 + "(" + (int)p1.getX() + "," + (int)p1.getY() + ") " 
                + l2 + "(" + (int)p2.getX() + "," + (int)p2.getY() + ")\n");
        gameWindow.log("\nNowa postać planszy:\n");
        gameWindow.log(gameWindow.getLetterTable().toString() + "\n");
        gameWindow.getLetterTable().calcPairs();
        gameWindow.log("Liczba możliwych par: " +gameWindow.getLetterTable().getPairs() + "\n\n");
        gameWindow.makeBoard();
        
        int pairs = gameWindow.getLetterTable().getPairs();
        if(pairs==0)
        {
            gameWindow.getTimer().stop();
            gameWindow.log("KONIEC GRY\n\n");
            
            JOptionPane.showMessageDialog(gameWindow,
                "Nie ma więcej par.\nKONIEC GRY",
                "KONIEC GRY",
                JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * Usuwa litere z tablicy liter
     * @param p  wspolrzedne litery w układzie planszy. Zaczynaja sie od 1.
     */
    private void removeLetter(Point p)
    {
        //konwersja wspolrzednych do numerow elementow tablicy
        int x = (int)p.getX()-1;
        int y = (int)p.getY()-1;
        // iteracja od klikniętego przycisku do przedostatniego najwyższego nad nim
        for(int h = y; h>0; h--)
        {
           char l = gameWindow.getLetterTable().getLetter(new Point(x,h-1));
           gameWindow.getLetterTable().setLetter(l, new Point(x, h)); 
        }
        gameWindow.getLetterTable().setLetter(' ', new Point(x, 0));
    }
}
