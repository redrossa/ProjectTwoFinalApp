// --== CS400 File Header Information ==--
// Name: Reno Raksi
// Email: raksi@wisc.edu
// Team: JF blue
// Role: Data Wrangler
// TA: Xinyi 
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.FileReader;
import java.io.StringReader;
import java.util.List;

/**
 * Provide tests for PlayerInterface and PlayerDataReaderInterface behaviors.
 */
public class DataWranglerTests {
    private String csvPath;
    private PlayerDataReaderInterface dataReader;

    private String failMessage(Object expected, Object actual) {
        return "Expected " + expected + ", got " + actual + " instead";
    }

    @Before
    public void setUp() {
        csvPath = "nbaplayers.csv";
        dataReader = new PlayerDataReader();
    }

    /**
     * Tests the data reader whether it returns the correct number of players in the csv
     * file that corresponds each line to a player’s statistics.
     */
    @Test
    public void testNumberOfPlayers() {
        try {
            int expectedNumber = 1233;
            int actualNumber = dataReader.readDataSet(new FileReader(csvPath)).size();
            Assert.assertEquals(failMessage(expectedNumber, actualNumber), expectedNumber, actualNumber);
        } catch (Exception e) {
            Assert.fail("Unexpected exception " + e);
        }
    }

    /**
     * Tests a player object returned from a data reader contains the expected properties.
     */
    @Test
    public void testPlayerProperties() {
        try {
            PlayerInterface p = new Player(
                    "Shelvin Mack",
                    2997,
                    894,
                    24,
                    300,
                    1421
            );
            List<PlayerInterface> l = dataReader.readDataSet(new FileReader(csvPath));
            Assert.assertTrue("No player with properties " + p + " was read in the CSV file", l.contains(p));
        } catch (Exception e) {
            Assert.fail("Unexpected exception " + e);
        }
    }

    /**
     * Tests the data reader that it contains all the player names in the csv file.
     */
    @Test
    public void testNames() {
        try {
            String[] expectedNames = {
                    "Patrick Patterson",
                    "Jim McIlvaine",
                    "Johnny Egan",
                    "Matt Carroll",
                    "Chuck Hayes"
            };
            String[] actualNames = dataReader.readDataSet(new StringReader(
                    "PLAYER_NAME,GP,MIN,FGM,FGA,FG_PCT,FG3M,FG3A,FG3_PCT,FTM,FTA,FT_PCT,OREB,DREB,REB,AST,STL,BLK,TOV,PF,PTS,AST_TOV,STL_TOV,EFG_PCT,TS_PCT\n" +
                    "Patrick Patterson,691,14471,1815,4058,0.447,600,1625,0.369,400,530,0.755,807,1937,2744,712,357,289,446,1084,4630,1.596,0.8,0.521,0.539\n" +
                    "Jim McIlvaine,401,5931,423,948,0.446,1,10,0.1,225,408,0.551,479,764,1243,105,136,691,231,1052,1072,0.455,0.589,0.447,0.475\n" +
                    "Johnny Egan,712,14447,2089,4867,0.429,-,-,-,1343,1668,0.805,-,-,1294,2102,-,-,-,1441,5521,-,-,0.429,0.493\n" +
                    "Matt Carroll,459,7587,1030,2496,0.413,344,896,0.384,609,724,0.841,147,716,863,313,223,60,297,704,3013,1.054,0.751,0.482,0.535\n" +
                    "Chuck Hayes,644,11814,1047,2104,0.498,0,14,0,316,510,0.62,1119,2124,3243,781,478,237,461,1485,2410,1.694,1.037,0.498,0.518"
            )).stream()
                    .map(PlayerInterface::getName)
                    .toArray(String[]::new);
            Assert.assertArrayEquals(failMessage(expectedNames, actualNames), expectedNames, actualNames);
        } catch (Exception e) {
            Assert.fail("Unexpected exception " + e);
        }
    }

    /**
     * Tests the data reader that it contains all the player points in the csv file.
     */
    @Test
    public void testPoints() {
        try {
            int[] expectedPoints = {
                    4630,
                    1072,
                    5521,
                    3013,
                    2410
            };
            int[] actualPoints = dataReader.readDataSet(new StringReader(
                    "PLAYER_NAME,GP,MIN,FGM,FGA,FG_PCT,FG3M,FG3A,FG3_PCT,FTM,FTA,FT_PCT,OREB,DREB,REB,AST,STL,BLK,TOV,PF,PTS,AST_TOV,STL_TOV,EFG_PCT,TS_PCT\n" +
                            "Patrick Patterson,691,14471,1815,4058,0.447,600,1625,0.369,400,530,0.755,807,1937,2744,712,357,289,446,1084,4630,1.596,0.8,0.521,0.539\n" +
                            "Jim McIlvaine,401,5931,423,948,0.446,1,10,0.1,225,408,0.551,479,764,1243,105,136,691,231,1052,1072,0.455,0.589,0.447,0.475\n" +
                            "Johnny Egan,712,14447,2089,4867,0.429,-,-,-,1343,1668,0.805,-,-,1294,2102,-,-,-,1441,5521,-,-,0.429,0.493\n" +
                            "Matt Carroll,459,7587,1030,2496,0.413,344,896,0.384,609,724,0.841,147,716,863,313,223,60,297,704,3013,1.054,0.751,0.482,0.535\n" +
                            "Chuck Hayes,644,11814,1047,2104,0.498,0,14,0,316,510,0.62,1119,2124,3243,781,478,237,461,1485,2410,1.694,1.037,0.498,0.518"
            )).stream()
                    .mapToInt(PlayerInterface::getPoints)
                    .toArray();
            Assert.assertArrayEquals(failMessage(expectedPoints, actualPoints), expectedPoints, actualPoints);
        } catch (Exception e) {
            Assert.fail("Unexpected exception " + e);
        }
    }

    /**
     * Tests that a player object correctly compares to another player object by points.
     */
    @Test
    public void testPlayerCompareTo() {
        try {
            PlayerInterface largerPlayer = new Player(
                    "Lloyd Neal",
                    4846,
                    3370,
                    324,
                    178,
                    632
            );
            PlayerInterface smallerPlayer = new Player(
                    "Shelvin Mack",
                    2997,
                    894,
                    24,
                    300,
                    1421
            );
            Assert.assertTrue("Expected a positive number", largerPlayer.compareTo(smallerPlayer) > 0);
        } catch (Exception e) {
            Assert.fail("Unexpected exception " + e);
        }
    }
}
