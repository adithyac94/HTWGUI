package htwmock;



/**
 * This class represents a mock class to test the controller in isolation. It is
 * created to specifically check the output when a pit is close to the player.It
 * extends the MockAbstractPlayer.
 * 
 */
public class MockPlayer extends MockAbstractPlayer {

  /**
   * Constructs a MockPlayer object with the given log, uniqueCode and uniqueCheck.
   * 
   * @param log         StringBuilder
   * @param uniqueCode  Unique Integer
   * @param uniqueCheck Unique Boolean
   */
  public MockPlayer(StringBuilder log, int uniqueCode, boolean uniqueCheck) {
    super(log, uniqueCode, uniqueCheck);

  }

  @Override
  public boolean isPitClose() {
    return uniqueCheck;
  }



}
