import java.util.Scanner;

import entities.*;

/**
 * Main
 * input w a s d for movement, and reset to reset the board
 */
public class Main {
    public static void main(String[] args) {
        Model ninjaSeModel = new Model(0);
        Scanner in = new Scanner(System.in);
        ninjaSeModel.printBoard();
        String move;
        while(!ninjaSeModel.checkWin()){
            if(ninjaSeModel.checkMove(Direction.Up)){
                System.out.print("Up, ");
            }
            if(ninjaSeModel.checkMove(Direction.Down)){
                System.out.print("Down, ");
            }
            if(ninjaSeModel.checkMove(Direction.Left)){
                System.out.print("Left, ");
            }
            if(ninjaSeModel.checkMove(Direction.Right)){
                System.out.print("Right, ");
            }
            System.out.println("is avaliable");
            move = in.nextLine();
            if(move.compareTo("w") == 0)
                ninjaSeModel.movePlayer(Direction.Up);
            else if(move.compareTo("a") == 0)
                ninjaSeModel.movePlayer(Direction.Left);
            else if(move.compareTo("s") == 0)
                ninjaSeModel.movePlayer(Direction.Down);
            else if(move.compareTo("d") == 0)
                ninjaSeModel.movePlayer(Direction.Right);
            else if(move.compareTo("reset") == 0){
                ninjaSeModel = new Model(0);
            }
            else if(move.compareTo("moves") == 0){
                System.out.println(ninjaSeModel.board.moveCount);
            }
            
            if (ninjaSeModel.checkWin()) {
                System.out.println("You Won!");
                System.out.println(ninjaSeModel.board.moveCount);
                ninjaSeModel.printBoard();
                ninjaSeModel = new Model(0);
            }
            ninjaSeModel.printBoard();
        }
        
        in.close();
    }
    
}