package chapter_7;

import java.util.ArrayList;

public class Prime {

  public static void main(String[] args) {
    generatePrimes(10000);
  }

  private boolean isPrime(int n) {
    int sqrt;

    if(n < 2) {
      return false;
    }

    sqrt = (int) Math.sqrt(n);

    for(int i = 2; i <= sqrt; i++) {
      if(n % i == 0) {
        return false;
      }
    }

    return true;
  }

  private static void generatePrimes(int max) {
    boolean[] flags = new boolean[max + 1];
    int prime = 2;
    ArrayList<Integer> primes = new ArrayList<>();

    initFlags(flags);

    while(prime <= max) {
      primes.add(prime);
      crossOffNonPrimes(flags, prime);

      prime = getNextPrime(flags, prime);
    }

    System.out.println(primes);
  }

  private static void initFlags(boolean[] flags) {
    for(int i = 0; i < flags.length; i++) {
      flags[i] = true;
    }
  }

  private static void crossOffNonPrimes(boolean[] flags, int prime) {
    for(int i = prime * prime; i < flags.length; i += prime) {
      flags[i] = false;
    }
  }

  private static int getNextPrime(boolean[] flags, int prime) {
    int nextPrime = prime + 1;

    while(nextPrime < flags.length && !flags[nextPrime]) {
      nextPrime++;
    }

    return nextPrime;
  }
}