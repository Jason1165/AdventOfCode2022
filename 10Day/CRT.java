import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class CRT {
  public static void main(String[] args) {
    part1(args[0]);
  }

  public static void part1(String file) {
    ArrayList<String> input = new ArrayList<String>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String n = in.nextLine();
        if (n.contains("addx")) {
          input.add("addx");
          String x = n.substring(5);
          input.add(x);
        }
        else {
          input.add(n);
        }
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    int cycle = 0;
    int total = 1;
    int sum20 = 0;
    char[][] arr = new char[6][40];
    while (cycle < input.size()) {
      String n = input.get(cycle);
      cycle++;
      // System.out.println("Cycle: " + cycle + "\t" + n + "\t" + total);
      if ((cycle+20) % 40 == 0) {
        sum20 = sum20 + cycle*total;
      }


      int row = (cycle-1) / 40;
      int col = (cycle-1) % 40;
      int dist = Math.abs(col - total);
      // System.out.println("Cycle: " + cycle + "\t" + "Distance: " + dist);
      if (dist <= 1) {
        arr[row][col] = '#';
      }
      else {
        arr[row][col] = '.';
      }

      if (!n.equals("noop") && !n.equals("addx")) {
        int x = Integer.parseInt(n);
        total += x;
      }

    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

    System.out.println(sum20);
  }
}
