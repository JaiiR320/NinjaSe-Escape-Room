import javax.swing.*;
import java.awt.*;

/**
 * Panel
 */
public class Control extends JPanel {
    Control control;
    Control(){
        this.setBounds(520, 0, 320, 520);
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setStroke(new BasicStroke(4));
        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.fillRect(0, 10, 300, 500);
    }
}