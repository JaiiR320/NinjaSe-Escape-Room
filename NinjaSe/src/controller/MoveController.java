package controller;

import javax.swing.JOptionPane;

import boundaries.*;
import entities.*;

public class MoveController {
    public Model model;
    public Window window;

    /**
     * Constructor for MoveController, which instantiates with the model and window
     * @param m Model
     * @param w Window
     */
    public MoveController(Model m, Window w) {
        this.model = m;
        this.window = w;
    }

    /**
     * moves player by calling <code>move()</code>, updates game panel, disables keys on win, and updates move counter
     * @see #move(Direction)
     * @param d
     */
    public void movePlayer(Direction d) {
        if(d == null){
            return;
        }
        if(this.model.board.checkMove(d)){
            this.model.board.move(d);
        }
        else if (this.model.board.checkPush(d)){
            this.model.board.push(d);
        }
        else if(this.model.board.checkCombine(d)){
            this.model.board.combine(d);
        }
        else {
            System.out.println("Cannot move " + d);
        }
        this.window.updateGame(this.model.board);
        this.window.cPanel.moveLabel.setText("Moves : " + this.model.board.moveCount);
        if(this.model.checkWin()){
            this.window.disableKeys();
            JOptionPane.showMessageDialog(null, "You Won!", "NinjaSe", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
}
