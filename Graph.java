import java.util.ArrayList;

public class Graph {
    // data
    // G = (V, E)
    // V = set of vertices - we'll only store label
    ArrayList<String> V = new ArrayList<String>();
    // E = set of edges - adjacency matrix
    public int MAX_SIZE = 10;
    double[][] E;

    // methods
    // AddVertex
    public void Resize() {
        // TO DO ...
    }

    public void AddVertex(String label) {
        if (V.size() == MAX_SIZE) {
            Resize();
        }
        V.add(label);
    }

    // AddEdge
    public void AddEdge(String fromLbl, String toLbl, double weight) throws Exception {
        // find the indices for fromLbl and toLbl
        // call them i and j
        int i = V.indexOf(fromLbl);
        int j = V.indexOf(toLbl);
        if (i == -1 || j == -1)// sanity check / validation / label not found
        {
            throw new Exception("Label not found ...");
        }

        E[i][j] = weight;
    }

    public void AddEdge(String fromLbl, String toLbl) throws Exception {
        AddEdge(fromLbl, toLbl, 1);
    }

    // RemoveEdge
    public void RemoveEdge(String fromLbl, String toLbl) throws Exception {
        AddEdge(fromLbl, toLbl, 0);
    }

    // RemoveVertex
    // Print
    public void Print() {
        int maxWidth = 0;
        for (String lbl : V) {
            if (lbl.length() > maxWidth) {
                maxWidth = lbl.length();
            }
        } // now we know the longest length of all labels

        maxWidth += 2; // leave some space

        System.out.println("PRINTING THE GRAPH ...");
        /////////////////// V //////////////////////
        System.out.print("Vertices: ");
        for (String lbl : V) {
            System.out.print(lbl + " ");
        }
        System.out.println();
        /////////////////// E //////////////////////
        System.out.println("E  - adjacency matrix:");

        System.out.print(String.format("%" + maxWidth + "s", " "));
        for (int col = 0; col < V.size(); col++) // labels row
        {
            System.out.print(String.format("%" + maxWidth + "s", V.get(col)));
        }
        System.out.println();

        for (int col = 0; col < V.size() + 1; col++) // --- ---- ---- --- ----
        {
            System.out.print(String.format("%" + maxWidth + "s", "------"));
        }
        System.out.println();

        for (int row = 0; row < V.size(); row++)// go row by row
        {

            System.out.print(String.format("%" + maxWidth + "s", V.get(row)) + "|");
            // display each row - column by column
            for (int col = 0; col < V.size(); col++) {
                System.out.print(String.format("%" + maxWidth + "s", E[row][col]));
            }
            System.out.println();
        }

    }

    // ctor
    public Graph(int max_size) {
        MAX_SIZE = max_size;
        E = new double[MAX_SIZE][MAX_SIZE];
    }

    public static void main(String[] args) throws Exception {
        Graph g = new Graph(10);
        g.AddVertex("Tacoma");
        g.AddVertex("Lacey");
        g.AddVertex("Olympia");
        g.AddVertex("Puyallup");
        g.AddVertex("Renton");

        g.Print();

        g.AddEdge("Tacoma", "Lacey", 100);
        g.AddEdge("Tacoma", "Olympia", 150);
        g.AddEdge("Puyallup", "Renton", 200);
        g.AddEdge("Lacey", "Olympia");

        // g.AddVertex("sdjlsakjdlsadlsakdlsakdjlsadasdjals");
        g.Print();

        // g.RemoveEdge("Lacey");
        // g.Print();

    }
}