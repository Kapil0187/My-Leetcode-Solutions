//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int dist;
    int node;
    Pair(int dist,int node)
    {
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        int path[] = new int[n+1];
        int dist[] = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        for(int i=0;i<=n;i++)
        {
            dist[i] = (int)1e9;
            path[i] = i;
        }
        dist[1] = 0;
        pq.add(new Pair(0,1));
        while(pq.size()!=0)
        {
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            for(Pair iter : adj.get(node))
            {
                int distance = iter.dist;
                int adjnode = iter.node;
                if(dis+distance <dist[adjnode])
                {
                    dist[adjnode] = dis + distance;
                    pq.add(new Pair(dist[adjnode],adjnode));
                    path[adjnode] = node;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(dist[n]==1e9)
        {
            ans.add(-1);
            return ans;
        }
        int node = n;
        while(path[node]!=node)
        {
            ans.add(node);
            node = path[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}