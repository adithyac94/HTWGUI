package htwmock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import htwmodel.Maze;
import htwmodel.Player;

/**
 * This represents an abstract mock class to test the controller in isolation.It
 * implements the Player interface.
 * 
 */
public abstract class MockAbstractPlayer implements Player {

  private StringBuilder log;
  protected final int uniqueCode;
  protected final boolean uniqueCheck;

  /**
   * Protected constructor for use by Mock Player subclasses.
   * 
   * @param log         StringBuilder
   * @param uniqueCode  Unique Integer
   * @param uniqueCheck Unique Boolean
   */
  protected MockAbstractPlayer(StringBuilder log, int uniqueCode, boolean uniqueCheck) {
    this.log = log;
    this.uniqueCode = uniqueCode;
    this.uniqueCheck = uniqueCheck;

  }

  @Override
  public boolean isPitClose() {
    return false;
  }

  @Override
  public boolean isWumpusClose() {
    return false;
  }

  @Override
  public void move(String pos) {
    log.append("Position " + pos);

  }

  @Override
  public boolean isEaten() {
    return false;
  }

  @Override
  public boolean hasFallen() {
    return false;
  }

  @Override
  public List<String> getTunnelLeads() {
    Map<String, List> tunnelLeads = new HashMap<String, List>();
    tunnelLeads.put("00", Arrays.asList("10"));
    tunnelLeads.put("11", Arrays.asList("12", "10", "22"));
    tunnelLeads.put("22", Arrays.asList("11"));
    tunnelLeads.put("12", Arrays.asList("11"));
    tunnelLeads.put("20", Arrays.asList("10"));
    tunnelLeads.put("10", Arrays.asList("11", "00", "20"));
    return tunnelLeads.get(getStartPosition());
  }

  @Override
  public Integer getStartPosition() {
    return 0;
  }

  @Override
  public List<String> getRooms() {
    List<String> rooms = new ArrayList<String>();
    rooms = Arrays.asList("00", "11", "22", "12", "20", "10");
    return rooms;
  }

  @Override
  public Integer getCurrentPosition() {
    return 0;
  }

  @Override
  public int isCaughtByBat(String pos) {

    return -2;
  }

  @Override
  public int shoot(String pos, int caves) {
    log.append(" Current Position " + pos + " Caves " + caves);
    return uniqueCode;
  }

  @Override
  public void setStartPosition(String startPosition) {
    log.append(" Start Position " + startPosition);

  }

  @Override
  public int getWumpusPosition() {

    return 0;
  }

  @Override
  public List<Integer> getPitsPosition() {
    List<Integer> pits = new ArrayList<Integer>();
    pits = Arrays.asList(0, 1, 2, 4, 5);
    return pits;
  }

  @Override
  public List<Integer> getBatsPosition() {
    List<Integer> bats = new ArrayList<Integer>();
    bats = Arrays.asList(3, 4, 6);
    return null;
  }

  @Override
  public String getCurPosition() {

    return "00";
  }

  @Override
  public String getCave(String caveDirection) {

    return null;
  }

  @Override
  public Maze getMaze() {

    return null;
  }

  @Override
  public int getArrowNumber() {

    return 0;
  }

  @Override
  public List<Integer> getRoomNumbers() {
    List<Integer> rooms = new ArrayList<Integer>();
    rooms = Arrays.asList(0, 1, 2, 4, 5);
    return rooms;
  }

  @Override
  public int getRows() {

    return 9;
  }

  @Override
  public int getColumns() {

    return 9;
  }

  @Override
  public List<String> getCardinalDirections() {

    return null;
  }

  @Override
  public void moveDirection(String dir) {

    log.append(" Directions " + dir);
  }

  @Override
  public List<String> getDirections(int pos) {
    log.append(" Directions " + pos);
    return null;
  }

  @Override
  public List<Integer> getListOfTunnels(int prevPosition, String direction) {
    log.append(" List Of Tunnels " + prevPosition + " Direction " + direction);
    return null;
  }

  @Override
  public List<Integer> getAdjacentRooms(int pos) {
    log.append(" Adjacent Rooms " + pos);
    return null;
  }

  @Override
  public Map<Integer, List> getCardinalNumber() {
    return null;
  }

  @Override
  public void setArrows(int arrow) {
    // TODO Auto-generated method stub
    
  }
}
