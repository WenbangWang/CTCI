package linkedlist;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node() {

    }

    public void displayNode() {
        if (data != null)
            System.out.print("{" + data + "}");
    }

}