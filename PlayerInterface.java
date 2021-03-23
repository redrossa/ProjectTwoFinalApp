// --== CS400 File Header Information ==--
// Name: Reno Raksi
// Email: raksi@wisc.edu
// Team: JF blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

/**
 * A PlayerInterface provides a contract of what methods are expected
 * of a Player implementation.
 */
public interface PlayerInterface extends Comparable<PlayerInterface> {
    /**
     * Returns the name of this player.
     * @return the name of this player.
     */
    String getName();

    /**
     * Returns the number of points this player has.
     * @return the number of points this player has.
     */
    int getPoints();

    /**
     * Returns the number of rebounds this player has.
     * @return the number of rebounds this player has.
     */
    int getRebounds();

    /**
     * Returns the number of blocks this player has.
     * @return the number of blocks this player has.
     */
    int getBlocks();

    /**
     * Returns the number of steals this player has.
     * @return the number of steals this player has.
     */
    int getSteals();

    /**
     * Returns the number of assists this player has.
     * @return the number of assists this player has.
     */
    int getAssists();

    /**
     * Compares this player with another player by points,
     * returning a negative value if this player has less
     * than the other player, a positive value if this player
     * has more than the other player, and 0 if this player
     * has equal number of points as the other player.
     * @param other the other player to compare against
     * @return a negative value if this player has less
     *         than the other player, a positive value if this player
     *         has more than the other player, and 0 if this player
     *         has equal number of points as the other player
     */
    int compareTo(PlayerInterface other);
}