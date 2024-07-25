package student;

/**
 * Controls a game between the two AIs.
 */
public class UnoWarMatch {
    /** This is the first AI Challenger. */
    private AI firstAI;
    /** This is the second AI challenger. */
    private AI secondAI;

    /**
     * Facilitates a game between the two AIs.
     * @param firstAI First AI.
     * @param secondAI Second AI.
     */
    public UnoWarMatch(AI firstAI, AI secondAI) {
        this.firstAI = firstAI;
        this.secondAI = secondAI;
    }

    /**
     * Plays a game of UnoWar between the two AI players.
     * @return true if the first AI wins the game, false otherwise.
     */
    public boolean playGame() {
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck, 5);
        Hand hand2 = new Hand(deck, 5);

        int roundsWonByFirstAI = 0;
        int roundsWonBySecondAI = 0;
        while (roundsWonByFirstAI < 10 && roundsWonBySecondAI < 10) {
            CardPile cardPile = new CardPile(deck.draw());
            boolean roundResult = playRound(firstAI, secondAI, hand1, hand2, cardPile);
            if (roundResult) {
                roundsWonByFirstAI++;
            } else {
                roundsWonBySecondAI++;
            }
        }

        return roundsWonByFirstAI > roundsWonBySecondAI;
    }

    /**
     * Calculates the win rate of the first AI from the number of attempts.
     * @param attempts Number of attempts taken.
     * @return Win odds of first AI.
     */
    public double winRate(int attempts) {
        int winsForFirstAI = 0;
        for (int i = 0; i < attempts; i++) {
            if (playGame()) {
                winsForFirstAI++;
            }
        }
        return winsForFirstAI / (double) attempts;
    }

    /**
     * This is a round of UnoWar given the two hands and the current card pile.
     * @param firstAI The first AI player.
     * @param secondAI The second AI player.
     * @param hand1 First hand.
     * @param hand2 Second hand.
     * @param cardPile Pile of cards right now.
     * @return true if the first hand wins the round, false otherwise.
     */
    private boolean playRound(AI firstAI, AI secondAI, Hand hand1, Hand hand2, CardPile cardPile) {
        boolean firstAITurn = true;
        AI currentAI;
        Hand currentHand;

        while (true) {
            if (firstAITurn) {
                currentAI = firstAI;
            } else {
                currentAI = secondAI;
            }
            currentHand = firstAITurn ? hand1 : hand2;

            Card chosenCard = currentAI.getPlay(currentHand, cardPile);

            if (chosenCard == null || !cardPile.canPlay(chosenCard)) {
                return !firstAITurn;
            }

            cardPile.play(chosenCard);
            currentHand.remove(chosenCard);

            firstAITurn = !firstAITurn;
        }
    }
}
