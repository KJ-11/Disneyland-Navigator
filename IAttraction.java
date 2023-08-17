// --== CS400 File Header Information ==--
// Name: Kshitij Jhunjhunwala
// Email: kjhunjhunwa2@wisc.edu
// Team: AT
// TA: Minghao Yan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes> 

import java.util.LinkedList;

/**
 * Interface for the Attraction object
 * 
 * @author Kshitij Jhunjhunwala
 */
public interface IAttraction {
  /**
   * Returns the name of the attraction
   * 
   * @return String of name of attraction
   */
  public String getName();
  
  /**
   * Returns the attraction type (ride, food, or bathroom)
   * 
   * @return String of type of attraction
   */
  public String getType();
  
  /**
   * Returns a linked list of links from this attraction object
   * 
   * @return links of this attraction object
   */
  public LinkedList getLinks();
  
  /**
   * Adds a link to this attraction object
   * 
   * @param link the link to be added
   */
  public void addLink(Attraction.Link link);
  
  /**
   * Returns a string representing the Attraction. i.e. "Castaway Creek (Ride)"
   * 
   * @return String of the attraction's name and type
   */
  @Override
  public String toString();
}
