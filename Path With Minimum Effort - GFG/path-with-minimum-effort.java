//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Tuple{
    int diff;
    int row;
    int col;
    Tuple(int dist,int row,int col)
    {
        this.diff = dist;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int MinimumEffort(int heights[][]) {
        int r = heights.length;
        int c = heights[0].length;
        int dis[][] = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                dis[i][j] = (int)1e9;
            }
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.diff-y.diff);
        dis[0][0] = 0;
        pq.add(new Tuple(0,0,0));
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        while(!pq.isEmpty())
        {
            int diff = pq.peek().diff;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.poll();
            for(int i=0;i<4;i++)
            {
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow<r && dcol<c && drow>=0 && dcol>=0)
                {
                    int neweffort = Math.max(Math.abs(heights[row][col]-heights[drow][dcol]),diff);
                    if(neweffort<dis[drow][dcol])
                    {
                        pq.add(new Tuple(neweffort,drow,dcol));
                        dis[drow][dcol] = neweffort;
                    }
                }
            }
        }
        return dis[r-1][c-1];
    }
}