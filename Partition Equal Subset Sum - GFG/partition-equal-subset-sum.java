//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int i=0;i<N;i++)
        {
            sum += arr[i];
        }
        if(sum%2!=0)
            return 0;
        sum = sum/2;
        int dp[][] = new int[N][sum+1];
        for(int i=0;i<N;i++)
            dp[i][0] = 1;
        if(arr[0]<=sum)
            dp[0][arr[0]] = 1;
        for(int i=1;i<N;i++)
        {
            for(int target=1;target<=sum;target++)
            {
                int notepick = dp[i-1][target];
                int pick = 0;
                if(arr[i]<=target)
                {
                    pick = dp[i-1][target-arr[i]];
                }
                dp[i][target] = pick==1||notepick==1?1:0;
            }
        }
        return dp[N-1][sum];
    }
}