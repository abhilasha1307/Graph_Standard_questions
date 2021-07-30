import java.util.*;

public class s1_helperE {
 static class Graph {
  int V;
  ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

  Graph(int V) {
   this.V = V;

   for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<Integer>());
   }
  }

  void addEdge_Directed(int v, int w) {
   adj.get(v).add(w);
  }

  void addEdge_UnDirected(int v, int w) {
   adj.get(v).add(w);
   adj.get(w).add(v);
  }
 }
}
