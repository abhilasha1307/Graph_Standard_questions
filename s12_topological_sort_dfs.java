import java.util.ArrayList;
import java.util.Stack;

public class s12_topological_sort_dfs extends s1_helperE {
 public static void main(String[] args) {
  Graph G = new Graph(6);
  G.addEdge_Directed(2, 3);
  G.addEdge_Directed(3, 1);
  G.addEdge_Directed(4, 0);
  G.addEdge_Directed(4, 1);
  G.addEdge_Directed(5, 0);
  G.addEdge_Directed(5, 2);

  Topological_sort(G.V, G.adj);
 }

 public static void Topological_sort(int v, ArrayList<ArrayList<Integer>> adj) {
  boolean[] vis = new boolean[v];
  Stack<Integer> S = new Stack<>();
  for (int i = 0; i < v; i++) {
   if (!vis[i]) {
    dfs(i, vis, adj, S);
   }
  }
  while (!S.isEmpty()) {
   System.out.print(S.pop() + " ");
  }
 }

 private static void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s) {
  vis[i] = true;
  for (int j : adj.get(i)) {
   if (!vis[j]) {
    dfs(j, vis, adj, s);
   }
  }
  s.push(i); // node 'i' is pushed in the stack only when all the outgoing edges have been
             // covered (no vertex or node depends on 'i'). Outdegree and indegree relation
  return;
 }
}
