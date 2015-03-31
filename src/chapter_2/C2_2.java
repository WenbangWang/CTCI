package chapter_2;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Find the kth element to the last of a linked list.
 */
public class C2_2 {

  public static void main(String[] args) {
    Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6};
    LinkedList<Integer> linkedList = new LinkedList<>(array);

    System.out.println(linkedList);
    System.out.println(findToLast(2, linkedList.getFirstNode()));
  }

  private static Node<Integer> findToLast(int index, Node<Integer> node) {
    if(node == null) {
      return null;
    }

    Node<Integer> current = node;
    Node<Integer> runner = current;

    for(int i = 0; i < index; i++) {
      if(runner == null) {
        return null;
      }

      runner = runner.next;
    }

    while(runner != null) {
      current = current.next;
      runner = runner.next;
    }

    return current;
  }
}