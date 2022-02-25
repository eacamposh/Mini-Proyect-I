package MiniProyectI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Eduardo Campos
 */


public class Question {

  private static final int DEFAULT_SCORE = 10;

  private String citiesUnderscore = "";
  private String cityGuess = "";
  private String[] newArray = {};
  List<String> wrongLetters = new ArrayList<String>();
  ControlQuestion controlQuestion = new ControlQuestion();

  public Question() {
  }

  public void startGame() throws IOException {
    Scanner in = new Scanner(System.in);
    ControlQuestion controlQuestion = new ControlQuestion();
    Boolean playing = true;
    String[] arrayCities = {};
    arrayCities = controlQuestion.readCitiesTxt();
    cityGuess = controlQuestion.randomCityChoice(arrayCities);
    newArray = new String[cityGuess.length()];
    cityGuess = cityGuess.trim().toLowerCase();
    citiesUnderscore = controlQuestion.letterTounderscores(cityGuess);
    for (int i = 0; i < cityGuess.length(); i++) {
      newArray[i] = String.valueOf(cityGuess.charAt(i));
      //System.out.println("New Array:");
      System.out.print(newArray[i]);
    }
    System.out.println("\nWelcome to Game - Guess The City");
    System.out.println("Guess City: " + citiesUnderscore);
    System.out.println("Enter Letter: ");
    String letter = in.nextLine();
    System.out.println("Letter: " + letter);
    letterFind(letter);


  }

  /**
   * @param letter
   */
  public void letterFind(String letter) {
    List<Integer> indexLetter = new ArrayList<Integer>();
    int count = 0;
    System.out.println("Citi Array: " + Arrays.toString(newArray));
    for (int i = 0; i < newArray.length; i++) {
      if (Objects.equals(newArray[i], letter)) {
        System.out.println("Letter Found!");
        System.out.println("Index Letter: " + i);
        indexLetter.add(i);
        count += i;
        System.out.println("Index Letter Array: " + indexLetter.size());
      }
    }
    int aux = 0;
    for (int i : indexLetter) {
      newArray[i] = cityGuess;
    }
  }
}
