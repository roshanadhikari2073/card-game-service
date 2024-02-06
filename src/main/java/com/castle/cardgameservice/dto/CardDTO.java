package com.castle.cardgameservice.dto;

import com.castle.cardgameservice.model.CardSuit;
import com.castle.cardgameservice.model.CardValue;

/**
 * Data Transfer Object for Card information.
 * Simplifies the data sent to and from the API, and can be extended
 * to include additional metadata if necessary.
 *
 * @author Roshan Adhikari
 */
public record CardDTO(CardSuit suit, CardValue value) {
}