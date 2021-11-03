package boundaries;

import entities.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    private int BLOCK_SIZE = 50;
    private Board board;
    private Image ninja;

    /**
     * Creates a game panel, initialized with a board. The board is used to draw the space and also 
     * records the height and width of the board. Also automatically sets the size of the screen
     * based on the actual size of the space
     * @param b
     */
    public GamePanel(Board b){
        this.board = b;
        this.SCREEN_HEIGHT = (b.height+1)*BLOCK_SIZE;
        this.SCREEN_WIDTH = (b.width+1)*BLOCK_SIZE;
        File pic = new File ("NinjaSe\\ninja-se.png");
        this.ninja = null;
        try {
            this.ninja = ImageIO.read(pic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setPreferredSize(new Dimension(this.SCREEN_WIDTH, this.SCREEN_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * Update the board in the panel object, so that the new board can be used to repaint
     * @param b the new board state
     */
    public void updateBoard(Board b){
        this.board = b;
    }

    /**
     * Paint the components passed in. Calls <code>draw()</code>
     * @see #draw(Graphics)
     * @param g the graphics
     */
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        draw(g);
    }
    
    /**
     * Draws the entire board on the panel. Lines overlap outside the panel by 2px. The board is dynamically drawn, and can take any board.
     * @param g the graphics
     */
    private void draw(Graphics g) {
        // Draw obstacles or empty spaces on board
        for(int i = 0; i < this.SCREEN_HEIGHT/this.BLOCK_SIZE; i++){
            for (int j = 0; j < this.SCREEN_WIDTH/this.BLOCK_SIZE; j++) {
                switch (board.space[i][j]) {
                    case Red:
                        g.setColor(Color.RED);
                        break;
                    case Blue:
                        g.setColor(Color.BLUE);
                        break;
                    case Yellow:
                        g.setColor(Color.YELLOW);
                        break;
                    case Green:
                        g.setColor(Color.GREEN);
                        break;
                    case Magenta:
                        g.setColor(Color.MAGENTA);
                        break;
                    case Cyan:
                        g.setColor(Color.CYAN);
                        break;
                    case Player:
                        g.setColor(new Color(0x9E49A6));
                        break;
                    case Empty:
                        g.setColor(Color.GRAY);
                        break;
                }
                g.fillRect(j*BLOCK_SIZE, i*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            }
        }
        // draw NinjaSe image on board
        g.drawImage(this.ninja, board.playerX*BLOCK_SIZE, board.playerY*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, Color.black, null);

        // Grid lines
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < SCREEN_HEIGHT/BLOCK_SIZE + 1; i++) {
            g2d.drawLine(0, i*BLOCK_SIZE, SCREEN_WIDTH, i*BLOCK_SIZE);
        }
        for (int i = 0; i < SCREEN_WIDTH/BLOCK_SIZE + 1; i++) {
            g2d.drawLine(i*BLOCK_SIZE, 0, i*BLOCK_SIZE, SCREEN_HEIGHT);
        }
    }
}
