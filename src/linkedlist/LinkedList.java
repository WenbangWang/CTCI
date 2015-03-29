package linkedlist;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    public Node<T> first;
    private Node<T> last;
    private int count;


    public LinkedList() {
        first = null;
        count = 0;
    }

    public LinkedList(T[] t) {
        count = 0;
        for (int i = 0; i < t.length; i++) {
            insertLast(t[i]);
        }
    }

    public LinkedList(Node<T> first) {
        this.first = first;
        count = 0;
        Node<T> node = first;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        this.last = node;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        if (first == null) {
            System.out.println("Nothing in the list!");
        }
        else {
            System.out.print("LinkedList (first->last): ");
            Node<T> current = first;
            while (current != null) {
                current.displayNode();
                current = current.next;
            }
        }
        System.out.println();
    }

    public void insertFirst(T data) {
        Node<T> node = new Node<T>(data);
        node.next = first;
//		first.next = null;
        first = node;
        count++;
    }

    private void insertLast(T key) {
        Node<T> node = new Node<T>(key);
        if (isEmpty()) {
            first = node;
//			first.next = null;
        } else
            last.next = node;
        last = node;
//		last.next = null;
        count++;
    }

    public Node<T> deleteFirst() {
        Node<T> temp = first;
        first = first.next;
        count--;
        return temp;
    }

    public Node<T> find(T key) {
        if (first == null) {
            System.out.println("Nothing in the list!");
            return null;
        }
        Node<T> current = first;
        while (current.data != key) {
            if (current.next != null)
                current = current.next;
            else
                return null;
        }
        return current;
    }

    public Node<T> delete(T key) {
        if (first == null) {
            System.out.println("Nothing in the list!");
            return null;
        }
        Node<T> current = first;
        Node<T> previous = first;
        while (current.data != key) {
            if (current.next != null) {
                previous = current;
                current = current.next;
            } else
                return null;
        }
        if (current == first) {
            current = first.next;
        } else {
            previous.next = current.next;
        }
        count--;
        return current;
    }

    public int size() {
        return count;
    }

    public void reverse() {
        Node<T> current = first;
        Node<T> next = first.next;
        Node<T> loopNode = null;

        while (next != null) {
            current.next = loopNode;
            loopNode = current;
            current = next;
            next = next.next;
        }
        current.next = loopNode;
        first = current;
    }


    public Node<T> reverse(Node<T> node) {
        Node<T> current = node;
        Node<T> next = node.next;
        Node<T> loopNode = null;

        while (next != null) {
            current.next = loopNode;
            loopNode = current;
            current = next;
            next = next.next;
        }
        current.next = loopNode;
        node = current;

        return node;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new LinkedListIterator<T>(this);
    }

    private class LinkedListIterator<TT> implements Iterator<TT> {
        private Node<TT> node;
        private LinkedList<TT> list;
        private int current = -1;

        public LinkedListIterator(LinkedList<TT> list) {
            this.list = list;
            node = list.first;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current < list.size() - 1;
        }

        @Override
        public TT next() {
            // TODO Auto-generated method stub
            current++;
            TT value = node.data;
            node = node.next;
            return value;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub

        }
    }
}
