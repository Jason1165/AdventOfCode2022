import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Dir {
  public static void main(String[] args) {
    solve(args[0]);
  }

  public static void solve(String file) {
    ArrayList<String> input = new ArrayList<String>();
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String x = in.nextLine();
        input.add(x);
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    int ans2 = 0;
    ArrayList<String> depth = new ArrayList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>();

    for (int i = 0; i < input.size(); i++) {
      String cmd = input.get(i);
      if (cmd.equals("$ cd ..")) {
        String n = depth.get(depth.size()-1);
        // System.out.println("Leaving Dir:" + n + " Line: " + i);
        int c = map.get(n);
        if (c <= 100000) {
            ans2 += c;
        }
        map.remove(n);
        // System.out.println(map.get(n));
        depth.remove(depth.size()-1);
      }
      else if (cmd.equals("$ ls")) {

      }
      else if (cmd.contains("$ cd ")) {
        cmd = cmd.replace("$ cd ", "");
        // System.out.println("Entering: " + cmd);
        depth.add(cmd);
      }
      else if (cmd.contains("dir ")) {

      }
      else {
        // System.out.println(cmd);
        String[] vals = cmd.split(" ");
        int gigs = Integer.parseInt(vals[0]);
        // System.out.println("Adding " + gigs + " from " + vals[1] + " to ");
        // System.out.println(gigs);
        for (int k = 0; k < depth.size(); k++) {
          String cur = depth.get(k);
        // System.out.println("\t" + cur);
          if (map.get(cur) != null) {
            map.put(cur, map.get(cur) + gigs);
          }
          else {
            map.put(cur, gigs);
          }
        }
      }
    }

    Collection<Integer> values = map.values();
    System.out.println(map.values());
    // // System.out.println(vals.size() + " " + dirs);
    // int ans = 0;
    // for (int s: values) {
    //   if (s <= 100000) {
    //     // System.out.println(s);
    //     ans += s;
    //   }
    // }
    // System.out.println(ans);
    System.out.println(ans2);

  }
}
