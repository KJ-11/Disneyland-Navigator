import java.util.List;

public interface IKruskal<NodeType, EdgeType extends Number> {
	/**
	 * Returns a list of the edges which make up Kruskal's MST
	 * 
	 * @return a list of edges which make up Kruskal's MST
	 */
	public List<?> KruskalMST();
}