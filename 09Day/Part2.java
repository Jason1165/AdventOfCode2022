import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Part2 {
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
    ArrayList<Point> snake = new ArrayList<Point>();
    for (int i = 0; i < 10; i++) {
      snake.add(new Point());
    }

    for (int i = 0; i < lines.size(); i++) {
      String n = lines.get(i);
      String dir = n.substring(0, 1);
      int dist = Integer.parseInt(n.substring(2));
      // System.out.println(dist);
      for (int j = 0; j < dist; j++) {
        if (dir.equals("U")) {
          snake.get(0).addX(-1);
          // headX--;
        }
        if (dir.equals("D")) {
          snake.get(0).addX(1);
          // headX++;
        }
        if (dir.equals("L")) {
          snake.get(0).addY(-1);
          // headY--;
        }
        if (dir.equals("R")) {
          snake.get(0).addY(1);
          // headY++;
        }
        for (int k = 1; k < snake.size(); k++) {
          // System.out.println("Head: " + snake.get(k-1).toString() + " " + k);
          // System.out.println("Tail: " + snake.get(k).toString() + " " + k);
          if (!snake.get(k).touching(snake.get(k-1))) {
            // System.out.println("Head: " + snake.get(k-1).toString() + " " + k);
            // System.out.println("Tail: " + snake.get(k).toString() + " " + k);
            snake.get(k).move(snake.get(k-1));
          }
        }
        // System.out.println(snake.toString());
        String s = snake.get(snake.size()-1).toString();
        // System.out.println(s);
        if (!locations.contains(s)) {
          locations.add(s);
        }

      }
      // System.out.println("FINAL: " + snake.toString());
    }
    System.out.println(locations.size());
  }
}
