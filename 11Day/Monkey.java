import java.util.ArrayList;
import java.util.Collections;

public class Monkey {
  ArrayList<Long> items;
  String op;
  long amount;
  long mods;
  long inspect;

  public Monkey(long[] ar, String operation, long num, long div) {
    items = new ArrayList<Long>();
    for (int i = 0; i < ar.length; i++) {
      items.add(ar[i]);
    }
    op = operation;
    amount = num;
    mods = div;
    inspect = 0;
  }


  public void inspect(Monkey t, Monkey f) {
    int i = 0;
    reduce();
    inspect += items.size();
    while (items.size() != 0) {
      rule(i);
      long number = items.remove(i);
      if (number % mods == 0) {
        t.add(number);
      }
      else {
        f.add(number);
      }
    }
  }

  private void rule(int index) {
    long val = items.get(index);
    if (op.equals("add")) {
      val += amount;
    }
    else if (op.equals("times")) {
      val *= amount;
    }
    else if (op.equals("square")) {
      val = val * val;
    }
    // bored
    // val = val / 3;
    items.set(index, val);
  }

  public void add(long num) {
    items.add(num);
  }

  public long inspectVal() {
    return inspect;
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < items.size(); i++) {
      s += items.get(i);
      if (i != items.size()-1) {
        s += ", ";
      }
    }
    return s;
  }

  public void reduce() {
    for (int i = 0; i < items.size(); i++) {
      // items.set(i, items.get(i)%96577);
      items.set(i, items.get(i)%9699690);
    }
  }


}
