package chapter_17;

/**
 * Given an array of integers,
 * write a method to find indices m and n such that if you sorted elements m through n,
 * the entire array would be sored.
 * Minimize n - m. 
 */
public class C17_6 {

  public static void main(String[] args) {

  }

  private static int findIndices(int[] array) {
    int lowerBound = findLowerBound(array);
    int upperBound = findUpperBound(array);
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    if(lowerBound == 1) {
      return 0;
    }
    if(lowerBound == array.length - 1 && upperBound == 0) {
      return array.length - 1;
    }

    for(int i = lowerBound; i <= upperBound; i++) {
      if(array[i] > max) {
        max = array[i];
      }

      if(array[i] < min) {
        min = array[i];
      }
    }

    return shrinkRight(array, upperBound, max) - shrinkLeft(array, lowerBound, min);
  }

  private static int shrinkLeft(int[] array, int lowerBound, int min) {
    for(int i = 0; i < lowerBound; i++) {
      if(array[i] <= min) {
        return i;
      }
    }

    return 0;
  }

  private static int shrinkRight(int[] array, int upperBound, int max) {
    for(int i = upperBound + 1; i < array.length; i++) {
      if(array[i] >= max) {
        return i;
      }
    }

    return array.length - 1;
  }

  private static int findUpperBound(int[] array) {
    for(int i = array.length - 1; i >= 1; i++) {
      if(array[i - 1] > array[i]) {
        return i - 1;
      }
    }

    return 0;
  }

  private static int findLowerBound(int[] array) {
    for(int i = 0; i < array.length - 1; i++) {
      if(array[i + 1] < array[i]) {
        return i + 1;
      }
    }

    return array.length - 1;
  }
}