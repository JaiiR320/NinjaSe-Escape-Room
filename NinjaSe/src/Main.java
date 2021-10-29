import java.util.Scanner;

import boundaries.Window;
import controller.KeyHandler;
import controller.ModelController;

/**
 * Main
 * input w a s d for movement, and reset to reset the board
 */
public class Main {    
    public static int level;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //level = scan.nextInt();
        level = 1;
        ModelController controller = new ModelController(level);
        Window game = new Window(controller.getBoard());
        game.updateGamePanel(controller.getBoard());
        while(true){
            game.updateGamePanel(controller.getBoard());
            controller.model.movePlayer(KeyHandler.proposed);

            if (KeyHandler.reset) {
                controller = new ModelController(level);
                KeyHandler.reset = false;
            }
            if (KeyHandler.moves) {
                System.out.println(controller.model.board.moveCount);
                KeyHandler.moves = false;
            }
            if (controller.model.checkWin()) {
                System.out.println("You Won!");
                System.out.println(controller.model.board.moveCount);
                game.updateGamePanel(controller.model.board);
                System.out.println("Continue? (yes)");
                while (scan.nextLine().compareTo("yes") != 0) {
                    System.out.println("Continue? (yes)");
                }
                KeyHandler.proposed = null;
                controller = new ModelController(level);
            }
        }
    }
}