package com.castle.cardgameservice.controller.decks;

import com.castle.cardgameservice.dto.CardDTO;
import com.castle.cardgameservice.service.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 * Rest controller for deck operations within a game session.
 * Provides endpoints for dealing, shuffling, and returning cards from the deck.
 * 
 * Utilizes DeckService for deck operations and GameSessionService for managing game sessions.
 * 
 * Author: Roshan Adhikari
 */
@RestController
@RequestMapping("/api/v1/games/{sessionId}/deck")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    /**
     * Endpoint to deal a card from the deck.
     *
     * @param sessionId the UUID of the game session
     * @return ResponseEntity with CardDTO if successful, or a bad request if the deck is empty
     */
    @GetMapping("/deal")
    public ResponseEntity<CardDTO> dealCard(@PathVariable UUID sessionId) {
        return ResponseEntity.ok(deckService.dealCard(sessionId));
    }

    /**
     * Endpoint to shuffle the deck.
     *
     * @param sessionId the UUID of the game session
     * @return ResponseEntity with no content if successful, or a bad request if the session is not found
     */
    @PostMapping("/shuffle")
    public ResponseEntity<List<CardDTO>> shuffleDeck(@PathVariable UUID sessionId) {
        List<CardDTO> shuffledCards = deckService.shuffleDeck(sessionId);
        return ResponseEntity.ok(shuffledCards);
    }

    /**
     * Endpoint to return a card to the deck.
     *
     * @param sessionId the UUID of the game session
     * @param cardDTO   the CardDTO representing the card to return
     * @return ResponseEntity with no content if successful, or a bad request if the session is not found
     */
    @PostMapping("/return")
    public ResponseEntity<Void> returnCard(@PathVariable UUID sessionId, @RequestBody CardDTO cardDTO) {
        deckService.returnCard(sessionId, cardDTO);
        return ResponseEntity.ok().build();
    }
}
