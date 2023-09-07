package Graph;
import java.util.*;

public class DetectCycle {
    static class pair {
        int first, second;
        
        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(int[][] edges, int v) {

         Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        boolean [] vis = new boolean[v];
        Arrays.fill(vis, false);
        
        for(int i =0; i< v; i++) {
            if(!vis[i] && isCycleBFS(adj, i, vis)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean isCycleBFS(Map<Integer,List<Integer>> adj, int u, boolean[] vis) {
        
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(u,-1));
        vis[u] = true;
        
        while(!q.isEmpty()) {
            pair p = q.poll();
            
            int src = p.first;
            int parent = p.second;
            
            for(int v : adj.get(src)) {
                if(vis[v] == false) {
                    vis[v] = true;
                    q.add(new pair(v,src));
                } else if(v != parent) {
                    return true;
                }
            }
        }
        
        return false;
       
    }
    public static void main(String[] args) {
        int [][] edges = {{5,4},{0,2},{0,3},{0,1},{2,5}};
        System.out.println(isCycle(edges, 6));
    }
}
