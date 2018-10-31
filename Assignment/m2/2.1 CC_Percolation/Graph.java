
/**
 * Class for graph.
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int v;
    private int e;
    private Bag<Integer>[] adj;

    /**
     * Initializes an empty graph with {@code v} vertices and 0 edges.
     * param v the number of vertices
     *
     * @param  v number of vertices
     * @throws IllegalArgumentException if {@code v < 0}.
     */
    public Graph(final int v) {
        if (v < 0) throw new IllegalArgumentException(
                "Number of vertices must be nonnegative");
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int v1 = 0; v1 < v; v1++) {
            adj[v1] = new Bag<Integer>();
        }
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int v() {
        return v;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int e() {
        return e;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v1) {
        if (v1 < 0 || v1 >= v)
            throw new IllegalArgumentException(
                "vertex " + v1 + " is not between 0 and " + (v - 1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v1 one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both
     * {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(final int v1, final int w) {
        validateVertex(v1);
        validateVertex(w);
        e++;
        adj[v1].add(w);
        adj[w].add(v1);
    }

    /**
     * Determines if it has edge.
     *
     * @param      v1     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v1, final int w) {
        for (int each : adj[w]) {
            if (each == v1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the vertices adjacent to vertex {@code v1}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v1}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v1 < v}
     */
    public Iterable<Integer> adj(final int v1) {
        validateVertex(v1);
        return adj[v1];
    }

    /**
     * Returns the degree of vertex {@code v1}.
     *
     * @param  v1 the vertex
     * @return the degree of vertex {@code v1}
     * @throws IllegalArgumentException unless {@code 0 <= v1 < v}
     */
    public int degree(final int v1) {
        validateVertex(v1);
        return adj[v1].size();
    }


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>v</em>, followed
     * by the number of edges <em>e</em>,
     *         followed by the <em>v</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(v + " vertices, " + e + " edges " + NEWLINE);
        for (int v1 = 0; v1 < v; v1++) {
            s.append(v1 + ": ");
            for (int w : adj[v1]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
