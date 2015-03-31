package linkedlist;

import java.util.ArrayList;

public class Test {

  private static LinkedList<Integer> linkedList;

  public static void main(String[] args) {
    testAddFirst();
    testAddLast();
    testCollectionConstructor();
    testRemoveFirst();
    testRemoveLast();
    testRemove();
    testReverse();
  }

  private static void testAddFirst() {
    init();

    printMethod("addFirst()");

    linkedList.addFirst(1);
    linkedList.addFirst(2);
    linkedList.addFirst(3);

    printResults();
  }

  private static void testAddLast() {
    init();

    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);

    printMethod("addLast()");
    printResults();
  }

  private static void testCollectionConstructor() {
    initWithCollection();

    printMethod("LinkedList()");
    printResults();
  }

  private static void testRemoveFirst() {
    initWithCollection();

    printMethod("removeFirst()");
    printResults();

    int data = linkedList.removeFirst();

    printSubResult("After remove: ");
    printResults(2);
    printSubResult("Old first is: " + data, 2);
  }

  private static void testRemove() {
    initWithCollection();

    printMethod("remove()");
    printResults();

    int data = linkedList.remove(2);

    printSubResult("After remove: ");
    printResults(2);

    printSubResult("Removed data is: " + data, 2);
  }

  private static void testRemoveLast() {
    initWithCollection();

    printMethod("removeLast()");
    printResults();

    int data = linkedList.removeLast();

    printSubResult("After remove: ");
    printResults(2);
    printSubResult("Old last is: " + data, 2);
  }

  private static void testReverse() {
    initWithCollection();

    printMethod("reverse()");
    printResults();

    linkedList.reverse();

    printResults();
  }

  private static void printResults() {
    printResults(1);
  }

  private static void printResults(int level) {
    printSubResult(linkedList.toString(), level);
    printSubResult(linkedList.sizeToString(), level);
    printSubResult("First: " +  linkedList.getFirst(), level);
    printSubResult("Last: " + linkedList.getLast(), level);
  }

  private static void printMethod(String name) {
    System.out.println(name + ":");
  }

  private static void printSubResult(String result) {
    printSubResult(result, 1);
  }

  private static void printSubResult(String result, int level) {
    for(int i = 0; i < level; i++) {
      System.out.print("  ");
    }

    System.out.println(result);
  }

  private static void init() {
    linkedList = new LinkedList<>();
  }

  private static void initWithCollection() {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);

    linkedList = new LinkedList<>(arrayList);
  }
}