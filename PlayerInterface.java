public interface PlayerInterface extends Comparable<PlayerInterface> {
    String getName();
    int getPoints();
    int getRebounds();
    int getBlocks();
    int getSteals();
    int getAssists();
    int compareTo(PlayerInterface);
}