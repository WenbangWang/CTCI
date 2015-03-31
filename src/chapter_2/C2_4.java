package chapter_2;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Partition a linked list aroung a value x,
 * such that all nodes less than x come beore all nodes greater than or equal to x.
 */
public class C2_4 {

  public static void main(String[] args) {
    Integer[] array = new Integer[] {7, 8, 9, 10, 3, 1, 2, 2, 4, 3, 3, 4, 5, 6};
    LinkedList<Integer> linkedList = new LinkedList<>(array);

    System.out.println(linkedList);

    partition(linkedList.getFirstNode(), 5);
  }

  private static void partition(Node<Integer> node, int value) {
    if(node == null) {
      return;
    }

    Node<Integer> firstHalf = null;
    Node<Integer> secondHalf = null;
    Node<Integer> firstHead = null;
    Node<Integer> secondHead = null;
    Node<Integer> current = node;

    while(current != null) {
      if(current.data >= value) {
        if(secondHalf == null) {
          secondHalf = new Node<>(current.data);
          secondHead = secondHalf;
        } else {
          secondHalf.next = new Node<>(current.data);
          secondHalf = secondHalf.next;
        }
      } else {
        if(firstHalf == null) {
          firstHalf = new Node<>(current.data);
          firstHead = firstHalf;
        } else {
          firstHalf.next = new Node<>(current.data);
          firstHalf = firstHalf.next;
        }
      }

      current = current.next;
    }

    if(firstHalf != null) {
      firstHalf.next = secondHead;
    } else {
      firstHead = secondHead;
    }

    System.out.println(new LinkedList<>(firstHead));
  }
}