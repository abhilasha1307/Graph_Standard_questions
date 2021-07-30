import java.util.*;

/*
===========================================================
PROBLEM: 
==========================================================
Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
*/

/*
=====================================================================
APPROACH:
====================================================================
In dfs, starting from vertex 0, first it will be marked true on the visisted array, added to the resultant list to be returned to the calling function and then 
for list of each vertex we will call the dfs function again for an element it he list, which has not been visited (recursion) and the process is repeated

a edge case can be when the graph is disconnected
for this we will have to loop over on the dfs function, and before calling check whether a said node is already visited
in the best case there will be only one disconnected node, and the dfs will be called the second time (from dfsOfGraph's for loop) only for this node, as all the others will be visited 
on way or another

in the worst case it will be call for all the nodes, as no node is connected to any other node

number of function calls will be same in both the above cases

TC : O(V+E)
SC : O(V)
*/

public class s5_dfs_graph extends s1_helperE {
  public static void main(String[] args) {
    Graph G = new Graph(5);
    G.addEdge_UnDirected(0, 1);
    G.addEdge_UnDirected(0, 2);
    G.addEdge_UnDirected(0, 4);
    G.addEdge_UnDirected(4, 3);

    System.out.println(dfsOfGraph(G.V, G.adj));
  }

  public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    ArrayList<Integer> ans = new ArrayList<Integer>();
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, ans, adj);
      }
    }

    return ans;
  }

  public static void dfs(int v, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
    vis[v] = true;
    ans.add(v);
    for (int j : adj.get(v)) {
      if (!vis[j]) {
        dfs(j, vis, ans, adj);
      }
    }
  }

}
