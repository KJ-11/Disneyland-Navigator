// --== CS400 File Header Information ==--
// Name: Michaekl Deng
// Email: madeng@wisc.edu
// Team: AT
// TA: Minghao Yan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the implementation of Graph for the individual component of Project
 * Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class AlgorithmEngineerTest {

	private Graph<String, Integer> graph;

	/**
	 * Instantiate graph.
	 */
	@BeforeEach
	public void createGraph() {
		graph = new Graph<>();
		// insert vertices A-F
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		// insert edges
		graph.insertEdge("A", "B", 6);
		graph.insertEdge("A", "C", 2);
		graph.insertEdge("A", "D", 5);
		graph.insertEdge("B", "E", 1);
		graph.insertEdge("B", "C", 2);
		graph.insertEdge("C", "B", 3);
		graph.insertEdge("C", "F", 1);
		graph.insertEdge("D", "E", 3);
		graph.insertEdge("E", "A", 4);
		graph.insertEdge("F", "A", 1);
		graph.insertEdge("F", "D", 1);
	}

	/**
	 * Checks the distance/total weight cost from the vertex A to F.
	 */
	@Test
	public void testPathCostAtoF() {
		assertEquals(graph.getPathCost("A", "F"), 3);
	}

	/**
	 * Checks the distance/total weight cost from the vertex A to D.
	 */
	@Test
	public void testPathCostAtoD() {
		assertEquals(graph.getPathCost("A", "D"), 4);
	}

	/**
	 * Checks the ordered sequence of data within vertices from the vertex A to D.
	 */
	@Test
	public void testPathAtoD() {
		assertEquals(graph.shortestPath("A", "D").toString(), "[A, C, F, D]");
	}

	/**
	 * Checks the ordered sequence of data within vertices from the vertex A to F.
	 */
	@Test
	public void testPathAtoF() {
		assertEquals(graph.shortestPath("A", "F").toString(), "[A, C, F]");
	}

	/**
	 * Checks the distance/total weight cost from the vertex A to E.
	 * 
	 * Part 9
	 */
	@Test
	public void testPathCostAtoE() {
		assertEquals(graph.getPathCost("A", "E"), 6);
	}

	/**
	 * Checks the ordered sequence of data within vertices from the vertex A to E.
	 * 
	 * Part 10
	 */
	@Test
	public void testPathAtoE() {
		assertEquals(graph.shortestPath("A", "E").toString(), "[A, C, B, E]");
	}

	/**
	 * Checks the distance/total weight cost from the vertex B to F.
	 * 
	 * Part 11
	 */
	@Test
	public void testPathCostBtoF() {
		assertEquals(graph.getPathCost("B", "F"), 3);
	}

	/**
	 * Checks the ordered sequence of data within vertices from the vertex B to F.
	 * 
	 * Part 12
	 */
	@Test
	public void testPathBtoF() {
		assertEquals(graph.shortestPath("B", "F").toString(), "[B, C, F]");
	}

	/**
	 * Checks the ordered sequence of data within vertices from the vertex D to B.
	 * 
	 * Part 13
	 */
	@Test
	public void testPathDtoB() {
		assertEquals(graph.shortestPath("D", "B").toString(), "[D, E, A, C, B]");
	}

	/**
	 * Checks to see if NoSuchElementException is thrown properly
	 * 
	 * Part 13
	 */
	@Test
	public void testExeception() {
		Graph<String, Integer> graph2 = new Graph<>();
		graph2.insertVertex("A");
		graph2.insertVertex("B");
		graph2.insertEdge("B", "A", 1);
		try {
			System.out.println(graph2.shortestPath("A", "B"));
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		Graph<String, Integer> graph3 = new Graph<>();
		graph3.insertVertex("A");
		graph3.insertVertex("B");
		graph3.insertVertex("C");
		graph3.insertEdge("A", "B", 1);
		try {
			System.out.println(graph3.shortestPath("A", "C"));
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

	}

	/**
	 * Simple test for our KruskalMST() method in UndirectedGraph.java
	 */
	@Test
	public void testMST1() {
		UndirectedGraph<String, Integer> graph = new UndirectedGraph<>();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertEdge("A", "B", 1);
		graph.insertEdge("A", "C", 2);
		graph.insertEdge("C", "B", 3);
		graph.insertEdge("A", "D", 4);
		graph.insertEdge("C", "D", 5);
		assertEquals("[A B 1, A C 2, A D 4]", graph.KruskalMST().toString());
	}

	/**
	 * Checks to make sure that KruskalMSt in UndirectedGraph.java returns null if
	 * no MST exists
	 */
	@Test
	public void testMST2() {
		UndirectedGraph<String, Integer> graph = new UndirectedGraph<>();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertEdge("A", "B", 1);
		graph.insertEdge("A", "C", 2);
		graph.insertEdge("C", "B", 3);
		graph.insertEdge("A", "D", 4);
		graph.insertEdge("C", "D", 5);
		assertEquals(null, graph.KruskalMST());
	}

	/**
	 * Big test for our KruskalMST() method in UndirectedGraph.java
	 */
	@Test
	public void testMST3() {
		UndirectedGraph<String, Integer> graph = new UndirectedGraph<>();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");

		graph.insertEdge("A", "B", 1);
		graph.insertEdge("A", "C", 3);
		graph.insertEdge("A", "D", 5);
		graph.insertEdge("A", "E", 7);
		graph.insertEdge("A", "F", 8);
		graph.insertEdge("B", "C", 2);
		graph.insertEdge("D", "C", 4);
		graph.insertEdge("E", "D", 6);

		assertEquals("[A B 1, B C 2, D C 4, E D 6, A F 8]", graph.KruskalMST().toString());
	}

	/**
	 * Another big test for our KruskalMST() method in UndirectedGraph.java w/
	 * different node types
	 */
	@Test
	public void testMST4() {
		UndirectedGraph<Integer, Integer> graph = new UndirectedGraph<>();
		graph.insertVertex(0);
		graph.insertVertex(1);
		graph.insertVertex(2);
		graph.insertVertex(3);
		graph.insertVertex(4);
		graph.insertVertex(5);
		graph.insertVertex(6);
		graph.insertVertex(7);

		graph.insertEdge(0, 1, 1);
		graph.insertEdge(1, 3, 2);
		graph.insertEdge(0, 3, 6);
		graph.insertEdge(2, 1, 4);
		graph.insertEdge(3, 5, 4);
		graph.insertEdge(5, 6, 7);
		graph.insertEdge(2, 6, 6);
		graph.insertEdge(2, 4, 2);
		graph.insertEdge(6, 4, 6);
		graph.insertEdge(6, 7, 5);
		graph.insertEdge(7, 4, 5);

		assertEquals("[0 1 1, 1 3 2, 2 4 2, 2 1 4, 3 5 4, 6 7 5, 7 4 5]", graph.KruskalMST().toString());
	}

	/**
	 * Another test for KruskalMST() testing to ensure that it returns null when no
	 * MST exists
	 */
	@Test
	public void testMST5() {
		UndirectedGraph<Integer, Integer> graph = new UndirectedGraph<>();
		graph.insertVertex(0);
		graph.insertVertex(1);
		graph.insertVertex(2);
		graph.insertVertex(3);
		graph.insertVertex(4);
		graph.insertVertex(5);
		graph.insertVertex(6);
		graph.insertVertex(7);

		graph.insertEdge(0, 1, 1);
		graph.insertEdge(1, 3, 2);
		graph.insertEdge(0, 3, 6);
		// graph.insertVertex(2, 1, 4);
		// graph.insertVertex(3, 5, 4);
		graph.insertEdge(5, 6, 7);
		graph.insertEdge(2, 6, 6);
		graph.insertEdge(2, 4, 2);
		graph.insertEdge(6, 4, 6);
		graph.insertEdge(6, 7, 5);
		graph.insertEdge(7, 4, 5);

		assertEquals(null, graph.KruskalMST());
	}
}
