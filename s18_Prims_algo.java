
//gfg
//TC and SC
//PQ and heap
import java.util.*;

public class s18_Prims_algo {
 static class Pair implements Comparator<Pair> {
  private int node;
  private int weight;

  Pair(int node, int weight) {
   this.node = node;
   this.weight = weight;
  }

  Pair() {
  }

  int getNode() {
   return node;
  }

  int getWeight() {
   return weight;
  }

  @Override
  public int compare(Pair node1, Pair node2) {
   if (node1.weight < node2.weight) {
    return -1;
   }
   if (node1.weight > node2.weight) {
    return 1;
   }
   return 0;
  }
 }

 public static void main(String[] args) {
  int V = 5;
  ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

  for (int i = 0; i < V; i++) {
   adj.add(new ArrayList<Pair>());
  }

  adj.get(0).add(new Pair(1, 2));
  adj.get(1).add(new Pair(0, 2));

  adj.get(1).add(new Pair(2, 3));
  adj.get(2).add(new Pair(1, 3));

  adj.get(0).add(new Pair(3, 6));
  adj.get(3).add(new Pair(0, 6));

  adj.get(1).add(new Pair(3, 8));
  adj.get(3).add(new Pair(1, 8));

  adj.get(1).add(new Pair(4, 5));
  adj.get(4).add(new Pair(1, 5));

  adj.get(2).add(new Pair(4, 7));
  adj.get(4).add(new Pair(2, 7));

  // PrimsAlgo(V, adj);
  primsAlgoOptm(V, adj);
 }

 // time: O(N^2)
 public static void PrimsAlgo(int v, ArrayList<ArrayList<Pair>> adj) {
  int[] key = new int[v];
  int[] parent = new int[v];
  boolean[] MST = new boolean[v];

  for (int i = 0; i < v; i++) {
   key[i] = Integer.MAX_VALUE;
   MST[i] = false;
   parent[i] = -1;
  }

  key[0] = 0;

  // looping for edges, therefore 0 to v-1

  for (int i = 0; i < v - 1; i++) {
   // heap will give mininum in log time or use a priority queue (also log time)
   int u = 0, min = Integer.MAX_VALUE;
   for (int j = 0; j < v; j++) {
    if (MST[j] == false && key[j] < min) {
     min = key[j];
     u = j;
    }
   }

   MST[u] = true;

   for (Pair k : adj.get(u)) {
    if (MST[k.getNode()] == false && k.getWeight() < key[k.getNode()]) {
     parent[k.getNode()] = u;
     key[k.getNode()] = k.getWeight();
    }
   }
  }

  for (int i = 1; i < v; i++) {
   System.out.println(parent[i] + "-" + i);
  }
 }

 // time ~ O(NlogN) (+ E factor)

 public static void primsAlgoOptm(int v, ArrayList<ArrayList<Pair>> adj) {
  int[] key = new int[v];
  int[] parent = new int[v];
  boolean[] MST = new boolean[v];

  for (int i = 0; i < v; i++) {
   key[i] = Integer.MAX_VALUE;
   MST[i] = false;
   parent[i] = -1;
  }

  key[0] = 0;

  PriorityQueue<Pair> pq = new PriorityQueue<Pair>(v, new Pair());
  pq.add(new Pair(0, key[0]));

  for (int i = 0; i < v - 1; i++) {
   int u = pq.poll().getNode(); // logN

   MST[u] = true;

   for (Pair k : adj.get(u)) {
    if (MST[k.getNode()] == false && k.getWeight() < key[k.getNode()]) {
     parent[k.getNode()] = u;
     key[k.getNode()] = k.getWeight();
     pq.add(new Pair(k.getNode(), key[k.getNode()])); // logN
    }
   }
  }

  for (int i = 1; i < v; i++) {
   System.out.println(parent[i] + "-" + i);
  }
 }
}
