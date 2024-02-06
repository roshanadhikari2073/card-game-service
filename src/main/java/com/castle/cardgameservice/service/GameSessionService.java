package com.castle.cardgameservice.service;

import com.castle.cardgameservice.model.Deck;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Manages game sessions, ensuring each session has its own unique deck.
 *
 * @author Roshan Adhikari
 */
@Service
public class GameSessionService {
    private final Map<UUID, Deck> sessions = new ConcurrentHashMap<>();

    /**
     * create a new game session with a unique deck.
     *
     * @return The UUID of the newly created game session.
     */
    public UUID createSession() {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, new Deck());
        return sessionId;
    }

    /**
     * Retrieves the deck associated with a given session ID.
     *
     * @param sessionId The UUID of the session.
     * @return The Deck associated with the session, or null if not found.
     */
    public Deck retrieveSession(UUID sessionId) throws ResponseStatusException {
        Deck deck = sessions.get(sessionId);
        if (deck == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found for ID: " + sessionId);
        }
        return deck;
    }

}
