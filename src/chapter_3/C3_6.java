package chapter_3;

import java.util.Stack;

/**
 * Sort a stack with another stack as the buffer.
 */
public class C3_6 {

  public static void main(String[] args) {
    int[] array = {1 ,2 ,3, 4, 5, 6, 7, 8, 9, 10};
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < array.length; i++) {
      stack.push(array[i]);
    }

    sort(stack);

    System.out.println(stack);
  }

  private static void sort(Stack<Integer> stack) {
    Stack<Integer> temp = new Stack<>();

    while(!stack.isEmpty()) {
      int top = stack.pop();

      while(!temp.isEmpty() && top < temp.peek()) {
        stack.push(temp.pop());
      }

      temp.push(top);
    }

    while(!temp.isEmpty()) {
      stack.push(temp.pop());
    }
  }
}