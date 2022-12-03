import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class Rucksack{
  public static void main(String[] args) {
    System.out.println(priority(args[0]));
    System.out.println(priority3(args[0]));
  }

  public static int priority(String file) {
    int answer = 0;
    try {
      File f  = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String line = in.nextLine();
        String first = line.substring(0,line.length()/2);
        String last = line.substring(line.length()/2);
        for (int i = 0; i < first.length(); i++) {
          if (last.contains(first.charAt(i) + "")) {
            char c = first.charAt(i);
            if (c >= 97) {
              answer += c - 96;
            }
            else {
              answer += c - 64 + 26;
            }
            i += first.length();
            // breaks for loop
          }
        }
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    return answer;
  }

  public static int priority3(String file) {
    int answer = 0;
    try {
      File f  = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String line = in.nextLine();
        String first = in.nextLine();
        String last = in.nextLine();
        for (int i = 0; i < line.length(); i++) {
          if (first.contains(line.charAt(i) + "") && last.contains(line.charAt(i) + "")) {
            char c = line.charAt(i);
            if (c >= 97) {
              answer += c - 96;
            }
            else {
              answer += c - 64 + 26;
            }
            i += line.length();
            // breaks for loop
          }
        }
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    return answer;
  }
}
