package chapter_9;

/**
 * A child is running up a staircase with n steps,
 * and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class C9_1 {

  public static void main(String[] args) {
    int n = 30;
    int[] buffer = new int[n + 1];
    long startTime, endTime;

    startTime = System.nanoTime();

    System.out.println(countStepDP(n, buffer));

    endTime = System.nanoTime();

    System.out.println("DP takes " + (endTime - startTime) / 1000 + " milliseconds");

    startTime = System.nanoTime();

    System.out.println(countStep(n));

    endTime = System.nanoTime();

    System.out.println("Recursive takes " + (endTime - startTime) / 1000 + " milliseconds");
  }

  public static int countStep(int n) {
    if(n < 0) {
      return 0;
    } else if(n == 0) {
      return 1;
    }

    return countStep(n - 1) + countStep(n - 2) + countStep(n - 3);
  }

  public static int countStepDP(int n, int[] buffer) {
    if(n < 0) {
      return 0;
    } else if(n == 0) {
      buffer[0] = 1;
      return buffer[0];
    }

    if(buffer[n] != 0) {
      return buffer[n];
    }

    buffer[n] = countStepDP(n - 1, buffer) + countStepDP(n - 2, buffer) + countStepDP(n - 3, buffer);

    return buffer[n];
  }
}