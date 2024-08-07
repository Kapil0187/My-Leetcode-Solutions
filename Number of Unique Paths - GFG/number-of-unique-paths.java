//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][] = new int[a][b];
        return find(a,b,0,0,dp);
    }
    public static int find(int r ,int c,int i,int j,int[][] dp)
    {
        if(i<0||j<0||i>=r ||j>=c)
            return 0;
        if(i==r-1 && j==c-1)
            return 1;
        if(dp[i][j]!=0)
            return dp[i][j];
        return dp[i][j] = find(r,c,i+1,j,dp)+find(r,c,i,j+1,dp);
    }
}