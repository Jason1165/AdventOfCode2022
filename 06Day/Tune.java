import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Tune {
  public static void main(String[] args) {
    solve(args[0]);
  }

  public static void solve(String file) {
    int ans = 0;
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      String input = in.nextLine();
      while (input.length() > ans) {
        String test = input.substring(ans, ans+14); // replace with ans+4 for part i
        if (!repeats(test) && ans > 0) {
          System.out.println(test);
          break;
        }
        ans++;
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    System.out.println(ans + 14); // replace with ans + 4
  }

  public static boolean repeats(String str) {
    while (str.length() > 0) {
      String c = str.substring(0,1);
      str = str.substring(1);
      if (str.indexOf(c) >= 0) {
        return true;
      }
    }
    return false;
  }
}
