package controller;
import entities.*;

public class ModelController {
    public Model model;

    public ModelController(int level){
        model = new Model(level);
    }
    public Board getBoard(){
        return this.model.board;
    }
}
