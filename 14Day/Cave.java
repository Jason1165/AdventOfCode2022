import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Cave {
  public static char AIR = '.';
  public static char ROCK = '#';
  public static char SAND = 'o';
  public static char ORIGIN = '+';
  public static int minimize = -500;

  char[][] map;
  int numOfSand;

  public Cave (String file, int x, int y) {
    map = new char[x][y];
    loadFile(file);
    numOfSand = 0;
  }

  public void loadFile(String file) {
    ArrayList<String> directions = new ArrayList<String>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String s = in.nextLine();
        directions.add(s);
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    fillAir();
    addRocks(directions);
    map[0][500-minimize] = SAND;
  }

  public void fillAir() {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = AIR;
      }
    }
  }

  public void addRocks(ArrayList<String> dirs) {
    int high = 0;
    for (int i = 0; i < dirs.size(); i++) {
      String str = dirs.get(i);
      int[][] steps = toArr(str);
      for (int s = 0; s < steps.length-1; s++) {
        int xStart = steps[s][0];
        int yStart = steps[s][1];
        int xEnd = steps[s+1][0];
        int yEnd = steps[s+1][1];
        if (xStart > high) {
          high = xStart;
        }
        map[xStart][yStart] = ROCK;
        map[xEnd][yEnd] = ROCK;
        if (xStart == xEnd) {
          if (yStart > yEnd) {
            for (int k = yEnd; k < yStart; k++) {
              map[xStart][k] = ROCK;
            }
          }
          if (yStart < yEnd) {
            for (int k = yStart; k < yEnd; k++) {
              map[xStart][k] = ROCK;
            }
          }
        }
        if (yStart == yEnd) {
          if (xStart > xEnd) {
            for (int k = xEnd; k < xStart; k++) {
              map[k][yStart] = ROCK;
            }
          }
          if (xStart < xEnd) {
            for (int k = xStart; k < xEnd; k++) {
              map[k][yStart] = ROCK;
            }
          }
        }
      }
     }
     addLastRow(high+2);
  }

  public void addLastRow(int row) {
    for (int i = 0; i < map[row].length; i++) {
      map[row][i] = ROCK;
    }
  }

  public int[][] toArr(String str) {
    str = str.replaceAll(" -> ", ",");
    String[] arr = str.split(",");
    int[][] ans = new int[arr.length/2][2];
    for (int i = 0; i < arr.length; i++) {
      int x = Integer.parseInt(arr[i]);
      if (i%2 == 0 && x > minimize) {
        x = x - minimize;
      }
      ans[i/2][(i+1)%2] = x;
    }
    return ans;
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        str += map[i][j];
      }
      str += "\n";
    }
    return str;
  }

  public String toString(int xMin, int xMax, int yMin, int yMax) {
    String str = "";
    for (int i = xMin; i <= xMax; i++) {
      for (int j = yMin; j <= yMax; j++) {
        str += map[i][j];
      }
      str += "\n";
    }
    return str;
  }

  /*
    if sand enters the abyss stop and break
    else we move the sand (if we move return true else return false)
      if down is valid change coors down
      else if down left is valid change coors down left
      else if down right is valid change coors down right
      else this sand has set and we cannot move return false
    so while move is true keep moving and if move is false we restart
  */

  public void addSand() {
    int n = 0;
    while (n == 0) {
      n = move(0, 500-minimize);
    }
  }

  public int sand() {
    int n = 0;
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == SAND) {
          n++;
        }
      }
    }
    numOfSand = n;
    return numOfSand;
  }

  public int move(int x, int y) {
    if (map[x+1][y] != ROCK && map[x+1][y] != SAND) {
      return move(x+1, y);
    }
    else if (map[x+1][y-1] != ROCK && map[x+1][y-1] != SAND) {
      return move(x+1, y-1);
    }
    else if (map[x+1][y+1] != ROCK && map[x+1][y+1] != SAND) {
      return move(x+1, y+1);
    }
    else {
      if (inAbyss(x, y)) {
        return -1;
      }
      map[x][y] = SAND;
      return 0;
    }
  }

  public boolean inAbyss(int x, int y) {
    // return (y == 0 || x == map.length-1 || y == map[0].length);
    return (x == 0 && y == 500 - minimize);
  }
}
