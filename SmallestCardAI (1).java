package student;

public class SmallestCardAI extends AI {
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card smallestCard = null;

        for (int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);
            if (cardPile.canPlay(card)) {
                if (smallestCard == null || card.getRankNum() < smallestCard.getRankNum()) {
                    smallestCard = card;
                }
            }
        }
        return smallestCard;
    }

    @Override
    public String getName() {
        return "Smallest Card AI";
    }
}
