import java.util.*;

public class s13_topological_sort_bfs extends s1_helperE {
 public static void main(String[] args) {
  Graph G = new Graph(6);
  G.addEdge_Directed(2, 3);
  G.addEdge_Directed(3, 1);
  G.addEdge_Directed(4, 0);
  G.addEdge_Directed(4, 1);
  G.addEdge_Directed(5, 0);
  G.addEdge_Directed(5, 2);

  for (int x : Topological_sort(G.V, G.adj)) {
   System.out.print(x + " ");
  }
 }

 public static int[] Topological_sort(int v, ArrayList<ArrayList<Integer>> adj) {
  int[] topo = new int[v];
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
  int ind = 0;
  while (!Q.isEmpty()) {
   Integer node = Q.poll();
   topo[ind++] = node;

   for (int j : adj.get(node)) {
    indegree[j]--;
    if (indegree[j] == 0) {
     Q.add(j);
    }
   }
  }
  return topo;
 }
}
