//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Pair{
    int level;
    int node;
    Pair(int level,int node)
    {
        this.level = level;
        this.node = node;
    }
}
class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        int vis[] = new int[V];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        vis[0] = 1;
        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int level = q.peek().level;
            q.poll();
            for(int adnode : adj.get(node))
            {
                if(adnode==X)
                    return level+1;
                if(vis[adnode]==0)
                {
                    q.add(new Pair(level+1,adnode));
                    vis[adnode] = 1;
                }
            }
        }
        return -1;
    }
}