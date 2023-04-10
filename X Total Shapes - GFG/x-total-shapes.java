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
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        // code here
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        int count = 0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='X' && vis[i][j]==0)
                {
                    dfs(grid,vis,i,j);
                    ++count;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int [][]vis,int r,int c)
    {
        vis[r][c] = 1;
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        for(int i=0;i<4;i++)
        {
            int drow = r+dr[i];
            int dcol = c+dc[i];
            if(drow>=0 && dcol>=0 && drow<grid.length && dcol<grid[0].length && grid[drow][dcol]=='X' && vis[drow][dcol]==0)
            {
                dfs(grid,vis,drow,dcol);
            }
        }
    }
}