import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Part1 {
  public static void main(String args[]) {
    solve();
  }

  public static void solve() {
    ArrayList<Monkey> monkeys = new ArrayList<Monkey>();
    long[] arr0 = {66, 79};
    long[] arr1 = {84, 94, 94, 81, 98, 75};
    long[] arr2 = {85, 79, 59, 64, 79, 95, 67};
    long[] arr3 = {70};
    long[] arr4 = {57, 69, 78, 78};
    long[] arr5 = {65, 92, 60, 74, 72};
    long[] arr6 = {77, 91, 91};
    long[] arr7 = {76, 58, 57, 55, 67, 77, 54, 99};

    Monkey mon0 = new Monkey(arr0, "times", 11, 7);
    Monkey mon1 = new Monkey(arr1, "times", 17, 13);
    Monkey mon2 = new Monkey(arr2, "add", 8, 5);
    Monkey mon3 = new Monkey(arr3, "add", 3, 19);
    Monkey mon4 = new Monkey(arr4, "add", 4, 2);
    Monkey mon5 = new Monkey(arr5, "add", 7, 11);
    Monkey mon6 = new Monkey(arr6, "square", 2, 17);
    Monkey mon7 = new Monkey(arr7, "add", 6, 3);
    // 9699690

    monkeys.add(mon0);
    monkeys.add(mon1);
    monkeys.add(mon2);
    monkeys.add(mon3);
    monkeys.add(mon4);
    monkeys.add(mon5);
    monkeys.add(mon6);
    monkeys.add(mon7);

    for (int i = 0; i < 10000; i++) {
      monkeys.get(0).inspect(monkeys.get(6), monkeys.get(7));
      monkeys.get(1).inspect(monkeys.get(5), monkeys.get(2));
      monkeys.get(2).inspect(monkeys.get(4), monkeys.get(5));
      monkeys.get(3).inspect(monkeys.get(6), monkeys.get(0));
      monkeys.get(4).inspect(monkeys.get(0), monkeys.get(3));
      monkeys.get(5).inspect(monkeys.get(3), monkeys.get(4));
      monkeys.get(6).inspect(monkeys.get(1), monkeys.get(7));
      monkeys.get(7).inspect(monkeys.get(2), monkeys.get(1));
      // System.out.println("Round: " + i);
      // for (int k = 0; k < monkeys.size(); k++) {
      //   System.out.println("Monkey " + k + ": " + monkeys.get(k).toString());
      // }
    }

    for (int i = 0; i < monkeys.size(); i++) {
      System.out.println("Monkey " + i + " inspected items " + monkeys.get(i).inspectVal() + " times.");
    }
    long a = 108359;
    long b = 108357;
    System.out.println(a*b);
  }
}
