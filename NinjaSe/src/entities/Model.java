package entities;

import controller.KeyHandler;

/**
 * Model
 */
public class Model {
    public Board board;

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
        if(d == null){
            return;
        }
        if(this.board.checkMove(d)){
            this.board.move(d);
        }
        else if (this.board.checkPush(d)){
            this.board.push(d);
        }
        else if(this.board.checkCombine(d)){
            this.board.combine(d);
        }
        else {
            System.out.println("Cannot move " + d);
        }
        KeyHandler.reset();
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


    public boolean checkWin(){
        for (Space[] row : this.board.space) {
            for (Space space : row) {
                if (space != Space.Empty && space != Space.Player)
                    return false;
            }
        }
        return true;
    }

    public void printBoard(){
        for (Space[] rowsSpaces : this.board.space) {
            for (Space space : rowsSpaces) {
                switch (space) {
                    case Red:
                        System.out.print("R ");
                        break;
                    case Blue:
                        System.out.print("B ");
                        break;
                    case Yellow:
                        System.out.print("Y ");
                        break;
                    case Green:
                        System.out.print("G ");
                        break;
                    case Magenta:
                        System.out.print("M ");
                        break;
                    case Cyan:
                        System.out.print("C ");
                        break;
                    case Player:
                        System.out.print("P ");
                        break;
                    case Empty:
                        System.out.print("E ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void initLevel1(){
        this.board = new Board(3, 3);
        this.board.setSpace(0, 0, Space.Player);
        this.board.setObstacle(1, 0, 2, 0, Space.Red);
        this.board.setObstacle(0, 1, 1, 1, Space.Blue);
        this.board.setObstacle(1, 2, 2, 2, Space.Green);
    }

    private void initLevel2(){
        this.board = new Board(7, 7);
        this.board.setSpace(0, 0, Space.Player);
        this.board.setObstacle(1, 0, 2, 0, Space.Red);
        this.board.setObstacle(0, 1, 1, 1, Space.Blue);
        this.board.setObstacle(1, 2, 2, 2, Space.Green);
    }

    private void initLevel3(){
        this.board = new Board(3, 7);
        this.board.setSpace(1, 0, Space.Player);
        this.board.setObstacle(0, 1, 2, 1, Space.Red);
        this.board.setObstacle(2, 0, 3, 1, Space.Yellow);
        this.board.setObstacle(1, 1, 6, 2, Space.Blue);
        this.board.setObstacle(6, 0, 6, 1, Space.Green);
    }

    private void initDefault(){
        this.board = new Board(3, 7);
        this.board.setSpace(1, 0, Space.Player);
        this.board.setObstacle(0, 1, 2, 1, Space.Red);
        this.board.setObstacle(2, 0, 3, 1, Space.Yellow);
        this.board.setObstacle(1, 1, 6, 2, Space.Blue);
        this.board.setObstacle(6, 0, 6, 1, Space.Green);
    }
}
