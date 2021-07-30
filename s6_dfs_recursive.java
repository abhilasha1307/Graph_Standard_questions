import java.util.*;

public class s6_dfs_recursive extends s1_helperE {
 public static void main(String[] args) {
  Graph G = new Graph(5);
  G.addEdge_UnDirected(0, 1);
  G.addEdge_UnDirected(0, 2);
  G.addEdge_UnDirected(0, 4);
  G.addEdge_UnDirected(4, 3);

  dfsOfGraph(G.V, G.adj);
 }

 public static void dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
  boolean[] visited = new boolean[V];
  for (int i = 0; i < V; i++) {
   if (!visited[i]) {
    dfs(i, adj, visited);
   }
  }
 }

 private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
  if (!visited[i]) {
   visited[i] = true;
   System.out.print(i + " ");

   for (int j : adj.get(i)) {
    dfs(j, adj, visited);
   }
   return;
  }
 }
}
