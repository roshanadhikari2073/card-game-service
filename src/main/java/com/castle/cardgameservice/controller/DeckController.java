package com.castle.cardgameservice.controller;


import com.castle.cardgameservice.dto.CardDTO;
import com.castle.cardgameservice.model.Card;
import com.castle.cardgameservice.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for the deck of cards
 * Provides endpoints for creating, shuffling, and returning from the deck
 *
 *@author: Roshan Adhikari
 */

@RestController
@RequestMapping("/api/v1/deck")
public class DeckController {

    private final DeckService deckService;

    @Autowired
    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/deal")
    public ResponseEntity<CardDTO> dealCard() {
        Card card = deckService.dealCard();
        return ResponseEntity.ok(new CardDTO(card.suit(), card.value()));
    }

    @PostMapping("/shuffle")
    @ResponseStatus(HttpStatus.OK)
    public void shuffleDeck() {
        deckService.shuffleDeck();
    }

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    public void returnCard(@RequestBody CardDTO cardDTO) {
        deckService.returnCard(new Card(cardDTO.suit(), cardDTO.value()));
    }
}
