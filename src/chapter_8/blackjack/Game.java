package chapter_8.blackjack;

import chapter_8.blackjack.card.BlackJackCard;

public class Game {

  public static void main(String[] args) {
    Deck<BlackJackCard> deck = new Deck<>(BlackJackCard.class);

    System.out.println(deck.dealCard());

    System.out.println(deck);
  }
}