//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        // Your code here
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        for(int i=0;i<c;i++)
        {
            if(vis[0][i]==0 && grid[0][i]==1)
            {
                dfs(grid,vis,0,i);
            }
            if(vis[r-1][i]==0 && grid[r-1][i]==1)
            {
                dfs(grid,vis,r-1,i);
            }
        }
        for(int i=0;i<r;i++)
        {
            if(vis[i][0]==0 && grid[i][0]==1)
            {
                dfs(grid,vis,i,0);
            }
            if(vis[i][c-1]==0 && grid[i][c-1]==1)
            {
                dfs(grid,vis,i,c-1);
            }
        }
        int count = 0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                    ++count;
            }
        }
        return count;
    }
    public static void dfs(int grid[][],int vis[][],int r,int c)
    {
        vis[r][c] = 1;
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        for(int i=0;i<4;i++)
        {
            int row = r+dr[i];
            int col = c+dc[i];
            if(row<grid.length && col<grid[0].length && col>=0 && row>=0 && grid[row][col]==1 && vis[row][col]==0)
            {
                dfs(grid,vis,row,col);
            }
        }
    }
}