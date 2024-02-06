package com.castle.cardgameservice.repository;

import  com.castle.cardgameservice.model.Deck;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Manages the lifecycle and operations of decks.
 * This repository is designed to potentially support multiple decks
 * in the future, with methods scoped for single deck operations for now.
 *
 * Author: Roshan Adhikari
 */
@Repository
public class DeckRepository {

}