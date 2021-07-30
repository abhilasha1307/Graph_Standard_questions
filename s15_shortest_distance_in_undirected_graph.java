import java.util.*;

//shortest distance from a fixed source to every other node in the graph 

public class s15_shortest_distance_in_undirected_graph extends s1_helperE {
 public static void main(String[] args) {
  Graph G = new Graph(9);
  G.addEdge_UnDirected(0, 1);
  G.addEdge_UnDirected(0, 3);
  G.addEdge_UnDirected(1, 2);
  G.addEdge_UnDirected(1, 3);
  G.addEdge_UnDirected(2, 6);
  G.addEdge_UnDirected(3, 4);
  G.addEdge_UnDirected(4, 5);
  G.addEdge_UnDirected(5, 6);
  G.addEdge_UnDirected(6, 7);
  G.addEdge_UnDirected(6, 8);
  G.addEdge_UnDirected(7, 8);

  shortest_distance(G.V, G.adj, 0);
 }

 public static void shortest_distance(int v, ArrayList<ArrayList<Integer>> adj, int src) {
  int[] dist = new int[v];
  Arrays.fill(dist, Integer.MAX_VALUE);

  Queue<Integer> Q = new LinkedList<>();

  dist[src] = 0;
  Q.add(src);
  while (!Q.isEmpty()) {
   int node = Q.poll();

   for (int j : adj.get(node)) {
    if (dist[node] + 1 < dist[j]) {
     dist[j] = dist[node] + 1;
     Q.add(j);
    }
   }
  }

  for (int x : dist) {
   System.out.print(x + " ");
  }
 }
}
