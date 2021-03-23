// --== CS400 File Header Information ==--
// Name: Reno Raksi
// Email: raksi@wisc.edu
// Team: JF blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

/**
 * A PlayerDataReader provides a way to read a CSV file containing NBA players
 * by line.
 */
public class PlayerDataReader implements PlayerDataReaderInterface {
    /** The index of the player name in the CSV file header. */
    private static final int PLAYER_NAME = 0;

    /** The index of the rebounds in the CSV file header. */
    private static final int REB = 14;

    /** The index of the assists in the CSV file header. */
    private static final int AST = 15;

    /** The index of the steals in the CSV file header. */
    private static final int STL = 16;

    /** The index of the blocks in the CSV file header. */
    private static final int BLK = 17;

    /** The index of the points in the CSV file header. */
    private static final int PTS = 20;

    /**
     * Parses a string integer value in the CSV file.
     * @param s a string integer value in the CSV file
     * @return a parsed int value of the given string integer value
     */
    private int parseStat(String s) {
        return s.equals("-") ? 0 : Integer.parseInt(s);
    }

    /**
     * Returns a list of PlayerInterface instances given a Reader to a CSV file
     * containing statistics of NBA players each line.
     * @param r a Reader to a CSV file containing statistics of NBA players each line
     * @return a list of PlayerInterface instances
     * @throws IOException if there are any IO errors.
     */
    @Override
    public List<PlayerInterface> readDataSet(Reader r) throws IOException {
        List<PlayerInterface> players = new LinkedList<>();
        CSVReader csvReader = new CSVReader(r);
        csvReader.skip(1); // skipping header line
        for (String[] line : csvReader)
            players.add(new Player(
                    line[PLAYER_NAME],
                    parseStat(line[PTS]),
                    parseStat(line[REB]),
                    parseStat(line[BLK]),
                    parseStat(line[STL]),
                    parseStat(line[AST])));
        return players;
    }
}
