import com.castle.cardgameservice.dto.CardDTO;
import com.castle.cardgameservice.model.Deck;
import com.castle.cardgameservice.service.DeckService;
import com.castle.cardgameservice.service.GameSessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeckTest {

    @Mock
    private GameSessionService gameSessionService;

    @InjectMocks
    private DeckService deckService;

    private UUID validSessionId;
    private Deck mockDeck;

    @BeforeEach
    public void setUp() {
        validSessionId = UUID.randomUUID();
        mockDeck = new Deck();
    }

    @Test
    public void testDealCardReducesDeckSize() {
        when(gameSessionService.retrieveSession(validSessionId)).thenReturn(mockDeck);

        int initialSize = mockDeck.getCards().size();
        deckService.dealCard(validSessionId);
        int newSize = mockDeck.getCards().size();

        assertEquals(initialSize - 1, newSize);
        assertTrue(newSize < 52);
    }

    @Test
    public void testReturnCardPreventsDuplicatesAndExceedingMaxSize() {
        when(gameSessionService.retrieveSession(validSessionId)).thenReturn(mockDeck);

        CardDTO cardDTO = deckService.dealCard(validSessionId);

        deckService.returnCard(validSessionId, cardDTO);
        int finalSize = mockDeck.getCards().size();

        assertEquals(52, finalSize);
        assertThrows(ResponseStatusException.class, () -> deckService.returnCard(validSessionId, cardDTO), "Card is already in the deck");
    }

    @Test
    public void testShuffleDeckMaintainsSize() {
        when(gameSessionService.retrieveSession(validSessionId)).thenReturn(mockDeck);

        deckService.shuffleDeck(validSessionId);
        int sizeAfterShuffle = mockDeck.getCards().size();

        assertEquals(52, sizeAfterShuffle);
    }
}
