// --== CS400 Project Three File Header ==--
// Name: Sreyas Srivastava
// CSL Username: sreyas
// Email: sssrivastav2@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

import java.util.LinkedList;

/**
 * This class defines an Attraction at the theme park
 * 
 * @author Sreyas Srivastava
 *
 */
public class AttractionFD implements IAttraction {
	
	private String name; // name of attraction
	private String type; // type of attraction
	
	/*
	 * Constructor that defines an Attraction object
	 */
	public AttractionFD(String name, String type) {
		this.name = name;
		this.type = type;
	}

	/**
	 * Returns the name of the Attraction
	 * 
	 * @return name of the Attraction
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the Attraction type (ride, food, or bathroom)
	 * 
	 * @return type of the Attraction
	 */
	@Override
	public String getType() {
		return this.type;
	}
    	/**
   	* Returns a linked list of links from this attraction object
   	* 
   	* @return links of this attraction object
   	*/
  	@Override
  	public LinkedList getLinks() {
         	 return null;
  	}
  
  	/**
   	* Adds a link to this attraction object
   	* 
   	* @param link the link to be added
   	*/
  	@Override
  	public void addLink(Attraction.Link link) {
 	 }
	
	/**
	 * Returns a String representing the Attraction. i.e. "CastawayCreek (Ride)"
	 * 
	 * @return String representation of the Attraction
	 */
	@Override
	public String toString() {
		return ("" + this.name + " (" + this.type + ")");
	}

}
