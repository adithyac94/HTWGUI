package htwmodel;

import java.util.List;
import java.util.Map;

/**
 * This interface represents a player. It contains operations to move a player,
 * shoot an arrow, returns the rooms in the maze and check if a player has been
 * eaten or fallen in to a pit.
 */
public interface Player {

  /**
   * This method sets the start position of the player.
   *
   * @param startPosition
   * 
   */
  void setStartPosition(String startPosition);

  /**
   * This method checks if the pit is close to the player.
   *
   * @return boolean
   * 
   */
  boolean isPitClose();

  /**
   * This method checks if the Wumpus is close to the player.
   *
   * @return boolean
   * 
   */
  boolean isWumpusClose();

  /**
   * This method moves a player to the specified position.
   *
   * @param position
   * 
   */
  void move(String position);

  /**
   * This method checks if the player has been eaten by the Wumpus.
   *
   * @return boolean
   * 
   */
  boolean isEaten();

  /**
   * This method checks if the player has fallen in to the pit.
   *
   * @return boolean
   * 
   */
  boolean hasFallen();

  /**
   * This method gets all the possible paths the player can move to from the
   * current positions.
   *
   * @return List of String
   * 
   */
  List<String> getTunnelLeads();

  /**
   * This method gets the start position of the player.
   *
   * @return String
   * 
   */
  Integer getStartPosition();

  /**
   * This method gets the list of all the rooms in the maze.
   *
   * @return List of String
   * 
   */
  List<String> getRooms();

  /**
   * This method gets the current of the player.
   *
   * @return String
   * 
   */
  Integer getCurrentPosition();

  /**
   * This method checks if the player is caught by the bat.
   *
   * @param position the Position of the player
   * 
   * @return integer
   * 
   */
  int isCaughtByBat(String position);

  /**
   * This method enables the player to shoot an arrow given the direction and the
   * number of caves.
   *
   * @param position the position of the player
   * @param caves    the number of caves
   * 
   * @return integer
   * 
   */
  int shoot(String position, int caves);

  /**
   * This method gets the list of all the rooms in the Grid.
   *
   * 
   * @return list of integers
   * 
   */
  List<Integer> getRoomNumbers();

  /**
   * This method gets the number of rows in the grid.
   *
   * @return integer
   * 
   */
  int getRows();

  /**
   * This method gets the number of columns in the grid.
   *
   * @return integer
   * 
   */
  int getColumns();

  /**
   * This method gets all the possible cardinal directions the player can move to
   * from the current positions.
   * 
   * @return a List of all possible directions
   */
  List<String> getCardinalDirections();

  /**
   * This method moves a player in the specified direction.
   * 
   * @param direction the direction the player wants to move.
   */
  void moveDirection(String direction);

  /**
   * This method gets all the possible rooms the player can move to from a
   * specified positions.
   * 
   * @param pos The position in the grid
   * 
   * @return a List of all possible rooms
   */
  List<String> getDirections(int pos);

  /**
   * This method gets all the tunnels between two locations to locations in the
   * Grid.
   * 
   * @param prevPosition The start position
   * @param direction    The direction from the start position.
   * 
   * @return a List of all the tunnels
   */
  List<Integer> getListOfTunnels(int prevPosition, String direction);

  /**
   * This method gets all the possible cardinal directions the player can move to
   * from the current positions.
   * 
   * @return a List of all possible directions
   */
  List<Integer> getAdjacentRooms(int pos);

  /**
   * This method gets all the possible cardinal directions one can move to from a
   * room.
   * 
   * @return a Map with key has the position and value as all the possible
   *         locations it can move to
   */
  Map<Integer, List> getCardinalNumber();

  /**
   * This method gets the position of the Wumpus.
   * 
   * @return Integer
   */
  int getWumpusPosition();

  /**
   * This method gets the list of pit positions in the grid.
   * 
   * @return List of Integers
   */
  List<Integer> getPitsPosition();

  /**
   * This method gets the list of bat positions in the grid.
   * 
   * @return List of Integers
   */
  List<Integer> getBatsPosition();

  /**
   * This method gets the current position in string format.
   * 
   * @return String
   */
  String getCurPosition();

  /**
   * This method gets the cave destination given the direction from a cell.
   * 
   * @return String
   */
  String getCave(String caveDirection);

  /**
   * This method gets the maze.
   * 
   * @return Maze
   */
  Maze getMaze();

  /**
   * This method gets the number of arrows remaining.
   * 
   * @return Integer
   */
  int getArrowNumber();

  void setArrows(int arrow);

}