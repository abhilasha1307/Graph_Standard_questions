import java.util.*;

/*
PROBLEM:)
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
*/

/*
APPROACH:)
a boolean array to record the vertices tha have been visited
we put the first vertex in the queue and then in the loop(that checks if elements are present in the queue) poll the head of the queue out 
for this element, its corresponding list is traversed separately
since this is bfs, if an element on the list is not visited, it will be put on the stack(to later traverse its list also) and also marked as true in the visited array 
all elements adjacent to a said element are visited and traversed later

Time Complexity: O(V + E)
Space: O(V)
*/

public class s3_bfs_graph extends s1_helperE {
  public static void main(String[] args) {
    Graph G = new Graph(5);
    G.addEdge_Directed(0, 1);
    G.addEdge_Directed(0, 2);
    G.addEdge_Directed(0, 3);
    G.addEdge_Directed(2, 4);

    ArrayList<Integer> ans = bfsOfGraph(5, G.adj);
    System.out.println(ans);
  }

  public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    Queue<Integer> Q = new LinkedList<Integer>();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < adj.size(); i++) {
      if (!visited[i]) {
        bfs(i, visited, adj, Q, list);
      }
    }

    return list;
  }

  private static void bfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Queue<Integer> Q,
      ArrayList<Integer> list) {

    Q.add(i);
    visited[i] = true;
    while (!Q.isEmpty()) {
      int s = Q.poll();
      list.add(s);

      for (int j : adj.get(s)) {
        Q.add(j);
        visited[j] = true;
      }
    }
  }
}
