package com.castle.cardgameservice.service;

import com.castle.cardgameservice.model.Card;
import com.castle.cardgameservice.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer for handling the business logic of deck operations.
 *
 * Author: Roshan Adhikari
 */
@Service
public class DeckService {

    private final DeckRepository deckRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Card dealCard() {
        return deckRepository.getDeck().deal();
    }

    public void shuffleDeck() {
        deckRepository.getDeck().shuffle();
    }

    public void returnCard(Card card) {
        deckRepository.getDeck().returnCard(card);
    }
}