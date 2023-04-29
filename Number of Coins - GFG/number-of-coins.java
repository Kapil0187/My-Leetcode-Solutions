//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int dp[][] = new int[M][V+1];
	    int ans = function(coins,M-1,V,dp);
	    
	    if(ans>=(int)1e9)
	        return -1;
	    return ans;
	}
	public int function(int coins[],int ind,int sum,int[][] dp)
	{
	    if(ind==0)
	    {
	        if(sum%coins[ind]==0)
	            return sum/coins[ind];
	        else
	            return (int)1e9;
	    }
	    if(dp[ind][sum]!=0)
	        return dp[ind][sum];
	    int nottake = function(coins,ind-1,sum,dp);
	    int take = Integer.MAX_VALUE;
	    if(coins[ind]<=sum)
	        take = 1+function(coins,ind,sum-coins[ind],dp);
	    return dp[ind][sum] = Math.min(take,nottake);
	}
}