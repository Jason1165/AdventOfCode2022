import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Sand {
  public static void main(String args[]) {
    solve2(args[0]);
  }

  public static void solve1(String file) {
    Cave cave = new Cave(file, 200, 200);
    // System.out.println(cave.toString(0, 10, 494, 504));
    // System.out.println(cave.toString(0, 100, 0, 100));
    cave.addSand();
    System.out.println(cave.toString(0, 20, 80, 120));
    System.out.println(cave.sand());
  }

  public static void solve2(String file) {
    Cave cave = new Cave(file, 600, 2000);
    cave.addSand();
    System.out.println(cave.sand());
  }
}
