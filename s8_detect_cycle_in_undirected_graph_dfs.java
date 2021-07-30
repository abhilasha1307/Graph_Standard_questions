import java.util.*;

/*
PROBLEM:)
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
*/

/*
=====================================================
APPROACH:) using dfs
=====================================================
in the list corresponding to a node, no previously visited node must be present, except the parent node (which in the undirected graph is the first node in the list)
for each element in the list temp, we first check if the element has been visited before, if not we call the fucntion on that element (for this element, v will be the parent element)

if the element has been visited, we check if this element is same as parent, if not then there exists a cycle in the graph and we return true

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

public class s8_detect_cycle_in_undirected_graph_dfs extends s1_helperE {
  public static void main(String[] args) {
    Graph G = new Graph(5);
    G.addEdge_UnDirected(0, 1);
    G.addEdge_UnDirected(1, 2);
    G.addEdge_UnDirected(2, 3);
    G.addEdge_UnDirected(3, 4);
    G.addEdge_UnDirected(1, 4);

    System.out.println(isCyclic(G.V, G.adj));
  }

  private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> list) {
    boolean[] visited = new boolean[v];

    for (int i = 0; i < v; i++) { // if the graph is disconnected
      if (!visited[i]) {
        if (isCyclicUtil(i, -1, visited, list))
          return true;
      }

    }
    return false;
  }

  private static boolean isCyclicUtil(int v, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> list) {

    visited[v] = true;

    for (int j : list.get(v)) {
      if (!visited[j]) {
        if (isCyclicUtil(j, v, visited, list))
          return true;
      } else if (j != parent) {
        return true;
      }
    }

    return false;
  }
}
