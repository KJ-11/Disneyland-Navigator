import java.util.LinkedList;

public class AttractionBD implements IAttraction{
    protected String name;
    protected String type;

    public AttractionBD(String name, String type) {
        this.name = name;
        this.type = type;
    }
    /**
     * Returns the name of the attraction
     *
     * @return String of name of attraction
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the attraction type (ride, food, or bathroom)
     *
     * @return String of type of attraction
     */
    @Override
    public String getType() {
        return type;
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
   * Returns a string representing the Attraction. i.e. "Castaway Creek (Ride)"
   * 
   * @return String of the attraction's name and type
   */
  @Override
  public String toString() {
	  return "placeholder";
  }
}
