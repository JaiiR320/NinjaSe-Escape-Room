package controller;

import entities.*;
import boundaries.GamePanel;
import boundaries.Window;

/**
 * ResetController
 */
public class ResetController {
    Model model;
    Window window;

    /**
     * Constructor for ResetController, which instantiates with the model and window
     * @param m
     * @param w
     */
    public ResetController(Model m, Window w) {
        this.model = m;
        this.window = w;
    }

    /**
     * Resets the current level, and updates tha game panel
     */
    public void resetCurrentLevel(){
        this.model.initialize(this.model.currentLevel);
        window.updateGame(model.board);
    }

    /**
     * Resets the game with a new level and updates the game panel
     * @param level
     */
    public void selectLevel(int level){
        this.model.initialize(level);
        window.remove(window.gPanel);
        window.gPanel = new GamePanel(model.board);
        window.gPanel.setBounds(4, 4, 350, 350);
        window.add(window.gPanel);
        window.updateGame(model.board);
    }
}