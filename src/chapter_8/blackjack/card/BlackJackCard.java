package chapter_8.blackjack.card;

import chapter_8.blackjack.suit.Suit;

public class BlackJackCard extends Card {

  public BlackJackCard(int faceValue, Suit suit) {
    super(faceValue, suit);
  }

  public int getValue() {
    if(this.isAce()) {
      return 1;
    } else if(this.isFaceCard()) {
      return 10;
    } else {
      return this.faceValue;
    }
  }

  public int maxValue() {
    if(this.isAce()) {
      return 11;
    } else {
      return this.getValue();
    }
  }

  public int minValue() {
    return this.getValue();
  }
}