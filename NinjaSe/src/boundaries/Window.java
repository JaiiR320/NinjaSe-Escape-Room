package boundaries;

import javax.swing.*;
import java.awt.*;
import entities.Board;

/**
 * Window class, for making window objects that contain the game and control panels
 */
public class Window extends JFrame{
    private GamePanel gPanel;
    private ControlPanel cPanel;

    /**
     * Creates a window object, which is the parent window the game is displayed on. 
     * Initialize it with a board so that the game panel can be initialized and drawn. 
     * The window will hole 2 panels, one for the game board and one for the controls.
     * @param b the board to initialize with
     */
    public Window(Board b){
        gPanel = new GamePanel(b);
        cPanel = new ControlPanel();
        cPanel.setPreferredSize(new Dimension(cPanel.SCREEN_WIDTH, cPanel.SCREEN_HEIGHT));

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(this.gPanel);
        this.add(this.cPanel);
        this.setTitle("NinjaSe");
        ImageIcon image = new ImageIcon("NinjaSe\\abra.png");
        this.setIconImage(image.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(230 + gPanel.SCREEN_WIDTH, 400);
        this.setVisible(true);
        this.setLocation(200, 200);
    }

    /**
     * Update the game panel by passing in a new instance of the board to repaint the board. You can update to any board state and it will update accordingly. 
     * @param b the board to update the panel to. Does not care about the previous state of the board
     */
    public void updateGamePanel(Board b) {
        this.gPanel.updateBoard(b);
        this.gPanel.repaint();
    }
}
