import java.util.*;

/*
Colour using exactly 2 colours, such that no 2 nodes have the same color
*/

public class s9_bipartite_graph_bfs extends s1_helperE {
 static class Pair {
  int first, second;

  Pair(int f, int s) {
   first = f;
   second = s;
  }
 }

 public static void main(String[] args) {
  Graph G = new Graph(9);
  G.addEdge_UnDirected(1, 2);
  G.addEdge_UnDirected(2, 3);
  G.addEdge_UnDirected(2, 8);
  G.addEdge_UnDirected(3, 4);
  G.addEdge_UnDirected(4, 5);
  G.addEdge_UnDirected(5, 6);
  G.addEdge_UnDirected(5, 8);
  G.addEdge_UnDirected(6, 7);

  // G.addEdge_UnDirected(1, 2);
  // G.addEdge_UnDirected(2, 3);
  // G.addEdge_UnDirected(3, 4);
  // G.addEdge_UnDirected(3, 10);
  // G.addEdge_UnDirected(4, 5);
  // G.addEdge_UnDirected(5, 6);
  // G.addEdge_UnDirected(6, 9);
  // G.addEdge_UnDirected(6, 7);
  // G.addEdge_UnDirected(7, 8);
  // G.addEdge_UnDirected(9, 10);
  // G.addEdge_UnDirected(6, 7);

  System.out.println(isBipartite(G.V, G.adj));
 }

 public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
  int[] col = new int[V + 1]; // 1 indexed graph
  Arrays.fill(col, -1);

  Queue<Pair> q = new LinkedList<Pair>();
  // colours can be 0 or 1
  for (int i = 1; i < V; i++) {

   // if not coloured
   if (col[i] == -1) {
    q.add(new Pair(i, 0));
    col[i] = 0;

    while (!q.isEmpty()) {
     Pair p = q.peek();
     q.poll();

     // current vertex
     int v = p.first;

     // colour of current vertex
     int c = p.second;

     for (int j : adj.get(v)) {
      if (col[j] == c)
       return false;

      // if uncooloured
      if (col[j] == -1) {
       col[j] = (c == 1) ? 0 : 1;
       q.add(new Pair(j, col[j]));
      }
     }
    }
   }
  }
  return true;
 }
}
