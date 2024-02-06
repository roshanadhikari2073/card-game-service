package com.castle.cardgameservice.controller;

import com.castle.cardgameservice.dto.CardDTO;
import com.castle.cardgameservice.service.DeckService;
import com.castle.cardgameservice.service.GameSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/games/{sessionId}/deck")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @GetMapping("/deal")
    public ResponseEntity<CardDTO> dealCard(@PathVariable UUID sessionId) {
        try {
            CardDTO cardDTO = deckService.dealCard(sessionId);
            return ResponseEntity.ok(cardDTO);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/shuffle")
    public ResponseEntity<Void> shuffleDeck(@PathVariable UUID sessionId) {
        try {
            deckService.shuffleDeck(sessionId);
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/return")
    public ResponseEntity<Void> returnCard(@PathVariable UUID sessionId, @RequestBody CardDTO cardDTO) {
        try {
            deckService.returnCard(sessionId, cardDTO);
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
