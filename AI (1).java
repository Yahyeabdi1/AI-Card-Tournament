package student;
public class AI {
    /**
     * This siumlates a card selection.
     *
     * @param hand Represents hand of cards.
     * @param cardpile Card pile in play.
     * @return Plays card otherwise is null.
     */
    public Card getPlay(Hand hand, CardPile cardpile) {
        for (int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);
            if (cardpile.canPlay(card)) {
                return card;
            }
        }
        return null; // No card was valid
    }

    /**
     * Returns AI name.
     *
     * @return AI name.
     */
    public String getName() {
        return "Random Card AI";
    }

    /**
     * Creates AI with random strategy that has been implemeneted.
     *
     * @return AI occurence.
     */
    public static AI createRandomCardAI() {
        return new AI();
    }
}
