package chapter_17;

/**
 * Find the contiguous sequence (both position and negative) with the largest sum
 */
public class C17_8 {

  public static void main(String[] args) {

  }

  private static int findSequence(int[] array) {
    int sum = 0;
    int maxSum = 0;

    for(int i = 0; i < array.length; i++) {
      sum += array[i];

      if(maxSum < sum) {
        maxSum = sum;
      } else if(sum < 0) {
        sum = 0;
      }
    }

    return 0;
  }
}