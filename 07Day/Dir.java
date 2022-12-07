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

    ArrayList<String> depth = new ArrayList<String>();
    // Map<String, Integer> map = new HashMap<String, Integer>();
    ArrayList<Integer> s = new ArrayList<Integer>();
    ArrayList<Integer> sizes = new ArrayList<Integer>();

    int ans2 = 0;
    for (int i = 0; i < input.size(); i++) {
      String cmd = input.get(i);
      if (cmd.equals("$ cd ..")) {
        int l = depth.size()-1;
        depth.remove(l);
        int c = s.get(l);
        if (c <= 100000) {
          ans2 += c;
        }
        sizes.add(c);
        s.remove(l);
      }
      else if (cmd.contains("$ cd ")) {
        cmd = cmd.replace("$ cd ", "");
        depth.add(cmd);
        s.add(0);
      }
      else if (cmd.contains("dir ")) {

      }
      else if (cmd.equals("$ ls")) {

      }
      else {
        String[] vals = cmd.split(" ");
        int gigs = Integer.parseInt(vals[0]);
        for (int k = 0; k < s.size(); k++) {
          s.set(k, s.get(k)+gigs);
        }
      }
      // System.out.println(depth.toString());
      // System.out.println(s.toString());
    }
    for (int i = 0; i < s.size(); i++) {
      sizes.add(s.get(i));
    }

    Collections.sort(sizes);
    int spaceUsed = s.get(0);
    int amount = 30000000 - (70000000 - spaceUsed);
    for (int i = 0; i < sizes.size(); i++) {
      int n = sizes.get(i);
      if (n >= amount) {
        System.out.println(n);
        break;
      }
    }
  }
}
