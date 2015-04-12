package chapter_8.blackjack.card;

import chapter_8.blackjack.suit.Suit;

public abstract class Card {

  private final String[] FACE_VALUES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  protected int faceValue;
  protected Suit suit;

  public Card(int faceValue, Suit suit) {
    this.faceValue = faceValue;
    this.suit = suit;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public boolean isAce() {
    return this.faceValue == 1;
  }

  public boolean isFaceCard() {
    return this.faceValue >= 11 && this.faceValue <= 13;
  }

  public boolean isNumberCard() {
    return this.faceValue >= 2 && this.faceValue <= 10;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    String faceValue = this.FACE_VALUES[this.faceValue - 1];

    switch (this.suit.getValue()) {
      case 0:
        stringBuilder.append("Diamond");
        break;
      case 1:
        stringBuilder.append("Club");
        break;
      case 2:
        stringBuilder.append("Heart");
        break;
      case 3:
        stringBuilder.append("Spade");
        break;
      default:
        break;
    }

    stringBuilder.append(" ").append(faceValue);

    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;

    Card card = (Card) o;

    if (this.faceValue != card.faceValue) return false;
    if (!suit.equals(card.suit)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = this.faceValue;
    result = 31 * result + suit.hashCode();
    return result;
  }

  public abstract int getValue();
}