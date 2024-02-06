package com.castle.cardgameservice.model;

/**
 * Represents a playing card with a suit and a value.
 *
 * @author Roshan Adhikari
 */
public class Card {
    CardSuit suit;
    CardValue  value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    // Getters
    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}