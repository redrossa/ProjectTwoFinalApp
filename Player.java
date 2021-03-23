// --== CS400 File Header Information ==--
// Name: Reno Raksi
// Email: raksi@wisc.edu
// Team: JF blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

import java.util.Objects;

/**
 * A Player the statistics of an NBA player.
 */
public class Player implements PlayerInterface {
    /** The name of this player. */
    private String name;

    /** The points this player has. */
    private int points;

    /** The rebounds this player has. */
    private int rebounds;

    /** The blocks this player has. */
    private int blocks;

    /** The steals this player has. */
    private int steals;

    /** The assists this player has. */
    private int assists;

    /**
     * Constructs a Player given the properties.
     * @param name the name of the player
     * @param points the points the player has
     * @param rebounds the rebounds the player has
     * @param blocks the blocks the player has
     * @param steals the steals the player has
     * @param assists the assists the player has
     */
    public Player(String name, int points, int rebounds, int blocks, int steals, int assists) {
        this.name = name;
        this.points = points;
        this.rebounds = rebounds;
        this.blocks = blocks;
        this.steals = steals;
        this.assists = assists;
    }

    /**
     * Returns the name of this player.
     * @return the name of this player.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the number of points this player has.
     * @return the number of points this player has.
     */
    @Override
    public int getPoints() {
        return points;
    }

    /**
     * Returns the number of rebounds this player has.
     * @return the number of rebounds this player has.
     */
    @Override
    public int getRebounds() {
        return rebounds;
    }

    /**
     * Returns the number of blocks this player has.
     * @return the number of blocks this player has.
     */
    @Override
    public int getBlocks() {
        return blocks;
    }

    /**
     * Returns the number of steals this player has.
     * @return the number of steals this player has.
     */
    @Override
    public int getSteals() {
        return steals;
    }

    /**
     * Returns the number of assists this player has.
     * @return the number of assists this player has.
     */
    @Override
    public int getAssists() {
        return assists;
    }

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
    @Override
    public int compareTo(PlayerInterface other) {
        return points - other.getPoints();
    }

    /**
     * Returns true if this player has all properties that equal
     * that of the other player, false otherwise.
     * @param o the other player to check for equality
     * @return true if this player has all properties that equal
     *         that of the other player, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return points == player.points &&
                rebounds == player.rebounds &&
                blocks == player.blocks &&
                steals == player.steals &&
                assists == player.assists &&
                Objects.equals(name, player.name);
    }

    /**
     * Returns the hashcode of this player.
     * @return the hashcode of this player.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, points, rebounds, blocks, steals, assists);
    }

    /**
     * Returns a string representation of this player.
     * @return a string representation of this player.
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", rebounds=" + rebounds +
                ", blocks=" + blocks +
                ", steals=" + steals +
                ", assists=" + assists +
                '}';
    }
}
