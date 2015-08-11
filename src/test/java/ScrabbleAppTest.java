import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleAppTest {

  @Test //the letter a always prouces the value of 1
  public void doesLetterHaveCorrectScore_1() {
      ScrabbleApp testScrabbleApp = new ScrabbleApp();
      String testLetter = "A";
      Integer testScore = 1;
      assertEquals(testScore, testScrabbleApp.getWordScore(testLetter));
  }

@Test //the letter a never produces a value other than 1
public void doesLetterHaveCorrectScore_3() {
    ScrabbleApp testScrabbleApp = new ScrabbleApp();
    String testLetter = "A";
    Integer testScore = 3;
    assertNotEquals(testScore, testScrabbleApp.getWordScore(testLetter));
    }


@Test
public void doAllLettersHaveCorrectScore_84() {
    ScrabbleApp testScrabbleApp = new ScrabbleApp();
    String testLetter = "abcdefghijklmnopqrstuvwxyz";
    Integer testScore = 84;
    assertEquals(testScore, testScrabbleApp.getWordScore(testLetter));
    }
}
