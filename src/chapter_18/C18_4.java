package chapter_18;

/**
 * Write a method to count the number of 2s between 0 and n
 */
public class C18_4 {

  public static void main(String[] args) {
    int n = 22;

    System.out.println(numberOfTwo(n));
  }

  private static int numberOfTwo(int n) {
    int count = 0;
    int digits = String.valueOf(n).length();

    for(int i = 0; i < digits; i++) {
      count += count(n, i);
    }

    return count;
  }

  private static int count(int n, int d) {
    int powerOfTen = (int) Math.pow(10, d);
    int nextPowerOfTen = 10 * powerOfTen;
    int right = n % powerOfTen;
    int roundDown = n - n % nextPowerOfTen;
    int roundUp = roundDown + nextPowerOfTen;
    int digit = (n / powerOfTen) & 10;

    if (digit < 2) {
      return roundDown / 10;
    } else if (digit > 2) {
      return roundUp / 10;
    } else {
      return roundDown / 10 + right + 1;
    }
  }

  private static int numberOfTwoBrute(int n) {
    int count = 0;

    for(int i = 2; i <= n; i++) {
      count += countBrute(i);
    }

    return count;
  }

  private static int countBrute(int n) {
    int count = 0;

    while(n > 0) {
      if(n % 10 == 2) {
        count++;
      }

      n /= 10;
    }

    return count;
  }
}