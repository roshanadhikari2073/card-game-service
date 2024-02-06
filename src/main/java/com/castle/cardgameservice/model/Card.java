package com.castle.cardgameservice.model;

/**
 * Represents a playing card with a suit and a value.
 *
 * Author: Roshan Adhikari
 */
public class Card {
    private String suit;
    private String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    // Getters
    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }
}