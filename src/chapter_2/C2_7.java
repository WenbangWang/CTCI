package chapter_2;

import linkedlist.LinkedList;
import linkedlist.Node;

import java.util.Stack;

/**
 * Check is a linked list is a palindrome
 */
public class C2_7 {

  public static void main(String[] args) {
    Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    LinkedList<Integer> linkedList = new LinkedList<>(array);

    System.out.println(linkedList);
    System.out.println(checkPalindrome(linkedList));
  }

  private static boolean checkPalindrome(LinkedList<Integer> linkedList) {
    Node<Integer> node = linkedList.getFirstNode();
    Node<Integer> current = node;
    Node<Integer> runner = current;
    Stack<Integer> stack = new Stack<>();

    if(current == null) {
      return false;
    }

    while(runner != null && runner.next != null) {
      stack.push(current.data);
      current = current.next;
      runner = runner.next.next;
    }

    if(runner != null) {
      current = current.next;
    }

    while(!stack.isEmpty()) {
      if(!stack.pop().equals(current.data)) {
        return false;
      }
      current = current.next;
    }

    return true;
  }
}