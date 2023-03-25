//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
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
            int rankU = Parent.get(up_u);
            Parent.set(up_u,rankU);
        }
    }
}
class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        DisjointSet ds = new DisjointSet(rows*cols);
        int vis[][] = new int[rows][cols];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for(int i=0;i<len;i++)
        {
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col]==1)
            {
                ans.add(count);
                continue;
            }
            vis[row][col] = 1;
            count++;
            
            int dr[] = new int[]{-1,1,0,0};
            int dc[] = new int[]{0,0,-1,1};
            for(int ind=0;ind<4;ind++)
            {
                int drow = row+dr[ind];
                int dcol = col+dc[ind];
                if(drow>=0 && dcol>=0 && drow<rows && dcol<cols)
                {
                    if(vis[drow][dcol]==1)
                    {
                        int nodeno = row*cols+col;
                        int adjno = drow*cols+dcol;
                        if(ds.findUpar(nodeno)!=ds.findUpar(adjno))
                        {
                            count--;
                            ds.unionByrank(nodeno,adjno);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends