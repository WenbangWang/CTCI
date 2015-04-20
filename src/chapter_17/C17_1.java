package chapter_17;

/**
 * Write a function to swap a number in place (no temporary variables)
 */
public class C17_1 {

  public static void main(String[] args) {
    IntegerWrapper a = new IntegerWrapper(1);
    IntegerWrapper b = new IntegerWrapper(2);
    swap(a, b);

    System.out.println("a: " + a);
    System.out.println("b: " + b);
  }

  private static void swap(IntegerWrapper a, IntegerWrapper b) {
    a.value = a.value ^ b.value;
    b.value = a.value ^ b.value;
    a.value = a.value ^ b.value;
  }

  private static class IntegerWrapper {
    int value;

    public IntegerWrapper(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value + "";
    }
  }
}