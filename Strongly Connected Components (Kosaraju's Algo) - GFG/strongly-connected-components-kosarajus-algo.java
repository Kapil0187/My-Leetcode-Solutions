//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,Stack<Integer> stack)
    {
        vis[node] = 1;
        for(int it:adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs(it,adj,vis,stack);
            }
        }
        stack.push(node);
    }
    
    public void dfs3(int node,int vis[],ArrayList<ArrayList<Integer>> adjT)
    {
        vis[node] = 1;
        for(int it:adjT.get(node))
        {
            if(vis[it]==0)
            {
                dfs3(it,vis,adjT);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int vis[] = new int[V];
        //sort using finsing time 
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,adj,vis,stack);
            }
        }
        
        //reverse adj list
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adjT.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++)
        {
            vis[i] = 0;
            for(int it:adj.get(i))
            {
                adjT.get(it).add(i);
            }
        }
       // System.out.print(stack);
        int scc = 0;
        while(!stack.isEmpty())
        {
            int node = stack.pop();
            if(vis[node]==0)
            {
                ++scc;
                dfs3(node,vis,adjT);
            }
        }
        return scc;
    }
   
}
