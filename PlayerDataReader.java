import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

public class PlayerDataReader implements PlayerDataReaderInterface {
    private static final int PLAYER_NAME = 0;
    private static final int REB = 14;
    private static final int AST = 15;
    private static final int STL = 16;
    private static final int BLK = 17;
    private static final int PTS = 20;

    private int parseStat(String s) {
        return s.equals("-") ? 0 : Integer.parseInt(s);
    }

    @Override
    public List<PlayerInterface> readDataSet(Reader r) throws FileNotFoundException, DataFormatException, IOException {
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
