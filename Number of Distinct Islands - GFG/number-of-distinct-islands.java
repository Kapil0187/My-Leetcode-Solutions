//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(grid,vis,list,i,j,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public static void dfs(int[][] grid,int vis[][],ArrayList<String> list,int r,int c,int pr,int pc)
    {
        String temp = ""+(r-pr)+""+(c-pc);
        list.add(temp);
        vis[r][c] = 1;
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        for(int i=0;i<4;i++)
        {
            int drow = r+dr[i];
            int dcol = c+dc[i];
            if(drow>=0 && dcol>=0 && drow<grid.length && dcol<grid[0].length && grid[drow][dcol]==1 && vis[drow][dcol]==0)
            {
                dfs(grid,vis,list,drow,dcol,pr,pc);
            }
        }
    }
}
