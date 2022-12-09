import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Rope {

  static int headX = 0;
  static int headY = 0;
  static int tailX = 0;
  static int tailY = 0;

  public static void main(String[] args) {
    solve(args[0]);
  }

  public static void solve(String file) {
    ArrayList<String> lines = new ArrayList<String>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String n = in.nextLine();
        lines.add(n);
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    ArrayList<String> locations = new ArrayList<String>();
    // ArrayList<String> twice = new ArrayList<String>();
    for (int i = 0; i < lines.size(); i++) {
      String n = lines.get(i);
      String dir = n.substring(0, 1);
      int dist = Integer.parseInt(n.substring(2));
      // System.out.println(dist);
      for (int j = 0; j < dist; j++) {
        if (dir.equals("U")) {
          headX--;
        }
        if (dir.equals("D")) {
          headX++;
        }
        if (dir.equals("L")) {
          headY--;
        }
        if (dir.equals("R")) {
          headY++;
        }
        if (!touching()) {
          move(dir);
        }
        String locT = "(" + tailX + ", " + tailY + ")";
        String locH = "(" + headX + ", " + headY + ")";
        // System.out.println("Head: " + locH);
        // System.out.println("Tail: " + locT);
        if (!locations.contains(locT)) {
          locations.add(locT);
        }
      }
    }
    System.out.println(locations.size());
  }

  public static boolean touching() {
    int xDist = Math.abs(headX - tailX);
    int yDist = Math.abs(headY - tailY);
    return (xDist <= 1 && yDist <= 1);
  }

  public static void move(String d) {
    if ((d.equals("U") || d.equals("D")) && headY == tailY) {
      if (d.equals("U")) tailX--;
      if (d.equals("D")) tailX++;
    }
    else if ((d.equals("R") || d.equals("L")) && headX == tailX) {
      if (d.equals("L")) tailY--;
      if (d.equals("R")) tailY++;
    }
    else {
      // north & west
      if (headX < tailX && headY < tailY) {
        tailX--;
        tailY--;
      }
      // south & west
      else if (headX > tailX && headY < tailY) {
        tailX++;
        tailY--;

      } // north & east
      else if (headX < tailX && headY > tailY) {
        tailX--;
        tailY++;

      } // south & east
      else if (headX > tailX && headY > tailY) {
        tailX++;
        tailY++;
      }
    }
  }
}
