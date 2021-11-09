import boundaries.*;
import entities.*;

/**
 * Main
 * input w a s d for movement, and reset to reset the board
 */
public class Main {    
<<<<<<< HEAD
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        Model NinjaSe = new Model();   
        //UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme");
		Window window = new Window(NinjaSe);     
        window.setVisible(true); 
=======
    public static void main(String[] args) {
        Model NinjaSe = new Model();
        Window window = new Window(NinjaSe);
>>>>>>> parent of 44924e2 (project read me)
    }
}