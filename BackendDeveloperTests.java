// --== CS400 Project Three File Header ==--
// Name: Henry Burke
// CSL Username: hburke
// Email: hpburke@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: have fun at disneyland

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackendDeveloperTests {
    private IDisneyParkBackend bd;

    /**
     * Instantiate graph.
     */
    @BeforeEach
    public void createGraph() {
        GraphBD<IAttraction, Integer> graph = new GraphBD<>();
        IDOTLoader dotloader = new DOTLoader();

        ArrayList<IAttraction> attractions = null;
        try {
            attractions = dotloader.loadData("AttractionData.gv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (attractions != null) {
            for (IAttraction attraction : attractions) {
                graph.insertVertex(attraction);
            }
        }

        for (int i = 0; i < attractions.size(); i++) {
            for (int j = 0; j < attractions.get(i).getLinks().size(); j++) {
                Attraction.Link link = (Attraction.Link) attractions.get(i).getLinks().get(j);
                graph.insertEdge(link.source, link.target, link.weight);
            }
        }
        bd = new DisneyParkBackend(graph, attractions);
    }

    /**
     * Tests the getters and setters for currentLocation.
     */
    @Test
    public void testGetAndSetCurrentLocation() {
        createGraph();
        bd.setCurrentLocation("AnimalKingdom");
        assertEquals("AnimalKingdom", bd.getCurrentLocation());
    }

    /**
     * Tests the getters and setters for destination.
     */
    @Test
    public void testGetAndSetDestination() {
        createGraph();
        bd.setDestination("GalaxysEdge");
        assertEquals("GalaxysEdge", bd.getDestination());
    }

    /**
     * Tests the currLocationToDestination() method.
     */
    @Test
    public void testCurrLocationToDestination() {
        bd.setCurrentLocation("AnimalKingdom");
        bd.setDestination("Bathroom1");

        assertEquals("[AnimalKingdom (Ride), Bathroom1 (Bathroom)]", bd.currLocationToDestination().toString());
    }

    /**
     * Tests the closestBathroom() method through multiple vertices.
     */
    @Test
    public void testClosestBathroom() {
        bd.setCurrentLocation("AnimalKingdom");
        assertEquals("[AnimalKingdom (Ride), Bathroom1 (Bathroom)]", bd.closestBathroom().toString());
    }

    /**
     * Tests the closestFoodTruck() method through multiple vertices.
     */
    @Test
    public void testClosestFoodTruck() {
        bd.setCurrentLocation("Bathroom1");
        assertEquals("[Bathroom1 (Bathroom), FoodTruck2 (Food)]", bd.closestFoodTruck().toString());
    }

    /**
     * Tests the integration between
     */
    @Test
    public void integrationTest1() {

    }

    /**
     * Tests the integration between
     */
    @Test
    public void integrationTest2() {

    }

    /**
     * Tests the
     */
    @Test
    public void CodeReviewOfDataWrangler1() {

    }

    /**
     * Tests the
     */
    @Test
    public void CodeReviewOfDataWrangler2() {

    }
}
