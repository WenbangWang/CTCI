package chapter_2;

import java.util.Stack;

import linkedlist.*;

public class C2_5 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Integer[] array1 = {6, 1, 7, 9, 2, 1};
        Integer[] array2 = {2, 9, 5};

        FirstLastList<Integer> list1 = new FirstLastList<Integer>();
        FirstLastList<Integer> list2 = new FirstLastList<Integer>();

        for (int i = 0; i < array1.length; i++) {
            list1.insertLast(array1[i]);
        }

        for (int i = 0; i < array2.length; i++) {
            list2.insertLast(array2[i]);
        }

        list1.reverse();
        list2.reverse();

        Node<Integer> node = add1(list1.first, list2.first);
        FirstLastList<Integer> list = new FirstLastList<Integer>();
        list.first = node;
        list.reverse();
        list.displayList();

/*		LinkedList<Integer> list1 = new LinkedList<Integer>(array1);
		LinkedList<Integer> list2 = new LinkedList<Integer>(array2);
		Node<Integer> node = add1(list1.first, list2.first);
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.first = node;
		list.displayList();*/

    }

    public static Node<Integer> add(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null && node2 == null)
            return null;
        Node<Integer> result = new Node<Integer>();
        Node<Integer> head = result;
        int carry = 0;

        while (node1 != null || node2 != null) {
            int data = (node1 != null ? node1.data : 0) + (node2 != null ? node2.data : 0) + carry;
            carry = data >= 10 ? 1 : 0;
            result.data = data % 10;
            result.next = new Node<Integer>();
            result = result.next;
            if (node1 != null)
                node1 = node1.next;
            if (node2 != null)
                node2 = node2.next;
        }
        if (result.data == null)
            result = null;
        return head;
    }

    public static Node<Integer> add1(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null && node2 == null)
            return null;
        int size1 = 0;
        int size2 = 0;
        Node<Integer> head1 = node1;
        Node<Integer> head2 = node2;
        while (node1 != null) {
            size1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            size2++;
            node2 = node2.next;
        }
        for (int i = 0; i < Math.abs(size1 - size2); i++) {
            if (size1 > size2) {
                Node<Integer> node = new Node<Integer>(0);
                node.next = head2;
                head2 = node;
            } else {
                Node<Integer> node = new Node<Integer>(0);
                node.next = head1;
                head1 = node;
            }
        }
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Node<Integer> result = new Node<Integer>();
        int carry = 0;
        while (head1 != null) {
            stack1.push(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.data);
            head2 = head2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int data1 = stack1.pop();
            int data2 = stack2.pop();
            int data = data1 + data2 + carry;
            carry = data >= 10 ? 1 : 0;
            result.data = data % 10;
            Node<Integer> newNode = new Node<Integer>();
            newNode.next = result;
            result = newNode;
        }
        if (carry == 1)
            result.data = 1;
        return result;
    }


}
