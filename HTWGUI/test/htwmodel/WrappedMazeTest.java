package htwmodel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the WrappedMaze class.
 * 
 */
public class WrappedMazeTest {

  Maze room;

  @Before
  public void setUp() throws Exception {

    room = new WrappedMaze(4, 6, 10, 3, 3);
    room.createMaze();

  }

  /**
   * This method tests the number of walls in a room maze.
   * 
   */

  @Test
  public void testNumberOfWallsForRoomMaze() {
    assertEquals(10, room.getNumberOfWalls());
  }

  /**
   * This method tests the invalid number of walls in a room maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfRemainingWalls() {
    room = new WrappedMaze(3, 3, 20, 3, 3);
    room.createMaze();
    assertEquals(20, room.getNumberOfWalls());
  }

  /**
   * This method tests negative number of walls in a maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeNumberOfRemainingWalls() {
    room = new WrappedMaze(3, 3, -5, 3, 3);
    room.createMaze();
    assertEquals(5, room.getNumberOfWalls());
  }

  /**
   * This method tests the number of bats in a maze.
   * 
   */
  @Test
  public void testNumberOfBats() {
    assertEquals(3, room.getBatPositions().size());
  }

  /**
   * This method tests the illegal number of bats in a maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfBats() {
    room = new WrappedMaze(4, 6, 2, 25, 2);
    room.createMaze();
    assertEquals(25, room.getBatPositions().size());
  }

  /**
   * This method tests the number of pits in a maze.
   * 
   */
  @Test
  public void testNumberOfPits() {
    assertEquals(3, room.getPitPositions().size());
  }

  /**
   * This method tests the illegal number of pits in a maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfPits() {
    room = new WrappedMaze(4, 6, 2, 2, 25);
    room.createMaze();
    assertEquals(25, room.getPitPositions().size());
  }

}
