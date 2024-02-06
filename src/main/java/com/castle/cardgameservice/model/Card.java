package com.castle.cardgameservice.model;

import lombok.RequiredArgsConstructor;

/**
 * Represents a playing card with a suit and a value.
 *
 * @author Roshan Adhikari
 */
public record Card(CardSuit suit, CardValue value) { }
