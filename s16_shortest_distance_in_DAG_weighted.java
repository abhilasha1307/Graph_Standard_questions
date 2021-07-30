import java.util.*;

//using topo sort.
public class s16_shortest_distance_in_DAG_weighted {
 static class Pair {
  private int node;
  private int weight;

  Pair(int node, int weight) {
   this.node = node;
   this.weight = weight;
  }

  int getNode() {
   return node;
  }

  int getWeight() {
   return weight;
  }
 }

 static class Graph {
  int V;
  ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

  Graph(int V) {
   this.V = V;

   for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<Pair>());
   }
  }

  void addEdge_Directed(int v, Pair w) {
   adj.get(v).add(w);
  }
 }

 public static void main(String[] args) {
  Graph G = new Graph(6);
  G.addEdge_Directed(0, new Pair(1, 2));
  G.addEdge_Directed(0, new Pair(4, 1));
  G.addEdge_Directed(1, new Pair(2, 3));
  G.addEdge_Directed(2, new Pair(3, 6));
  G.addEdge_Directed(4, new Pair(2, 2));
  G.addEdge_Directed(4, new Pair(5, 4));
  G.addEdge_Directed(5, new Pair(3, 1));

  shortest_path(0, G.V, G.adj);
 }

 public static void shortest_path(int src, int v, ArrayList<ArrayList<Pair>> adj) {
  Stack<Integer> S = new Stack<>();
  int dist[] = new int[v];
  Arrays.fill(dist, Integer.MAX_VALUE);

  boolean[] visited = new boolean[v];

  for (int i = 0; i < v; i++) {
   if (!visited[i]) {
    topoSortUtil(i, visited, S, adj);
   }
  }

  dist[src] = 0;
  while (!S.isEmpty()) {
   int node = S.pop();
   // node has been reached previously
   if (dist[node] != Integer.MAX_VALUE) {
    for (Pair j : adj.get(node)) {
     if (dist[node] + j.getWeight() < dist[j.getNode()]) {
      dist[j.getNode()] = dist[node] + j.getWeight();
     }
    }
   }
  }

  for (int i = 0; i < v; i++) {
   if (dist[i] == Integer.MAX_VALUE) {
    System.out.print("{node " + i + " is unreachable}");
   } else {
    System.out.print(dist[i] + " ");
   }
  }
 }

 private static void topoSortUtil(int i, boolean[] vis, Stack<Integer> s, ArrayList<ArrayList<Pair>> adj) {
  vis[i] = true;
  for (Pair j : adj.get(i)) {
   if (!vis[j.getNode()]) {
    topoSortUtil(j.getNode(), vis, s, adj);
   }
  }
  s.push(i);
  return;
 }
}