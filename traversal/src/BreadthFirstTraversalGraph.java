import java.util.LinkedList;

/**
 * Created by APandey on 05-03-2016.
 *
 */
public class BreadthFirstTraversalGraph {
    private int v; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency lists

    // Constructor
    public BreadthFirstTraversalGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i =0; i < v; i++)
            adj[i] = new LinkedList<Integer>();
    }

    // Function to add an edge to graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {

        // Mark all the vertices as not visited ( by default set to false )
        boolean visited[] = new boolean[v];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while ( queue.size() != 0 ) {

            // Dequeue a vertex from queue and print it
            s = queue.poll();

            System.out.print(s+" ");

            // Get all the adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it visited and enqueue it
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstTraversalGraph graph = new BreadthFirstTraversalGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is the Breadth First Traversal (Starting from vertex 2)");

        graph.BFS(2);
    }
}
