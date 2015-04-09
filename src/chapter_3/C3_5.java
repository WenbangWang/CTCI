package chapter_3;

import java.util.Stack;

/**
 * Implement a myQueue with two stacks.
 */
public class C3_5 {

  public static void main(String[] args) {
    myQueue queue = new myQueue();

    for(int i = 0; i < 10; i++) {
      queue.enQueue(i);
    }

    queue.deQueue();
    queue.enQueue(10);

    System.out.println(queue);
  }

  private static class myQueue {

    private Stack<Integer> stack;
    private Stack<Integer> bufferStack;

    public myQueue() {
      this.init();
    }

    public myQueue(int[] array) {
      this.init();
      for(int i : array) {
        this.enQueue(i);
      }
    }

    public int deQueue() {
      if(!this.bufferStack.isEmpty()) {
        return this.bufferStack.pop();
      }

      this.shiftDataToBuffer();

      return this.bufferStack.pop();
    }

    public void enQueue(int data) {
      this.stack.push(data);
    }

    @Override
    public String toString() {
      Stack<Integer> queue = new Stack<>();

      if(!this.bufferStack.isEmpty()) {
        queue.addAll(this.bufferStack);
      }

      queue.addAll(this.reverseStack());

      return queue.toString();
    }

    private void shiftDataToBuffer() {
      while(!this.stack.isEmpty()) {
        this.bufferStack.push(this.stack.pop());
      }
    }

    private Stack<Integer> reverseStack() {
      Stack<Integer> tempStack = (Stack<Integer>) this.stack.clone();
      Stack<Integer> reversedStack = new Stack<>();

      while(!tempStack.isEmpty()) {
        reversedStack.push(tempStack.pop());
      }

      return reversedStack;
    }

    private void init() {
      this.stack = new Stack<>();
      this.bufferStack = new Stack<>();
    }
  }
}