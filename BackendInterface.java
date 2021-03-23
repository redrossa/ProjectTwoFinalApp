//--== CS400 File Header Information ==--
//Name: Yuven Sundaramoorthy
//Email: ysundaramoor@wisc.edu
//Team: JF
//Role: Backend Developer
//TA: Xinyi
//Lecturer: Gary
//Notes to Grader: <optional extra notes>

public interface BackendInterface {
//  public List<String> getFivePlayers();
  public int getTotalPlayers();
  public boolean isEmpty();
  public String getStatLine(int points);
  public String getPlayerName(int points);
  public PlayerInterface searchByPlayerName(String name);
}
