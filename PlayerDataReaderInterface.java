import java.util.List;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public interface PlayerDataReaderInterface {
    List<PlayerInterface> readDataSet(Reader r) throws FileNotFoundException, DataFormatException, IOException;
}