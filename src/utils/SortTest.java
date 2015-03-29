package utils;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

  private static int[] sortedArray;

  public static void main(String[] args) {
    int size = 10000;
    int[] array = generateRandomIntArray(size);
    sortedArray = sort(array);

//        System.out.print("The original array is ");
//        printArray(array);
//        System.out.println();

    testSort(array, "bubble");
    testSort(array, "select");
    testSort(array, "insertion");
    testSort(array, "merge");
    testSort(array, "quick");
  }

  private static void testSort(int[] array, String method) {
    int[] arrayToBeTested;
    String result;
    long startTime, endTime;

    startTime = System.nanoTime();

    arrayToBeTested = sort(array, method);

    endTime = System.nanoTime();

    if (isIdentical(sortedArray, arrayToBeTested)) {
      result = "PASS";
    } else {
      result = "FAIL";
    }

    System.out.print(method + " sort: " + result);
    System.out.println(". It takes " + (endTime - startTime) / 1000 + " milliseconds");
  }

  private static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  private static int[] generateRandomIntArray(int length) {
    int[] array = new int[length];
    Random generator = new Random();

    for (int i = 0; i < length; i++) {
      array[i] = generator.nextInt(length);
    }

    return array;
  }

  private static boolean isIdentical(int[] array1, int[] array2) {
    return Arrays.equals(array1, array2);
  }

  private static int[] sort(int[] array, String method) {
    int[] temp = array.clone();

    switch (method.toLowerCase()) {
      case "bubble":
        Sort.bubbleSort(temp);
        break;
      case "select":
        Sort.selectSort(temp);
        break;
      case "merge":
        Sort.mergeSort(temp);
        break;
      case "insertion":
        Sort.insertionSort(temp);
        break;
      case "quick":
        Sort.quickSort(temp);
        break;
      default:
        System.out.println("No such method");
        break;
    }

    return temp;
  }

  private static int[] sort(int[] array) {
    int[] temp = array.clone();

    Arrays.sort(temp);

    return temp;
  }
}
