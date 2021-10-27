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
        this.setSize(800, 540); // 800x500 pixels
        this.setLocation(200, 200); // opens at top left corner, (200, 200)
        this.setLayout(null);
        ImageIcon icon = new ImageIcon("abra.png");
        this.setIconImage(icon.getImage()); // change image at top left of frame

        //Color bg = new Color(0xEFE2BA);
        this.getContentPane().setBackground(Color.LIGHT_GRAY); // set background color
        JLabel label = new JLabel();
        label.setText("Ninja Se");
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        JPanel panel = new JPanel();
        panel.setBounds(0,0,500,500);
        panel.add(label);
        this.add(panel);

        
        this.setVisible(true); // is visible

    }
    
}