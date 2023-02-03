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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int step;
    Pair(int row,int col,int step)
    {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        int ans[][] = new int[r][c];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1)
                {
                    vis[i][j] = 1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().step;
            ans[row][col] = step;
            q.poll();
            for(int i=0;i<4;i++)
            {
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow>=0 && dcol>=0 && drow<r && dcol<c && grid[drow][dcol]==0 && vis[drow][dcol]==0)
                {
                    vis[drow][dcol] = 1;
                    q.add(new Pair(drow,dcol,step+1));
                }
            }
        }
        return ans;
    }
}