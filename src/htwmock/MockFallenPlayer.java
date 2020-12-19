package htwmock;

/**
 * This class represents a mock class to test the controller in isolation. It is
 * created to specifically check the output when a player has fallen into a
 * pit.It extends the MockAbstractPlayer.
 * 
 */
public class MockFallenPlayer extends MockAbstractPlayer {

  /**
   * Constructs a MockFallenPlayer object with the given log, uniqueCode and
   * uniqueCheck.
   * 
   * @param log         StringBuilder
   * @param uniqueCode  Unique Integer
   * @param uniqueCheck Unique Boolean
   */
  public MockFallenPlayer(StringBuilder log, int uniqueCode, boolean uniqueCheck) {
    super(log, uniqueCode, uniqueCheck);

  }

  @Override
  public boolean hasFallen() {
    return uniqueCheck;
  }

}
