package chapter_3;

import java.util.Stack;

/**
 * Implement a stack, in addition to push and pop, also has a function min which returns the minimum element.
 * Push, pop and min should all operate in O(1) time.
 */
public class C3_2 {

  public static void main(String[] args) {
    int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3};
    StackWithMin stackWithMin = new StackWithMin(array);


    System.out.println(stackWithMin);
    stackWithMin.pop();
    System.out.println(stackWithMin.min());
    stackWithMin.pop();
    System.out.println(stackWithMin.min());
    stackWithMin.pop();
    System.out.println(stackWithMin.min());
  }

  private static class StackWithMin {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;
    private int min;

    public StackWithMin() {
      this.init();
    }

    public StackWithMin(int[] array) {
      this.init();

      for(int i : array) {
        this.push(i);
      }
    }

    public void push(int data) {
      if(this.min() >= data) {
        this.minStack.push(data);
      }

      this.stack.push(data);
    }

    public int pop() {
      int min = this.stack.pop();

      if(min == this.min()) {
        this.minStack.pop();
      }

      return min;
    }

    public int min() {
      if(this.minStack.isEmpty()) {
        return Integer.MAX_VALUE;
      }

      return this.minStack.peek();
    }

    @Override
    public String toString() {
      return stack.toString();
    }

    private void init() {
      this.minStack = new Stack<>();
      this.stack = new Stack<>();
    }
  }
}