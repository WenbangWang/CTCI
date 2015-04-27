package chapter_18;

import java.util.Random;

/**
 * Write a method to shuffle a deck of cards. It mush be a perfect shuffle -
 * in other words, each of the 52! permutations of the deck has to be equally likely.
 * Assume that you are given a random number generator which is perfect.
 */
public class C18_2 {

  public static void main(String[] args) {
    int length = 52;
    int[] array = new int[length];

    generate(array);
    print(array);
    shuffle(array);
    print(array);
  }

  public static void shuffle(int[] array) {
    Random generator = new Random();
    for(int i = 0, length = array.length; i < length; i++) {
      int index = generator.nextInt(length - i) + i;

      int temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }

  public static void generate(int[] array) {
    for(int i = 0; i < array.length; i++) {
      array[i] = i;
    }
  }

  public static void print(int[] array) {
    for(int i = 0; i < array.length; i++) {
      System.out.print(array[i]);

      if(i != array.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }
}