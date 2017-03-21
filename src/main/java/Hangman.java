import java.io.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Hangman{

  private Boolean continueGame = true;
  private Integer misses;
  private String chosenDifficulty;
  private String chosenWord;
  private String guessedWord;
  private String[] chosenWordArray;
  private List<String> chosenWordArrayList = new ArrayList<String>();
  private List<Integer> guessedLetters = new ArrayList<Integer>();
  private List<String> guessedWordArray = new ArrayList<String>();
  private String[] storedWordsEasy    = {"easyWord","easyStored","easyWords"};
  private String[] storedWordsMedium  = {"mediumThings","mediumStored","mediumWords"};
  private String[] storedWordsHard    = {"Large Double","Words For Days","Hard Words"};

  //BACKEND METHODS
  public String pickedWord(String difficulty){
    Random rGen = new Random();
    Integer randomSelector = rGen.nextInt(3);
    if(difficulty.equals("hard")){
      chosenWord = storedWordsHard[randomSelector];
    }
    if(difficulty.equals("medium")){
      chosenWord = storedWordsMedium[randomSelector];
    }
    if(difficulty.equals("easy")) {
      chosenWord = storedWordsEasy[randomSelector];
    }
    for(int i = 0; i < chosenWord.length(); i++){
      guessedWordArray.add(" ");
    }

    //Put chosen word into an array list
    String chosenWordLowerCase = chosenWord.toLowerCase();
    chosenWordArray = chosenWordLowerCase.split("");
    for(String el : chosenWordArray){
      chosenWordArrayList.add(el);
    }

    return chosenWord;
  }

  public List<String> guessedLetters(String letter){
    //guessedWordArray
    Boolean isLetter = false;
    String newLetter = letter.toLowerCase();

    for(int k = 0; k < chosenWordArrayList.size(); k++){
      if(chosenWordArrayList.get(k).equals(newLetter)){
        isLetter = true;
        guessedWordArray.set(k, newLetter);
      }
    }
    return guessedWordArray;
  }

  //SETTERS
  public String setDifficulty(String difficulty){
    String inputDifficulty = difficulty.toLowerCase();
    System.out.println("input dif: "+inputDifficulty);
    if(inputDifficulty.equals("easy")){
      chosenDifficulty = "easy";
    } else if(inputDifficulty.equals("medium")) {
      chosenDifficulty = "medium";
    } else if(inputDifficulty.equals("hard")) {
      chosenDifficulty = "hard";
    } else {
      chosenDifficulty = "easy";
    }
    return chosenDifficulty;
  }

  //GETTERS
  public String getDifficulty(){
    return chosenDifficulty;
  }

  public String getWord(){
    return chosenWord;
  }
  public List<String> getGuessedWord(){
    return guessedWordArray;
  }
  public Boolean continueGame(){
    return continueGame;
  }
  public List<String> guessedWordArray(){
    return guessedWordArray;
  }
}
