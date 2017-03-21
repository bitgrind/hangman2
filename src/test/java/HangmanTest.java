import org.junit.*;
import static org.junit.Assert.*;

public class HangmanTest {

  @Test
  public void difficulty_returnUserDifficulty_Hard(){
    Hangman testGame = new Hangman();
    String expectedWord = "hard";
    assertEquals(expectedWord, testGame.setDifficulty("Hard"));
  }
  @Test
  public void difficulty_returnUserDifficulty_Easy(){
    Hangman testGame = new Hangman();
    String expectedWord = "easy";
    assertEquals(expectedWord, testGame.setDifficulty("EASY"));
  }

  @Test
  public void difficulty_returnUserDifficultyDefault_Easy(){
    Hangman testGame = new Hangman();
    String expectedWord = "easy";
    assertEquals(expectedWord, testGame.setDifficulty("Being Difficult"));
  }

  @Test
  public void pickedWord_returnsWord_HardWords(){
    Hangman testGame = new Hangman();
    String expectedWord = "Hard Words";
    assertEquals(expectedWord, testGame.pickedWord("hard"));
  }

  @Test
  public void guessedLetters_returnsBoolean_True(){
    Hangman testGame = new Hangman();
    Boolean expectedWord = true;
    testGame.pickedWord("hard");
    assertEquals(expectedWord, testGame.guessedLetters("s"));
  }

  @Test
  public void guessedLetters_returnsBooleanOnCapitalLetters_false(){
    Hangman testGame = new Hangman();
    Boolean expectedWord = true;
    testGame.pickedWord("hard");
    assertEquals(expectedWord, testGame.guessedLetters("W"));
  }

  @Test
  public void guessedLetters_returnsGuessWordArray_Array(){
    Hangman testGame = new Hangman();
    Boolean expectedWord = true;
    testGame.pickedWord("hard");
    assertEquals(expectedWord, testGame.guessedLetters("W"));
  }
}
