package Graph;
import java.util.*;

public class DFS {

    public static void solve(int [][] edges, int v) {
          Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Arrays.fill(vis,false);

        dfs(adj, vis, 0, ans);
        
         for(int i =0; i<ans.size(); i++) {
            System.out.print(ans.get(i));
        }
    }
    public static void dfs(Map<Integer,List<Integer>> adj, boolean[] vis, int u, List<Integer> ans) {
        if(vis[u] == true) return;
        vis[u] = true;
        ans.add(u);
        for(int v : adj.get(u)) {
            if(vis[v] == false) {
                dfs(adj,vis, v,ans);
            }
        } 

    }
    public static void main(String[] args) {
        int [][] edges = {{5,4},{0,2},{0,3},{0,1},{2,5}};
        solve(edges, 6);
    }
}
