// --== CS400 File Header Information ==--
// Name: Kshitij Jhunjhunwala
// Email: kjhunjhunwa2@wisc.edu
// Team: AT
// TA: Minghao Yan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements the IDOTLoader interface
 * 
 * @author Kshitij Jhunjhunwala
 *
 */
public class DOTLoader implements IDOTLoader {


  /**
   * Loads data from AttractionData, and creates an Attraction object for each node
   * 
   * @param filePath String of .gv filepath
   * @return ArrayList of all attractions
   * @throws FileNotFoundException thrown if file path does not exist
   */
  @Override
  public ArrayList<IAttraction> loadData(String filePath) throws FileNotFoundException {

    Scanner scnr = new Scanner(new File(filePath)); // instantiates scanner
    ArrayList<IAttraction> attractionItems = new ArrayList<>(); // list of all groceryItem objects

    while (scnr.hasNext()) {

      String line = scnr.nextLine().strip();

      // checks if line is trying to create an attraction object
      if (line.contains("comment")) {

        String name = line.substring(0, line.indexOf(" "));
        String type = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
        Attraction attractionObject = new Attraction(name.strip(), type.strip());
        attractionItems.add(attractionObject); // adds attraction object to arraylist

      }

      // checks if line is trying to describe an edge
      if (line.contains("label")) {

        String source = line.substring(0, line.indexOf(" "));
        String target = line.substring(line.indexOf(">") + 2, line.indexOf("[") - 1);
        int weight = Integer.parseInt(line.substring(line.indexOf("=") + 1, line.indexOf("]")));

        Integer sourceIndex = null;
        Integer targetIndex = null;

        for (int i = 0; i < attractionItems.size(); i++) {
          if (sourceIndex != null && targetIndex != null) {
            break; // indexes found
          }
          String currName = attractionItems.get(i).getName(); // current Attraction name
          if (currName.equals(source)) {
            sourceIndex = i;
          }
          if (currName.equals(target)) {
            targetIndex = i;
          }
        }

        // adds link to source attraction object if link exists and is valid(indices != null)
        if (sourceIndex != null && targetIndex != null) {
          attractionItems.get(sourceIndex).addLink(new Attraction.Link(
              attractionItems.get(sourceIndex), attractionItems.get(targetIndex), weight));
        }
      }
    }
    return attractionItems; // returns arrayList of Attraction objects
  }
}

