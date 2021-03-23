
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Backend implements BackendInterface {

  private List<PlayerInterface> players;

  private RedBlackTree<PlayerInterface> playerTree;

  /**
   * Initializes a Backend given the command line arguments.
   * 
   * @param args the command line arguments whose zeroth element is expected to be
   *             the path to a movies CSV file.
   * @throws IOException         if the named file does not exist, is a directory
   *                             rather than a regular file, or for some other
   *                             reason cannot be opened for reading.
   * @throws DataFormatException
   */
  public Backend(String[] args) throws IOException {
    this(new FileReader(args[0]));
  }

  /**
   * Initializes a Backend given a Reader to a movies CSV file.
   * 
   * @param r a Reader to a movies CSV file.
   * @throws IOException           if the named file does not exist, is a
   *                               directory rather than a regular file, or for
   *                               some other reason cannot be opened for reading.
   * @throws DataFormatException
   * @throws FileNotFoundException
   */
  public Backend(Reader r) throws IOException {
    players = new PlayerDataReader().readDataSet(r);
    playerTree = new RedBlackTree<PlayerInterface>();
    for (int i = 0; i < players.size(); i++) {
      playerTree.insert(players.get(i));
    }
  }

  @Override
  public int getTotalPlayers() {
    return players.size();
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    if (playerTree.root == null)
      return true;
    return false;
  }

  @Override
  public String getStatLine(int points) {
    try {
      return playerTree.search(playerTree.root, points).data.toString();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public String getPlayerName(int points) {
    try {
      return playerTree.search(playerTree.root, points).data.getName();
    }catch (Exception e) {
      return null;
    }
  }

  @Override
  public PlayerInterface searchByPlayerName(String name) {
    for(PlayerInterface i: players) {
      if(i.getName().equals(name)) {
        return i;
      }
    }
    return null;
  }
}
