import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileOutputStream;

public class Calorie {
  public static void main(String[] args) {
    System.out.println(highestCal(args[0]));
    System.out.println(highestThreeCal(args[0]));
  }

  public static int highestCal(String file) {
    ArrayList<Integer> cals = new ArrayList<Integer>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      int amount = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();
        if (line.equals("")) {
          cals.add(amount);
          amount = 0;
        }
        else {
          amount += Integer.parseInt(line);
        }
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    Collections.sort(cals);
    return cals.get(cals.size()-1);
  }

  public static int highestThreeCal(String file) {
    ArrayList<Integer> cals = new ArrayList<Integer>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      int amount = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();
        if (line.equals("")) {
          cals.add(amount);
          amount = 0;
        }
        else {
          amount += Integer.parseInt(line);
        }
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    Collections.sort(cals);
    int answer = cals.get(cals.size()-1) + cals.get(cals.size()-2) + cals.get(cals.size()-3);
    return answer;
  }

}
