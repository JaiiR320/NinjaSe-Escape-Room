package boundaries;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;

import entities.*;
import controller.*;
/**
 * Window class, for making window objects that contain the game and control panels
 */
public class Window extends JFrame{
    public GamePanel gPanel;
    public ControlPanel cPanel;
    private Model model;

    /**
     * Creates a window object, which is the parent window the game is displayed on. 
     * Initialize it with a board so that the game panel can be initialized and drawn. 
     * The window will hole 2 panels, one for the game board and one for the controls.
     * @param b the board to initialize with
     */
    public Window(Model m){
        this.model = m;
        gPanel = new GamePanel(this.model.board);
        gPanel.setPreferredSize(new Dimension(350, 350));
        cPanel = new ControlPanel();
        cPanel.setPreferredSize(new Dimension(cPanel.SCREEN_WIDTH, cPanel.SCREEN_HEIGHT));
        
        cPanel.up.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MoveController(model, Window.this).movePlayer(Direction.Up);
            }
        });
        cPanel.down.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MoveController(model, Window.this).movePlayer(Direction.Down);
            }
        });
        cPanel.left.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MoveController(model, Window.this).movePlayer(Direction.Left);
            }
        });
        cPanel.right.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MoveController(model, Window.this).movePlayer(Direction.Right);
            }
        });
        cPanel.level1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResetController(model, Window.this).selectLevel(1);
            }
        });
        cPanel.level2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResetController(model, Window.this).selectLevel(2);
            }
        });
        cPanel.level3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResetController(model, Window.this).selectLevel(3);
            }
        });
        cPanel.reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResetController(model, Window.this).resetCurrentLevel();
            }
        });

        this.cPanel.add(cPanel.up);
        this.cPanel.add(cPanel.down);
        this.cPanel.add(cPanel.left);
        this.cPanel.add(cPanel.right);
        this.cPanel.add(cPanel.reset);
        this.cPanel.add(cPanel.level1);
        this.cPanel.add(cPanel.level2);
        this.cPanel.add(cPanel.level3);
        this.cPanel.add(cPanel.moveLabel);

        //this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(null);
        cPanel.setBounds(358, 4, 200, 350);
        gPanel.setBounds(4, 4, 350, 350);
        this.add(this.gPanel);
        this.add(this.cPanel);
        
        this.setTitle("NinjaSe");
        ImageIcon image = new ImageIcon("NinjaSe\\bin\\abra.png");
        this.setIconImage(image.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(578, 397));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.updateKeyState();
    }

    /**
     * Update the game panel by passing in a new instance of the board to repaint the board. You can update to any board state and it will update accordingly. 
     * @param b the board to update the panel to. Does not care about the previous state of the board
     */
    public void updateGame(Board b) {
        this.gPanel.updateBoard(b);
        this.updateKeyState();
        this.cPanel.moveLabel.setText("Moves: 0");
        this.gPanel.repaint();
    }

    /**
     * Updates the state of the keys by making keys with illegal direction disabled
     */
    public void updateKeyState() {
        if (!this.model.checkMove(Direction.Up)) {
            this.cPanel.up.setEnabled(false);
        } else {
            this.cPanel.up.setEnabled(true);
        }

        if (!this.model.checkMove(Direction.Down)) {
            this.cPanel.down.setEnabled(false);
        } else {
            this.cPanel.down.setEnabled(true);
        }

        if (!this.model.checkMove(Direction.Left)) {
            this.cPanel.left.setEnabled(false);
        } else {
            this.cPanel.left.setEnabled(true);
        }

        if (!this.model.checkMove(Direction.Right)) {
            this.cPanel.right.setEnabled(false);
        } else {
            this.cPanel.right.setEnabled(true);
        }

        if (this.model.currentLevel == 1) {
            this.cPanel.level1.setEnabled(false);
        } else {
            this.cPanel.level1.setEnabled(true);
        }
        if (this.model.currentLevel == 2) {
            this.cPanel.level2.setEnabled(false);
        } else {
            this.cPanel.level2.setEnabled(true);
        }

        if (this.model.currentLevel == 3) {
            this.cPanel.level3.setEnabled(false);
        } else {
            this.cPanel.level3.setEnabled(true);
        }

    }

    public void disableKeys() {
        this.cPanel.up.setEnabled(false);
        this.cPanel.down.setEnabled(false);
        this.cPanel.left.setEnabled(false);
        this.cPanel.right.setEnabled(false);        
    }
}
