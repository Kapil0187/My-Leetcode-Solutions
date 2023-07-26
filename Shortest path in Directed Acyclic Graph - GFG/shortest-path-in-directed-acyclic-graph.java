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


//User function Template for Java
class Pair{
    int node;
    int weight;
    Pair(int node,int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<N;i++)
		    adj.add(new ArrayList<>());
		for(int i=0;i<edges.length;i++)
		{
		    adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
		
		int dis[] = new int[N];
	    for(int i=0;i<N;i++)
	        dis[i] = (int)1e9;
	    PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->x.weight-y.weight);
	    q.add(new Pair(0,0));
	    dis[0] = 0;
	    while(!q.isEmpty())
	    {
	        int node = q.peek().node;
	        int w = q.peek().weight;
	        q.poll();
	        for(Pair adjnode : adj.get(node))
	        {
	            if(dis[adjnode.node]>w+adjnode.weight)
	            {
	                q.add(new Pair(adjnode.node,w+adjnode.weight));
	                dis[adjnode.node] = w+adjnode.weight;
	            }
	        }
	    }
	    for(int i=0;i<N;i++)
	    {
	        if(dis[i]==(int)1e9)
	            dis[i] = -1;
	    }
	    return dis;
	}
}


