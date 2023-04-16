//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int row;
    int col;
    Pair(int row,int col)
    {
        this.row = row;
        this.col = col;
    }
}
class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        int vis[][] = new int[N][M];
        for(int i=0;i<N;i++)
        {
            if(matrix[i][0]==1 && vis[i][0]==0)
            {
                bfs(matrix,vis,i,0);
            }
            if(matrix[i][M-1]==1 && vis[i][M-1]==0)
            {
                bfs(matrix,vis,i,M-1);
            }
        }
        for(int i=0;i<M;i++)
        {
            if(matrix[0][i]==1 && vis[0][i]==0)
            {
                bfs(matrix,vis,0,i);
            }
            if(matrix[N-1][i]==1 && vis[N-1][i]==0)
            {
                bfs(matrix,vis,N-1,i);
            }
        }
        int count = 0;
        for(int i=1;i<N-1;i++)
        {
            for(int j=1;j<M-1;j++)
            {
                if(vis[i][j]==0 && matrix[i][j]==1)
                {
                    bfs(matrix,vis,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int matrix[][],int vis[][],int r,int c)
    {
        vis[r][c] = 1;
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++)
            {
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow>=0 && dcol>=0 && drow<matrix.length && dcol<matrix[0].length && matrix[drow][dcol]==1 && vis[drow][dcol]==0)
                {
                    q.add(new Pair(drow,dcol));
                    vis[drow][dcol] = 1;
                }
            }
        }
    }
}