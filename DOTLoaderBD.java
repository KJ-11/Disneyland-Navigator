// --== CS400 Project Three File Header ==--
// Name: Henry Burke
// CSL Username: hburke
// Email: hpburke@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: did you drink enough water today?

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DOTLoaderBD implements IDOTLoader{
    /**
     * Loads data from AttractionData, and creates an Attraction object for each node
     *
     * @param filePath String of .gv filepath
     * @return ArrayList of all attractions
     * @throws FileNotFoundException thrown if file path does not exist
     */
    @Override
    public ArrayList<IAttraction> loadData(String filePath) throws FileNotFoundException {
        IAttraction coaster = new Attraction("rollercoaster", "Ride");
        IAttraction bathroom1 = new Attraction("bathroom1", "Bathroom");
        IAttraction bathroom2 = new Attraction("bathroom2", "Bathroom");
        IAttraction food = new Attraction("foodtruck1", "Food");

        ArrayList<IAttraction> attractList = new ArrayList<>();
        attractList.add(coaster);
        attractList.add(bathroom1);
        attractList.add(bathroom2);
        attractList.add(food);

        return attractList;
    }
}
