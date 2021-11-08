import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import boundaries.*;
import entities.*;

/**
 * Main
 * input w a s d for movement, and reset to reset the board
 */
public class Main {    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        Model NinjaSe = new Model();   
        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme");
		Window window = new Window(NinjaSe);      
    }
}