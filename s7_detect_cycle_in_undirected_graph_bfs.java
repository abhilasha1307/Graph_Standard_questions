import java.util.*;

public class s7_detect_cycle_in_undirected_graph_bfs extends s1_helperE {
  static class Node {
    int first;
    int second;

    Node(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public static void main(String[] args) {
    Graph G = new Graph(5);
    G.addEdge_UnDirected(0, 1);
    G.addEdge_UnDirected(1, 2);
    G.addEdge_UnDirected(2, 3);
    G.addEdge_UnDirected(3, 4);
    G.addEdge_UnDirected(1, 4);

    System.out.println(isCyclic(G.V, G.adj));
  }

  private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> list) {
    boolean[] visited = new boolean[v];

    for (int i = 0; i < v; i++) { // if the graph is disconnected
      if (!visited[i]) {
        if (isCyclicUtil(i, visited, list))
          return true;
      }

    }
    return false;
  }

  private static boolean isCyclicUtil(int v, boolean[] visited, ArrayList<ArrayList<Integer>> list) {
    Queue<Node> Q = new LinkedList<>();
    Q.add(new Node(v, -1));
    visited[v] = true;

    while (!Q.isEmpty()) {
      int node = Q.peek().first;
      int parent = Q.peek().second;

      Q.remove();
      for (int j : list.get(node)) {
        if (visited[j] == false) {
          Q.add(new Node(j, node));
          visited[j] = true;
        } else if (j != parent) {
          return true;
        }
      }
    }
    return false;
  }
}
