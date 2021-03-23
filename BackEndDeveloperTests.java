
import org.junit.Test;

import static org.junit.Assert.*;

import java.awt.List;
import java.io.StringReader;
import java.util.ArrayList;

public class BackEndDeveloperTests {
  public static void main(String[] args) {
    (new BackEndDeveloperTests()).runTests();
  }


  public void runTests() {
    // add all tests to this method
    System.out.println("Test search by player name: " + (testSearchByName() ? "PASSED" : "FAILED"));
    System.out.println("Test get number of players: " + (testNumberOfPlayers() ? "PASSED" : "FAILED"));
    System.out.println("Test is empty: " + (testIsEmpty() ? "PASSED" : "FAILED"));
    System.out.println("Test get stat line: " + (testGetStatLine() ? "PASSED" : "FAILED"));
    System.out.println("Test get player name: " + (testGetPlayerName() ? "PASSED" : "FAILED"));
  }
  public boolean testSearchByName() {
    try {
      BackendInterface backend = new Backend(new StringReader(
          "PLAYER_NAME,GP,MIN,FGM,FGA,FG_PCT,FG3M,FG3A,FG3_PCT,FTM,FTA,FT_PCT,OREB,DREB,REB,AST,STL,BLK,TOV,PF,PTS\n"
              + "Oscar Robertson,1040,43886,9508,19620,0.485,-,-,-,7694,9185,0.838,71,208,7804,9887,77,4,-,2931,26710\n"
              + "Wesley Matthews,821,25819,3596,8512,0.422,1694,4459,0.38,1634,1984,0.824,417,2033,2450,1730,843,166,1016,1761,10520\n"
              + "Lamar Odom,961,32131,4811,10393,0.463,664,2126,0.312,2495,3599,0.693,1821,6238,8059,3554,848,892,2253,2916,12781\n"));
      if (backend.searchByPlayerName("Wesley Matthews").getPoints()==10520)
        return true;
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  public boolean testNumberOfPlayers() {
    try {
      BackendInterface backend = new Backend(new StringReader(
          "PLAYER_NAME,GP,MIN,FGM,FGA,FG_PCT,FG3M,FG3A,FG3_PCT,FTM,FTA,FT_PCT,OREB,DREB,REB,AST,STL,BLK,TOV,PF,PTS\n"
              + "Oscar Robertson,1040,43886,9508,19620,0.485,-,-,-,7694,9185,0.838,71,208,7804,9887,77,4,-,2931,26710\n"
              + "Wesley Matthews,821,25819,3596,8512,0.422,1694,4459,0.38,1634,1984,0.824,417,2033,2450,1730,843,166,1016,1761,10520\n"
              + "Lamar Odom,961,32131,4811,10393,0.463,664,2126,0.312,2495,3599,0.693,1821,6238,8059,3554,848,892,2253,2916,12781\n"));
      if (backend.getTotalPlayers() == 3)
        return true;
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean testIsEmpty() {
    try {
      BackendInterface backend = new Backend(new StringReader(""));
      if (backend.isEmpty())
        return true;
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean testGetStatLine() {
    try {
      BackendInterface backend = new Backend(new StringReader(
          "PLAYER_NAME,GP,MIN,FGM,FGA,FG_PCT,FG3M,FG3A,FG3_PCT,FTM,FTA,FT_PCT,OREB,DREB,REB,AST,STL,BLK,TOV,PF,PTS\n"
              + "Oscar Robertson,1040,43886,9508,19620,0.485,-,-,-,7694,9185,0.838,71,208,7804,9887,77,4,-,2931,26710\n"
              + "Wesley Matthews,821,25819,3596,8512,0.422,1694,4459,0.38,1634,1984,0.824,417,2033,2450,1730,843,166,1016,1761,10520\n"
              + "Lamar Odom,961,32131,4811,10393,0.463,664,2126,0.312,2495,3599,0.693,1821,6238,8059,3554,848,892,2253,2916,12781\n"));
      if (backend.getStatLine(10520).equals(
          "Player{name='Wesley Matthews', points=10520, rebounds=2450, blocks=166, steals=843, assists=1730}"))
        return true;
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean testGetPlayerName() {
    try {
      BackendInterface backend = new Backend(new StringReader(
          "PLAYER_NAME,GP,MIN,FGM,FGA,FG_PCT,FG3M,FG3A,FG3_PCT,FTM,FTA,FT_PCT,OREB,DREB,REB,AST,STL,BLK,TOV,PF,PTS\n"
              + "Oscar Robertson,1040,43886,9508,19620,0.485,-,-,-,7694,9185,0.838,71,208,7804,9887,77,4,-,2931,26710\n"
              + "Wesley Matthews,821,25819,3596,8512,0.422,1694,4459,0.38,1634,1984,0.824,417,2033,2450,1730,843,166,1016,1761,10520\n"
              + "Lamar Odom,961,32131,4811,10393,0.463,664,2126,0.312,2495,3599,0.693,1821,6238,8059,3554,848,892,2253,2916,12781\n"));
      
      if (backend.getPlayerName(10520).equals("Wesley Matthews"))
        return true;
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
