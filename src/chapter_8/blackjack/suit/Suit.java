package chapter_8.blackjack.suit;

/**
 * Abstract class for Suit
 */
public abstract class Suit {

  private int value;

  protected Suit(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;

    Suit suit = (Suit) o;

    if (this.value != suit.value) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return this.value;
  }
}