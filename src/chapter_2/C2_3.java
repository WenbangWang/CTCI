package chapter_2;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Given only access to a node in the middle of a singley linked list, delete this node.
 */
public class C2_3 {

  public static void main(String[] args) {
    Integer[] array = new Integer[] {1, 2, 2, 3, 3, 4, 5, 6, 4, 3};
    LinkedList<Integer> linkedList = new LinkedList<>(array);

    System.out.println(linkedList);
    deleteNode(linkedList.getFirstNode().next.next);
    System.out.println(linkedList);
  }

  private static boolean deleteNode(Node<Integer> node) {
    if(node == null || node.next == null) {
      return false;
    }

    node.data = node.next.data;
    node.next = node.next.next;

    return true;
  }
}