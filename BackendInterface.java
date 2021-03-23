
public interface BackendInterface {
//  public List<String> getFivePlayers();
  public int getTotalPlayers();
  public boolean isEmpty();
  public String getStatLine(int points);
  public String getPlayerName(int points);
  public PlayerInterface searchByPlayerName(String name);
}
