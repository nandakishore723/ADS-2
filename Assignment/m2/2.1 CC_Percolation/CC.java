/**
 * Class for cc.
 */
public class CC {
    private boolean[] marked; // marked[v] = has vertex v been marked?
    private int[] id;         // id[v] = id of connected component containing v
    private int[] size;       // size[id] = no. of vertices in given component
    private int count;        // number of connected components

    /**
     * Computes the connected components of the undirected graph {@code g}.
     *
     * @param      g     the undirected graph
     */
    public CC(Graph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        size = new int[g.V()];
        int v;
        for (v = 0; v < g.V(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    /**
     * { function_description }.
     *
     * @param      g     { parameter_description }.
     * @param      v     { parameter_description }.
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * Returns the component id of the connected component containing vertex
     * {@code v}.
     *
     * @param  v the vertex
     * @return the component id of the connected component containing
     * vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    /**
     * Returns the number of vertices in the connected component containing vertex
     * {@code v}.
     *
     * @param  v the vertex
     * @return the number of vertices in the connected component containing
     * vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    /**
     * Returns the number of connected components in the graph {@code g}.
     *
     * @return the number of connected components in the graph {@code g}
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if vertices {@code v} and {@code w} are in the same
     * connected component.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return {@code true} if vertices {@code v} and {@code w} are in the same
     *         connected component; {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @throws IllegalArgumentException unless {@code 0 <= w < V}
     */
    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    /**
     * Returns true if vertices {@code v} and {@code w} are in the same
     * connected component.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return {@code true} if vertices {@code v} and {@code w} are in the same
     *         connected component; {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @throws IllegalArgumentException unless {@code 0 <= w < V}
     * @deprecated Replaced by {@link #connected(int, int)}.
     */
    @Deprecated
    public boolean areConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }.
     */
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (V - 1));
    }
}
