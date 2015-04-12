package chapter_8.blackjack.hand;

import chapter_8.blackjack.card.BlackJackCard;

public class BlackJackHand extends Hand<BlackJackCard> {

  private final int TWENTY_ONE = 21;
  private int minScore;
  private int maxScore;

  public BlackJackHand() {
    super();
    this.maxScore = 0;
    this.minScore = 0;
  }

  @Override
  public void addCard(BlackJackCard blackJackCard) {
    super.addCard(blackJackCard);

    maxScore += blackJackCard.maxValue();
    minScore += blackJackCard.minValue();
  }

  public int score() {
    return this.minScore;
  }

  public boolean isBusted() {
    return this.minScore > this.TWENTY_ONE;
  }

  public boolean isTwentyOne() {
    return this.maxScore == this.TWENTY_ONE || this.minScore == this.TWENTY_ONE;
  }

  public boolean isBlackJack() {
    if(cards.size() != 2) {
      return false;
    }

    BlackJackCard firstCard = this.cards.get(0);
    BlackJackCard secondCard = this.cards.get(1);

    return (firstCard.isAce() && secondCard.isFaceCard()) || (firstCard.isFaceCard() && secondCard.isAce());
  }
}