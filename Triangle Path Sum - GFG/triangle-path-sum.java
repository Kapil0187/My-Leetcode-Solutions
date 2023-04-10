//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        if(n==1)
            return grid.get(0).get(0);
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j] = -1;
            }
        }
        return findpath(grid,dp,0,0,n);
        //return dp[0][0];
    }
    public static int findpath(ArrayList<ArrayList<Integer>> grid,int[][] dp,int i,int j,int n)
    {
        if(i==n-1||j==n-1)
            return grid.get(i).get(j);
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left = findpath(grid,dp,i+1,j,n);
        int right = findpath(grid,dp,i+1,j+1,n);
        return dp[i][j] = grid.get(i).get(j) + Math.min(left,right);
    }
}