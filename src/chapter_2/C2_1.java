package chapter_2;

import linkedlist.LinkedList;
import linkedlist.Node;

import java.util.HashMap;

/**
 * Remove duplicates from an unsorted linked list.
 * And solve this problem if a temporary buffer is not allowed.
 */
public class C2_1 {

  public static void main(String[] args) {
    Integer[] array = new Integer[] {1, 2, 2, 3, 3, 4, 5, 6, 4, 3};
    LinkedList<Integer> linkedList1 = new LinkedList<>(array);
    LinkedList<Integer> linkedList2 = new LinkedList<>(array);

    System.out.println(linkedList1);

    removeDupsWithMap(linkedList2.getFirstNode());
    removeDups(linkedList1.getFirstNode());

    System.out.println(linkedList1);
    System.out.println(linkedList2);
  }

  private static void removeDupsWithMap(Node<Integer> node) {
    if(node == null) {
      return;
    }

    HashMap<Integer, Boolean> map = new HashMap<>();
    Node<Integer> current = node;
    Node<Integer> pre = current;

    while(current != null) {
      if(map.containsKey(current.data)) {
        pre.next = current.next;
      } else {
        map.put(current.data, true);
        pre = current;
      }

      current = current.next;
    }
  }

  private static void removeDups(Node<Integer> node) {
    if(node == null) {
      return;
    }

    Node<Integer> current = node;

    while(current != null) {
      Node<Integer> runner = current;

      while(runner.next != null) {
        if(runner.next.data.equals(current.data)) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }

      current = current.next;
    }
  }
}