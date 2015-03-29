package utils;

import java.util.Arrays;

public class Sort {


  public static boolean isSorted(int[] array) {
    if(array == null && array.length == 0) {
      return true;
    }
    int[] temp = array.clone();

    Arrays.sort(temp);

    return Arrays.equals(array, temp);
  }

  public static void bubbleSort(int[] array) {
    for (int i = array.length; i > 0; i--) {
      for (int j = 1; j < i; j++) {
        if (array[j - 1] > array[j]) {
          swap(array, j - 1, j);
        }
      }
    }
  }

  public static void selectSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;

      for (int j = i + 1; j < array.length; j++) {
        if (array[min] > array[j]) {
          min = j;
        }
      }

      swap(array, min, i);
    }
  }

  public static void insertionSort(int[] array) {
    for (int out = 1; out < array.length; out++) {
      int temp = array[out];
      int in = out;

      while (in > 0 && array[in - 1] > temp) {
        array[in] = array[--in];
      }

      array[in] = temp;
    }
  }

  public static void mergeSort(int[] array) {
    int[] workspace = new int[array.length];
    mergeSort(workspace, array, 0, array.length - 1);
  }

  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private static void quickSort(int[] array, int left, int right) {
    if (left < right) {
      int last = left;

      swap(array, left, (left + right) / 2);

      for (int i = left + 1; i <= right; i++) {
        if (array[i] < array[left]) {
          swap(array, i, ++last);
        }
      }

      swap(array, left, last);

      quickSort(array, left, last - 1);
      quickSort(array, last + 1, right);
    }
  }

  private static void mergeSort(int[] workspace, int[] array, int start, int end) {
    if (start != end) {
      int mid = (start + end) / 2;

      mergeSort(workspace, array, start, mid);
      mergeSort(workspace, array, mid + 1, end);
      merging(workspace, array, start, mid + 1, end);
    }
  }

  private static void merging(int[] workspace, int[] array, int lowPtr, int highPtr, int upperBound) {
    int lowerBound = lowPtr;
    int mid = highPtr - 1;
    int n = upperBound - lowerBound + 1;
    int i = 0;

    while (lowPtr <= mid && highPtr <= upperBound) {
      if (array[lowPtr] < array[highPtr]) {
        workspace[i++] = array[lowPtr++];
      } else {
        workspace[i++] = array[highPtr++];
      }
    }

    while (lowPtr <= mid) {
      workspace[i++] = array[lowPtr++];
    }

    while (highPtr <= upperBound) {
      workspace[i++] = array[highPtr++];
    }

    for (i = 0; i < n; i++) {
      array[lowerBound + i] = workspace[i];
    }
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static void swapBitManipulation(int[] array, int i, int j) {
    array[i] = array[i] ^ array[j];
    array[j] = array[i] ^ array[j];
    array[i] = array[i] ^ array[j];
  }
}
