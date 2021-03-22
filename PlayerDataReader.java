import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.zip.DataFormatException;

public class PlayerDataReader implements PlayerDataReaderInterface {
    @Override
    public List<PlayerInterface> readDataSet(Reader r) throws FileNotFoundException, DataFormatException, IOException {
        return null;
    }
}
