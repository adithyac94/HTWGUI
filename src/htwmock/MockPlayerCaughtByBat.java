package htwmock;

/**
 * This class represents a mock class to test the controller in isolation. It is
 * created to specifically check the output when a player is caught by a bat or
 * if the player ducks the bat. It extends the MockAbstractPlayer.
 * 
 */
public class MockPlayerCaughtByBat extends MockAbstractPlayer {

  /**
   * Constructs a MockPlayerCaughtByBat object with the given log, uniqueCode and
   * uniqueCheck.
   * 
   * @param log         StringBuilder
   * @param uniqueCode  Unique Integer
   * @param uniqueCheck Unique Boolean
   */
  public MockPlayerCaughtByBat(StringBuilder log, int uniqueCode, boolean uniqueCheck) {

    super(log, uniqueCode, uniqueCheck);

  }

  @Override
  public int isCaughtByBat(String pos) {

    return uniqueCode;
  }

}
