package hanoi;

import java.util.Stack;

public class Tower {

  private Stack<Plate> stack;
  public final int index;

  public Tower(int index) {
    this.stack = new Stack<Plate>();
    this.index = index;
  }

  public Tower(int numberOfPlates, int index) throws Exception{
    this.stack = new Stack<Plate>();
    this.index = index;

    for(int i = numberOfPlates; i > 0; i--) {
      this.push(new Plate(i));
    }
  }

  public void push(Plate plate) throws Exception{
    if(violateRules(plate)) {
      throw new Exception("Cannot push plate with value " + plate.value + " on top of plate with value " + stack.peek().value);
    } else {
      stack.push(plate);
    }
  }

  public Plate pop() throws Exception{
    if(this.isEmpty()) {
      throw new Exception("Cannot pop an empty tower");
    } else {
      return this.stack.pop();
    }
  }

  public boolean isEmpty() {
    return this.stack.empty();
  }

  public int size() {
    return this.stack.size();
  }

  private void movePlates(int n, Tower destination, Tower buffer) throws Exception{
    if(n > 0) {
      this.movePlates(n - 1, buffer, destination);
      this.moveTopTo(destination);
      buffer.movePlates(n - 1, destination, this);
    }
  }

  public void movePlatesTo(Tower destination, Tower buffer) throws Exception{
    movePlates(this.size(), destination, buffer);
  }

  private void moveTopTo(Tower t) throws Exception{
    Plate top = this.pop();
    t.push(top);
    System.out.println("Move " + top + " from " + this.index + " to " + t.index);
  }

  private boolean violateRules(Plate t) {
    return !this.isEmpty() && this.stack.peek().value <= t.value;
  }


}
