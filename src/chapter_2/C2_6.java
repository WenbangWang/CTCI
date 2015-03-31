package chapter_2;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Given a circular linked list,
 * implement an algorithm which returns the code at the beginning of the loop
 */
public class C2_6 {

  public static void main(String[] args) {
    Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    LinkedList<Integer> linkedList = new LinkedList<>(array);

    System.out.println(linkedList);

    Node<Integer> loopNode = linkedList.getFirstNode().next.next.next.next.next;
    linkedList.getLastNode().next = loopNode;

    System.out.println(loopNode);
    findHead(linkedList.getFirstNode());
  }

  private static void findHead(Node<Integer> node) {
    if(node == null) {
      return;
    }

    Node<Integer> current = node;
    Node<Integer> runner = current;

    while(runner != null && runner.next != null) {
      current = current.next;
      runner = runner.next.next;

      if(current == runner) {
        break;
      }
    }

    if(runner == null || runner.next == null) {
      return;
    }

    current = node;

    while(current != runner) {
      current = current.next;
      runner = runner.next;
    }

    System.out.println("The beginning of the loop is: " + current);
  }
}