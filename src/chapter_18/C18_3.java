package chapter_18;

import static chapter_18.C18_2.*;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a method to randomly generate a set of m integers from an array of size n.
 * Each element must have equal probability of being chosen.
 */
public class C18_3 {

  public static void main(String[] args) {
    int m = 5;
    int n = 10;
    int[] array = new int[n];

    generate(array);
    print(randomlyPick(array, m));
  }

  private static int[] randomlyPick(int[] array, int m) {
    int[] set = new int[m];
    int[] copy = Arrays.copyOf(array, array.length);
    Random generator = new Random();

    for(int i = 0; i < m; i++) {
      int index = generator.nextInt(copy.length - i) + i;

      set[i] = copy[index];
      copy[index] = copy[i];
    }

    return set;
  }
}