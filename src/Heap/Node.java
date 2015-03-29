package Heap;

public class Node {

    private int data;
    public Node leftChild;
    public Node rightChile;

    public Node(int data) {
        this.data = data;
    }

    public void display() {
        System.out.print("{ " + data + " }");
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
