//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int second;
    int waight;
    Pair(int second,int waight)
    {
        this.second = second;
        this.waight = waight;
    }
}
//User function Template for Java
class Solution {
    public static void toposort(int vis[],ArrayList<ArrayList<Pair>> adj,Stack<Integer> stack,int node)
    {
        vis[node] = 1;
        for(Pair obj:adj.get(node))
        {
            int v = obj.second;
            if(vis[v]==0)
            {
                toposort(vis,adj,stack,v);
            }
        }
        stack.push(node);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<N;i++)
		{
		    adj.add(new ArrayList<Pair>());
		}
		for(int i=0;i<M;i++)
		{
		    adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
		int vis[] = new int[N];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<N;i++)
		{
		    if(vis[i]==0)
		    {
		        toposort(vis,adj,stack,i);
		    }
		}
		int dist[] = new int[N];
		for(int i=0;i<N;i++)
		{
		    dist[i] = (int)1e9;
		}
		dist[0] = 0;
		while(!stack.isEmpty())
		{
		    int node = stack.pop();
		    for(Pair obj:adj.get(node))
		    {
		        int dis = obj.waight;
		        int n = obj.second;
		        if(dist[node]+dis<dist[n])
		        {
		            dist[n] = dist[node]+dis;
		        }
		    }
		}
		for(int i=0;i<N;i++)
		{
		    if(dist[i]==1e9)
		        dist[i] = -1;
		}
		return dist;
	}
}