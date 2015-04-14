package chapter_9;

public class Fibonacci {

  public static void main(String[] args) {
    int n = 40;
    int[] buffer = new int[n + 1];
    long startTime, endTime;

    startTime = System.nanoTime();

    System.out.println(fibonacciDP(n, buffer));

    endTime = System.nanoTime();

    System.out.println("DP takes " + (endTime - startTime) / 1000 + " milliseconds");

    startTime = System.nanoTime();

    System.out.println(fibonacci(n));

    endTime = System.nanoTime();

    System.out.println("Recursive takes " + (endTime - startTime) / 1000 + " milliseconds");
  }

  public static int fibonacciDP(int n, int[] buffer) {
    if(n == 0 || n == 1) {
      buffer[n] = n;
      return n;
    }

    if(buffer[n] != 0) {
      return buffer[n];
    }

    buffer[n] = fibonacciDP(n - 1, buffer) + fibonacciDP(n - 2, buffer);

    return buffer[n];
  }

  public static int fibonacci(int n) {
    if(n == 0 || n == 1) {
      return n;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}