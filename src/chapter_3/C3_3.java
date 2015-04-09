package chapter_3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Implement a datastrucure SetOfStacks that will create new stack once the previous one was full.
 * Follow Up: Implement a function popAt(int index) to pop on a specific sub-stack
 */
public class C3_3 {

  public static void main(String[] args) {
    SetOfStacks setOfStacks = new SetOfStacks(2);

    for(int i = 0; i < 20; i++) {
      setOfStacks.push(i);
    }
    System.out.println(setOfStacks);

    System.out.println(setOfStacks.popAt(2));
    System.out.println(setOfStacks.popAt(2));
    System.out.println(setOfStacks);
  }

  private static class SetOfStacks {

    private ArrayList<LimitedStack> setOfStacks;
    private int threshold;

    public SetOfStacks(int threshold) {
      this.init();
      this.threshold = threshold;
    }

    public void push(int data) {
      LimitedStack stack = this.getLastStack();

      if(stack == null || stack.isFull()) {
        stack = new LimitedStack(this.threshold);
        this.setOfStacks.add(stack);
      }

      stack.push(data);
    }

    public int pop() {
      LimitedStack stack = this.getLastStack();
      int value;

      if(stack == null) {
        throw new RuntimeException("Nothing in the stack");
      }

      value = stack.pop();

      this.removeLastEmptyStack();

      return value;
    }

    public int popAt(int index) {
      int lastIndex = this.getLastIndex();
      LimitedStack stack;
      int value;

      if(index > lastIndex || index <= 0) {
        throw new IndexOutOfBoundsException();
      }

      if(index == lastIndex) {
        return this.pop();
      }

      stack = this.setOfStacks.get(index - 1);
      value = stack.pop();

      this.shift(index);

      return value;
    }

    @Override
    public String toString() {
      return this.setOfStacks.toString();
    }

    private void shift(int index) {
      for(int i = index, size = this.getLastIndex(); i <= size; i++) {
        LimitedStack preStack = this.setOfStacks.get(i - 1);
        LimitedStack currentStack = this.setOfStacks.get(i);

        preStack.push(currentStack.removeLast());
      }

      this.removeLastEmptyStack();
    }

    private void removeLastEmptyStack() {
      if(this.getLastStack().isEmpty()) {
        this.setOfStacks.remove(this.getLastIndex());
      }
    }

    private LimitedStack getLastStack() {
      if(this.setOfStacks.isEmpty()) {
        return null;
      }

      return this.setOfStacks.get(this.getLastIndex());
    }

    private int getLastIndex() {
      if(this.setOfStacks.isEmpty()) {
        return 0;
      }

      return this.setOfStacks.size() - 1;
    }

    private void init() {
      this.setOfStacks = new ArrayList<>();
    }

    private class LimitedStack extends Stack<Integer> {

      private int threshold;

      public LimitedStack(int threshold) {
        this.threshold = threshold;
      }

      public void push(int data) {
        if(this.size() > threshold) {
          throw new RuntimeException("Exceed threshold");
        }

        super.push(data);
      }

      public boolean isFull() {
        return this.size() == this.threshold;
      }

      public int removeLast() {
        return super.remove(0);
      }
    }
  }
}