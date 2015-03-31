package chapter_2;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */
public class C2_5 {

  public static void main(String[] args) {
    Integer[] firstArray = {6, 1, 7, 9, 2, 1};
    Integer[] secondArray = {2, 9, 5};
    LinkedList<Integer> firstLinkedList = new LinkedList<>(firstArray);
    LinkedList<Integer> secondLinkedList = new LinkedList<>(secondArray);

    System.out.println(firstLinkedList);
    System.out.println(secondLinkedList);

//    plusReverseOrder(firstLinkedList, secondLinkedList);
    plusInOrder(firstLinkedList, secondLinkedList);
  }

  private static void plusInOrder(LinkedList<Integer> firstLinkedList, LinkedList<Integer> secondLinkedList) {
    padZeros(firstLinkedList, secondLinkedList);
    NodeCarryWrapper wrapper = plusInOrder(firstLinkedList.getFirstNode(), secondLinkedList.getFirstNode());

    System.out.println(new LinkedList<>(wrapper.node));
  }

  private static NodeCarryWrapper plusInOrder(Node<Integer> firstNode, Node<Integer> secondNode) {
    if(firstNode == null && secondNode == null) {
      return new NodeCarryWrapper();
    }

    NodeCarryWrapper wrapper = plusInOrder(firstNode.next, secondNode.next);

    int sum = wrapper.carry;
    int data;
    int carry;
    Node<Integer> current;

    if(firstNode != null) {
      sum += firstNode.data;
    }
    if(secondNode != null) {
      sum += secondNode.data;
    }

    data = sum % 10;
    carry = sum / 10;
    current = new Node<>(data);
    current.next = wrapper.node;
    wrapper.carry = carry;
    wrapper.node = current;

    return wrapper;
  }

  private static void padZeros(LinkedList<Integer> firstLinkedList, LinkedList<Integer> secondLinkedList) {
    int firstSize = firstLinkedList.size();
    int secondSize = secondLinkedList.size();

    for(int i = 0, abs = Math.abs(firstSize - secondSize); i < abs; i++) {
      if(firstSize > secondSize) {
        padZerosTo(secondLinkedList);
      } else {
        padZerosTo(firstLinkedList);
      }
    }
  }

  private static void padZerosTo(LinkedList<Integer> linkedList) {
    linkedList.addFirst(0);
  }

  private static void plusReverseOrder(LinkedList<Integer> firstLinkedList, LinkedList<Integer> secondLinkedList) {
    Node<Integer> first = plusReverseOrder(firstLinkedList.getFirstNode(), secondLinkedList.getFirstNode(), 0);
    System.out.println("Plus in reverse order:");
    System.out.println(new LinkedList<>(first));
  }

  private static Node<Integer> plusReverseOrder(Node<Integer> firstNode, Node<Integer> secondNode, int carry) {
    if(firstNode == null && secondNode == null && carry == 0) {
      return null;
    }

    int sum = carry;
    int data;
    Node<Integer> result;

    if(firstNode != null) {
      sum += firstNode.data;
    }
    if(secondNode != null) {
      sum += secondNode.data;
    }

    data = sum % 10;
    carry = sum / 10;
    result = new Node<>(data);

    if(firstNode != null || secondNode != null || carry != 0) {
      Node<Integer> next = plusReverseOrder(firstNode == null ? null : firstNode.next, secondNode == null ? null : secondNode.next, carry);
      result.next = next;
    }

    return result;
  }

  private static class NodeCarryWrapper {
    public Node<Integer> node = null;
    public int carry = 0;
  }
}