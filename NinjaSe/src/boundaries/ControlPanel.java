package boundaries;

import java.awt.*;
import java.awt.event.*;
import java.lang.Character.UnicodeBlock;

import javax.swing.JButton;
import javax.swing.JPanel;
import controller.*;

/**
 * ControlPanel
 */
public class ControlPanel extends JPanel implements ActionListener {
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;

    public ControlPanel(){
        this.SCREEN_HEIGHT = 350;
        this.SCREEN_WIDTH = 200;
        this.addKeyListener(new MyKeyAdapter());
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        JButton up = new JButton("⯅");
        JButton down = new JButton("⯆");
        JButton left = new JButton("⯇");
        JButton right =  new JButton("⯈");
        up.setFocusable(false);
        down.setFocusable(false);
        left.setFocusable(false);
        right.setFocusable(false);

        this.setLayout(null);

        up.setBounds(70, 250, 60, 30);
        down.setBounds(70, 310, 60, 30);
        left.setBounds(40, 280, 60, 30);
        right.setBounds(100, 280, 60, 30);

        up.setFont(new Font("Monospaced", Font.BOLD, 25));
        down.setFont(new Font("Monospaced", Font.BOLD, 25));
        left.setFont(new Font("Monospaced", Font.BOLD, 25));
        right.setFont(new Font("Monospaced", Font.BOLD, 25));


        this.add(up);
        this.add(down);
        this.add(left);
        this.add(right);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_W:
                    KeyHandler.moveU();
                    break;
                case KeyEvent.VK_A:
                    KeyHandler.moveL();
                    break;
                case KeyEvent.VK_S:
                    KeyHandler.moveD();
                    break;
                case KeyEvent.VK_D:
                    KeyHandler.moveR();
                    break;
                case KeyEvent.VK_R:
                    KeyHandler.resetGame();
                    break;
                case KeyEvent.VK_Q:
                    KeyHandler.showMoves();
                    break;
            }
        }
    }
}
