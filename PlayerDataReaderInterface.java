import java.util.List;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.io.DataFormatException;
import java.io.IOException;

public interface PlayerDataReaderInterface {
    List<PlayerInterface> readDataSet(Reader) throws FileNotFoundException, DataFormatException, IOException;
}