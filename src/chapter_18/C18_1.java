package chapter_18;

/**
 * Write a method to add two numbers. You should not use + operator
 */
public class C18_1 {

  public static void main(String[] args) {
    int a = -5;
    int b = 6;

    System.out.println(add(a, b));
  }

  private static int add(int a, int b) {
    if(b == 0) {
      return a;
    }

    int sum = a ^ b;
    int carry = (a & b) << 1;

    return add(sum, carry);
  }
}