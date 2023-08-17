// --== CS400 Project Three File Header ==--
// Name: Sreyas Srivastava
// CSL Username: sreyas
// Email: sssrivastav2@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains methods that display and control the user interface of this application
 * 
 * @author Sreyas Srivastava
 *
 */
public class DisneyParkFrontend implements IDisneyParkFrontend {
	
	private IDisneyParkBackend backend; // back end object
	private Scanner scnr = new Scanner(System.in); // object to read user input from
	
	/**
	 * Constructor that defines a DisneyParkFrontend object
	 * 
	 * @param backend object that controls the back end of the application
	 */
	public DisneyParkFrontend(IDisneyParkBackend backend) {
		this.backend = backend;
	}
	
	/**
	 * Constructor that defines a DisneyParkFrontend object
	 */
	public DisneyParkFrontend() {
		this.backend = new DisneyParkBackendFD();
	}
	
	/**
	 * This method runs the command loop for the front end, and will terminate when
	 * the user exits the application
	 */
	@Override
	public void runCommandLoop() {
		try {
			System.out.println("Welcome to DisneyWorld!\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-\n");
			
			while (true) {
				this.displayMainMenu();
				int input = scnr.nextInt();

				if (input == 1) {
					scnr.nextLine();
					this.chooseCurrentLocation();
				} else if (input == 2) {
					scnr.nextLine();
					this.chooseDestination();
				} else if (input == 3) {
					scnr.nextLine();
					this.findBathroom();
				} else if (input == 4) {
					scnr.nextLine();
					this.findFoodTruck();
				} else if (input == 5) {
					scnr.nextLine();
					this.displayAtttractions();
				} else if (input == 6) {
					break;
				} else {
					System.out.println("Please enter a valid integer option\n");
				}
			}
			
			System.out.println("Thank you for visiting!");
			scnr.close();
		} catch (InputMismatchException e) {
			scnr.close();
			System.out.println("Invalid Input\n");
		}
	}

	/**
	 * This method displays the main menu of the application
	 */
	@Override
	public void displayMainMenu() {
		System.out.println("1) Enter your current location");
		System.out.println("2) Enter your destination");
		System.out.println("3) Find nearest bathroom");
		System.out.println("4) Find nearest food truck");
		System.out.println("5) Show all attractions and facilities");
		System.out.println("6) Exit\n");
	}
	
	/**
	 * This method allows the user to choose their current location from a list of
	 * locations in the theme park
	 */
	@Override
	public void chooseCurrentLocation() {
		System.out.println("What is your current location? Enter below:");
		String currentLocation = scnr.nextLine();
		if (currentLocation.length() == 0) {
			System.out.println("Invalid location (location is blank)\n");
		} else {
			try {
				this.backend.setCurrentLocation(currentLocation);
				System.out.println("Current location set to " + this.backend.getCurrentLocation() + "\n");
			} catch (NullPointerException e) {
				System.out.println("Location does not exist, try again\n");
			}
		}
	}
	
	/**
	 * This method allows the user to choose their destination from a list of
	 * locations in the theme park
	 */
	@Override
	public void chooseDestination() {
		System.out.println("What is your destination? Enter below:");
		String destination = scnr.nextLine();
		if (destination.length() == 0) {
			System.out.println("Invalid destination (destination is blank)\n");
		} else {
			try {
				this.backend.setDestination(destination);
				System.out.println("Current destination set to " + this.backend.getDestination() + "\n");
				List<IAttraction> path = this.backend.currLocationToDestination();
				System.out.println("Here is your shortest path:\n");
				System.out.print("[");
				for (int i = 0; i < path.size(); i++) {
					if (i == path.size() - 1) {
						System.out.print(path.get(i).getName());
					} else {
						System.out.print(path.get(i).getName() + ", ");
					}
				}
				System.out.print("]\n");
			} catch (NullPointerException e) {
				System.out.println("Location does not exist, try again\n");
			}
		}
	}
	
	/**
	 * This method allows the user to find the nearest bathroom based on their
	 * current location
	 */
	@Override
	public void findBathroom() {
		List<IAttraction> closestBathroomPath = this.backend.closestBathroom();
		System.out.println("Nearest Bathroom to Your Location:");
		System.out.println(closestBathroomPath.get(closestBathroomPath.size() - 1).getName() + "\n");
		System.out.println("This is how you get there :");
		System.out.print("[");
		for (int i = 0; i < closestBathroomPath.size(); i++) {
			if (i == closestBathroomPath.size() - 1) {
				System.out.print(closestBathroomPath.get(i).getName());
			} else {
				System.out.print(closestBathroomPath.get(i).getName() + ", ");
			}
			
		}
		System.out.print("]\n");
	}
	
	/**
	 * This method allows the user to find the nearest food truck based on their
	 * current location
	 */
	@Override
	public void findFoodTruck() {
		List<IAttraction> closestFoodTruckPath = this.backend.closestFoodTruck();
		System.out.println("Nearest Food Truck to Your Location:");
		System.out.println(closestFoodTruckPath.get(closestFoodTruckPath.size() - 1).getName() + "\n");
		System.out.println("This is how you get there :");
		System.out.print("[");
		for (int i = 0; i < closestFoodTruckPath.size(); i++) {
			if (i == closestFoodTruckPath.size() - 1) {
				System.out.print(closestFoodTruckPath.get(i).getName());
			} else {
				System.out.print(closestFoodTruckPath.get(i).getName() + ", ");
			}
			
		}
		System.out.print("]\n");
	}
	
	/**
	 * This methods displays a list of all the attractions and facilities in the
	 * theme park
	 */
	@Override
	public void displayAtttractions() {
		IAttraction[] attractions = this.backend.printAttractions();
		if (attractions.length == 0) {
			System.out.println("No attractions exist\n");
		} else {
			System.out.println("Here Are Our Attractions And Facilities:\n");
			for (int i = 0; i < attractions.length; i++) {
				System.out.println((i + 1) + ". " + attractions[i]);
			}
			System.out.println();
		}
	}
}
