// --== CS400 Project Three File Header ==--
// Name: Henry Burke
// CSL Username: hburke
// Email: hpburke@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: have fun at disneyland

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DisneyParkBackend implements IDisneyParkBackend {
    protected IAttraction currLocation; // current location of user.
    protected IAttraction destination; // chosen destination of user.
    protected GraphADT<IAttraction, Integer> graph; // graph of all attractions.
    protected ArrayList<IAttraction> attractList; // array list of all attractions

    /**
     * Constructor for internal testing.
     *
     * @param graph        graph of attractions.
     * @param attractArray array of all attractions.
     */
    public DisneyParkBackend(GraphBD<IAttraction, Integer> graph, ArrayList<IAttraction> attractArray) {
        // sets all parameters
        this.graph = graph;
        currLocation = null;
        destination = null;
        this.attractList = attractArray;
    }

    /**
     * Constructor for integration.
     *
     * @param graph        graph of attractions.
     * @param attractArray array of all attractions.
     */
    public DisneyParkBackend(Graph<IAttraction, Integer> graph, ArrayList<IAttraction> attractArray) {
        // sets all parameters
        this.graph = graph;
        currLocation = null;
        destination = null;
        this.attractList = attractArray;
    }

    /**
     * Sets the visitor's current location to a given attraction, bathroom, or food truck.
     *
     * @param currLocation current location given by frontend
     */
    @Override
    public void setCurrentLocation(String currLocation) {
        IAttraction[] attractArray = printAttractions();
        for (IAttraction iAttraction : attractArray) {
            if (iAttraction.getName().equals(currLocation)) {
                this.currLocation = iAttraction;
                break;
            }
        }
    }

    /**
     * Sets the visitor's desired location to a given attraction, bathroom, or food truck.
     *
     * @param destination the visitor's desired location given by frontend
     */
    @Override
    public void setDestination(String destination) {
        IAttraction[] attractArray = printAttractions();
        for (IAttraction iAttraction : attractArray) {
            if (iAttraction.getName().equals(destination)) {
                this.destination = iAttraction;
                break;
            }
        }
    }

    /**
     * Gets current location.
     *
     * @return current location
     */
    @Override
    public String getCurrentLocation() {
        return currLocation.getName();
    }

    /**
     * Gets destination.
     *
     * @return destination
     */
    @Override
    public String getDestination() {
        return destination.getName();
    }

    /**
     * Returns the path from the current location to the set destination.
     *
     * @return the path from the current location to the set destination
     */
    @Override
    public List<IAttraction> currLocationToDestination() {
        return graph.shortestPath(currLocation, destination);
    }

    /**
     * Finds the closest bathroom to the visitor's current location.
     */
    @Override
    public List<IAttraction> closestBathroom() {
        // initializes a list where we will hold all attractions of type bathroom.
        List<IAttraction> bathrooms = new ArrayList<>();

        // creates an array of ALL attractions.
        IAttraction[] attractArray = printAttractions();

        // iterates through the array of all attractions, and adds them to array list bathrooms if they are of
        // type bathroom.
        for (IAttraction iAttraction : attractArray) {
            if (iAttraction.getType().equals("Bathroom")) {
                bathrooms.add(iAttraction);
            }
        }

        // initialize closestBathroom object and pathCost object to look for closest bathroom.
        IAttraction closestBathroom = null;
        double pathCost = 1000000000;

        // iterate through all the bathrooms and save the one with the lowest cost into closestBathroom.
        for (IAttraction bathroom : bathrooms) {
            try {
                if (bathroom != null && pathCost > graph.getPathCost(currLocation, bathroom)) {
                    closestBathroom = bathroom;
                    pathCost = graph.getPathCost(currLocation, bathroom);
                }
            } catch (NoSuchElementException ignored) {
            }
        }
        // return the path to the closest bathroom.
        return graph.shortestPath(currLocation, closestBathroom);
    }

    /**
     * Finds the closest food truck to the visitor's current location.
     */
    @Override
    public List<IAttraction> closestFoodTruck() {
        // initializes a list where we will hold all attracions of type foodtruck.
        List<IAttraction> foodtrucks = new ArrayList<>();

        // iterates through the array of all attractions, and adds them to array list foodtrucks if they are of
        // type foodtruck.
        IAttraction[] attractArray = printAttractions();
        for (IAttraction iAttraction : attractArray) {
            if (iAttraction.getType().equals("Food")) {
                foodtrucks.add(iAttraction);
            }
        }

        // initialize closestFoodtruck object and pathCost object to look for closest food truck.
        IAttraction closestFoodtruck = null;
        double pathCost = 1000000000;

        // iterate through all the food trucks and save the one with the lowest cost into closestFoodtruck.
        for (IAttraction ftruck : foodtrucks) {
            if (pathCost > graph.getPathCost(currLocation, ftruck)) {
                closestFoodtruck = ftruck;
                pathCost = graph.getPathCost(currLocation, ftruck);
            }
        }
        // return the path to the closest food truck.
        return graph.shortestPath(currLocation, closestFoodtruck);
    }

    /**
     * Returns an array of all the attractions available in the Disney Park.
     *
     * @return array of all attractions in park.
     */
    @Override
    public IAttraction[] printAttractions() {
        // create an array with the same size as the array list of all attractions from data wrangler.
        IAttraction[] attractArray = new Attraction[attractList.size()];

        // iterate and copy all the elements into our array.
        int count = 0;
        for (IAttraction attraction : attractList) {
            attractArray[count] = attraction;
            count++;
        }

        // return array of all attraction objects.
        return attractArray;
    }
}
