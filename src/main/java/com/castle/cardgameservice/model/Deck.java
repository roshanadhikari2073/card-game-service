package com.castle.cardgameservice.model;

import java.util.*;
import java.util.stream.Stream;

/**
 * Represents a deck of playing cards, supporting operations like shuffle, deal, and return.
 * The deck is automatically initialized and shuffled upon creation.
 *
 * Author: Roshan Adhikari
 */
public class Deck {
    private final Deque<Card> cards = new ArrayDeque<>();

    public Deck() {
        initialize();
    }

    private void initialize() {
        cards.clear();
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                cards.offer(new Card(suit, value));
            }
        }
        shuffle();
    }

    public void shuffle() {
        List<Card> shuffledList = new LinkedList<>(cards);
        Collections.shuffle(shuffledList);
        cards.clear();
        cards.addAll(shuffledList);
    }

    public Card deal() {
        return cards.poll();
    }

    public void returnCard(Card card) {
        cards.offerLast(card);
    }
}
