package com.castle.cardgameservice.repository;

import  com.castle.cardgameservice.model.Deck;
import org.springframework.stereotype.Repository;

/**
 * Manages the lifecycle and operations of decks.
 * This repository is designed to potentially support multiple decks
 * in the future, with methods scoped for single deck operations for now.
 *
 * Author: Roshan Adhikari
 */
@Repository
public class DeckRepository {

    private final Deck deck = new Deck(); // Placeholder for a single deck instance

    public DeckRepository() {
        // Initialize the deck with cards
        deck.initialize();
    }

    public Deck getDeck() {
        // In a more complex implementation, this could retrieve a deck by ID
        return deck;
    }

    // Future methods for managing multiple decks could be added here
}