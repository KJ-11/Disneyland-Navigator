// --== CS400 File Header Information ==--
// Name: Kshitij Jhunjhunwala
// Email: kjhunjhunwa2@wisc.edu
// Team: AT
// TA: Minghao Yan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * This class tests methods defined in the Attraction and DOTLoader classes
 * 
 * @author kshitij
 *
 */
public class DataWranglerTests {

  /**
   * This method checks the getter and setter methods of the Attraction class, namely getName(),
   * getType(), getLinks(), and addLink()
   */
  @Test
  public void test1() {
    Attraction testAttraction = new Attraction("test1", "type1");

    // test for getName() method
    Assertions.assertEquals(testAttraction.getName(), "test1",
        "Test1 failed: getName() method failed to return correct value.");

    // test for getType() method
    Assertions.assertEquals(testAttraction.getType(), "type1",
        "Test1 failed: getType() method failed to return correct value.");

    // test for getLinks() method
    Assertions.assertEquals(testAttraction.getLinks(), new LinkedList<Attraction.Link>(),
        "Test1 failed: getLinks() method failed to return correct value.");

    // test for addLink() method
    Attraction.Link link =
        new Attraction.Link((IAttraction) testAttraction, (IAttraction) testAttraction, 10);
    testAttraction.addLink(link);

    LinkedList<Attraction.Link> links = new LinkedList<Attraction.Link>();
    links.add(link);
    Assertions.assertEquals(testAttraction.getLinks(), links,
        "Test1 failed: getLinks() method failed to return correct value.");
  }

  /**
   * This method tests whether the toString() method of the Attraction class works as intended.
   */
  @Test
  public void test2() {
    Attraction testAttraction = new Attraction("test1", "type1");
    Assertions.assertEquals(testAttraction.toString(), "test1 (type1)",
        "Test2 failed: toString() method didn't return the correct value.");
  }

  /**
   * This method checks if the loadData() method of the DOTLoader class works as correctly and
   * throws an exception when the file path doesn't exist
   */
  @Test
  public void test3() {

    DOTLoader testLoader = new DOTLoader();
    try {
      testLoader.loadData("invalid.gv");
      Assertions
          .fail("Test3 failed: No exception thrown by loadData() method when an invalid file path"
              + " is passed as an argument.");
    } catch (FileNotFoundException e) {
      Assertions.assertTrue(true);
    } catch (Exception e) {
      Assertions.fail(
          "Test3 failed: wrong exception thrown by loadData() method when an invalid file path"
              + "is passed as an argument.");
    }

  }

  /**
   * This method checks if the loadData() method of the DOTLoader class works as correctly when the
   * file path is valid and exists
   */
  @Test
  public void test4() {

    DOTLoader testLoader = new DOTLoader();

    try {
      Assertions.assertEquals(testLoader.loadData("AttractionData.gv").get(0).getName(),
          "AnimalKingdom", "Test4 failed: loadData() method didn't load the correct objects when "
              + "passed a valid file path.");
    } catch (Exception e) {
      e.printStackTrace();
      Assertions.fail("Test4 failed: unknown exception thrown by loadData()");
    }

  }

  /**
   * This method checks if the loadData() method of the DOTLoader class correctly loads all data
   * points in the .gv file
   */
  @Test
  public void test5() {

    DOTLoader testLoader = new DOTLoader();
    String expected =
        "[AnimalKingdom (Ride), GalaxysEdge (Ride), AstroOrbital (Ride), Barnstormer (Ride), "
            + "CastawayCreek (Ride), DisneyCastle (Ride), FossilFun (Ride), Bathroom1 (Bathroom), "
            + "Bathroom2 (Bathroom), Bathroom3 (Bathroom), FoodTruck1 (Food), FoodTruck2 (Food), "
            + "FoodTruck3 (Food)]";

    try {
      Assertions.assertEquals(expected, testLoader.loadData("AttractionData.gv").toString(),
          "Test5 failed: toString() of arraylist created by loadData() method didn't look"
              + " as expected.");
    } catch (Exception e) {
      e.printStackTrace();
      Assertions.fail("Test5 failed: unknown exception thrown by loadData().");
    }

  }

  /**
   * This method checks if all the graph is loaded correctly after integrating.
   *
}
