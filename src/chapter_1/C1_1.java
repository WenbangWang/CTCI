package chapter_1;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures.
 */
public class C1_1 {

  public static void main(String[] args) {
    String str = "aaa";

    if (findUnique(str)) {
      System.out.println("Unique");
    } else {
      System.out.println("Not Unique");
    }
  }

  private static boolean findUnique(String str) {
    if (str == null || str.length() == 0) {
      return true;
    }

    if (str.length() > 256) {
      return false;
    }

    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';

      if ((checker & (1 << val)) > 0) {
        return false;
      }

      checker |= (1 << val);
    }

    return true;
  }

  private static boolean findUniqueShit(String str) {
    if (str == null) {
      return true;
    }

    char[] charArray = str.toCharArray();

    if (charArray.length == 0) {
      return true;
    }

    for (int i = 0; i < charArray.length; i++) {
      char outerChar = charArray[i];
      for (int j = 0; j < charArray.length; j++) {
        char innerChar = charArray[j];
        if (i != j && outerChar == innerChar) {
          return false;
        }
      }
    }

    return true;
  }
}
