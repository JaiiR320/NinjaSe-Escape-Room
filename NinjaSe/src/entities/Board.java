package entities;

/**
 * Board
 * any move methods automatically increment moveCount and legality is assumed to be checked before calling
 */
public class Board {
    public int height;
    public int width;
    public int moveCount;
    public int playerX, playerY;
    public Space[][] space;

    /**
     * Board Constructor, set the height and width of the board
     * and
     * <p>
     * <b>Note</b>: 
     * manually edit spaces using <code>setSpace</code>, must also manually 
     * set player position, which updates <code>playerX</code> and <code>playerY</code>
     * @see #setSpace
     * @param height
     * @param width
     */
    public Board(int height, int width){
        this.height = height;
        this.width = width;
        this.space = new Space[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.setSpace(i, j, Space.Empty);
            }
        }
        this.playerX = -1;
        this.playerY = -1;        
    }

    /**
     * Set Space on the board manually by inputting the coordinate and the space type
     * If the <code>s</code> is a <code>Space.Player</code>, <code>playerX</code> and <code>playerY</code> are updated accordingly
     * @see Space
     * @param x the x coordinate
     * @param y the y coordinate 
     * @param s the Space type
     */
    public void setSpace(int x, int y, Space s) {
        if(s == Space.Player){this.playerX = x; this.playerY = y;}
        this.space[x][y] = s;
    }

    public void setObstacle(int x1, int y1, int x2, int y2, Space s){
        this.space[x1][y1] = s;
        this.space[x2][y2] = s;
    }

    /**
     * Checks if the space is an obstacle
     * @param x the x coordinate
     * @param y the y coordinate 
     * @return
     * true if there is an obstacle
     * <li>false if there is no obstacle</li>
     */
    public boolean isObstacle(int x, int y) {
        boolean out = 
        (this.space[x][y] == Space.Blue    ||
         this.space[x][y] == Space.Cyan    || 
         this.space[x][y] == Space.Green   || 
         this.space[x][y] == Space.Magenta || 
         this.space[x][y] == Space.Red     || 
         this.space[x][y] == Space.Yellow);
        return out; 
    }

    /**
     * <p>Moves the player in the specified direction.</p>
     * <b>Note</b>: does not take into account if a move is legal or not
     * @param d the specified direction
     * @see #checkMove
     */
    public void move(Direction d){
        this.moveCount++;
        switch (d) {
        case Up:
            this.space[this.playerX][this.playerY-1] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerY -= 1;
            break;
        case Down:
            this.space[this.playerX][this.playerY+1] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerY += 1;
            break;
        case Left:
            this.space[this.playerX-1][this.playerY] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerX -= 1;
            break;
        case Right:
            this.space[this.playerX+1][this.playerY] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerX += 1;
            break; 
        }
    }
    
    /**
     * Pushes an obstacle in the specified direction
     * <p>
     * <b>Note</b>: does not take into account if a move is legal or not
     * @param d the specified direction
     * @see #checkPush
     */
    public void push(Direction d){
        this.moveCount++;
        switch (d) {
        case Up:
            this.space[this.playerX][this.playerY-2] = this.space[this.playerX][this.playerY-1];
            this.space[this.playerX][this.playerY-1] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerY -= 1;
            break;
        case Down:
            this.space[this.playerX][this.playerY+2] = this.space[this.playerX][this.playerY+1];
            this.space[this.playerX][this.playerY+1] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerY += 1;
            break;
        case Left:
            this.space[this.playerX-2][this.playerY] = this.space[this.playerX-1][this.playerY];
            this.space[this.playerX-1][this.playerY] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerX -= 1;
            break;
        case Right:
            this.space[this.playerX+2][this.playerY] = this.space[this.playerX+1][this.playerY];
            this.space[this.playerX+1][this.playerY] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerX += 1;
            break; 
        }
    }
    
    /**
     * Pushes two obstacles together, combining them and removing them from the board
     * <p>
     * <b>Note</b>: does not take into account if a move is legal or not
     * @param d the specified direction
     * @see #checkCombine
     */
    public void combine(Direction d) {
        this.moveCount++;
        switch (d) {
        case Up:
            this.space[this.playerX][this.playerY-2] = Space.Empty;
            this.space[this.playerX][this.playerY-1] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerY -= 1;
            break;
        case Down:
            this.space[this.playerX][this.playerY+2] = Space.Empty;
            this.space[this.playerX][this.playerY+1] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerY += 1;
            break;
        case Left:
            this.space[this.playerX-2][this.playerY] = Space.Empty;
            this.space[this.playerX-1][this.playerY] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerX -= 1;
            break;
        case Right:
            this.space[this.playerX+2][this.playerY] = Space.Empty;
            this.space[this.playerX+1][this.playerY] = Space.Player;
            this.space[this.playerX][this.playerY] = Space.Empty;
            this.playerX += 1;
            break; 
        }
    }

    /**
     * Checks if there is an empty space in the specified direction.
     * @param d the specified direction
     * @return
     * true if there is an empty space adjacent to the player
     * <li>false if there is no empty space</li>
     */
    public boolean checkMove(Direction d){
        switch (d) {
        case Up:
            if(this.playerY != 0 && this.space[this.playerX][this.playerY-1] == Space.Empty){
                return true;
            }
        case Down:
            if(this.playerY != this.height && this.space[this.playerX][this.playerY+1] == Space.Empty){
                return true;
            }
        case Left:
            if(this.playerX != 0 && this.space[this.playerX-1][this.playerY] == Space.Empty){
                return true;
            }
        case Right:
            if(this.playerX != this.width && this.space[this.playerX+1][this.playerY] == Space.Empty){
                return true;
            }         
        }
        return false;
    }

    /**
     * Checks if there is an obstacle in the specified direction, and an empty space beyond that
     * @param d the specified direction
     * @return
     * true if there is an obstacle, then an empty space
     * <li>false if there is no obstacle or empty space beyond</li>
     */
    public boolean checkPush(Direction d){
        switch (d) {
        case Up:
            return this.playerY > 1 && this.isObstacle(this.playerX, this.playerY-1) && !this.isObstacle(this.playerX, this.playerY-2);
        case Down:
            return this.playerY < this.height-1 && this.isObstacle(this.playerX, this.playerY+1) && !this.isObstacle(this.playerX, this.playerY+2);
        case Left:
            return this.playerX > 1 && this.isObstacle(this.playerX-1, this.playerY) && !this.isObstacle(this.playerX-2, this.playerY);
        case Right:
            return this.playerX < this.width-1 && this.isObstacle(this.playerX+1, this.playerY) && !this.isObstacle(this.playerX+2, this.playerY);
        default:
            return false;
        }
    }

    /**
     * Check if player is at least 2 spaces from edge, and if there are 2 obstacles adjacent 
     * and inline with the player, and if they are the same color obstacle in the corresponding direction
     * @param d the specified direction
     * @return true if there are 2 obstacles adjacent and inline with the player
     * <li>false if the player is at the edge, or there are no obstacles inline with player</li>
     */
    public boolean checkCombine(Direction d){
        int x = this.playerX;
        int y = this.playerY;
        switch (d) {
        case Up:
            return y > 1 && this.isObstacle(x, y-1) && this.isObstacle(x, y-2) && space[x][y-1] == space[x][y-2];
        case Down:
            return y < this.height-1 && this.isObstacle(x, y+1) && this.isObstacle(x, y+2) && space[x][y+1] == space[x][y+2];
        case Left:
            return x > 1 && this.isObstacle(x-1, y) && this.isObstacle(x-2, y) && space[x-1][y] == space[x-2][y];
        case Right:
            return x < this.width-1 && this.isObstacle(x+1, y) && this.isObstacle(x+2, y) && space[x+1][y] == space[x+2][y]; 
        default:
            return false;
        }
    }
}