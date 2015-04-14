package chapter_9;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a method to compute all permutations of a string.
 */
public class C9_5 {

  public static void main(String[] args) {
    String string = "abcde";

    System.out.println(permutationsOfString(string));

  }

  private static ArrayList<String> permutationsOfString(String string) {
    if(string == null) {
      return null;
    }

    ArrayList<String> permutations = new ArrayList<>();

    if(string.length() == 0) {
      permutations.add("");
    } else {
      char first = string.charAt(0);
      String substring = string.substring(1);
      ArrayList<String> subPermutations = permutationsOfString(substring);

      for(String permutation : subPermutations) {
        for(int i = 0, length = permutation.length(); i <= length; i++) {
          String temp = insertCharAt(first, permutation, i);

          permutations.add(temp);
        }
      }
    }

    return permutations;
  }

  private static String insertCharAt(char c, String target, int index) {
    return target.substring(0, index) + c + target.substring(index);
  }
}