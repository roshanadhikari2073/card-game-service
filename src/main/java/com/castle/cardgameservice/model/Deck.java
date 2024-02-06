package com.castle.cardgameservice.model;

import java.util.*;

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
        // Reset the deck
        cards.clear();

        // Populate the deck with standard 52 cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String value : values) {
                cards.offer(new Card(suit, value));
            }
        }

        shuffle(); // Shuffle the deck after initialization
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
        // Consideration: In a real game, you might want to shuffle the deck after returning a card.
    }
}
