import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Supply {
  public static void main(String[] args) {
    solution(args[0]);
    // System.out.println(reverse("hello"));
  }

  public static void solution(String file) {
    ArrayList<String> crates = new ArrayList<String>();
    // crates.add("ZN");
    // crates.add("MCD");
    // crates.add("P");
    crates.add("BLDTWCFM");
    crates.add("NBL");
    crates.add("JCHTLV");
    crates.add("SPJW");
    crates.add("ZSCFTLR");
    crates.add("WDGBHNZ");
    crates.add("FMSPBGCN");
    crates.add("WQRJFVCZ");
    crates.add("RPMLH");
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String line = in.nextLine();
        line = line.replace("move ", "");
        line = line.replace("from ", "");
        line = line.replace("to ", "");
        // System.out.println(line);
        String[] n = line.split(" ");
        int a = Integer.parseInt(n[0]);
        int b = Integer.parseInt(n[1]);
        int c = Integer.parseInt(n[2]);
        // System.out.println(n.length);
        String s = crates.get(b-1);
        // System.out.println(a + " " + b + " " + c);
        // System.out.println(s.length());
        String add = s.substring(s.length()-a);


        //  add = reverse(add); 


        // System.out.println(add);
        crates.set(c-1, crates.get(c-1)+add);
        crates.set(b-1, s.substring(0, s.length()-a));
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    String ans = "";
    for (int i = 0; i < crates.size(); i++) {
      ans += crates.get(i).substring(crates.get(i).length()-1);
    }
    System.out.println(ans);
  }

  public static String reverse(String str) {
    String ans = "";
    for (int i = str.length()-1; i >= 0; i--) {
      ans += str.charAt(i);
    }
    return ans;
  }


}
