package chapter_17;

import chapter_9.Factorial;

/**
 * Computes the number of trailing zeros of a n factorial
 */
public class C17_3 {

  public static void main(String[] args) {
    int n = 12;

    System.out.println(Factorial.factorial(n));
    System.out.println(trailingZeros(n));
  }

  private static int trailingZeros(int n) {
    int count = 0;

    for(int i = 5; n / i > 0; i *= 5) {
      count += n / i;
    }

    return count;
  }
}