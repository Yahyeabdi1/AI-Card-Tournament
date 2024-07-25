
package student;

/**
 * Simulates a tournament using different AI strategies.
 */
public class Tournament {
    /**
     * Method that executes simulation.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        AI randomAI = AI.createRandomCardAI();
        AI smallestAI = new SmallestCardAI();
        AI biggestAI = new BiggestCardAI();

        AI[] challengers = {randomAI, smallestAI, biggestAI};
        String[] names = {"Random AI", "Low Rank AI", "High Rank AI"};

        int attempts = 1000;
        // calculates the win rates
        for (int i = 0; i < challengers.length; i++) {
            for (int j = 0; j < challengers.length; j++) {
                UnoWarMatch match = new UnoWarMatch(challengers[i], challengers[j]);
                double winRate = match.winRate(attempts);
                System.out.printf("%s vs. %s: Win Rate: %.3f%n", names[i], names[j], winRate);
            }
        }
    }
}
