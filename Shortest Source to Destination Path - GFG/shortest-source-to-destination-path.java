//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Tuple{
    int dist;
    int row;
    int col;
    Tuple(int dist,int row,int col)
    {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[0][0]==0)
            return -1;
        int path[][] = new int[N][M];
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,0));
        int dr[] = new int[]{-1,1,0,0};
        int dc[] = new int[]{0,0,-1,1};
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                path[i][j] = (int)1e9;
            }
        }
        path[0][0] = 0;
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
                if(drow<N && dcol<M && drow>=0 && dcol>=0 && A[drow][dcol]==1 && path[drow][dcol]>dist+1)
                {
                    path[drow][dcol] = dist+1;
                    q.add(new Tuple(dist+1,drow,dcol));
                }
            }
        }
        if(path[X][Y]==1e9)
            return -1;
        return path[X][Y];
    }
};