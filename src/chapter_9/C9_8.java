package chapter_9;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cents),
 * write code to calculate the number of ways of representing n cents.
 */
public class C9_8 {

  public static void main(String[] args) {
    int n = 6;

    System.out.println(makeChange(n, 25));
  }

  private static int makeChange(int n, int denom) {
    int nextDenom = 0;

    switch (denom) {
      case 25:
        nextDenom = 10;
        break;
      case 10:
        nextDenom = 5;
        break;
      case 5:
        nextDenom = 1;
        break;
      case 1:
        return 1;
    }

    int ways = 0;

    for(int i = 0; i * denom <= n; i++) {
      ways += makeChange(n - i * denom, nextDenom);
    }

    return ways;
  }
}