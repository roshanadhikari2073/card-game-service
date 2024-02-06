package com.castle.cardgameservice.model;

import com.castle.cardgameservice.model.enums.CardSuit;
import com.castle.cardgameservice.model.enums.CardValue;

/**
 * Represents a playing card with a suit and a value.
 *
 * @author Roshan Adhikari
 */
public record Card(CardSuit suit, CardValue value) {
}
