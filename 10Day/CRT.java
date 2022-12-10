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
    while (cycle < input.size()) {
      String n = input.get(cycle);
      cycle++;
      //System.out.println("Cycle: " + cycle + "\t" + n + "\t" + total);
      if ((cycle+20) % 40 == 0) {
        // System.out.println("Cycle: " + cycle + " ");
        // System.out.println("X Value: " + total);
        sum20 = sum20 + cycle*total;
      }
      if (!n.equals("noop") && !n.equals("addx")) {
        int x = Integer.parseInt(n);
        total += x;
      }
    }

    System.out.println(sum20);
  }
}
