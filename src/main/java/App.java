import java.io.Console;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    Console console = System.console();


    // String userDifficulty = console.readLine("Choose Diffucitly:\nEasy - Medium - Hard:\n");
    // String resultDifficulty = newHangman.setDifficulty(userDifficulty);
    // System.out.println("---------------------------\nChosen Difficulty: " + resultDifficulty + "\n---------------------------");
    // String resultWord = newHangman.getDifficulty();
    // System.out.println("Set Word: "+newHangman.pickedWord(newHangman.getDifficulty()));
    // System.out.println("Guessed Word: " + newHangman.getGuessedWord());

    // while(newHangman.continueGame()){
    //   String guessedLetter = console.readLine("Choose A Letter:\n");
    //   System.out.println(newHangman.guessedLetters(guessedLetter));
    //   System.out.println(newHangman.guessedWordArray());
    // }


    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Hangman newHangman = new Hangman();
      String setWord = newHangman.pickedWord("hard");
      String userLetter = request.queryParams("hangman-letter");
      String getWord = newHangman.getWord();
      List<String> getGuessedWord = newHangman.guessedLetters(userLetter);
      model.put("getWord", getWord);
      model.put("guessedWord", guessedWord);
      model.put("getWordTemp", "templates/getWord.vtl" );
      model.put("getLetter", "templates/getLetter.vtl" );
      model.put("userLetter", userLetter);
      model.put("gameObj", newHangman);
      model.put("setWord", setWord);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
