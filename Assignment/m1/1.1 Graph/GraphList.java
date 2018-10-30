import java.util.Scanner;
/**
 * List of graphs.
 */
class GraphList {
    /**
     * variable declaration.
     */
    private int v;
    /**
     * variable declaration.
     */
    private int e;
    /**
     * array declaration.
     */
    private Bag<Integer>[] adj;
    /**
     * array declaration.
     */
    private String[] tokens;
    /**
     * Constructs the object.
     */
    GraphList() {
    }
    /**
     * Constructs the object.
     *
     * @param      scan  The scan
     */
    GraphList(final Scanner scan) {
        this.v = Integer.parseInt(scan.nextLine());
        adj = (Bag<Integer>[]) new Bag[v];
        int i;
        for (i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
        int e = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        int j;
        for (j = 0; j < e; j++) {
            String[] inputs = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }

    /**
     * method for vertices.
     *
     * @return  vertices.
     */
    public int v() {
        return v;
    }
    /**
     * method for edges.
     *
     * @return edges.
     */
    public int e() {
        return e;
    }

    /**
     * Adds an edge.
     *
     * @param      v1    the int.
     * @param      w    the int.
     */
    public void addEdge(final int v1, final int w) {
        if (v1 != w) {
            adj[v1].add(w);
            adj[w].add(v1);
            e++;
        } else {
            return;
        }
    }

    /**
     * method for adjacent vertex.
     *
     * @param      v    the int.
     *
     * @return adjacent vertex.
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Determines if it has edge.
     *
     * @param      v    the int.
     * @param      w    the int.
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(int v, int w) {
        return true;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(v + " vertices, " + e + " edges" + "\n");
        if (e > 0) {
            for (int i = 0; i < v; i++) {
                s.append(tokens[i] + ": ");
                for (int j : adj[i]) {
                    s.append(tokens[j] + " ");
                }
                s.append("\n");
            }
            return s.toString();
        } else {
            s.append("No edges");
            return s.toString();
        }
    }
}
