package Graph;

import java.util.*;

public class AdjacentMatrix {
    public static void adjacentMatrix(int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        System.out.println(graph);
    }
    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        adjacentMatrix(edges);
    }
}
