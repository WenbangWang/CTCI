package chapter_9;

import java.util.Arrays;
import java.util.Random;

/**
 * A magic index in an array A[1 ... n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists in array A.
 *
 * Follow Up:
 * What if the values are not distinct?
 */
public class C9_3 {

  public static void main(String[] args) {
    int length = 50;
    int[] array = generateSortedArray(length);

    for(int i = 0; i < length; i++) {
      System.out.print(array[i] + " ");
    }

    System.out.println();

    System.out.println(findMagicIndex(array, 0, length));
  }

  public static int findMagicIndex(int[] array, int start, int end) {
    if(start > end) {
      return -1;
    }

    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    int leftIndex;
    int rightIndex;
    int left;
    int right;

    if(midIndex == midValue) {
      return midIndex;
    }

    leftIndex = Math.min(midIndex - 1, midValue);
    left = findMagicIndex(array, start, leftIndex);

    if(left >= 0) {
      return left;
    }

    rightIndex = Math.max(midIndex + 1, midValue);
    right = findMagicIndex(array, rightIndex, end);

    return right;
  }

  private static int[] generateSortedArray(int length) {
    int[] array = new int[length];
    Random generator = new Random();

    for(int i = 0; i <= 9; i++) {
      array[i] = 9;
    }

    for(int i = 10; i < length; i++) {
      array[i] = generator.nextInt(length) + 10;
    }

    Arrays.sort(array);

    return array;
  }
}