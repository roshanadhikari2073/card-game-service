package com.castle.cardgameservice.controller.game;

import com.castle.cardgameservice.service.GameSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller for managing game sessions.
 *
 * @author Roshan Adhikari
 */
@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameController {

    private final GameSessionService gameSessionService;

    @PostMapping("/create")
    public ResponseEntity<UUID> createGameSession() {
        try {
            return ResponseEntity.ok(gameSessionService.createSession());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
