import java.awt.*;

import javax.swing.*;

/**
 * Application
 */
public class Application extends JFrame {
    Board board;
    Control control;
    public static void main(String[] args) {
        new Application();
    }

    public Application() {
        board = new Board();
        control = new Control();
        this.setTitle("NinjaSe"); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close window
        this.setResizable(false); // not resizable
        this.setLocation(100, 100); // opens at center of screen
        this.setLayout(null);
        this.setSize(new Dimension(846, 559));

          // change image at top left of frame

        this.add(board);
        this.add(control);
        this.setVisible(true); // is visible
    }    
}