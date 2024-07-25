package student;

public class Card {
    /** Rank of the card. */
    private final int rank;
    /** Suit of the card. */
    private final int suit;

    /**
     * Initializes card with suit and rank.
     * If rank or suit is out of range, it creates Ace of Spades.
     *
     * @param rank The rank of the card.
     * @param suit The suit of the card.
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            System.out.println("Out of range. Make Ace of Spades.");
            this.rank = 1; // Ace
            this.suit = 1; // Spades
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    /**
     * Returns the rank.
     *
     * @return The rank number.
     */
    public int getRankNum() {
        return rank;
    }

    /**
     * Returns the rank.
     *
     * @return Name of Rank.
     */
    public String getRankName() {
        switch (rank) {
            case 1: return "Ace";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "Unknown";
        }
    }

    /**
     * Returns the suit.
     *
     * @return The name of the suit.
     */
    public String getSuitName() {
        switch (suit) {
            case 1: return "Spades";
            case 2: return "Hearts";
            case 3: return "Clubs";
            case 4: return "Diamonds";
            default: return "Unknown";
        }
    }

    /**
     * Overrides the toString method.
     *
     * @return String representation of the card.
     */
    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    /**
     * Overrides the equals method.
     *
     * @param obj Comparison for the card.
     * @return True if the object depicts a Card similar to this card, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return this.rank == other.rank && this.suit == other.suit;
    }

    /**
     * Overrides the hashCode method.
     *
     * @return A hash code value for the card.
     */
    @Override
    public int hashCode() {
        return 31 * rank + suit;
    }
}
