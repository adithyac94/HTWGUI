package htwmodel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the UnWrappedMaze class.
 * 
 */
public class UnWrappedMazeTest {

  Maze room;

  @Before
  public void setUp() throws Exception {

    room = new UnWrappedMaze(4, 6, 2, 2, 2);
    room.createMaze();

  }

  /**
   * This method tests the number of walls in a maze.
   * 
   */
  @Test
  public void testNumberOfWallsForRoomMaze() {
    assertEquals(2, room.getNumberOfWalls());
  }

  /**
   * This method tests the invalid number of walls in a maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfRemainingWalls() {
    room = new UnWrappedMaze(3, 3, 5, 2, 2);
    room.createMaze();
    assertEquals(5, room.getNumberOfWalls());
  }

  /**
   * This method tests negative number of walls in a maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeNumberOfRemainingWalls() {
    room = new UnWrappedMaze(3, 3, -5, 2, 2);
    room.createMaze();
    assertEquals(5, room.getNumberOfWalls());
  }

  /**
   * This method tests the number of bats in a maze.
   * 
   */
  @Test
  public void testNumberOfBats() {
    assertEquals(2, room.getBatPositions().size());
  }

  /**
   * This method tests the number of pits in a maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfBats() {
    room = new UnWrappedMaze(4, 6, 2, 25, 2);
    room.createMaze();
    assertEquals(25, room.getBatPositions().size());
  }

  /**
   * This method tests the number of pits in a maze.
   * 
   */
  @Test
  public void testNumberOfPits() {
    assertEquals(2, room.getPitPositions().size());
  }

  /**
   * This method tests the number of pits in a maze.
   * 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNumberOfPits() {
    room = new UnWrappedMaze(4, 6, 2, 2, 25);
    room.createMaze();
    assertEquals(25, room.getPitPositions().size());
  }
}
