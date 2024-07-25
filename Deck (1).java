package student;

import java.util.Random;

/**
 * It's a deck of playing cards.
 * It shuffles and draws card, while also monitoring the progress made.
 */
public class Deck {
    /**
     * This is an array that holds the deck of cards.
     */
    private Card[] cards;

    /**
     * Monitors the amount of cards that have been drawn.
     */
    private int cardsDrawn;

    /**
     * Generates a deck of 52 cards and shuffles them all.
     */
    public Deck() {
        cards = new Card[52];
        int index = 0;
        // Fill deck by creating cards of the suit and rank.
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index++] = new Card(rank, suit);
            }
        }
        shuffle();
        cardsDrawn = 0;
    }

    /**
     * This shuffles the deck and also resets the cards drawn.
     */
    public void shuffle() {
        Random r = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            // Swap cards[i] with cards[j]
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        cardsDrawn = 0; // Restart card count
    }

    /**
     * Draws the top card from the deck. If all cards have been drawn, the deck is reshuffled.
     *
     * @return The drawn card.
     */
    public Card draw() {
        if (cardsDrawn == cards.length) {
            shuffle(); // Reshuffle the deck if all cards have been drawn
        }
        return cards[cardsDrawn++];
    }

    /**
     * Returns num cards remianing.
     *
     * @return Cards that weren't Drawn.
     */
    public int cardsRemaining() {
        return cards.length - cardsDrawn;
    }

    /**
     * Confirms is deck is empty.
     *
     * @return {@code true} if no cards are left, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return cardsRemaining() == 0;
    }
}
