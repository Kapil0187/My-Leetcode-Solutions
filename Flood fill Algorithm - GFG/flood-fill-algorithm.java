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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
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
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int oldcolor = image[sr][sc];
        int vis[][] = new int[image.length][image[0].length];
        bfs(image,vis,sr,sc,oldcolor,newColor);
        return image;
    }
    public void bfs(int image[][],int vis[][],int sr,int sc,int oldcolor,int newColor)
    {
        vis[sr][sc] = newColor;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc] = 1;
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            image[row][col]= newColor;
            for(int i=0;i<4;i++)
            {
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow>=0 && dcol>=0 && drow<image.length && dcol<image[0].length && image[drow][dcol]==oldcolor && vis[drow][dcol]==0)
                {
                    q.add(new Pair(drow,dcol));
                    vis[drow][dcol]=1;
                }
            }
        }
    }
}