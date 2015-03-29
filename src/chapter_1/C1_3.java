package chapter_1;

/**
 * Given two strings, write a method to decide if one is the permutation of the other.
 * Open questions:
 * 1. Case sensitive or not.
 * 2. whitespace matters or not.
 */
public class C1_3 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    String str1 = "asdfghjkl";
    String str2 = "lkjhgfdsa";
//    if (permutation(str1, str2))
//      System.out.println("True");
//    else
//      System.out.println("False");


    str1 = quickSort(str1);
    str2 = quickSort(str2);

    if(str1.equals(str2)) {
      System.out.println("True");
    } else {
      System.out.println("false");
    }
  }

  public static boolean permutation(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;
    char[] c = str2.toCharArray();
    int head = 0;
    int tail = str2.length() - 1;

    while (tail > head) {
      c[head] = (char) (c[head] ^ c[tail]);
      c[tail] = (char) (c[tail] ^ c[head]);
      c[head] = (char) (c[head++] ^ c[tail--]);
    }
    String subString = new String(c);

    return str1.equals(subString);
  }

  private static String quickSort(String s) {
    char[] charArray = s.toCharArray();

    quickSort(charArray, 0, charArray.length - 1);

    return new String(charArray);
  }

  private static void quickSort(char[] charArray, int left, int right) {
    if(left < right) {
      int last = left;

      swap(charArray, left, (left + right) / 2);

      for(int i = left; i <= right; i++) {
        if(charArray[i] < charArray[left]) {
          swap(charArray, i, ++last);
        }
      }

      swap(charArray, left, last);
      quickSort(charArray, left, last - 1);
      quickSort(charArray, last + 1, right);
    }
  }

  private static void swap(char[] charArray, int i, int j) {
    char temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
  }
}
