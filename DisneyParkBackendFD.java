// --== CS400 Project Three File Header ==--
// Name: Sreyas Srivastava
// CSL Username: sreyas
// Email: sssrivastav2@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder class developed by FD to replicate the back end
 * 
 * @author Sreyas Srivastava
 *
 */
public class DisneyParkBackendFD implements IDisneyParkBackend {
	
	private String currLocation; // stores the current location
	private String destination; // stores the destination 
	private IAttraction attraction1 = new AttractionFD("AnimalKingdom", "Ride");
	private IAttraction attraction2 = new AttractionFD("CastawayCreek", "Ride");
	private IAttraction attraction3 = new AttractionFD("Bathroom1", "Bathroom");
	private IAttraction attraction4 = new AttractionFD("FoodTruck1", "Food");
	// list of attractions
	private IAttraction[] attractions = {attraction1, attraction2, attraction3, attraction4};
	
	/**
     * Sets the visitor's current location to a given attraction, bathroom, or food truck.
     *
     * @param currLocation current location given by frontend
     */
	@Override
	public void setCurrentLocation(String currLocation) {
		this.currLocation = currLocation;
	}
	
	/**
     * Sets the visitor's desired location to a given attraction, bathroom, or food truck.
     *
     * @param destination the visitor's desired location given by frontend
     */
	@Override
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
     * Gets current location.
     *
     * @return current location
     */
	@Override
	public String getCurrentLocation() {
		return this.currLocation;
	}
	
	/**
     * Gets destination.
     *
     * @return destination
     */
	@Override
	public String getDestination() {
		return this.destination;
	}
	
	/**
     * Returns the path from the current location to the set destination.
     *
     * @return the path from the current location to the set destination
     */
	@Override
	public List<IAttraction> currLocationToDestination() {
		List<IAttraction> path = new ArrayList<>();
		path.add(attraction1);
		path.add(attraction3);
		path.add(attraction4);
		path.add(attraction2);
		return path;
	}
	
	/**
     * Finds the closest bathroom to the visitor's current location.
     * 
     * @return shortest path from current location to nearest bathroom
     */
	@Override
	public List<IAttraction> closestBathroom() {
		List<IAttraction> path = new ArrayList<>();
		path.add(attraction1);
		path.add(attraction3);
		return path;
	}
	
	 /**
     * Finds the closest food truck to the visitor's current location.
     * 
     * @return shortest path from current location to nearest food truck
     */
	@Override
	public List<IAttraction> closestFoodTruck() {
		List<IAttraction> path = new ArrayList<>();
		path.add(attraction1);
		path.add(attraction3);
		path.add(attraction4);
		return path;
	}
	
	/**
     * Returns an array of all the attractions available in the Disney Park.
     *
     * @return array of all attractions in park.
     */
	@Override
	public IAttraction[] printAttractions() {
		return this.attractions;
	}
	
}