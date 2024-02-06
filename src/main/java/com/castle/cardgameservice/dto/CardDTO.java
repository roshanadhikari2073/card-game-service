package com.castle.cardgameservice.dto;

/**
 * Data Transfer Object for Card information.
 * Simplifies the data sent to and from the API, and can be extended
 * to include additional metadata if necessary.
 *
 * @author Roshan Adhikari
 */
public record CardDTO(String suit, String value) {
}