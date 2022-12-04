import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Camp {
  public static void main(String[] args) {
    System.out.println(count(args[0]));
    System.out.println(count2(args[0]));
  }

  public static int count(String file) {
    int answer = 0;
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String n = in.nextLine();
        n = n.replace('-', ',');
        String[] nums = n.split(",");
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
          num[i] = Integer.parseInt(nums[i]);
        }

        if ((num[0] <= num[2] && num[1] >= num[3]) || (num[0] >= num[2] && num[1] <= num[3])) {
          // System.out.println(Arrays.toString(num));
          answer ++;
        }
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    return answer;
  }

  public static int count2(String file) {
    int answer = 0;
    try {
      File f = new File(file);
      Scanner in = new Scanner(f);
      while (in.hasNextLine()) {
        String n = in.nextLine();
        n = n.replace('-', ',');
        String[] nums = n.split(",");
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
          num[i] = Integer.parseInt(nums[i]);
        }

        int low1 = num[0];
        int up1 = num[1];
        int low2 = num[2];
        int up2 = num[3];
        // find those not overlapping
        if ((low1 < low2 && up1 < low2) || (low1 > low2 && low1 > up2)) {
          // System.out.println(Arrays.toString(num));
          answer --;
        }
        answer ++;
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    return answer;
  }
}
