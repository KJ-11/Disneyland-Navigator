// --== CS400 Project Three File Header ==--
// Name: Henry Burke
// CSL Username: hburke
// Email: hpburke@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: did you drink enough water today?

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Interface to set up the backend portion of DisneyParkBackend.java
 *
 * @author Henry Burke
 */
public interface IDisneyParkBackend {

    /**
     * Sets the visitor's current location to a given attraction, bathroom, or food truck.
     *
     * @param currLocation current location given by frontend
     */
    public void setCurrentLocation(String currLocation);

    /**
     * Sets the visitor's desired location to a given attraction, bathroom, or food truck.
     *
     * @param destination the visitor's desired location given by frontend
     */
    public void setDestination(String destination);

    /**
     * Gets current location.
     *
     * @return current location
     */
    public String getCurrentLocation();

    /**
     * Gets destination.
     *
     * @return destination
     */
    public String getDestination();

    /**
     * Returns the path from the current location to the set destination.
     *
     * @return the path from the current location to the set destination
     */
    public List<IAttraction> currLocationToDestination();

    /**
     * Finds the closest bathroom to the visitor's current location.
     */
    public List<IAttraction> closestBathroom();

    /**
     * Finds the closest food truck to the visitor's current location.
     */
    public List<IAttraction> closestFoodTruck();

    /**
     * Returns an array of all the attractions available in the Disney Park.
     *
     * @return array of all attractions in park.
     */
    public IAttraction[] printAttractions();
}
