// --== CS400 File Header Information ==--
// Name: Reno Raksi
// Email: raksi@wisc.edu
// Team: JF blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

import java.util.Objects;

public class Player implements PlayerInterface {
    private String name;
    private int points;
    private int rebounds;
    private int blocks;
    private int steals;
    private int assists;

    public Player(String name, int points, int rebounds, int blocks, int steals, int assists) {
        this.name = name;
        this.points = points;
        this.rebounds = rebounds;
        this.blocks = blocks;
        this.steals = steals;
        this.assists = assists;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public int getRebounds() {
        return rebounds;
    }

    @Override
    public int getBlocks() {
        return blocks;
    }

    @Override
    public int getSteals() {
        return steals;
    }

    @Override
    public int getAssists() {
        return assists;
    }

    @Override
    public int compareTo(PlayerInterface other) {
        return points - other.getPoints();
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(name, points, rebounds, blocks, steals, assists);
    }

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

    public static void main(String[] args) {
        Player p = new Player(null, 0, 0, 0, 0, 0);
        System.out.println(p instanceof Comparable);
    }
}
