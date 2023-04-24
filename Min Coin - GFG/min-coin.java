//{ Driver Code Starts
//Initial Template for Java

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
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount  = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
        // Code here
        int n = nums.length;
        int dp[][] = new int[n][amount+1];
        int ans=  Min(nums,amount,n-1,dp);
        if(ans>=(int)1e9)
            return -1;
        return ans;
    }
    public int Min(int[] nums,int amount,int ind,int[][] dp)
    {
        if(ind==0)
        {
            if(amount%nums[0]==0)
                return amount/nums[ind];
            else
                return (int)1e9;
        }
        if(dp[ind][amount]!=0)
            return dp[ind][amount];
        int nottake = Min(nums,amount,ind-1,dp);
        int take = Integer.MAX_VALUE;
        if(nums[ind]<=amount)
            take = 1+Min(nums,amount-nums[ind],ind,dp);
        return dp[ind][amount] = Math.min(take,nottake);
    }
}