import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    //unused.
  }
  /**
   * main function to handle the testcases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // Self loops are not allowed...
    // Parallel Edges are allowed...
    // Take the Graph input here...
    Scanner scan = new Scanner(System.in);
    int vertices = Integer.parseInt(scan.nextLine());
    int edges = Integer.parseInt(scan.nextLine());
    EdgeWeightedGraph graph = new EdgeWeightedGraph(vertices);
    while (edges > 0) {
      String[] tokens = scan.nextLine().split(" ");
      Edge e = new Edge(Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]),
                        Double.parseDouble(tokens[2]));
      graph.addEdge(e);
      edges--;
    }
    String caseToGo = scan.nextLine();
    switch (caseToGo) {
    case "Graph":
      //Print the Graph Object.
      System.out.println(graph);
      break;

    case "DirectedPaths":
      // Handle the case of DirectedPaths, where two integers are given.
      // First is the source and second is the destination.
      // If the path exists print the distance between them.
      // Other wise print "No Path Found."
      String[] tokens = scan.nextLine().split(" ");
      int i = Integer.parseInt(tokens[0]);
      int j = Integer.parseInt(tokens[1]);
      DijkstraUndirectedSP dj =
        new DijkstraUndirectedSP(graph, i);
      if (dj.hasPathTo(j)) {
        System.out.println(dj.distTo(j));
      } else {
        System.out.println("No Path Found.");
      }
      break;

    case "ViaPaths":
      // Handle the case of ViaPaths, where three integers are given.
      // First is the source and second is the via is
      // the one where path should pass through.
      // third is the destination.
      // If the path exists print the distance between them.
      // Other wise print "No Path Found."
      /*String[] tokens = scan.nextLine().split(" ");
      int i = Integer.parseInt(tokens[0]);
      int j = Integer.parseInt(tokens[1]);
      int k = Integer.parseInt(tokens[2]);
      DijkstraUndirectedSP dij =
        new DijkstraUndirectedSP(graph, i);
      if (dij.hasPathTo(j)) {
        System.out.println(dij.distTo(j));
        if (dij.hasPathTo(k)) {
          System.out.println(dij.distTo(k));
        }
      } else {*/
      //}
      System.out.println("No Path Found.");


      break;

    default:
      break;
    }

  }
}



