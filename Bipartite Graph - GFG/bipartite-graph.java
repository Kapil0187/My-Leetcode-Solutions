//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>graph)
    {
        // Code here
        int color[] = new int[v];
        for(int i=0;i<v;i++)
            color[i]=-1;
        for(int i=0;i<v;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(color,graph,i,0)==false)
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int[] color,ArrayList<ArrayList<Integer>> graph,int node,int col)
    {
        color[node] = col;
        for(int adj:graph.get(node))
        {
            if(color[adj]==-1)
            {
                if(dfs(color,graph,adj,1-col)==false)
                    return false;
            }
            else if(color[adj]==color[node])
            {
                return false;
            }
        }
        return true;
    }
}