
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karol
 */
public class GeoButton extends JButton implements MouseListener{
    private Point coordinates;
    private GameWindow gameWindow;
    
    public GeoButton(char c, int x, int y, GameWindow f)
    {
        this.setText("" + c);
        this.coordinates = new Point(x, y);
        this.addMouseListener(this);
        this.gameWindow = f;
    }
    
    public Point getPoint()
    {
        return coordinates;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        setSameLettersBorder(BorderFactory.createLineBorder(Color.black, 4));
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.setBorder(null);
        setSameLettersBorder(null);
    }
    
    private void setSameLettersBorder(Border b)
    {
        ArrayList<Point> sameLettersCoordinates = gameWindow.getLetterTable().getSameMap().get(this.getText());
        Hashtable<Point, GeoButton> points_to_buttons = gameWindow.getPoints_to_buttons();
        
        if(sameLettersCoordinates!=null)
        {
            for(Point point : sameLettersCoordinates)
            {
                points_to_buttons.get(point).setBorder(b);
            }
        }
    }
}
