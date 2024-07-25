package student;

public class BiggestCardAI extends AI {
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card biggestCard = null;

        for (int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);
            if (cardPile.canPlay(card)) {
                if (biggestCard == null || card.getRankNum() > biggestCard.getRankNum()) {
                    biggestCard = card;
                }
            }
        }
        return biggestCard;
    }

    @Override
    public String getName() {
        return "Biggest Card AI";
    }
}
