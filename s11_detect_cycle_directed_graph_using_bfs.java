import java.util.*;

/*
PROBLEM:
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
*/

public class s11_detect_cycle_directed_graph_using_bfs extends helperM {
  public static void main(String[] args) {
    Graph g = new Graph(6);
    g.addEdge_Directed(0, 1);
    g.addEdge_Directed(1, 2);
    g.addEdge_Directed(2, 0);
    g.addEdge_Directed(3, 4);
    g.addEdge_Directed(4, 5);

    System.out.println(isCycle(g.V, g.adj));
  }

  static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

    // Create a vector to store indegrees of all
    // vertices. Initialize all indegrees as 0.
    int[] in_degree = new int[V];
    Arrays.fill(in_degree, 0);

    // Traverse adjacency lists to fill indegrees of
    // vertices. This step takes O(V+E) time
    for (int u = 0; u < V; u++) {
      for (int v : adj.get(u))
        in_degree[v]++;
    }

    // Create an queue and enqueue all vertices with
    // indegree 0
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < V; i++)
      if (in_degree[i] == 0)
        q.add(i);

    // Initialize count of visited vertices
    int cnt = 0;

    // Create a vector to store result (A topological
    // ordering of the vertices)
    Vector<Integer> top_order = new Vector<>();

    // One by one dequeue vertices from queue and enqueue
    // adjacents if indegree of adjacent becomes 0
    while (!q.isEmpty()) {

      // Extract front of queue (or perform dequeue)
      // and add it to topological order
      int u = q.poll();
      top_order.add(u);

      // Iterate through all its neighbouring nodes
      // of dequeued node u and decrease their in-degree
      // by 1
      for (int itr : adj.get(u))
        if (--in_degree[itr] == 0)
          q.add(itr);
      cnt++;
    }

    // Check if there was a cycle
    if (cnt != V)
      return true;
    else
      return false;
  }
}
