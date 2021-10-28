import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Window extends JFrame implements ActionListener {
    private static String name;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
                    for (UIManager.LookAndFeelInfo look : looks) {
                        System.out.println(look.getClassName());
                    }
                    UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme");
                    
                    Window frame = new Window();
                    frame.setVisible(true);
                    name = JOptionPane.showInputDialog("Enter your name");  
                    JOptionPane.showMessageDialog(null, "Hello, " + name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Window() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(500, 500);
        setResizable(false);
        setTitle("Ninja Se");
        JButton jb1 = new JButton("Windows");        
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Nimbus");        
        JButton jb4 = new JButton("Button 4");

        jb1.addActionListener(this);
        jb4.addActionListener(this);
        jb1.setFocusPainted(false);
        jb2.setFocusPainted(false);
        jb3.setFocusPainted(false);
        jb4.setFocusPainted(false);

        // Define the panel to hold the buttons 
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        // Set up the title for different panels
        panel1.setBorder(BorderFactory.createTitledBorder("Game"));
        panel2.setBorder(BorderFactory.createTitledBorder("Controls"));
        
        // Set up the BoxLayout
        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel1.setLayout(layout1);
        panel2.setLayout(layout2);
        
        // Add the buttons into the panel with three different alignment options
        jb1.setAlignmentX(CENTER_ALIGNMENT);
        jb2.setAlignmentX(CENTER_ALIGNMENT);
        panel1.add(jb1);
        panel1.add(jb2);
        
        jb3.setAlignmentX(CENTER_ALIGNMENT);
        jb4.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jb3);
        panel2.add(jb4);
        
        // Add the three panels into the frame
        setLayout(new FlowLayout());
        add(panel1);
        add(panel2);
        
        // Set the window to be visible as the default to be false
        //pack();
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
        case "Windows":
            System.out.println("1");
            break;
        case "Button 4":
            System.out.println("4");
            break;
        }
    }
}