package controller;

import entities.Direction;

/**
 * 
 */
public class KeyHandler {
    public static Direction proposed;
    public static boolean reset = false;
    public static boolean moves = false;
    
    public static void moveU(){
        proposed = Direction.Up;
    }
    public static void moveD(){
        proposed = Direction.Down;
    }
    public static void moveL(){
        proposed = Direction.Left;
    }
    public static void moveR(){
        proposed = Direction.Right;
    }
    public static void reset(){
        proposed = null;
    }
    public static void resetGame(){
        reset = true;
    }
    public static void showMoves(){
        moves = true;
    }
}
