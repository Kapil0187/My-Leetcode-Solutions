//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first,int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first,int second,int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        int m = flights.length;
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int dis[] = new int[n];
        for(int i=0;i<n;i++)
        {
            dis[i] = (int)1e9;
        }
        dis[src] = 0;
        while(!q.isEmpty())
        {
            int stop = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            q.poll();
            if(stop>k)
                continue;
            for(Pair iter : adj.get(node))
            {
                int adjnode = iter.first;
                int dist = iter.second;
                if(dist+cost<dis[adjnode])
                {
                    dis[adjnode] = dist+cost;
                    q.add(new Tuple(stop+1,adjnode,dist+cost));
                }
            }
        }
        if(dis[dst]==(int)1e9)
            return -1;
        return dis[dst];
    }
}