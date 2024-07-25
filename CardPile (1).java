package student;

/**
 * This is a pile of cards.
 */
public class CardPile {
    /** Top card. */
    private Card topCard;
    /** Number of cards that are in pile . */
    private int numCards;

    /**
     * Creates pile of cards starting with first card.
     * @param topCard The first card on top.
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.numCards = 1; // Starts with single card.
    }

    /**
     * Verifies if a card is playable on top of the current top card.
     * @param card The card that checksif it is playable.
     * @return true if the card can be played, false otherwise.
     */
    public boolean canPlay(Card card) {
        if (card.getRankNum() == topCard.getRankNum()
            || card.getSuitName().equals(topCard.getSuitName())
            || card.getRankNum() > topCard.getRankNum()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Plays a card onto the pile if it is playable.
     * @param card The card that is played onto the pile.
     */
    public void play(Card card) {
        if (canPlay(card)) {
            topCard = card; // Change this to top card
            numCards++; // Increment the numCards
        } else {
            System.out.println("Sorry! Card can't be played because it violates the rules.");
        }
    }

    /**
     * Gets the number of cards in the pile.
     * @return The number of cards in the pile.
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * Gets the top card of the pile.
     * @return The top card at the moment.
     */
    public Card getTopCard() {
        return topCard;
    }
}
