package utils;

public class BinarySearch {

  public static void main(String[] args) {
    int[] array= {2,3,6,1,6,7,8,10};
    Sort.quickSort(array);

    System.out.println(search(array, 3));
  }

  public static boolean search(int[] array, int data) {
    if(!Sort.isSorted(array)) {
      return false;
    }

    return search(array, data, 0, array.length - 1);
  }

  private static boolean search(int[] array, int data, int left, int right) {
    if(left > right) {
      return false;
    }

    int mid = (left + right) / 2;

    if(array[mid] == data) {
      return true;
    }

    if(data < array[mid]) {
      return search(array, data, left, mid - 1);
    } else {
      return search(array, data, mid + 1, right);
    }
  }
}
