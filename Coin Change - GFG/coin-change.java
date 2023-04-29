//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][] = new long[N][sum+1];
        for(int t=0;t<=sum;t++)
        {
            if(t%coins[0]==0)
                dp[0][t] = 1L;
            else 
                dp[0][t] = 0L;
        }
        for(int i=1;i<N;i++)
        {
            for(int t=0;t<=sum;t++)
            {
                long nottake = dp[i-1][t];
                long take = 0;
                if(coins[i]<=t)
                    take = dp[i][t-coins[i]];
                dp[i][t] = nottake+take;
            }
        }
        return dp[N-1][sum];
    }
    public long find(int coins[],int ind,int sum,long[][] dp)
    {
        if(ind==0)
        {
            if(sum%coins[ind]==0)
                return 1L;
            else
                return 0L;
        }
        if(dp[ind][sum]!=0) 
            return dp[ind][sum];
        long nottake = find(coins,ind-1,sum,dp);
        long take = 0;
        if(coins[ind]<=sum)
            take = find(coins,ind,sum-coins[ind],dp);
        return dp[ind][sum] = take+nottake;
    }
}