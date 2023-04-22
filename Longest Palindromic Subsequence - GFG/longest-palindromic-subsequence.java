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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        int len = S.length();
        String rev = "";
        
        for(int i=len-1;i>=0;i--)
            rev += S.charAt(i);
     
        int dp[][] = new int[len+1][len+1];
        for(int i=0;i<len;i++)
            dp[i][0] = 0;
        for(int j=0;j<len;j++)
            dp[0][j] = 0;
        for(int i=1;i<=len;i++)
        {
            for(int j=1;j<=len;j++)
            {
                if(S.charAt(i-1)==rev.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len][len];
    }
}