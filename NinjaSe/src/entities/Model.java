package entities;

/**
 * Model
 */
public class Model {
    public Board board;
    public int currentLevel;

    public Model(){
        this.initialize(1);
    }

    /**
     * Initialize the model with a given level. Updates the board.
     * @param level
     */
    public void initialize(int level){
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
                initLevel1();
                break;
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

    /**
     * Checks if the current board has no obstacles. 
     * @return
     * true if the board has no obstacles
     * <li>false if the board still has obstacles</li>
     */
    public boolean checkWin(){
        for (Space[] row : this.board.space) {
            for (Space space : row) {
                if (space != Space.Empty && space != Space.Player)
                    return false;
            }
        }
        return true;
    }

    /**
     * Prints the board to the console
     */
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
        this.board = new Board(4, 5);
        this.board.setSpace(1, 1, Space.Player);
        this.board.setObstacle(3, 0, 2, 2, Space.Yellow);
        this.currentLevel = 1;
    }

    private void initLevel2(){
        this.board = new Board(3, 7);
        this.board.setSpace(1, 0, Space.Player);
        this.board.setObstacle(0, 1, 2, 1, Space.Red);
        this.board.setObstacle(2, 0, 3, 1, Space.Yellow);
        this.board.setObstacle(1, 1, 6, 2, Space.Blue);
        this.board.setObstacle(6, 0, 6, 1, Space.Green);
        this.currentLevel = 2;
    }

    private void initLevel3(){
        this.board = new Board(7, 7);
        this.board.setSpace(6, 6, Space.Player);
        this.board.setObstacle(5, 1, 0, 3, Space.Magenta);
        this.board.setObstacle(1, 2, 3, 3, Space.Cyan);
        this.board.setObstacle(2, 2, 5, 6, Space.Green);
        this.board.setObstacle(1, 3, 4, 5, Space.Yellow);
        this.board.setObstacle(1, 4, 5, 5, Space.Blue);
        this.board.setObstacle(2, 3, 6, 5, Space.Red);
        this.currentLevel = 3;
    }
}
