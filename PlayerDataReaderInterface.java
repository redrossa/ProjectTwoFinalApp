// --== CS400 File Header Information ==--
// Name: Reno Raksi
// Email: raksi@wisc.edu
// Team: JF blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

import java.util.List;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

/**
 * A PlayerDataReaderInterface provides a contract of what methods are expected
 * of a player data reader implementation.
 */
public interface PlayerDataReaderInterface {
    /**
     * Returns a list of PlayerInterface instances given a Reader to a CSV file
     * containing statistics of NBA players each line.
     * @param r a Reader to a CSV file containing statistics of NBA players each line
     * @return a list of PlayerInterface instances
     * @throws FileNotFoundException if the file is not found
     * @throws DataFormatException if there are inappropriate types of values in the
     *         CSV file
     * @throws IOException if there are any IO errors.
     */
    List<PlayerInterface> readDataSet(Reader r) throws FileNotFoundException, DataFormatException, IOException;
}