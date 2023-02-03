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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int tim;
    Pair(int row,int col,int tim)
    {
        this.row = row;
        this.col = col;
        this.tim = tim;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        
        int vis[][] = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    vis[i][j] = 2;
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        int time = 0;
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tim;
            q.poll();
            vis[r][c] = 2;
            time = Math.max(time,t);
            for(int i=0;i<4;i++)
            {
                int row = r+dr[i];
                int col = c+dc[i];
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1 && vis[row][col]==0)
                {
                    vis[row][col] = 2;
                    q.offer(new Pair(row,col,t+1));
                }
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(vis[i][j]!=2 && grid[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return time; 
    }
}