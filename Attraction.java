// --== CS400 File Header Information ==--
// Name: Kshitij Jhunjhunwala
// Email: kjhunjhunwa2@wisc.edu
// Team: AT
// TA: Minghao Yan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes> 

import java.util.LinkedList;

/**
 * Class that implements the methods defined in the IAttraction interface
 * 
 * @author kshitij
 *
 */
public class Attraction implements IAttraction{
  
  String name; // instance field
  String type; // instance field
  LinkedList<Link> linksLeaving; // instance field

  
  /** 
   * Constructor for an attraction object
   * 
   * @param name the name of the attraction
   * @param type the type of the attraction
   */
  public Attraction(String name, String type) {
    this.name = name;
    this.type = type;
    this.linksLeaving = new LinkedList<>();
  }
  
  /**
   * Link objects are stored within their source vertex, and group together their target destination
   * vertex, along with an integer weight.
   */
  protected static class Link {
    public IAttraction target; // instance field
    public IAttraction source; // instance field
    public int weight; // instance field

    /**
     * Constructor for the link object
     * 
     * @param source source attraction object
     * @param target target attraction object
     * @param weight integer weight of link
     */
    public Link(IAttraction source, IAttraction target, int weight) {
      this.source = source;
      this.target = target;
      this.weight = weight;
    }
  }

  /**
   * Gets the name of the attraction
   * 
   * @return String the name
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Gets the type of the attraction
   * 
   * @return String the type
   */
  @Override
  public String getType() {
    return this.type;
  }
  
  /**
   * Gets the Links of the attraction
   * 
   * @return LinkedList of links
   */
  @Override
  public LinkedList<Link> getLinks() {
    return this.linksLeaving;
  }
  
  
  /**
   * Adds a link to the attraction object
   * 
   * @param Link link object to be added
   */
  @Override
  public void addLink(Link link) {
    this.linksLeaving.add(link);
  }
  
  /**
   * Returns a string representing the Attraction. i.e. "Castaway Creek (Ride)"
   * 
   * @return String of the attraction's name and type
   */
  @Override
  public String toString() {
    String s = "";
    s = s + this.getName() + " (" + this.getType() + ")";
    return s;
  }

}
