package chapter_8.blackjack.suit;

public class SuitGenerator {

  /**
   *
   * @param value This can be 0 (Diamond), 1 (Club), 2 (Heart) and 3 (Spade).
   * @return Diamond or Club or Heart or Spade
   */
  public static Suit getSuitFromValue(int value) {
      switch (value) {
      case 0:
        return new Diamond();
      case 1:
        return new Club();
      case 2:
        return new Heart();
      case 3:
        return new Spade();
      default:
        return null;
    }
  }
}