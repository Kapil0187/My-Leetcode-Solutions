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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Tuple{
    int row;
    int col;
    int cost;
    Tuple(int row,int col,int cost)
    {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}
class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int r = grid.length;
        int c = grid[0].length;
        int dis[][] = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                dis[i][j] = (int)1e9;
            }
        }
        int vis[][] = new int[r][c];
        dis[0][0] = grid[0][0];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)-> x.cost - y.cost);
        pq.add(new Tuple(0,0,grid[0][0]));
        vis[0][0] = 1;
        while(!pq.isEmpty())
        {
            int row = pq.peek().row;
            int col = pq.peek().col;
            int cost = pq.peek().cost;
            pq.poll();
            int dr[] = new int[]{-1,1,0,0};
            int dc[] = new int[]{0,0,-1,1};
            for(int i=0;i<4;i++)
            {
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow>=0 && dcol>=0 && drow<r && dcol<c && vis[drow][dcol]==0)
                {
                    if(cost+grid[drow][dcol]<dis[drow][dcol])
                    {
                        dis[drow][dcol] = cost+grid[drow][dcol];
                        pq.add(new Tuple(drow,dcol,dis[drow][dcol]));
                        vis[drow][dcol] = 1;
                    }
                }
            }
        }
        return dis[r-1][c-1];
    }
}