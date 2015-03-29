package chapter_1;

/**
 * Replace all whitespaces in a string with "%20".
 */
public class C1_4 {

  public static void main(String[] args) {
    String str = "I'm a string of characters";
    int length = str.length();
    char[] charArray = buildStringWithTrailingSpaces(str);

    addSpaces(charArray, length);

    System.out.println(charArray);
  }

  private static void addSpaces(char[] charArray, int length) {
    int numberOfTrailingSpaces = countTrailingSpaces(charArray);
    int newLength = length + numberOfTrailingSpaces;

    for(int i = length - 1; i >= 0; i--) {
      if(charArray[i] == ' ') {
        charArray[newLength - 1] = '0';
        charArray[newLength - 2] = '2';
        charArray[newLength - 3] = '%';
        newLength = newLength - 3;
      } else {
        charArray[--newLength] = charArray[i];
      }
    }
  }

  private static int countSpacesInSentence(char[] charArray, int numberOfTrailingSpaces) {
    int numberOfSpacesInSentence = 0;

    for(int i = 0; i < charArray.length - numberOfSpacesInSentence; i++) {
      if(charArray[i] == ' ') {
        numberOfSpacesInSentence++;
      }
    }

    return numberOfSpacesInSentence;
  }

  private static int countTrailingSpaces(char[] charArray) {
    int numberOfTrailingSpaces = 0;

    for(int i = charArray.length - 1; i >= 0; i--) {
      if(charArray[i] == ' ') {
        numberOfTrailingSpaces++;
      } else {
        break;
      }
    }

    return numberOfTrailingSpaces;
  }

  private static char[] buildStringWithTrailingSpaces(String s) {
    StringBuilder stringBuilder = new StringBuilder(s);
    int numberOfSpacesInSentence = 0;
    int numberOfTrailingSpaces;

    for(char c : s.toCharArray()) {
      if(c == ' ') {
        numberOfSpacesInSentence++;
      }
    }

    numberOfTrailingSpaces = numberOfSpacesInSentence * 2;

    for(int i = 0; i < numberOfTrailingSpaces; i++) {
      stringBuilder.append(' ');
    }

    return stringBuilder.toString().toCharArray();
  }

  private static char[] processSpace(char[] charArray) {
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];

      if (c == ' ') {
        sb.append("%20");
      } else {
        sb.append(c);
      }
    }

    return sb.toString().toCharArray();
  }
}
