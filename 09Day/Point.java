import java.util.ArrayList;

public class Point {
  private int x;
  private int y;

  public Point(int a, int b) {
    x = a;
    y = b;
  }

  public Point() {
    x = 0;
    y = 0;
  }

  public String toString() {
    String n = "(" + x + ", " + y + ")";
    return n;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int addX(int n) {
    x += n;
    return getX();
  }

  public int addY(int n) {
    y += n;
    return getY();
  }

  public boolean touching(Point other) {
    int oX = other.getX();
    int oY = other.getY();
    int disX = Math.abs(x - oX);
    int disY = Math.abs(y - oY);
    return (disX <= 1 && disY <= 1);
  }

  public void move(Point p, String d) {
      int headX = p.getX();
      int headY = p.getY();
      if (headX == x && headY < y) {
        y--;
      }
      else if (headX == x && headY > y) {
        y++;
      }
      else if (headY == y && headX > x) {
        x++;
      }
      else if (headY == y && headX < x) {
        x--;
      }
      else {
        if (headX > x && headY > y) {
          x++;
          y++;
        }
        else if (headX > x && headY < y) {
          x++;
          y--;
        }
        else if (headX < x && headY > y) {
          x--;
          y++;
        }
        else if (headX < x && headY < y) {
          x--;
          y--;
        }
      }
  }

  public static void main(String[] args) {
    // Point n = new Point(-5, 3);
    // Point x = new Point(-3, 3);
    // System.out.println(n.toString() + " " + x.toString());
    // System.out.println(n.touching(x));
    // x.move(n, "L");
    // System.out.println(n.toString() + " " + x.toString());
  }
}
