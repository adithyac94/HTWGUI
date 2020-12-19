package htwmock;

/**
 * This class represents a mock class to test the controller in isolation. It is
 * created to specifically check the output when a player is eaten by the Wumpus
 * or if the Wumpus is close.It extends the MockAbstractPlayer.
 * 
 */
public class MockPlayerEaten extends MockAbstractPlayer {

  /**
   * Constructs a MockPlayerEaten object with the given log, uniqueCode and
   * uniqueCheck.
   * 
   * @param log         StringBuilder
   * @param uniqueCode  Unique Integer
   * @param uniqueCheck Unique Boolean
   */
  public MockPlayerEaten(StringBuilder log, int uniqueCode, boolean uniqueCheck) {

    super(log, uniqueCode, uniqueCheck);

  }

  @Override
  public boolean isEaten() {
    return uniqueCheck;
  }

  @Override
  public boolean isWumpusClose() {
    return uniqueCheck;
  }

}
