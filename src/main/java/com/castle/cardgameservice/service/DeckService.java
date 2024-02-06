package com.castle.cardgameservice.service;

import com.castle.cardgameservice.dto.CardDTO;
import com.castle.cardgameservice.model.Card;
import com.castle.cardgameservice.model.Deck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service layer for handling the business logic of deck operations.
 *
 * Author: Roshan Adhikari
 */
@Service
@RequiredArgsConstructor
public class DeckService {

    private GameSessionService gameSessionService;

    /**
     * Deals a card from the deck associated with the given session ID.
     *
     * @param sessionId the UUID of the session
     * @return CardDTO the dealt card
     */
    public CardDTO dealCard(UUID sessionId) {
        if (sessionId == null) {throw new IllegalArgumentException("Invalid session ID.");}

        Deck deck = gameSessionService.getDeck(sessionId);
        if (deck == null) {throw new IllegalStateException("Session not found for ID: " + sessionId);}

        Card card = deck.deal();
        return new CardDTO(card.suit(), card.value());
    }

    /**
     * Shuffles the deck associated with the given session ID.
     *
     * @param sessionId the UUID of the session
     */
    public void shuffleDeck(UUID sessionId) {
        Deck deck = gameSessionService.getDeck(sessionId);
        if (deck == null) {
            throw new IllegalStateException("Session not found for ID: " + sessionId);
        }
        deck.shuffle();
    }

    /**
     * Returns a card to the deck associated with the given session ID.
     *
     * @param sessionId the UUID of the session
     * @param cardDTO the card to return
     */
    public void returnCard(UUID sessionId, CardDTO cardDTO) {
        Deck deck = gameSessionService.getDeck(sessionId);
        if (deck == null) {
            throw new IllegalStateException("Session not found for ID: " + sessionId);
        }
        Card card = new Card(cardDTO.suit(), cardDTO.value());
        deck.returnCard(card);
    }
}
