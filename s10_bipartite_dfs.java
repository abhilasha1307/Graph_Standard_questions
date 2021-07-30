import java.util.ArrayList;
import java.util.Arrays;

public class s10_bipartite_dfs extends s1_helperE {
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

  System.out.println(isBipartite(G.V, G.adj));
 }

 public static boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
  int[] colour = new int[v + 1];
  Arrays.fill(colour, -1);
  for (int i = 1; i < v; i++) {
   if (colour[i] == -1) {
    if (checkUtil(i, colour, adj) == false) {
     return false;
    }
   }
  }
  return true;
 }

 private static boolean checkUtil(int i, int[] colour, ArrayList<ArrayList<Integer>> adj) {
  if (colour[i] == -1) {
   colour[i] = 1;
  }

  for (int j : adj.get(i)) {
   if (colour[j] == -1) {
    colour[j] = 1 - colour[i];
    if (checkUtil(j, colour, adj) == false) {
     return false;
    }
   } else if (colour[j] == colour[i]) {
    return false;
   }
  }
  return true;
 }
}
