package chapter_9;

import java.util.ArrayList;

/**
 * Implement an algorithm to pring all valid combinations of n-pairs of parentheses.
 */
public class C9_6 {

  public static void main(String[] args) {
    int count = 5;
    char[] parens = new char[count * 2];
    ArrayList<String> list = new ArrayList<>();

    addParen(list, count, count, parens, 0);
  }

  private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] parens, int count) {
    if(leftRem < 0 || leftRem > rightRem) {
      return;
    }

    if(leftRem == 0 && rightRem == 0) {
      String paren = String.copyValueOf(parens);
      list.add(paren);

      return;
    }

    if(leftRem > 0) {
      parens[count] = '(';
      addParen(list, leftRem - 1, rightRem, parens, count + 1);
    }

    if(rightRem > 0) {
      parens[count] = ')';
      addParen(list, leftRem, rightRem - 1, parens, count + 1);
    }
  }
}