import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Interface for the DOT file loader
 * 
 * @author Anton Gurevich
 */
public interface IDOTLoader {
  /**
   * Loads data from AttractionData, and creates an Attraction object for each node 
   * 
   * @param filePath String of .gv filepath
   * @return ArrayList of all attractions
   * @throws FileNotFoundException thrown if file path does not exist
   */
  ArrayList<IAttraction> loadData(String filePath) throws FileNotFoundException;
}
