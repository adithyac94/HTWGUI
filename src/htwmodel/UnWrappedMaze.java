package htwmodel;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a UnWrapped Maze. It defines all the operations
 * mandated by the Abstract Maze class. It consist of methods to create and add
 * walls to the maze.
 */
public class UnWrappedMaze extends AbstractMaze {

  /**
   * Constructs an UnWrapped Maze with the given number of rows, columns and
   * remaining walls.
   *
   * @param row            The number of rows
   * @param column         The number of columns
   * @param remainingWalls The number of remaining Walls
   */
  public UnWrappedMaze(int row, int column, int remainingWalls, int bats, int pits)
      throws IllegalArgumentException {
    super(row, column, remainingWalls, bats, pits);

  }

  @Override
  public void createMaze() {
    createGrid();
    addWalls();
    removeWall();

  }

  /**
   * This method adds walls to an UnWrapped maze.
   *
   *
   */
  private void addWalls() {

    int x = getRows();
    int y = getColumns();
    for (int i = 0; i < x; ++i) {
      for (int j = 0; j < y; ++j) {
        Set<String> walls = new HashSet<String>();
        if ((i + 1) < x && (i + 1) > 0) {
          String wall = maze[i][j] + "." + maze[i + 1][j];
          walls.add(wall);
          allWalls.add(wall);
        }
        if ((j + 1) < y && (j + 1) > 0) {
          String wall = maze[i][j] + "." + maze[i][j + 1];
          walls.add(wall);
          allWalls.add(wall);
        }
        cellPaths.put(maze[i][j], new HashSet<String>());
        possibleDirections.put(maze[i][j], new HashSet<String>());
      }
    }

  }

}
