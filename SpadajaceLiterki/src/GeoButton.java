
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karol
 */
public class GeoButton extends JToggleButton implements MouseListener{
    private Point coordinates;
    private GameWindow gameWindow;
    private Border selectedBorder;
    
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
    
    public Point getPoint()
    {
        return coordinates;
    }
    
    public Border getSelectedBorder()
    {
        return selectedBorder;
    }
    
    public void setSelectedBorder(Border b)
    {
        this.selectedBorder = b;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Point firstPoint = gameWindow.getSelectedPoint();
        gameWindow.log(getText() + " " + coordinates + " zostalo klikniete (zaznaczone = "
                + this.isSelected() + ")\n");
                
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

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        setSameLettersBorder(BorderFactory.createLineBorder(Color.black, 4));
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.setBorder(selectedBorder);
        setSameLettersBorder(null);
    }
    
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
    
    private void removeLetterPair(Point p1, Point p2)
    {
        removeLetter(p1);
        removeLetter(p2);
        gameWindow.log("Usuwanie liter " + p1 + " " + p2 + "\n");
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
//        gameWindow.getPoints_to_buttons().get(new Point((int)p.getX(), 1)).setVisible(false);
    }
}
