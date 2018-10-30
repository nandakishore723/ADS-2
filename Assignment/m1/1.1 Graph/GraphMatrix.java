import java.util.Scanner;
/**
 * Class for graph matrix.
 */
class GraphMatrix {
    /**
     * array declaration.
     */
    private String[] tokens;
    /**
     * 2d array declaration.
     */
    private int[][] matrix;
    /**
     * variable declaration.
     */
    private int v;
    /**
     * variable declaration.
     */
    private int e;
    /**
     * Constructs the object.
     */
    GraphMatrix() {
        e = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      scan  The scan
     */
    GraphMatrix(final Scanner scan) {
        this.v = Integer.parseInt(scan.nextLine());
        matrix = new int[v][v];
        int edge = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        int i;
        for (i = 0; i < edge; i++) {
            String[] input = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
    }

    /**
     * Adds an edge.
     *
     * @param      v    the int.
     * @param      w    the int.
     */
    public void addEdge(int v, int w) {
        if (v != w) {
            if (!hasEdge(v, w)) {
                matrix[v][w] = 1;
                matrix[w][v] = 1;
                e++;
            }
        }
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
        if (matrix[v][w] == 1) {
            return true;
        }
        return false;
    }

    /**
     * display method.
     */
    public String toString() {
        String str = "";
        str += v + " vertices, " + e + " edges" + "\n";
        if (e > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    str += matrix[i][j] + " ";
                }
                str += "\n";
            }
            System.out.println(str);
        } else {
            str += "No edges";
            System.out.println(str);
        }
        return str.toString();
    }
}
