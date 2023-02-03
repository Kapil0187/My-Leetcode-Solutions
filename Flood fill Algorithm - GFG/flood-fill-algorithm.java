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
        bfs(image,vis,sr,sc,newColor,oldcolor);
        return image;
    }
    public static void bfs(int image[][],int vis[][],int sr,int sc,int newcolor,int oldcolor)
    {
        vis[sr][sc] = 1;
        image[sr][sc] = newcolor;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++)
            {
                int row = r+dr[i];
                int col = c+dc[i];
                if(row<image.length && col<image[0].length && row>=0 && col>=0 && vis[row][col]==0 && image[row][col]==oldcolor)
                {
                    q.offer(new Pair(row,col));
                    vis[row][col] = 1;
                    image[row][col] = newcolor;
                }
            }
        }
    }
}