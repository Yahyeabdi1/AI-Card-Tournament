
package student;

/**
 * Player hand in card game.
 */
public class Hand {
    /** This is an array of cards in hand. */
    private Card[] cards;
    /** Amount of cards in hand. */
    private int size;
    /** Cards are drawn from this deck. */
    private Deck deck;

    /**
     * Hand is initialized and cards are drawn from deck.
     *
     * @param deck Deck to draw cards from.
     * @param size Initial size of hand.
     */
    public Hand(Deck deck, int size) {
        this.deck = deck;
        this.size = size;
        this.cards = new Card[size];
     // loads hands with cards from deck.
        for (int i = 0; i < size; i++) {
            this.cards[i] = deck.draw();
        }
    }

    /**
     * Gets the size of the hand.
     *
     * @return num of cards in the hand.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get card from hand at the given position.
     *
     * @param i Index of card.
     * @return The card at the chosen index.
     */
    public Card get(int i) {
        if (i < 0 || i >= size) {
            System.out.println("Out of range. Returns first card.");
            return cards[0];
        }
        return cards[i];
    }

    /**
     * Removes a card from the hand and draws a new one.
     *
     * @param card The card to remove.
     * @return true if the card was successfully removed, false otherwise.
     */
    public boolean remove(Card card) {
        for (int i = 0; i < size; i++) {
            if (cards[i].equals(card)) {
                // Remove the card by shifting the remaining cards down one position.
                for (int j = i; j < size - 1; j++) {
                    cards[j] = cards[j + 1];
                }
                // Draw a new card to occupy the last place.
                cards[size - 1] = deck.draw();
                return true;
            }
        }
        return false;
    }
}

