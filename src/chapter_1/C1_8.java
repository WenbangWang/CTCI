package chapter_1;

/**
 * Given two strings, s1 and s2, check if s2 is a toration of s1 using only one call to isSubString method.
 */
public class C1_8 {

  public static void main(String[] args) {
    String str1 = "waterbottle";
    String str2 = "erbottlewat";

    System.out.println(isRotation(str1, str2));
  }

  private static boolean isRotation(String str1, String str2) {
    int str1Length = str1.length();

    if(str1Length == str2.length() && str1Length > 0) {
      String newString = str1 + str1;

      return isSubString(newString, str2);
    }

    return false;
  }

  private static boolean isSubString(String str1, String str2) {
    for(int i = 0; i < str1.length(); i++) {
      int j = 0;

      try {
        while(str1.charAt(i) == str2.charAt(j)) {
          i++;
          j++;

          if(j == str2.length()) {
            return true;
          }
        }
      } catch (IndexOutOfBoundsException e) {
        return false;
      }
    }

    return false;
  }
}