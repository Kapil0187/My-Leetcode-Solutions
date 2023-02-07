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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



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
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int vis[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    if(dfs(grid,vis,i,j)==true)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(int[][] grid,int vis[][],int r,int c)
    {
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++)
            {
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow<grid.length && dcol<grid[0].length && drow>=0 && dcol>=0 && grid[drow][dcol]==2)
                    return true;
                if(drow<grid.length && dcol<grid[0].length && drow>=0 && dcol>=0 && grid[drow][dcol]==3 && vis[drow][dcol]==0)
                {
                    q.add(new Pair(drow,dcol));
                    vis[drow][dcol]=1;
                }
            }
        }
        return false;
    }
}