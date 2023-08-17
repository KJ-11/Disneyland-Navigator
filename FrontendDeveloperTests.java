// --== CS400 Project Three File Header ==--
// Name: Sreyas Srivastava
// CSL Username: sreyas
// Email: sssrivastav2@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class contains junit tests to check the functionality of the methods in 
 * the class DisneyParkFrontend
 * 
 * @author Sreyas Srivastava
 *
 */
public class FrontendDeveloperTests {
	
	/**
	 * Test to see if the chooseCurrentLocation() method works correctly
	 */
	@Test
	public void test1() {
		String expected = "What is your current location? Enter below:\nCurrent location set "
				+ "to AnimalKingdom";
		TextUITester tester = new TextUITester("AnimalKingdom\n");
		DisneyParkFrontend testFrontend = new DisneyParkFrontend();
        testFrontend.chooseCurrentLocation();
        String actual = tester.checkOutput();
        Assertions.assertTrue(actual.contains(expected));
	}
	
	/**
	 * Test to see if the chooseDestination() method works correctly
	 */
	@Test
	public void test2() {
		String expected = "What is your destination? Enter below:\nCurrent destination set to "
				+ "FoodTruck1";
		TextUITester tester = new TextUITester("FoodTruck1\n");
		DisneyParkFrontend testFrontend = new DisneyParkFrontend();
        testFrontend.chooseDestination();
        String actual = tester.checkOutput();
        Assertions.assertTrue(actual.contains(expected));
	}
	
	/**
	 * Test to see if the findBathroom() method works correctly
	 */
	@Test
	public void test3() {
		String expected = "Nearest Bathroom to Your Location:\nBathroom1\n\nThis is how you get "
				+ "there :\n[AnimalKingdom, Bathroom1]";
		DisneyParkFrontend testFrontend = new DisneyParkFrontend(new DisneyParkBackendFD());
		TextUITester tester = new TextUITester("");
        testFrontend.findBathroom();
        String actual = tester.checkOutput();
        Assertions.assertTrue(actual.contains(expected));
	}
	
	/**
	 * Test to see if the findFoodTruck() method works correctly
	 */
	@Test
	public void test4() {
		String expected = "Nearest Food Truck to Your Location:\nFoodTruck1\n\nThis is how you get "
				+ "there :\n[AnimalKingdom, Bathroom1, FoodTruck1]";
		DisneyParkFrontend testFrontend = new DisneyParkFrontend(new DisneyParkBackendFD());
		TextUITester tester = new TextUITester("");
        testFrontend.findFoodTruck();
        String actual = tester.checkOutput();
        Assertions.assertTrue(actual.contains(expected));
	}
	
	/**
	 * Test to see if the displayAttractions() method works correctly
	 */
	@Test
	public void test5() {
		String expected = "Here Are Our Attractions And Facilities:\n\n1. AnimalKingdom (Ride)\n"
				+ "2. CastawayCreek (Ride)\n3. Bathroom1 (Bathroom)\n4. FoodTruck1 (Food)\n\n";
		DisneyParkFrontend testFrontend = new DisneyParkFrontend(new DisneyParkBackendFD());
		TextUITester tester = new TextUITester("");
		testFrontend.displayAtttractions();
		String actual = tester.checkOutput();
		Assertions.assertTrue(actual.contains(expected));
	}
}
