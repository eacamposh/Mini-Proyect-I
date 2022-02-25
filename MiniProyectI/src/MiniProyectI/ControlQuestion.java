package MiniProyectI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Eduardo Campos
 */

public class ControlQuestion {

  private String letter;

  /**
   * @return Array of the cities
   * @throws IOException
   */
  public String[] readCitiesTxt() throws IOException {
    List<String> listCities = new ArrayList<>();
    FileReader fr = new FileReader("cities.txt");
    BufferedReader br = new BufferedReader(fr);
    String line;
    while ((line = br.readLine()) != null) {
      listCities.add(line);
    }
    String[] arrayCities = new String[listCities.size()];
    for (int i = 0; i < listCities.size(); i++) {
      arrayCities[i] = listCities.get(i);
    }
    // System.out.println(Arrays.toString(arrayCities));
    return arrayCities;
  }

  /**
   * @return random city
   */
  public String randomCityChoice(String[] cities) {
    Random r = new Random();
    int random = r.nextInt(cities.length);
    System.out.println("City Random: " + cities[random]);
    return cities[random];
  }

  public String letterTounderscores(String city) {
    int size = city.length();
    String letterUnderscore = "";
    while (size != 0) {
      letterUnderscore = letterUnderscore + "_";
      size--;
    }
    System.out.println(letterUnderscore);
    return letterUnderscore;
  }

  /**
   * invalid input: asdf - more than one letter (won't count)
   *
   * @return true or false
   */
  private boolean isInvalidInput(String letter) {
    if (letter == null & letter.isEmpty() & letter.length() > 1) {
      System.out.println("Enter only one letter!");
      return false;
    }
    return true;
  }

  /**
   * @param letter
   * @return true or false
   */
  private boolean isIvalidWrongChar(String letter) {
    if (letter.substring(0, 1).matches("[A-Z]*")) {
      return true;
    }
    System.out.println("Enter only characters");
    return false;
  }


}
