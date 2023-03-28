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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> Parent = new ArrayList<>();
    DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            Parent.add(i);
        }
    }
    public int findUpar(int node)
    {
        if(Parent.get(node)==node)
            return node;
        int ulp = findUpar(Parent.get(node));
        Parent.set(node,ulp);
        return Parent.get(node);
    }
    public void unionByrank(int u,int v)
    {
        int up_u = findUpar(u);
        int up_v = findUpar(v);
        if(up_u==up_v)
            return;
        if(rank.get(up_u)<rank.get(up_v))
            Parent.set(up_u,up_v);
        else if(rank.get(up_v)<rank.get(up_u))
            Parent.set(up_v,up_u);
        else
        {
            Parent.set(up_v,up_u);
            int rankU = rank.get(up_u);
            rank.set(up_u,rankU+1);
        }
    }
}

class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n+1);
        int m = edge.length;
        int extraedges = 0;
        for(int i=0;i<m;i++)
        {
            int u = edge[i][0];
            int v = edge[i][1];
            if(ds.findUpar(u)==ds.findUpar(v))
                extraedges++;
            else
                ds.unionByrank(u,v);
        }
        
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            if(ds.Parent.get(i)==i)
                cnt++;
        }
        int ans = cnt-1;
        if(extraedges>=ans)
            return ans;
        return -1;
    }
}