package chapter_8.blackjack.hand;

import chapter_8.blackjack.card.Card;

import java.util.ArrayList;

public abstract class Hand<T extends Card> {

  protected ArrayList<T> cards;

  public Hand() {
    this.cards = new ArrayList<>();
  }

  public void addCard(T card) {
    cards.add(card);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    for(T card : cards) {
      stringBuilder.append(card.toString());
    }

    return stringBuilder.toString();
  }

  public abstract int score();
}