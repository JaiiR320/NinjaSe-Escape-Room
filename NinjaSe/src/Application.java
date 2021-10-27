import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Application
 */
public class Application extends JFrame {
    public static void main(String[] args) {
        Application window = new Application();
    }

    public Application() {
        this.setTitle("NinjaSe"); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close window
        this.setResizable(false); // not resizable
        this.setSize(800, 500); // 800x500 pixels
        this.setLocation(200, 200); // opens at top left corner, (200, 200)

        ImageIcon icon = new ImageIcon("abra.png");
        this.setIconImage(icon.getImage()); // change image at top left of frame

        //Color bg = new Color(0xEFE2BA);
        this.getContentPane().setBackground(Color.LIGHT_GRAY); // set background color
        JLabel label = new JLabel();
        label.setText("Ninja Se");
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setBounds(0, 0, 250, 250);

        this.add(label);
        this.pack();
        this.setVisible(true); // is visible

    }
    
}