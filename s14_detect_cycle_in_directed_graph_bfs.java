import java.util.*;

public class s14_detect_cycle_in_directed_graph_bfs extends s1_helperE {
 public static void main(String[] args) {
  Graph G = new Graph(5);
  G.addEdge_Directed(1, 2);
  G.addEdge_Directed(2, 3);
  G.addEdge_Directed(3, 4);
  G.addEdge_Directed(4, 2);

  System.out.println(Detect_cycle(G.V, G.adj));
 }

 public static boolean Detect_cycle(int v, ArrayList<ArrayList<Integer>> adj) {
  // int[] topo = new int[v];
  int[] indegree = new int[v];

  // count indegree
  for (int i = 0; i < v; i++) {
   for (int j : adj.get(i)) {
    indegree[j]++;
   }
  }

  // add nodes to queue which have indegree = 0 in the beginning
  Queue<Integer> Q = new LinkedList<>();
  for (int i = 0; i < v; i++) {
   if (indegree[i] == 0) {
    Q.add(i);
   }
  }

  // reduce indegree of nodes and if it becomes zero then add them to the queue
  int count = 0;
  while (!Q.isEmpty()) {
   Integer node = Q.poll();
   count++;
   for (int j : adj.get(node)) {
    indegree[j]--;
    if (indegree[j] == 0) {
     Q.add(j);
    }
   }
  }
  if (count == v) {
   return false;
  }
  return true;
 }
}
