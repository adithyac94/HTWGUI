package htwcontroller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import htwmock.MockFallenPlayer;
import htwmock.MockPlayer;
import htwmock.MockPlayerCaughtByBat;
import htwmock.MockPlayerEaten;
import htwmodel.Player;

/**
 * A JUnit test class for the HwtController class.
 * 
 */
public class HtwControllerTest {

  Player model;
  StringBuilder log;

  @Before
  public void setUp() throws Exception {
    log = new StringBuilder();
    model = new MockPlayer(log, 1234321, false);
  }

  /**
   * This method tests if the inputs provided to the controller are accurate.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testMockInput() throws IOException {

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 S 1 00 K");
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    assertEquals(" Start Position 00 Current Position 00 Caves 1", log.toString());
  }

  /**
   * This method tests for invalid start positions given by the user.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStartPosition() throws IOException {

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("55 S 1 00 K");
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    assertEquals(" Start Position 00 Current Position 00 Caves 1", log.toString());
  }

  /**
   * This method tests the output of the controller.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testMockControllerOutput() throws IOException {

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 S 1 00 K");

    HtwController controller = new HtwController(in, out);
    controller.start(model);
    assertEquals("You are in Cave 00\nThe Cave connects to [10]\n", out.toString());
  }

  /**
   * This method tests the output when a Player comes close to a pit.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testPlayerComingCloseToPit() throws IOException {

    String expectedOuput = "You feel a cold wind blowing\nYou are in Cave 00\n"
        + "The Cave connects to [10]\nYou"
        + " feel a cold wind blowing\nYou are in Cave 00\nThe Cave connects to [10]\n";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 M 10 K");
    log = new StringBuilder();
    model = new MockPlayer(log, 1234321, true);
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    assertEquals(expectedOuput, out.toString());
  }

  /**
   * This method tests the output when a Player is eaten by the Wumpus.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testPlayerEaten() throws IOException {

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 M 1 00 K");
    log = new StringBuilder();
    model = new MockPlayerEaten(log, 1234321, true);
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    assertEquals("\nChomp, chomp, chomp, thanks for feeding the Wumpus! :P \nBetter Luck Next Time",
        out.toString());
  }

  /**
   * This method tests the output when a Player falls in to the pit.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testFallenPlayer() throws IOException {

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 M 1 00 K");
    log = new StringBuilder();
    model = new MockFallenPlayer(log, 1234321, true);
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    assertEquals("\nOh no..Down the rabbit hole you go!!! \nBetter Luck Next Time", out.toString());
  }

  /**
   * This method tests the output when a Player wins the game.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testWinningPlayer() throws IOException {

    String expectedOuput = "You are in Cave 00\nThe Cave connects to [10]\n"
        + "Hee hee hee, you got the wumpus! ^|^ \nNext time you won't be so lucky";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 S 1 00 K");
    log = new StringBuilder();
    model = new MockPlayer(log, 1, false);
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    System.out.println("Output " + out.toString());
    assertEquals(expectedOuput, out.toString());
  }

  /**
   * This method tests the output when a player is out of arrows.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testPlayerOutOfArrows() throws IOException {

    String expectedOutput = "You are in Cave 00\nThe Cave connects to [10]\n"
        + "Oh no..You are all out of arrows \nBetter Luck Next Time\n";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 S 1 00");
    log = new StringBuilder();
    model = new MockPlayer(log, -1, false);
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    System.out.println("Output " + out.toString());
    assertEquals(expectedOutput, out.toString());
  }

  /**
   * This method tests the output when a player is grabbed by the bat.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testPlayerCaughtByBat() throws IOException {

    String expectedOutput = "\nSnatch -- you are grabbed by superbats ^^ ^^ and ...\n"
        + "You are dropped in Cave 00\nYou are in Cave 00\nThe Cave connects to [10]\n";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 k");
    log = new StringBuilder();
    model = new MockPlayerCaughtByBat(log, 1, false);
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    System.out.println("Output " + out.toString());
    assertEquals(expectedOutput, out.toString());
  }

  /**
   * This method tests the output when a player ducks a bat.
   * 
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testPlayerDuckedByBat() throws IOException {

    String expectedOutput = "\nWhoa -- you successfully duck superbats that try to grab you\n"
        + "You are in Cave 00\nThe Cave connects to [10]\n";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("00 k");
    log = new StringBuilder();
    model = new MockPlayerCaughtByBat(log, 0, false);
    HtwController controller = new HtwController(in, out);
    controller.start(model);
    System.out.println("Output " + out.toString());
    assertEquals(expectedOutput, out.toString());
  }
}
