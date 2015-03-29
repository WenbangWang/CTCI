package hanoi;

public class Plate {

  public final int value;

  public Plate(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return Integer.toString(this.value);
  }
}
