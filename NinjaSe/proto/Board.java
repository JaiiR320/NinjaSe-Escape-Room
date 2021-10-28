import javax.swing.*;
import java.awt.*;

/**
 * Board
 */
public class Board extends JPanel {
    Board board;
    Board(){
        this.setBounds(0, 0, 520, 520);
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.fillRect(10,10,500,500);
    }
}