import java.util.Scanner;

/**
 * Class for page rank.
 */
class PageRank {
    private Digraph dig;
    private double[] pg;
    /**
     * Constructs the object.
     *
     * @param      dig   The dig
     */
    PageRank(Digraph dig) {
        this.dig = dig;
        pg = new double[dig.V()];
        int i;
        for (i = 0; i < pg.length; i++) {
            pg[i] = 1.0 / dig.V();
        }
    }

    /**
     * Gets the pr.
     *
     * @param      v     { parameter_description }.
     *
     * @return     The pr.
     */
    double getPR(int v) {
        double npg = pg[v];
        int j;
        for (j = 0; j < 1000; j++) {
            for (int k : dig.adj(v)) {
                npg = npg / dig.outdegree(k);
            }
        }
        return npg;
    }

    class WebSearch {

    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = " ";
        str = str + dig + "\n";
        int i;
        for (i = 0; i < dig.V(); i++) {
            str = str + i + " - " + getPR(i) + "\n";
        }
        return str;
    }
}

/*private Digraph buildGraph(String , int V) {
    Digraph graph = new Digraph(V);
    In in = new In();
    while (in.hasNextLine()) {
        String[] tokens = in.readLine().split(",");
        for (int i = 1; i < tokens.length; i++) {
            graph.addEdge(
                Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[i]));
            System.out.println();

        }
    }
    return graph;
}*/

/**
 * Class for solution.
 */
public class Solution {

    private Solution() {
        //unused
    }
    /**
     * Constructs the object.
     */
    public static void main(String[] args) {
        // read the first line of the input to get the number of vertices
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        // iterate count of vertices times
        // to read the adjacency list from std input
        // and build the graph
        Digraph digraph = new Digraph(n);
        int i;
        for (i = 0; i < n; i++) {
            String[] line = scan.nextLine().split(" ");
            int j;
            for (j = 1; j < line.length; j++) {
                digraph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[j]));
            }
        }
        // Create page rank object and pass the graph object to the constructor
        PageRank npg = new PageRank(digraph);
        // print the page rank object
        System.out.println(npg);

        // This part is only for the final test case

        // File path to the web content
        String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object and the file path to the constructor

        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky

    }
}
