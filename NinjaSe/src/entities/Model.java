package entities;

/**
 * Model
 */
public class Model {
    Board board;

    public Model(int level){
        switch (level) {
        case 1:
            initLevel1();
            break;
        case 2:
            initLevel2();
            break;
        case 3:
            initLevel3();
            break;
        default:
            initDefault();
            break;
        }
    }

    /**
     * moves the player, and simultaneously checks for if the move is possible
     * @param d the specified direction
     */
    public void movePlayer(Direction d){
        if(this.board.checkMove(d)){
            this.board.move(d);
        }
        else if (this.board.checkPush(d)){
            this.board.push(d);
        }
        else if(this.board.checkCombine(d)){
            this.board.combine(d);
        }
    }
    
    /**
     * Used for making buttons avaliable. Each time the game is updated, 
     * this function is called for each button/direction, and the buttons are updated
     * @param d the direction specified
     * @return 
     * true if there is a move possible
     * <li>false if there is no move possible</li>
     */
    public boolean checkMove(Direction d){
        return this.board.checkMove(d) || this.board.checkPush(d) || this.board.checkCombine(d); 
    }

    private void initLevel1(){
        this.board = new Board(3, 3);
        this.board.setSpace(0, 0, Space.Player);
        this.board.setObstacle(1, 0, 2, 0, Space.Red);
        this.board.setObstacle(0, 1, 0, 2, Space.Blue);
        this.board.setObstacle(2, 1, 2, 2, Space.Green);
    }

    private void initLevel2(){
        //TODO : implement medium difficulty level
    }

    private void initLevel3(){
        //TODO : implement hard difficulty level
    }

    private void initDefault(){
        this.board = new Board(6, 3);
        this.board.setSpace(1, 0, Space.Player);
        this.board.setObstacle(0, 1, 2, 1, Space.Red);
        this.board.setObstacle(2, 0, 3, 1, Space.Yellow);
        this.board.setObstacle(1, 1, 5, 2, Space.Blue);
        this.board.setObstacle(5, 0, 5, 1, Space.Green);
    }
}
