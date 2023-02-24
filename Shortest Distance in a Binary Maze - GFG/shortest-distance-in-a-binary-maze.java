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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int dist;
    int row;
    int col;
    Pair(int dist,int row,int col)
    {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0] && destination[1]==source[1])
            return 0;
        int path[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                path[i][j]=(int)1e9;
            }
        }
        path[source[0]][source[1]] = 0;
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,source[0],source[1]));
        while(!q.isEmpty())
        {
            int dist = q.peek().dist;
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++)
            {
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow<grid.length && dcol<grid[0].length && drow>=0 && dcol>=0 && grid[drow][dcol]==1 && path[drow][dcol]>(dist+1))
                {
                    path[drow][dcol] = dist+1;
                    if(drow==destination[0] && dcol==destination[1])
                        return dist+1;
                    q.add(new Pair(dist+1,drow,dcol));
                }
            }
        }
        if(path[destination[0]][destination[1]]==1e9)
            return -1;
        return path[destination[0]][destination[1]];
    }
}
