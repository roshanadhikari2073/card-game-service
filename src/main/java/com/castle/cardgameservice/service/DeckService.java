package com.castle.cardgameservice.service;

import com.castle.cardgameservice.dto.CardDTO;
import com.castle.cardgameservice.model.Card;
import com.castle.cardgameservice.model.Deck;
import com.castle.cardgameservice.model.enums.CardSuit;
import com.castle.cardgameservice.model.enums.CardValue;
import com.castle.cardgameservice.util.DeckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service layer for handling the business logic of deck operations.
 *
 * Author: Roshan Adhikari
 */
@Service
public class DeckService {

    private final GameSessionService gameSessionService;

    @Autowired
    public DeckService(GameSessionService gameSessionService) {this.gameSessionService = gameSessionService;}

    /**
     * Deals a card from the deck associated with the given session ID.
     *
     * @param sessionId the UUID of the session
     * @return CardDTO the dealt card
     */
    public CardDTO dealCard(UUID sessionId) throws ResponseStatusException {
        if (sessionId == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid session ID");}

        Deck deck = gameSessionService.retrieveSession(sessionId);

        Card card = deck.deal();
        return new CardDTO(card.suit(), card.value());
    }

    /**
     * Shuffles the deck associated with the given session ID.
     *
     * @param sessionId the UUID of the session
     */
    public List<CardDTO> shuffleDeck(UUID sessionId) throws ResponseStatusException {
        if (sessionId == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid session ID");}

        Deck deck = gameSessionService.retrieveSession(sessionId);

        deck.shuffle();
        return deck.getCards().stream()
                .map(card -> new CardDTO(card.suit(), card.value()))
                .collect(Collectors.toList());
    }

    /**
     * Returns a card to the deck associated with the given session ID.
     *
     * @param sessionId the UUID of the session
     * @param cardDTO the card to return
     */
    public void returnCard(UUID sessionId, CardDTO cardDTO) throws ResponseStatusException {
        if (cardDTO == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid card");}
        if (sessionId == null) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid session ID");}

        Deck deck = gameSessionService.retrieveSession(sessionId);
        Card card = DeckUtils.convertToCard(cardDTO);

        if (DeckUtils.isCardInDeck(deck, card)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Card is already in the deck");
        }

        deck.returnCard(card);
    }
}
