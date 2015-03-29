package Heap;

public class MaxHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int size) {
        this.heap = new int[size];
        this.size = 0;
        this.capacity = size;
    }

    public void insert(int data) {
        this.heap[this.size] = data;

        trickleUp(this.size);
        increaseHeapSize();
    }

    public int remove() {
        int root = this.heap[0];

        setData(0, this.heap[--size]);
        trickleDown(0);

        return root;
    }

    public int size() {
        return this.size;
    }

    public boolean change(int index, int data) {
        if(index < 0 || index >= capacity) {
            return false;
        }

        int oldValue = this.heap[index];

        if(oldValue > data) {
            trickleDown(index);
        } else {
            trickleUp(index);
        }

        return true;

    }

    private void trickleUp(int index) {
        int data = this.heap[index];
        int parentIndex = parentIndex(index);

        while(index > 0 && data > parent(index)) {
            setData(index, this.heap[parentIndex]);
            index = parentIndex;
            parentIndex = parentIndex(index);
        }

        setData(index, data);
    }

    private void trickleDown(int index) {
        int data = this.heap[index];
        int largerIndex, largerData;

        while(index < size / 2) {
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            if(rightChildIndex < this.size && leftChild < rightChild) {
                largerIndex = rightChildIndex;
            } else {
                largerIndex = leftChildIndex;
            }

            largerData = this.heap[largerIndex];

            if(data > largerData) {
                break;
            }

            setData(index, largerData);
            index = largerIndex;
        }

        setData(index, data);
    }

    private void increaseHeapSize() {
        if(this.size == this.capacity - 1) {
            extendHeap();
        }

        this.size++;
    }

    private void extendHeap() {
        int newCapacity = capacity * 2 + 1;
        int[] newHeap = new int[newCapacity];

        for(int i = 0; i <= this.size; i++) {
            this.heap[i] = newHeap[i];
        }

        this.heap = newHeap;
        this.capacity = newCapacity;
    }

    private void setData(int index, int data) {
        this.heap[index] = data;
    }

    private int parent(int index) {
        return this.heap[parentIndex(index)];
    }

    private int leftChild(int index) {
        return this.heap[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return this.heap[rightChildIndex(index)];
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }
}
