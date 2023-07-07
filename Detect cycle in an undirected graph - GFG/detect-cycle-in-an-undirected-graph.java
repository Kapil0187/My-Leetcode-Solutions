//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int parent;
    Pair(int node,int parent)
    {
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[] = new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(adj,vis,i,-1))
                    return true;
            }
        }
        return false;
        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] vis,int ind,int parent)
    {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ind,parent));
        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int par = q.poll().parent;
            vis[node] = 1;
            for(int adjnode : adj.get(node))
            {
                if(vis[adjnode]==0)
                {
                    q.add(new Pair(adjnode,node));
                }
                else if(adjnode!=par)
                    return true;
            }
        }
        return false;
    }
} 
/*
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
    }
    public boolean dfs(int[] vis,ArrayList<ArrayList<Integer>> adj,int ind,int parent)
    {
        vis[ind] = 1;
        for(int it : adj.get(ind))
        {
            if(vis[it]==0)
            {
                if(dfs(vis,adj,it,ind))
                    return true;
            }
            else if(parent!=it)
                return true;
        }
        return false;
    }
}

*/

