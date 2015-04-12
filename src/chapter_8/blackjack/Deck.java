package chapter_8.blackjack;

import chapter_8.blackjack.card.Card;
import chapter_8.blackjack.suit.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Deck<T extends Card> {

  private HashMap<T, Boolean> cards;
  private Class<T> cardClass;

  public Deck(Class<T> cardClass) {
    this.cardClass = cardClass;
    this.shuffle();
  }

  public void shuffle() {
    this.cards = new HashMap<>();

    for(int i = 1; i <= 13; i++) {
      for(int j = 0; j <= 3; j++) {
        this.cards.put(this.createNewCardInstance(i, j), true);
      }
    }
  }

  public T dealCard() {
    int faceValue;
    int suitValue;
    Random generator;
    T card;

    if(this.isEmpty()) {
      return null;
    }

    generator = new Random();
    faceValue = generator.nextInt(14);
    suitValue = generator.nextInt(4);
    card = this.createNewCardInstance(faceValue, suitValue);

    return this.cards.remove(card) ? card : null;
  }

  public boolean isEmpty() {
    return this.cards.isEmpty();
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder diamondStringBuilder = new StringBuilder();
    StringBuilder clubStringBuilder = new StringBuilder();
    StringBuilder heartStringBuilder = new StringBuilder();
    StringBuilder spadeStringBuilder = new StringBuilder();

    for(Map.Entry entry : this.cards.entrySet()) {
      T card = (T) entry.getKey();
      Suit suit = card.getSuit();
      String cardString = card.toString();
      StringBuilder tempStringBuilder;

      if(suit instanceof Diamond) {
        tempStringBuilder = diamondStringBuilder;
      } else if(suit instanceof Club) {
        tempStringBuilder = clubStringBuilder;
      } else if(suit instanceof Heart) {
        tempStringBuilder = heartStringBuilder;
      } else if(suit instanceof Spade) {
        tempStringBuilder = spadeStringBuilder;
      } else {
        tempStringBuilder = new StringBuilder();
      }

      tempStringBuilder.append(cardString).append(" ");
    }

    this.appendStringBuilderTo(stringBuilder, diamondStringBuilder);
    this.appendStringBuilderTo(stringBuilder, clubStringBuilder);
    this.appendStringBuilderTo(stringBuilder, heartStringBuilder);
    this.appendStringBuilderTo(stringBuilder, spadeStringBuilder);

    return stringBuilder.toString();
  }

  private T createNewCardInstance(int faceValue, int suitValue) {
    try {
      return this.cardClass.getConstructor(int.class, Suit.class).newInstance(faceValue, SuitGenerator.getSuitFromValue(suitValue));
    } catch (
      InstantiationException |
      IllegalAccessException |
      InvocationTargetException |
      NoSuchMethodException e) {
      e.printStackTrace();
    }

    return null;
  }

  private boolean isEmptyStringBuilder(StringBuilder stringBuilder) {
    return stringBuilder.length() == 0;
  }

  private void appendStringBuilderTo(StringBuilder target, StringBuilder source) {
    if(!this.isEmptyStringBuilder(source)) {
      target.append(source).append("\r\n");
    }
  }
}