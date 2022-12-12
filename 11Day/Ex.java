import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Ex {
  public static void main(String args[]) {
    solve();
  }

  public static void solve() {
    ArrayList<Monkey> monkeys = new ArrayList<Monkey>();
    long[] arr0 = {79, 98};
    long[] arr1 = {54, 65, 75, 74};
    long[] arr2 = {79, 60, 97};
    long[] arr3 = {74};


    Monkey mon0 = new Monkey(arr0, "times", 19, 23);
    Monkey mon1 = new Monkey(arr1, "add", 6, 19);
    Monkey mon2 = new Monkey(arr2, "square", 2, 13);
    Monkey mon3 = new Monkey(arr3, "add", 3, 17);
    // 96517


    monkeys.add(mon0);
    monkeys.add(mon1);
    monkeys.add(mon2);
    monkeys.add(mon3);


    for (int i = 0; i < 10000; i++) {
      monkeys.get(0).inspect(monkeys.get(2), monkeys.get(3));
      monkeys.get(1).inspect(monkeys.get(2), monkeys.get(0));
      monkeys.get(2).inspect(monkeys.get(1), monkeys.get(3));
      monkeys.get(3).inspect(monkeys.get(0), monkeys.get(1));
      // System.out.println("Round: " + i);
      // for (int k = 0; k < monkeys.size(); k++) {
      //   System.out.println("Monkey " + k + ": " + monkeys.get(k).toString());
      // }
    }

    for (int i = 0; i < monkeys.size(); i++) {
      System.out.println("Monkey " + i + " inspected items " + monkeys.get(i).inspectVal() + " times.");
    }
  }
}
