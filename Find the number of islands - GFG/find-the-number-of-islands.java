//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
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
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int r = grid.length;
        int c = grid[0].length;
        
        int vis[][] = new int[r][c];
        int count = 0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    bfs(grid,vis,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfs(char[][] grid,int vis[][],int r,int c)
    {
        vis[r][c] = 1;
       
            for(int dr=-1;dr<=1;dr++)
            {
                for(int dc=-1;dc<=1;dc++)
                {
                    int drow = r+dr;
                    int dcol = c+dc;
                    if(drow>=0 && dcol>=0 && drow<grid.length && dcol<grid[0].length && grid[drow][dcol]=='1' && vis[drow][dcol]==0)
                    {
                        bfs(grid,vis,drow,dcol);
                    }
                }
            }
    
    }
}
