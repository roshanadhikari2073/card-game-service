package com.castle.cardgameservice.util;

import com.castle.cardgameservice.dto.CardDTO;
import com.castle.cardgameservice.model.Card;
import com.castle.cardgameservice.model.Deck;

public class DeckUtils {

    /**
     * Checks if a card is already present in the deck.
     *
     * @param deck The deck to check.
     * @param card The card to look for in the deck.
     * @return true if the deck contains the card, false otherwise.
     */
    public static boolean isCardInDeck(Deck deck, Card card) {
        return deck.getCards().contains(card);
    }

    /**
     * Converts a CardDTO to a Card model.
     *
     * @param cardDTO The CardDTO to convert.
     * @return A new Card instance with the suit and value from the CardDTO.
     */
    public static Card convertToCard(CardDTO cardDTO) {
        return new Card(cardDTO.suit(), cardDTO.value());
    }

}
