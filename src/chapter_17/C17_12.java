package chapter_17;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Design an algorithm to find all pair of integers within an array which sum to a specific value
 */
public class C17_12 {

  public static void main(String[] args) {

  }

  private static ArrayList<Point> findPairs(int[] array, int sum) {
    ArrayList<Point> result = new ArrayList<>();
    int first = 0;
    int last = array.length - 1;

    Arrays.sort(array);

    while (first < last) {
      int tempSum = array[first] + array[last];

      if(tempSum == sum) {
        result.add(new Point(array[first], array[last]));
        first++;
        last--;
      } else {
        if(tempSum > sum) {
          last--;
        } else {
          first++;
        }
      }
    }
    return result;
  }
}