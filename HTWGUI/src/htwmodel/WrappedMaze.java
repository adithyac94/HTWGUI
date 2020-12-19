package htwmodel;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Wrapped Maze. It defines all the operations mandated
 * by the Abstract Maze class. It consist of methods to add wrapped walls and
 * create a maze.
 */
public class WrappedMaze extends AbstractMaze {

  /**
   * Constructs an UnWrapped Maze with the given number of rows, columns and
   * remaining walls.
   *
   * @param x              The number of rows
   * @param y              The number of columns
   * @param remainingWalls The number of remaining Walls
   * @param bats           The number of bats
   * @param pits           The number of pits
   */
  public WrappedMaze(int x, int y, int remainingWalls, int bats, int pits) {
    super(x, y, remainingWalls, bats, pits);
  }

  @Override
  public void createMaze() {

    createGrid();
    addWrappedWalls();

    removeWall();

  }

  /**
   * This method adds walls to a Wrapped maze.
   *
   */
  private void addWrappedWalls() {

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
        if ((i == 0)) {
          String wall = maze[i][j] + "." + maze[x - 1][j];
          walls.add(wall);
          allWalls.add(wall);
        }
        if ((j == 0)) {
          String wall = maze[i][j] + "." + maze[i][y - 1];
          walls.add(wall);
          allWalls.add(wall);
        }
        cellPaths.put(maze[i][j], new HashSet<String>());
        possibleDirections.put(maze[i][j], new HashSet<String>());
      }
    }

  }

}
