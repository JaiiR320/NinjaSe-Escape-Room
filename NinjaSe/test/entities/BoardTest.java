package entities;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * BoardTest
 */
public class BoardTest {
    @Test
    public void boardTest(){
        Board b = new Board(4, 4);
        Space[][] copy = b.space;
        
        for (Space[] spaces : copy) {
            for (Space s : spaces) {
                assertEquals(Space.Empty, s);
            }
        }
    }
    
    @Test
    public void setSpaceTest(){
        Board b = new Board(4, 4);
        Space[][] copy = b.space;
        
        for (Space[] spaces : copy) {
            for (Space s : spaces) {
                assertEquals(Space.Empty, s);
            }
        }
        b.setSpace(0, 0, Space.Blue);
        assertEquals(Space.Blue, b.space[0][0]);

        b.setSpace(3, 3, Space.Player);
        assertEquals(Space.Player, b.space[3][3]);

        b.setSpace(1, 2, Space.Magenta);
        assertEquals(Space.Magenta, b.space[1][2]);
    }

    @Test
    public void setObstacleTest(){
        Board b = new Board(5, 5);
        b.setObstacle(0, 0, 1, 1, Space.Blue);
        assertEquals(Space.Blue, b.space[0][0]);
        assertEquals(Space.Blue, b.space[1][1]);

        b.setObstacle(4, 3, 2, 1, Space.Green);
        assertEquals(Space.Green, b.space[4][3]);
        assertEquals(Space.Green, b.space[2][1]);

        b.setObstacle(1, 4, 3, 2, Space.Cyan);
        assertEquals(Space.Cyan, b.space[1][4]);
        assertEquals(Space.Cyan, b.space[3][2]);
    }

    @Test
    public void moveTest(){
        Board b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.move(Direction.Down);
        assertEquals(Space.Player, b.space[2][3]);
        assertEquals(Space.Empty, b.space[2][2]);

        b.setSpace(2, 2, Space.Player);
        b.move(Direction.Up);
        assertEquals(Space.Player, b.space[2][1]);
        assertEquals(Space.Empty, b.space[2][2]);

        b.setSpace(2, 2, Space.Player);
        b.move(Direction.Left);
        assertEquals(Space.Player, b.space[1][2]);
        assertEquals(Space.Empty, b.space[2][2]);

        b.setSpace(2, 2, Space.Player);
        b.move(Direction.Right);
        assertEquals(Space.Player, b.space[3][2]);
        assertEquals(Space.Empty, b.space[2][2]);
    }

    @Test
    public void pushTest(){
        Board b;

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(2, 3, Space.Blue);
        b.push(Direction.Down);
        assertEquals(Space.Player, b.space[2][3]);
        assertEquals(Space.Blue, b.space[2][4]);
        assertEquals(Space.Empty, b.space[2][2]);

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(2, 1, Space.Cyan);
        b.push(Direction.Up);
        assertEquals(Space.Player, b.space[2][1]);
        assertEquals(Space.Cyan, b.space[2][0]);
        assertEquals(Space.Empty, b.space[2][2]);

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(1, 2, Space.Red);
        b.push(Direction.Left);
        assertEquals(Space.Player, b.space[1][2]);
        assertEquals(Space.Red, b.space[0][2]);
        assertEquals(Space.Empty, b.space[2][2]);

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(3, 2, Space.Green);
        b.push(Direction.Right);
        assertEquals(Space.Player, b.space[3][2]);
        assertEquals(Space.Green, b.space[4][2]);
        assertEquals(Space.Empty, b.space[2][2]);
    }

    @Test
    public void combineTest(){
        Board b;
        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(2, 1, Space.Green);
        b.setSpace(2, 0, Space.Green);
        b.combine(Direction.Up);
        assertEquals(Space.Player, b.space[2][1]);
        assertEquals(Space.Empty, b.space[2][0]);
        assertEquals(Space.Empty, b.space[2][2]);

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(2, 3, Space.Green);
        b.setSpace(2, 4, Space.Green);
        b.combine(Direction.Down);
        assertEquals(Space.Player, b.space[2][3]);
        assertEquals(Space.Empty, b.space[2][4]);
        assertEquals(Space.Empty, b.space[2][2]);

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(1, 2, Space.Green);
        b.setSpace(0, 2, Space.Green);
        b.combine(Direction.Left);
        assertEquals(Space.Player, b.space[1][2]);
        assertEquals(Space.Empty, b.space[0][2]);
        assertEquals(Space.Empty, b.space[2][2]);

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setSpace(3, 2, Space.Green);        
        b.setSpace(4, 2, Space.Green);
        b.combine(Direction.Right);
        assertEquals(Space.Player, b.space[3][2]);
        assertEquals(Space.Empty, b.space[4][2]);
        assertEquals(Space.Empty, b.space[2][2]);
    }

    @Test
    public void checkMoveTest(){
        Board b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setObstacle(2, 1, 2, 3, Space.Green);
        b.setObstacle(1, 2, 3, 2, Space.Green);
        assertFalse(b.checkMove(Direction.Up));
        assertFalse(b.checkMove(Direction.Down));
        assertFalse(b.checkMove(Direction.Left));
        assertFalse(b.checkMove(Direction.Right));

        b = new Board(5, 5);
        b.setSpace(0, 0, Space.Player);
        assertFalse(b.checkMove(Direction.Up));
        assertFalse(b.checkMove(Direction.Left));

        b = new Board(5, 5);
        b.setSpace(4, 4, Space.Player);
        assertFalse(b.checkMove(Direction.Down));
        assertFalse(b.checkMove(Direction.Right));

        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        assertTrue(b.checkMove(Direction.Up));
        assertTrue(b.checkMove(Direction.Down));
        assertTrue(b.checkMove(Direction.Left));
        assertTrue(b.checkMove(Direction.Right));
    }

    @Test
    public void checkPushTest(){
        Board b = new Board(5, 5);
        //obstacles around player, empty spaces behind obstacles
        b.setSpace(2, 2, Space.Player);
        b.setObstacle(2, 1, 2, 3, Space.Green);
        b.setObstacle(1, 2, 3, 2, Space.Green);
        assertTrue(b.checkPush(Direction.Up));
        assertTrue(b.checkPush(Direction.Down));
        assertTrue(b.checkPush(Direction.Left));
        assertTrue(b.checkPush(Direction.Right));

        //no obstacles around player
        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        assertFalse(b.checkPush(Direction.Up));
        assertFalse(b.checkPush(Direction.Down));
        assertFalse(b.checkPush(Direction.Left));
        assertFalse(b.checkPush(Direction.Right));

        //obstacles around player, obstacles behind obstacles
        b = new Board(5, 5);
        b.setSpace(2, 2, Space.Player);
        b.setObstacle(2, 1, 2, 3, Space.Green);
        b.setObstacle(1, 2, 3, 2, Space.Green);
        b.setObstacle(2, 0, 2, 4, Space.Green);
        b.setObstacle(0, 2, 4, 2, Space.Green);
        assertFalse(b.checkPush(Direction.Up));
        assertFalse(b.checkPush(Direction.Down));
        assertFalse(b.checkPush(Direction.Left));
        assertFalse(b.checkPush(Direction.Right));
    }

    @Test
    public void checkCombineTest(){
        Board b = new Board(5, 5);
        //no obstacles around player, empty spaces behind empty spaces
        b.setSpace(2, 2, Space.Player);
        assertFalse(b.checkCombine(Direction.Up));
        assertFalse(b.checkCombine(Direction.Down));
        assertFalse(b.checkCombine(Direction.Left));
        assertFalse(b.checkCombine(Direction.Right));

        //obstacles around player, empty spaces behind obstacles
        b = new Board(5, 5);        
        b.setSpace(2, 2, Space.Player);
        b.setObstacle(2, 1, 2, 3, Space.Green);
        b.setObstacle(1, 2, 3, 2, Space.Green);
        assertFalse(b.checkCombine(Direction.Up));
        assertFalse(b.checkCombine(Direction.Down));
        assertFalse(b.checkCombine(Direction.Left));
        assertFalse(b.checkCombine(Direction.Right));

        //empty spaces around player, obstacles behind empty spaces
        b = new Board(5, 5);        
        b.setSpace(2, 2, Space.Player);
        b.setObstacle(2, 0, 2, 4, Space.Green);
        b.setObstacle(0, 2, 4, 2, Space.Green);
        assertFalse(b.checkCombine(Direction.Up));
        assertFalse(b.checkCombine(Direction.Down));
        assertFalse(b.checkCombine(Direction.Left));
        assertFalse(b.checkCombine(Direction.Right));

        //obstacles around player, obstacles behind obstacles
        b = new Board(5, 5);        
        b.setSpace(2, 2, Space.Player);
        b.setObstacle(2, 1, 2, 3, Space.Green);
        b.setObstacle(1, 2, 3, 2, Space.Green);
        b.setObstacle(2, 0, 2, 4, Space.Green);
        b.setObstacle(0, 2, 4, 2, Space.Green);
        assertTrue(b.checkCombine(Direction.Up));
        assertTrue(b.checkCombine(Direction.Down));
        assertTrue(b.checkCombine(Direction.Left));
        assertTrue(b.checkCombine(Direction.Right));
    }
}
