import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Tree {
  public static void main(String[] args) {
    solve(args[0]);
  }

  public static void solve(String file) {
    ArrayList<String>lines = new ArrayList<String>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while(in.hasNextLine()) {
        String n = in.nextLine();
        lines.add(n);
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    int[][] arr = new int[lines.size()][lines.get(0).length()];
    for (int i = 0; i < lines.size(); i++) {
      String n = lines.get(i);
      for (int j = 0; j < n.length(); j++) {
        String c = n.substring(j, j+1);
        arr[i][j] = Integer.parseInt(c);
      }
    }

    int ans = 0;
    int score = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      for (int j = 1; j < arr[i].length - 1; j++) {
        if (isVisible(arr, i, j)) {
          ans ++;
          int c = calculateScore(arr, i, j);
          if (c > score) {
             // System.out.println(i + " " + j);
            score = c;
          }

        }
      }
    }

    ans = ans + arr.length + arr.length + arr[0].length + arr[0].length - 4;
    System.out.println(ans);
    System.out.println(score);
  }

  public static boolean isVisible(int[][] arr, int x, int y) {
    boolean a = true;
    boolean b = true;
    boolean c = true;
    boolean d = true;
    for (int i = 0; i < x; i++) {
      if (arr[x][y] <= arr[i][y]) {
        a = false;
      }
    }
    for (int i = x+1; i < arr.length; i++) {
      if (arr[x][y] <= arr[i][y]) {
        b = false;
      }
    }
    for (int i = 0; i < y; i++) {
      if (arr[x][y] <= arr[x][i]) {
        c = false;
      }
    }
    for (int i = y+1; i < arr[x].length; i++) {
      if (arr[x][y] <= arr[x][i]) {
        d = false;
      }
    }
    return (a || b || c || d);
  }

  public static int calculateScore(int[][] arr, int x, int y) {
    int a = x;
    int b = arr.length - x - 1;
    int c = y;
    int d = arr[x].length - y - 1;
    for (int i = x - 1; i >= 0; i--) {
      if (arr[x][y] <= arr[i][y]) {
        a = x - i;
        break;
      }
    }
    for (int i = x+1; i < arr.length; i++) {
      if (arr[x][y] <= arr[i][y]) {
        b = i - x;
        break;
      }
    }
    for (int i = y-1; i >= 0; i--) {
      if (arr[x][y] <= arr[x][i]) {
        c = y - i;
        break;
      }
    }
    for (int i = y+1; i < arr[x].length; i++) {
      if (arr[x][y] <= arr[x][i]) {
        d = i - y;
        break;
      }
    }
    return (a*b*c*d);
  }
}
