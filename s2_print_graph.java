/*
====================================================================
PROBLEM:)
====================================================================
Given the adjacency list of a bidirectional graph. Your task is to return the adjacency list for each vertex.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(1)
*/

/*
===================================================================
APPROACH:)
===================================================================
nodes are from 0 to V-1;
graph is given in LL rep form 
using a loop we will traverse the lists corresponding to each element and then return the result

Time Complexity: O(V + E)
Auxiliary Space: O(1)
*/
import java.util.*;

public class s2_print_graph {
 public static void main(String[] args) {
  int V = 5;
  ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(V);

  for (int i = 0; i < V; i++) {
   list.add(new ArrayList<Integer>()); // every element of 'list' is also an arraylist, so we initialze it with empty
                                       // arraylists
  }

  addEdge(list, 0, 1);
  addEdge(list, 0, 4);
  addEdge(list, 1, 2);
  addEdge(list, 1, 3);
  addEdge(list, 1, 4);
  addEdge(list, 2, 3);
  addEdge(list, 3, 4);

  ArrayList<ArrayList<Integer>> ans = printGraph(list);
  for (int i = 0; i < V; i++) {
   int j = 0;
   for (; j < ans.get(i).size() - 1; j++) {
    System.out.print(ans.get(i).get(j) + "->");
   }
   System.out.println(ans.get(i).get(j));
  }
 }

 private static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {

  // case of undirected graph
  list.get(u).add(v);
  list.get(v).add(u);
 }

 public static ArrayList<ArrayList<Integer>> printGraph(ArrayList<ArrayList<Integer>> adj) {
  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

  for (int i = 0; i < adj.size(); i++) {
   ArrayList<Integer> temp = new ArrayList<Integer>();
   temp.add(i);
   for (int j = 0; j < adj.get(i).size(); j++) {

    temp.add(adj.get(i).get(j));
   }
   result.add(temp);
  }

  return result;
 }
}
