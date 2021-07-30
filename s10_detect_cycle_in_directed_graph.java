/*
===========================================
PROBLEM:)
=======================================
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V, E ≤ 1O^5
*/

/*
============================================================
APPROACH:)
=============================================================
use 2 array visited and recStack, visited is used to keep track of the nodes that have been visited
recStack will help in finding cycle in the graph
we call the utility function on the first node
first 2 steps are to check whether its present in the recursion stack and has been visited, if the node is called for the first time, it wont be 
for each element in the list of the present node, we will call the utility function
If there is an instance where the function is called on a vertex that is already present in the recursion stack (checked through if (recStack[i]) return true;), this means
that there is a cycle startin and ending at that said node. return true

if no cycle is found, we mark recStack[i] = false, this tells us that that node is pushed out of the recursion stack and then return false

if in case the graph is disconnected, and only one part has cycle, for that we have called the Utility function on each node, in the adj list
if the node has already been visited, we will return false (this graph didn't have the cycle, its the other graph and for that the nodes will give visited[node] = false)


Time Complexity: O(V + E)
Space: O(V)
*/
import java.util.ArrayList;

public class s10_detect_cycle_in_directed_graph extends s1_helperE {

  public static void main(String[] args) {
    Graph g = new Graph(10);
    g.addEdge_Directed(1, 2);
    g.addEdge_Directed(2, 3);
    g.addEdge_Directed(3, 4);
    g.addEdge_Directed(3, 6);
    g.addEdge_Directed(4, 5);
    g.addEdge_Directed(6, 5);
    g.addEdge_Directed(7, 8);
    g.addEdge_Directed(8, 9);
    g.addEdge_Directed(9, 7);

    System.out.println(isCyclic(g.V, g.adj));
  }

  public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (isCyclicUtil(i, visited, recStack, adj))
          return true;
      }
    }
    return false;

  }

  private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
    visited[i] = true;
    recStack[i] = true;

    for (Integer c : adj.get(i)) {
      if (!visited[c]) {
        if (isCyclicUtil(c, visited, recStack, adj))
          return true;
      } else if (recStack[c]) {
        return true;
      }
    }
    recStack[i] = false;
    return false;
  }
}
