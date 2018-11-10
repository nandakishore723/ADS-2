import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution {

	/**
	 * Constructs the object.
	 */
	private Solution() {
		// unused
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertices = Integer.parseInt(scan.nextLine());
		int edges = Integer.parseInt(scan.nextLine());
		EdgeWeightedGraph graph = new EdgeWeightedGraph(vertices);
		while (scan.hasNext()) {
			String[] input = scan.nextLine().split(" ");
			graph.addEdge(new Edge(Integer.parseInt(input[0]),
			              Integer.parseInt(input[1]),
			              Double.parseDouble(input[2])));
		}
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...

		String caseToGo = null;
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			break;

		/*case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;*/

		default:
			break;
		}
	}
}
