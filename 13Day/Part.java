import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Part {
  public static void main (String[] args) {
    part1(args[0]);
  }

  public static void part1(String file) {
    int answer = 0;
    int rep = 0;
    ArrayList<String> input = new ArrayList<String>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String a = in.nextLine();
        input.add(a);
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    for (int i = 0; i < input.size(); i+=3) {
      boolean pair = helper(input.get(i), input.get(i+1));
      rep++;
      if (pair) {
        System.out.println("Pair " + rep + " is in the right order");
        answer += rep;
      }
    }
    System.out.println("Total Pairs: " + rep);
    System.out.println("Answer: " + answer);
  }

  public static boolean helper(String left, String right) {
    // System.out.println("Left: " + left);
    // System.out.println("Right: " + right);

    /*
      left runs out of elements first
    */
    if (left.equals("[]") && right.length() > 2) {
      return true;
    }
    /*
      right runs out of elements first
    */
    else if (right.equals("[]") && left.length()>2) {
      return false;
    }
    /*
    */
    else {
      int[] l = splice(left);
      int[] r = splice(right);
      for (int i = 0; i < l.length; i++) {
        // System.out.println("Comparing: " + l[i] + " " + r[i]);
        if (l[i] < r[i]) {
          return false;
        }
      }

    }
    return false;
  }

  public static int[] splice(String str) {
    if (isArray(str)) {
      str = str.substring(1, str.length()-1);
      String[] s = str.split(",");
      int[] temp = new int[s.length];
      for (int i = 0; i < s.length; i++) {
        temp[i] = Integer.parseInt(s[i]);
      }
      return temp;
    }
    else {
      return null;
    }
  }

  public static boolean isArray(String str) {
    String t = str.substring(1, str.length()-1);
    int a = t.indexOf("[");
    if (a == -1) {
      return true;
    }
    return false;
  }


}
