package linkedlist;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

  private Node<T> first;
  private Node<T> last;
  private int size;

  public LinkedList() {
    this.init();
  }

  public LinkedList(T[] array) {
    this.init();

    for(T t : array) {
      this.addLast(t);
    }
  }

  public LinkedList(Collection<T> collection) {
    this.init();

    for(T t : collection) {
      this.addLast(t);
    }
  }

  public LinkedList(Node<T> first) {
    this.init();

    this.first = first;
  }

  public void addFirst(T key) {
    Node<T> newFirst = new Node<>(key);

    if(this.isEmpty()) {
      this.initFirstAndLastWith(newFirst);
    } else {
      newFirst.next = this.first;
      this.first.pre = newFirst;
      this.first = newFirst;
    }

    this.size++;
  }

  public void addLast(T key) {
    Node<T> newLast = new Node<>(key);

    if(this.isEmpty()) {
      this.initFirstAndLastWith(newLast);
    } else {
      newLast.pre = this.last;
      this.last.next = newLast;
      this.last = newLast;
    }

    this.size++;
  }

  public T removeFirst() {
    if(this.isEmpty()) {
      return null;
    }

    T data = this.first.data;

    this.first = this.first.next;
    this.first.pre = null;
    this.size--;

    return data;
  }

  public T removeLast() {
    if(this.isEmpty()) {
      return null;
    }

    T data = this.last.data;

    this.last = this.last.pre;
    this.last.next = null;
    this.size--;

    return data;
  }

  public T remove(int index) {
    Node<T> current = this.getNode(index);

    if(current == null) {
      return null;
    }

    current.pre.next = current.next;
    current.next.pre = current.pre;

    this.size--;

    return current.data;
  }

  public T get(int index) {
    Node<T> node = this.getNode(index);

    if(node != null) {
      return node.data;
    }

    return null;
  }

  public void clear() {
    this.init();
  }

  public T getFirst() {
    if(this.isEmpty()) {
      return null;
    } else {
      return this.first.data;
    }
  }

  public Node<T> getFirstNode() {
    if(this.isEmpty()) {
      return null;
    } else {
      return this.first;
    }
  }

  public T getLast() {
    if(this.isEmpty()) {
      return null;
    } else {
      return this.last.data;
    }
  }

  public Node<T> getLastNode() {
    if(this.isEmpty()) {
      return null;
    } else {
      return this.last;
    }
  }

  public void reverse() {
    Node<T> current = this.first;
    Node<T> next = this.first.next;
    Node<T> loopNode = null;
    this.last = this.first;

    while(next != null) {
      current.next = loopNode;
      current.pre = next;
      loopNode = current;
      current = next;
      next = next.next;
    }

    current.next = loopNode;
    current.pre = next;

    this.first = current;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public String sizeToString() {
    return "Size: " + this.size();
  }

  @Override
  public String toString() {
    Node<T> current = this.first;
    StringBuilder stringBuilder = new StringBuilder();

    if(current != null) {
      stringBuilder.append("First->Last: ");
    }

    while(current != null) {
      stringBuilder.append(current);

      if(current.next != null) {
        stringBuilder.append("->");
      }

      current = current.next;
    }

    return stringBuilder.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator<>(this);
  }

  private class LinkedListIterator<TT> implements Iterator<TT> {

    private Node<TT> node;
    private LinkedList<TT> list;
    private int current;

    public LinkedListIterator(LinkedList<TT> list) {
      this.list = list;
      this.node = this.list.first;
      this.current = -1;
    }

    @Override
    public boolean hasNext() {
      return this.current < this.list.size() - 1;
    }

    @Override
    public TT next() {
      this.current++;

      TT data = this.node.data;
      this.node = this.node.next;

      return data;
    }

    @Override
    public void remove() {

    }
  }

  private Node<T> getNode(int index) {
    if(index == 1) {
      return this.getFirstNode();
    } else if(index == this.size - 1) {
      return this.getLastNode();
    } else if(index < 0 || index >= this.size()) {
      return null;
    }
    Node<T> current = this.first;

    for(int i = 0; i < index - 1; i++) {
      current = current.next;
    }

    return current;
  }

  private void initFirstAndLastWith(Node<T> node) {
    this.first = node;
    this.last = node;
  }

  private void init() {
    this.size = 0;
    this.first = null;
    this.last = null;
  }
}