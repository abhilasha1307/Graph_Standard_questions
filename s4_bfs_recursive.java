import java.util.*;

//have to use a queue to store a seen node to be traversed list
public class s4_bfs_recursive extends s1_helperE {
 public static void main(String[] args) {
  Graph G = new Graph(5);
  G.addEdge_Directed(0, 1);
  G.addEdge_Directed(0, 2);
  G.addEdge_Directed(0, 3);
  G.addEdge_Directed(2, 4);

  bfsOfGraph(5, G.adj);
 }

 public static void bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
  boolean[] visited = new boolean[V];
  Queue<Integer> Q = new LinkedList<>();
  for (int i = 0; i < adj.size(); i++) {
   if (!visited[i]) {
    visited[i] = true;
    Q.add(i);
    bfs(visited, adj, Q);
   }
  }

 }

 private static void bfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj, Queue<Integer> Q) {
  if (Q.isEmpty()) {
   return;
  }

  int s = Q.poll();
  System.out.print(s + " ");
  for (int j : adj.get(s)) {
   Q.add(j);
   visited[j] = true;
  }
  bfs(visited, adj, Q);
 }
}
