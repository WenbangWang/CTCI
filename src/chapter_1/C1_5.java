package chapter_1;

public class C1_5 {

  public static void main(String[] args) {
    String str = "aaaaabbbbcccdde";
    CompressedString compressedString = new CompressedString();

    stringCompression(str, compressedString);

    if(compressedString.length > str.length()) {
      System.out.println(str);
    } else {
      System.out.println(compressedString);
    }
  }

  private static void stringCompression(String str, CompressedString compressedString) {
    int count = 1;
    char last = str.charAt(0);
    StringBuilder stringBuilder = new StringBuilder();

    for(int i = 1; i < str.length(); i++) {
      if(str.charAt(i) == last) {
        count++;
      } else {
        stringBuilder.append(last);
        stringBuilder.append(count);
        last = str.charAt(i);
        count = 1;
      }
    }

    stringBuilder.append(last);
    stringBuilder.append(count);

    compressedString.length = stringBuilder.length();
    compressedString.value = stringBuilder.toString();
  }

  private static class CompressedString {
    public int length;
    public String value;

    @Override
    public String toString() {
      return this.value;
    }
  }
  private static String countRepeatWithString(String str) {
    String result = "";
    char last = str.charAt(0);
    int count = 1;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == last) {
        count++;
      } else {
        result += last + "" + count;
        last = str.charAt(i);
        count = 1;
      }
    }

    result += last + "" + count;

    if (result.length() > str.length()) {
      return str;
    } else {
      return result;
    }
  }

  private static String countRepeatWithStringBuffer(String str) {
    StringBuffer result = new StringBuffer();
    char last = str.charAt(0);
    int count = 1;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == last) {
        count++;
      } else {
        result.append(last);
        result.append(count);
        last = str.charAt(i);
        count = 1;
      }
    }

    result.append(last);
    result.append(count);

    if (result.length() > str.length()) {
      return str;
    } else {
      return result.toString();
    }
  }

  private static String countRepeatWithCharArray(String str) {
    int size = calculateArraySize(str);
    char[] charArray = new char[size];
    char last = str.charAt(0);
    int count = 1;
    int index = 0;

    if (size > str.length()) {
      return str;
    }

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == last) {
        count++;
      } else {
        index = pushCharsIntoArray(charArray, last, index, count);
        last = str.charAt(i);
        count = 1;
      }
    }

    pushCharsIntoArray(charArray, last, index, count);

    return String.valueOf(charArray);
  }

  private static int pushCharsIntoArray(char[] charArray, char last, int index, int count) {
    charArray[index++] = last;

    char[] countArray = String.valueOf(count).toCharArray();

    for (char c : countArray) {
      charArray[index++] = c;
    }

    return index;
  }

  private static int calculateArraySize(String str) {
    char last = str.charAt(0);
    int count = 1;
    int size = 0;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == last) {
        count++;
      } else {
        size += 1 + String.valueOf(count).length();
        last = str.charAt(i);
        count = 1;
      }
    }

    size += 1 + String.valueOf(count).length();

    return size;
  }
}
