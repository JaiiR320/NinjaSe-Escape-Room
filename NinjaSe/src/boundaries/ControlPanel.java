package boundaries;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ControlPanel
 */
public class ControlPanel extends JPanel {
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    public JButton up;
    public JButton down;
    public JButton left;
    public JButton right;
    public JButton reset;
    public JLabel moveLabel;
    public JButton level1;
    public JButton level2;
    public JButton level3;


    public ControlPanel(){
        this.SCREEN_HEIGHT = 350;
        this.SCREEN_WIDTH = 200;
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);

        up = new JButton("⯅");
        down = new JButton("⯆");
        left = new JButton("⯇");
        right = new JButton("⯈");
        reset = new JButton("Reset");
        level1 = new JButton("Level 1");
        level2 = new JButton("Level 2");
        level3 = new JButton("Level 3");
        moveLabel = new JLabel("Moves: 0");

        up.setFocusable(false);
        down.setFocusable(false);
        left.setFocusable(false);
        right.setFocusable(false);
        reset.setFocusable(false);
        level1.setFocusable(false);
        level2.setFocusable(false);
        level3.setFocusable(false);

        this.setLayout(null);

        up.setBounds(72, 250, 60, 30);
        down.setBounds(72, 310, 60, 30);
        left.setBounds(42, 280, 60, 30);
        right.setBounds(102, 280, 60, 30);
        reset.setBounds(102, 8, 90, 50);
        level1.setBounds(6, 80, 110, 30);
        level2.setBounds(6, 110, 110, 30);
        level3.setBounds(6, 140, 110, 30);
        moveLabel.setBounds(6, 8, 90, 50);

        up.setFont(new Font("Monospaced", Font.BOLD, 25));
        down.setFont(new Font("Monospaced", Font.BOLD, 25));
        left.setFont(new Font("Monospaced", Font.BOLD, 25));
        right.setFont(new Font("Monospaced", Font.BOLD, 25));       
        level1.setFont(new Font("Monospaced", Font.BOLD, 15));  
        level2.setFont(new Font("Monospaced", Font.BOLD, 15));  
        level3.setFont(new Font("Monospaced", Font.BOLD, 15));   
        reset.setFont(new Font("Monospaced", Font.BOLD, 18));
    }
}   
