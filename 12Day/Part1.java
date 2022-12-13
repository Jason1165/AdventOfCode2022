import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Part1 {
  public static boolean animate = true;
  public static void main(String[] args) {
    part1(args[0]);
  }

  public static void part1(String file) {
    ArrayList<String> input = new ArrayList<String>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String s = in.nextLine();
        input.add(s);
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    int[] start = new int[2];
    int[] end = new int[2];
    char[][] arr = new char[input.size()][];
    for (int i = 0; i < input.size(); i++) {
      String s = input.get(i);
      if (s.contains("S")) {
        start[0] = i;
        start[1] = s.indexOf("S");
      }
      if (s.contains("E")) {
        end[0] = i;
        end[1] = s.indexOf("E");
      }
      arr[i] = s.toCharArray();
    }
    arr[start[0]][start[1]] = 'a';
    // System.out.println(start[0] + " " + start[1]);
    // System.out.println(end[0] + " " + end[1]);
    // System.out.println(solve(start[0], start[1], arr));

    System.out.println(BFS(start[0], start[1], end[0], end[1], arr));
    // System.out.println((BFS(end[0], end[1], -1, -1, arr)));

  }

  public static int BFS(int row, int col, int rowT, int colT, char[][] arr) {
    ArrayList<int[]> frontier = new ArrayList<int[]>();
    frontier.add(new int[] {row, col});
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] visited = new int[arr.length][arr[0].length];
    visited[rowT][colT] = -1; //
    int ticks = 0;
    while (frontier.size()!=0) {
      if (animate) {
        gotoTop();
        out(visited, arr);
        wait(100m e);
      }
      int len = frontier.size();
      for (int k = 0; k < len; k++) {
        int[] current = frontier.remove(0);
        visited[current[0]][current[1]] += 1;
        if (current[0] == rowT && current[1] == colT) {
          return ticks;
        }
        // if (arr[current[0]][current[1]] == 'a') {
        //   return ticks;
        // }
        for (int i = 0; i < dir.length; i++) {
          if (dir[i][0] + current[0] == -1 || dir[i][0] + current[0] == arr.length || dir[i][1] + current[1] == -1 || dir[i][1] + current[1] == arr[row].length) {
          }
          else {
            // 2
            if (valid(arr, current[0], current[1], current[0] + dir[i][0], current[1] + dir[i][1]) && visited[current[0]+dir[i][0]][current[1]+dir[i][1]] <= 10) {
              visited[current[0]+dir[i][0]][current[1]+dir[i][1]]++;
              frontier.add(new int[] {current[0]+dir[i][0], current[1]+dir[i][1]});
            }
          }
        }
      }
    //  System.out.println(ticks);
      ticks++;
    }
    return -1;
  }


  // public static int solve(int row, int col, char[][] arr) {
  //   int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  //   if (arr[row][col] == 'E') {
  //     return 0;
  //   }
  //   for (int i = 0; i < dir.length; i++) {
  //     if (dir[i][0] + row == -1 || dir[i][0] + row == arr.length || dir[i][1] + col == -1 || dir[i][1] + col == arr[row].length) {
  //
  //     }
  //     else {
  //       if (animate) {
  //         gotoTop();
  //         // out(arr);
  //         wait(50);
  //       }
  //       if (valid(arr, row, col, row + dir[i][0], col + dir[i][1])) {
  //         arr[row][col] = '@';
  //         int x = solve(row+dir[i][0], col+dir[i][1], arr);
  //         if (x == -1) {
  //           arr[row+dir[i][0]][col+dir[i][1]] = '.';
  //         }
  //         else {
  //           return x+1;
  //         }
  //       }
  //     }
  //   }
  //   return -1;
  // }

  public static void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public static boolean valid(char[][] arr, int x, int y, int x1, int y1) {
    char a = arr[x][y];
    char b = arr[x1][y1];
    if (a+1 == b || a == b) {
      return true;
    }
    if (a > b && b != 'E') {
      return true;
    }
    if (a == 'z' && b == 'E') {
      return true;
    }
    if (a == 'y' && b == 'E') {
      return true;
    }
    return false;
  }

  public static boolean valid2(char[][] arr, int x, int y, int x1, int y1) {
    char a = arr[x][y];
    char b = arr[x1][y1];
    if (a == b+1 || a == b) {
      return true;
    }
    if (b > a && b != 'E') {
      return true;
    }
    if (a == 'a' && b == 'a') {
      return true;
    }
    if (a == 'b' && b == 'a') {
      return true;
    }
    return false;
  }

  public static void out(int[][] arr, char[][] c) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0) System.out.print(c[i][j]);
        else if (arr[i][j] < 0) System.out.print("@");
        else if (arr[i][j] > 10) System.out.print(".");
      }
      System.out.println();
    }
  }

  public static void out(char[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }


}
