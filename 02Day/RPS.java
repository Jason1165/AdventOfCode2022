import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class RPS {
  public static void main(String[] args) {
    System.out.println(points(args[0]));
    System.out.println(points2(args[0]));
  }

  public static int points(String file) {
    int answer = 0;
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      ArrayList<String> lines = new ArrayList<String>();
      while (in.hasNextLine()) {
        String next = in.nextLine();
        lines.add(next);
      }
      for (int i = 0 ; i < lines.size(); i++) {
        String current = lines.get(i);
        String opponent = current.substring(0, 1);
        String me = current.substring(2,3);
        if (opponent.equals("A")) {
          if (me.equals("X")) {
            answer = answer + 1 + 3;
          }
          else if (me.equals("Y")) {
            answer = answer + 2 + 6;
          }
          else if (me.equals("Z")) {
            answer = answer + 3 + 0;
          }
        }
        else if (opponent.equals("B")) {
          if (me.equals("X")) {
            answer = answer + 1 + 0;
          }
          else if (me.equals("Y")) {
            answer = answer + 2 + 3;
          }
          else if (me.equals("Z")) {
            answer = answer + 3 + 6;
          }
        }
        else if (opponent.equals("C")) {
          if (me.equals("X")) {
            answer = answer + 1 + 6;
          }
          else if (me.equals("Y")) {
            answer = answer + 2 + 0;
          }
          else if (me.equals("Z")) {
            answer = answer + 3 + 3;
          }
        }
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    return answer;
  }

  public static int points2(String file) {
    int answer = 0;
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      ArrayList<String> lines = new ArrayList<String>();
      while (in.hasNextLine()) {
        String next = in.nextLine();
        lines.add(next);
      }
      for (int i = 0 ; i < lines.size(); i++) {
        String current = lines.get(i);
        String opponent = current.substring(0, 1);
        String me = current.substring(2,3);
        if (opponent.equals("A")) {
          if (me.equals("X")) {
            answer = answer + 0 + 3;
          }
          else if (me.equals("Y")) {
            answer = answer + 3 + 1;
          }
          else if (me.equals("Z")) {
            answer = answer + 6 + 2;
          }
        }
        else if (opponent.equals("B")) {
          if (me.equals("X")) {
            answer = answer + 0 + 1;
          }
          else if (me.equals("Y")) {
            answer = answer + 3 + 2;
          }
          else if (me.equals("Z")) {
            answer = answer + 6 + 3;
          }
        }
        else if (opponent.equals("C")) {
          if (me.equals("X")) {
            answer = answer + 0 + 2;
          }
          else if (me.equals("Y")) {
            answer = answer + 3 + 3;
          }
          else if (me.equals("Z")) {
            answer = answer + 6 + 1;
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
